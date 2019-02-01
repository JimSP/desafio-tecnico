package com.vagas.desafiotecnico.exceptions;

import java.math.BigInteger;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class VagaNaoExisteException extends IllegalArgumentException{
	
	private static final long serialVersionUID = -5582557881767848511L;
	
	private final BigInteger idVaga;

	public VagaNaoExisteException(final BigInteger idVaga) {
		super("vaga não existe.");
		this.idVaga = idVaga;
	}
}
