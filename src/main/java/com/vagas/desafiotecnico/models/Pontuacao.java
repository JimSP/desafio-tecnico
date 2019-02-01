package com.vagas.desafiotecnico.models;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class Pontuacao implements Serializable{

	private static final long serialVersionUID = -3136288410266617435L;

	private final BigDecimal pontos;
	
	public Integer getPontuacao() {
		return pontos.intValue();
	}
}
