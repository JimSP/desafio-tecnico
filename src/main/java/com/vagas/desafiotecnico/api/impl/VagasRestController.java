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

import com.vagas.desafiotecnico.api.VagasRestInterface;
import com.vagas.desafiotecnico.dtos.StatusCodeDto;
import com.vagas.desafiotecnico.dtos.VagaDto;
import com.vagas.desafiotecnico.models.Vaga;
import com.vagas.desafiotecnico.services.VagasInterface;

@RestController
public class VagasRestController implements VagasRestInterface {

	@Autowired
	private VagasInterface vagasService;
	
	@Autowired
	private ModelMapper modelMapper;

	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.api.impl.VagasRestInterface#post(com.vagas.desafiotecnico.models.Vaga)
	 */
	@Override
	@PostMapping(path = "/v1/vagas", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody VagaDto post(@Valid @RequestBody final VagaDto vagaDto) {
		final Vaga vaga = modelMapper.map(vagaDto, Vaga.class);
		final Vaga cagaCriada = vagasService.salvar(vaga);
		
		final VagaDto vagaResultDto = modelMapper.map(cagaCriada, VagaDto.class);
		
		vagaResultDto.setCodigo(StatusCodeDto.CODIGO_SUCESSO.getCodigo());
		vagaResultDto.setMensagem(StatusCodeDto.CODIGO_SUCESSO.getMensagem());
		
		return vagaResultDto;
	}
}
