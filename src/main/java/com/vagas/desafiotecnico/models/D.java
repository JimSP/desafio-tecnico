package com.vagas.desafiotecnico.models;

/**
 * D: intervalo de distancia.
 * 
 * @author alexandre
 *
 */
public enum D {

	ZERO_ATE_CINCO(100),
	MAIOR_QUE_CINCO_E_MENOR_OU_IGUA_DEZ(75),
	MAIOR_QUE_DEZ_E_MENOR_OU_IGUAL_QUE_QUINZE(50),
	MAIOR_QUE_QUINZE_E_MENOR_OU_IGUA_QUE_VINTE(25),
	MAIOR_QUE_VINTE(0);

	private final Integer pontos;

	private D(final Integer pontos) {
		this.pontos = pontos;
	}

	public Integer getPontos() {
		return pontos;
	}
	
	/***
	 * obtem o intervalo dada uma distancia.
	 * 
	 * @param distancia
	 * @return D
	 */
	public static D of(final Integer distancia) {

		if (distancia < 5) {
			return ZERO_ATE_CINCO;
		} else if (distancia < 11) {
			return MAIOR_QUE_CINCO_E_MENOR_OU_IGUA_DEZ;
		} else if (distancia < 16) {
			return MAIOR_QUE_DEZ_E_MENOR_OU_IGUAL_QUE_QUINZE;
		} else if (distancia < 21) {
			return MAIOR_QUE_QUINZE_E_MENOR_OU_IGUA_QUE_VINTE;
		} else {
			return MAIOR_QUE_VINTE;
		}
	}
}
