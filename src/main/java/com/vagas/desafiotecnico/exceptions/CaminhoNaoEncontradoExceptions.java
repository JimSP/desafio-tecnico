package com.vagas.desafiotecnico.exceptions;

import com.vagas.desafiotecnico.models.Candidatura;
import com.vagas.desafiotecnico.models.Regiao;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CaminhoNaoEncontradoExceptions extends RuntimeException{

	private static final long serialVersionUID = 7010913010983090007L;
	
	private final Candidatura candidatura;
	private final Regiao regiao;

	public CaminhoNaoEncontradoExceptions(final Candidatura candidatura, final Regiao regiao) {
		super("Caminho não encontrado, possivelmente algumas das localidades não estão ligadas, verifique a Região.");
		this.candidatura = candidatura;
		this.regiao = regiao;
	}
}
