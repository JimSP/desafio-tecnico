package com.vagas.desafiotecnico.models;

import java.util.Arrays;

public enum NivelExperiencia {

	ESTAGIARIO(1), JUNIOR(2), PLENO(3), SENIOR(4), ESPECIALISTA(5);

	private final Integer nivel;

	private NivelExperiencia(final Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getNivel() {
		return nivel;
	}

	public static NivelExperiencia of(final Integer nivel) {
		return Arrays
				.asList(NivelExperiencia.values())
				.stream()
				.filter(nivelExperiencia -> nivelExperiencia.nivel == nivel)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(String.format("nivel=%s invalido", nivel)));
	}
}
