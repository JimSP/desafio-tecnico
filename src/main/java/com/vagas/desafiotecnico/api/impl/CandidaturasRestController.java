package com.vagas.desafiotecnico.api.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vagas.desafiotecnico.api.CandidaturasRestInterface;
import com.vagas.desafiotecnico.dtos.CandidatoDto;
import com.vagas.desafiotecnico.dtos.CandidaturaDto;
import com.vagas.desafiotecnico.models.Candidato;
import com.vagas.desafiotecnico.models.Candidatura;
import com.vagas.desafiotecnico.models.Vaga;
import com.vagas.desafiotecnico.services.CalcularPontuacaoCandidatoInterface;
import com.vagas.desafiotecnico.services.CandidatosInterface;
import com.vagas.desafiotecnico.services.CandidaturasInterface;
import com.vagas.desafiotecnico.services.VagasInterface;

@RestController
public class CandidaturasRestController implements CandidaturasRestInterface {

	@Autowired
	private CandidaturasInterface candidaturaService;

	@Autowired
	private CandidatosInterface candidatosService;

	@Autowired
	private VagasInterface vagasService;
	
	@Autowired
	private CalcularPontuacaoCandidatoInterface calcularPontuacaoCandidatoService;
	
	@Autowired
	private ModelMapper modelMapper;

	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.api.impl.CandidaturaRestInterface#post(com.vagas.desafiotecnico.dtos.CandidaturaDto)
	 */
	@Override
	@PostMapping(path = "/v1/candidaturas", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody CandidaturaDto post(@Valid @RequestBody final CandidaturaDto candidaturaDto) {

		final Candidato candidato = candidatosService.buscarCandidato(candidaturaDto.getIdCandidato());
		
		final Vaga vaga = vagasService.buscarVaga(candidaturaDto.getIdVaga());
		
		final Candidatura candidaturaResult = candidaturaService.candidatar(candidato, vaga);
		
		final CandidaturaDto candidaturaDtoResponse = modelMapper.map(candidaturaResult, CandidaturaDto.class);
		candidaturaDtoResponse.setCodigo(0);
		candidaturaDtoResponse.setMensagem("OK");
		
		return candidaturaDtoResponse;
	}

	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.api.impl.CandidaturaRestInterface#get(java.math.BigInteger)
	 */
	@Override
	@GetMapping(path = "/v1/vagas/{id_vaga}/candidaturas/ranking", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<CandidatoDto> get(@PathVariable(name = "id_vaga", required = true) BigInteger idVaga) {
		final List<Candidatura> candidaturas = candidaturaService.buscarCandidatura(idVaga);

		final List<CandidatoDto> candidatos = candidaturas
				.stream()
				.map(candidatura -> calcularPontuacaoCandidatoService.calcular(candidatura).getCandidato())
				.map(mapper->modelMapper.map(mapper, CandidatoDto.class))
				.collect(Collectors.toList());
		
		return candidatos;
	}
}
