package com.vagas.desafiotecnico.functions;

import com.vagas.desafiotecnico.models.D;
import com.vagas.desafiotecnico.models.N;
import com.vagas.desafiotecnico.models.Pontuacao;

@FunctionalInterface
public interface FuncaoPontuacao {

	Pontuacao calcular(final N n, final D d);
}