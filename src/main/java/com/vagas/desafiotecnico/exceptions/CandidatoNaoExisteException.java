package com.vagas.desafiotecnico.exceptions;

import java.math.BigInteger;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CandidatoNaoExisteException extends IllegalArgumentException{
	
	private static final long serialVersionUID = 2249304558682228744L;
	
	private final BigInteger idCandidato;

	public CandidatoNaoExisteException(final BigInteger idCandidato) {
		super("candidato não existe.");
		this.idCandidato = idCandidato;
	}
}
