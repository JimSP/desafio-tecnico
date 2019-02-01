package com.vagas.desafiotecnico.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SistemaIndisponivelException extends RuntimeException{

	private static final long serialVersionUID = 2716090825782909008L;

	public SistemaIndisponivelException(final String message) {
		super(message);
	}
}
