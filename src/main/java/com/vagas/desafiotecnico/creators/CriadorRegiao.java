package com.vagas.desafiotecnico.creators;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import com.vagas.desafiotecnico.models.Localidade;
import com.vagas.desafiotecnico.models.Regiao;

public final class CriadorRegiao {
	
	private CriadorRegiao() {
		
	}

	public static Regiao criarRegiao(final Localidade... localidades) {
		return Regiao
				.builder()
				.localidades(Collections.synchronizedSet(new HashSet<>(Arrays.asList(localidades))))
				.build();
	}

}
