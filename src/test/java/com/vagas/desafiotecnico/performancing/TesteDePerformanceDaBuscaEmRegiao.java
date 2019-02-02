package com.vagas.desafiotecnico.performancing;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Test;

import com.vagas.desafiotecnico.creators.CriadorLocalidade;
import com.vagas.desafiotecnico.functions.FuncaoMenorCaminho;
import com.vagas.desafiotecnico.models.Localidade;
import com.vagas.desafiotecnico.models.Regiao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TesteDePerformanceDaBuscaEmRegiao {

	private FuncaoMenorCaminho funcaoMenorCaminho = new FuncaoMenorCaminho();

	private Regiao regiao;
	private String primeiraLocalidade = UUID.randomUUID().toString();
	private String ultimaLocalidade;
	private AtomicInteger size = new AtomicInteger(0);

	@Before
	public void condicoesIniciais() {
		log.debug("m=condicoesIniciais");
		
		final Long begin = System.currentTimeMillis();
		
		regiao = CriaMegaRegiaoParaTestePerformance.criar(CriadorLocalidade.criarLocalidade(primeiraLocalidade),
				900_000, uuidLocalidade -> {
					ultimaLocalidade = uuidLocalidade;
					size.incrementAndGet();
				});
		
		final Long end = System.currentTimeMillis();
		
		log.debug("m=condicoesIniciais, interval={} {}", end - begin, "milis");
	}

	@Test(timeout = 2L)
	public void teste() {
		log.debug("m=teste");
		
		final Long begin = System.nanoTime();
		final Long beginMilis = System.currentTimeMillis();
		
		funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao,
				Localidade.builder().ponto(ultimaLocalidade).build());
		
		final Long end = System.nanoTime();
		final Long endMilis = System.currentTimeMillis();
		
		log.debug("m=teste, size={}", size.get());
		log.debug("m=teste, interval={} {}", end - begin, "nanos");
		log.debug("m=teste, interval={} {}", endMilis - beginMilis, "milis");
	}

}
