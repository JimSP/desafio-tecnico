package com.vagas.desafiotecnico.models;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * Representa uma pontuacao.
 * 
 * @author alexandre
 *
 */
@Data
@Builder
@EqualsAndHashCode(of="pontos")
public final class Pontuacao implements Serializable{

	private static final long serialVersionUID = -3136288410266617435L;

	private final BigDecimal pontos;
	
	public Integer getPontuacao() {
		return pontos.intValue();
	}
}
