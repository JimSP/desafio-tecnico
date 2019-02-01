package com.vagas.desafiotecnico.api.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vagas.desafiotecnico.dtos.ApiStatusDto;
import com.vagas.desafiotecnico.dtos.MensagemErroDto;
import com.vagas.desafiotecnico.exceptions.CaminhoNaoEncontradoExceptions;
import com.vagas.desafiotecnico.exceptions.CandidatoNaoExisteException;
import com.vagas.desafiotecnico.exceptions.CandidaturaNaoExisteExceptions;
import com.vagas.desafiotecnico.exceptions.SistemaIndisponivelException;
import com.vagas.desafiotecnico.exceptions.VagaNaoExisteException;

@RestControllerAdvice
public class ApiAdviceRestController {

	@ExceptionHandler(CandidatoNaoExisteException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Candidato não existe.")
	public @ResponseBody ApiStatusDto naoExiste(final CandidatoNaoExisteException canditadoNaoExisteException) {
		return MensagemErroDto
				.builder()
				.mensagem(String.format("Pessoa não exite, pessoa_id=", canditadoNaoExisteException.getIdCandidato()))
				.codigo(1)
				.build();
	}

	@ExceptionHandler(VagaNaoExisteException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Vaga não existe.")
	public @ResponseBody ApiStatusDto naoExiste(final VagaNaoExisteException vagaNaoExisteException) {
		return MensagemErroDto
				.builder()
				.mensagem(String.format("Vaga não exite, vaga_id=", vagaNaoExisteException.getIdVaga()))
				.codigo(2)
				.build();
	}

	@ExceptionHandler(CandidaturaNaoExisteExceptions.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Não existe candidatura para a vaga.")
	public @ResponseBody ApiStatusDto naoExiste(final CandidaturaNaoExisteExceptions candidaturaNaoExisteExceptions) {
		return MensagemErroDto
				.builder()
				.mensagem(String.format("Não existe candidatura para a vaga, vaga_id=",
				candidaturaNaoExisteExceptions.getIdVaga())).codigo(2)
				.build();
	}

	@ExceptionHandler(CaminhoNaoEncontradoExceptions.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Caminho não encontrado")
	public @ResponseBody ApiStatusDto naoExiste(final CaminhoNaoEncontradoExceptions caminhoNaoEncontradoExceptions) {
		return MensagemErroDto
				.builder()
				.mensagem(caminhoNaoEncontradoExceptions.getMessage())
				.codigo(98)
				.build();
	}

	@ExceptionHandler(SistemaIndisponivelException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Sistema indisponivel no momento. Tente novamente mais tarde.")
	public @ResponseBody ApiStatusDto naoExiste(final SistemaIndisponivelException sistemaIndisponivelException) {
		return MensagemErroDto
				.builder()
				.mensagem(sistemaIndisponivelException.getMessage())
				.codigo(99)
				.build();
	}
}
