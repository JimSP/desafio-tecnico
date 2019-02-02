package com.vagas.desafiotecnico.creators;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import com.vagas.desafiotecnico.models.Localidade;
import com.vagas.desafiotecnico.models.Ponto;

public final class CriadorLocalidade {
	
	private CriadorLocalidade() {
		
	}

	public static Localidade criarLocalidade(final Ponto ponto) {
		return Localidade
				.builder()
				.ponto(ponto.name())
				.distancia(Integer.MAX_VALUE)
				.localidadesVisinhas(new HashMap<>())
				.localidades(Collections.synchronizedList(new LinkedList<>()))
				.build();
	}
	
	public static Localidade criarLocalidade(final String ponto) {
		return Localidade
				.builder()
				.ponto(ponto)
				.distancia(Integer.MAX_VALUE)
				.localidadesVisinhas(new HashMap<>())
				.localidades(Collections.synchronizedList(new LinkedList<>()))
				.build();
	}
}
