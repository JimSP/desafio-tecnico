package com.vagas.desafiotecnico.exceptions;

import java.math.BigInteger;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CandidaturaNaoExisteExceptions extends IllegalArgumentException {

	private static final long serialVersionUID = -3244930528994370469L;

	private final BigInteger idVaga;

	public CandidaturaNaoExisteExceptions(final BigInteger idVaga) {
		super("Não existe candidatura para a vaga.");
		this.idVaga = idVaga;
	}
}
