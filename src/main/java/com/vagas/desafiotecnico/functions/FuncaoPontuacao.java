package com.vagas.desafiotecnico.functions;

import static java.math.BigDecimal.valueOf;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.vagas.desafiotecnico.models.D;
import com.vagas.desafiotecnico.models.N;
import com.vagas.desafiotecnico.models.Pontuacao;


/***
 * Componente para calculo da Pontuação (N + D)/2
 * 
 * @author alexandre
 *
 */
@Component
public class FuncaoPontuacao {

	@Cacheable("cache-pontuacao")
	public Pontuacao calcular(N n, D d) {
		return Pontuacao
				.builder()
				.pontos(n.getN().add(valueOf(d.getPontos())).divide(valueOf(2L)))
				.build();
	}
}
