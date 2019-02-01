package com.vagas.desafiotecnico.api.impl;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vagas.desafiotecnico.api.CandidatosRestInterface;
import com.vagas.desafiotecnico.dtos.CandidatoDto;
import com.vagas.desafiotecnico.models.Candidato;
import com.vagas.desafiotecnico.services.CandidatosInterface;

@RestController
public class CandidatosRestController implements CandidatosRestInterface {

	@Autowired
	private CandidatosInterface candidatosService;
	
	@Autowired
	private ModelMapper modelMapper;

	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.api.CandidatoRestInterface#post(com.vagas.desafiotecnico.dtos.CandidatoDto)
	 */
	@Override
	@PostMapping(path = "/v1/pessoas", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody CandidatoDto post(@Valid @RequestBody final CandidatoDto candidatoDto) {
		
		final Candidato candidato = modelMapper.map(candidatoDto, Candidato.class);
		
		final Candidato candidatoResult = candidatosService.salvar(candidato);
		final CandidatoDto candidatoDtoResponse = modelMapper.map(candidatoResult, CandidatoDto.class);

		candidatoDtoResponse.setCodigo(0);
		candidatoDtoResponse.setMensagem("OK");
		return candidatoDtoResponse;
	}
}
