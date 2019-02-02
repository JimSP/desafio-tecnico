package com.vagas.desafiotecnico.models;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * Número N: 100 - (25 * (nivelExperienciaEsperado -  nivelExperienciaCandidato))
 * 
 * 
 * @author alexandre
 *
 */
@Data
@Builder
@EqualsAndHashCode(callSuper=false)
public final class N implements Serializable {

	private static final long serialVersionUID = 5644855017828439162L;

	private final NivelExperiencia nivelExperienciaEsperado;
	private final NivelExperiencia nivelExperienciaCandidato;

	/***
	 * efetua o calculo de N
	 * @return BigDecimal
	 */
	public BigDecimal getN() {
		return BigDecimal
				.valueOf(100L - (25L * (nivelExperienciaEsperado.ordinal() - nivelExperienciaCandidato.ordinal())));
	}
}
