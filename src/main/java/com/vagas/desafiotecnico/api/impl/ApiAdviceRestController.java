package com.vagas.desafiotecnico.api.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vagas.desafiotecnico.dtos.ApiStatusDto;
import com.vagas.desafiotecnico.dtos.MensagemErroDto;
import com.vagas.desafiotecnico.dtos.StatusCodeDto;
import com.vagas.desafiotecnico.exceptions.CaminhoNaoEncontradoExceptions;
import com.vagas.desafiotecnico.exceptions.CandidatoNaoExisteException;
import com.vagas.desafiotecnico.exceptions.CandidaturaNaoExisteExceptions;
import com.vagas.desafiotecnico.exceptions.SistemaIndisponivelException;
import com.vagas.desafiotecnico.exceptions.VagaNaoExisteException;

@RestControllerAdvice
public class ApiAdviceRestController {

	@ExceptionHandler(CandidatoNaoExisteException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Candidato nao existe.")
	public @ResponseBody ApiStatusDto naoExiste(final CandidatoNaoExisteException canditadoNaoExisteException) {
		return MensagemErroDto
				.builder()
				.mensagem(String.format(StatusCodeDto.CODIGO_ERRO_CANDIDATO_NAO_EXISTE.getMensagem(), canditadoNaoExisteException.getIdCandidato()))
				.codigo(StatusCodeDto.CODIGO_ERRO_CANDIDATO_NAO_EXISTE.getCodigo())
				.build();
	}

	@ExceptionHandler(VagaNaoExisteException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Vaga nao existe.")
	public @ResponseBody ApiStatusDto naoExiste(final VagaNaoExisteException vagaNaoExisteException) {
		return MensagemErroDto
				.builder()
				.mensagem(String.format(StatusCodeDto.CODIGO_ERRO_VAGA_NAO_EXISTE.getMensagem(), vagaNaoExisteException.getIdVaga()))
				.codigo(StatusCodeDto.CODIGO_ERRO_VAGA_NAO_EXISTE.getCodigo())
				.build();
	}

	@ExceptionHandler(CandidaturaNaoExisteExceptions.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nao existe candidatura para a vaga.")
	public @ResponseBody ApiStatusDto naoExiste(final CandidaturaNaoExisteExceptions candidaturaNaoExisteExceptions) {
		return MensagemErroDto
				.builder()
				.mensagem(String.format(StatusCodeDto.CODIGO_ERRO_CANDIDATURA_NAO_EXISTE.getMensagem(),
				candidaturaNaoExisteExceptions.getIdVaga()))
				.codigo(StatusCodeDto.CODIGO_ERRO_CANDIDATURA_NAO_EXISTE.getCodigo())
				.build();
	}

	@ExceptionHandler(CaminhoNaoEncontradoExceptions.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Caminho nao encontrado")
	public @ResponseBody ApiStatusDto naoExiste(final CaminhoNaoEncontradoExceptions caminhoNaoEncontradoExceptions) {
		return MensagemErroDto
				.builder()
				.mensagem(caminhoNaoEncontradoExceptions.getMessage())
				.codigo(StatusCodeDto.CODIGO_ERRO_CAMINHO_NAO_ENCONTRADO.getCodigo())
				.build();
	}

	@ExceptionHandler(SistemaIndisponivelException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Sistema indisponivel no momento. Tente novamente mais tarde.")
	public @ResponseBody ApiStatusDto naoExiste(final SistemaIndisponivelException sistemaIndisponivelException) {
		return MensagemErroDto
				.builder()
				.mensagem(sistemaIndisponivelException.getMessage())
				.codigo(StatusCodeDto.CODIGO_ERRO_SISTEMA_INDIPONIVEL.getCodigo())
				.build();
	}
}
