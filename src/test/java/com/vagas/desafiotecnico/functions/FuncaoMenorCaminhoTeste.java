package com.vagas.desafiotecnico.functions;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vagas.desafiotecnico.creators.CriadorRegiaoTeste;
import com.vagas.desafiotecnico.models.Ponto;
import com.vagas.desafiotecnico.models.Regiao;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FuncaoMenorCaminhoTeste {

	@Autowired
	private FuncaoMenorCaminho funcaoMenorCaminho;

	@Test
	public void teste() {

		log.debug("m=teste");

		final Regiao regiao = CriadorRegiaoTeste.criarRegiaoDeTeste();

		log.debug("m=teste, msg=\"regiao criada\", regiao={}", regiao);

		funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.A).ifPresent(localidadeA -> {
			log.debug("m=teste, msg=\"busca localidade A\", localidade={}", localidadeA);
			funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeA);
			assertThat(localidadeA.getDistancia(), equalTo(0));
		});

		funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.B).ifPresent(localidadeB -> {
			log.debug("m=teste, msg=\"busca localidade B\", localidade={}", localidadeB);
			assertThat(localidadeB.getDistancia(), equalTo(5));
		});

		funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.C).ifPresent(localidadeC -> {
			log.debug("m=teste, msg=\"busca localidade C\", localidade={}", localidadeC);
			assertThat(localidadeC.getDistancia(), equalTo(12));
		});

		funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.D).ifPresent(localidadeD -> {
			log.debug("m=teste, msg=\"busca localidade D\", localidade={}", localidadeD);
			assertThat(localidadeD.getDistancia(), equalTo(8));
		});

		funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.E).ifPresent(localidadeE -> {
			log.debug("m=teste, msg=\"busca localidade E\", localidade={}", localidadeE);
			assertThat(localidadeE.getDistancia(), equalTo(16));
		});

		funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.F).ifPresent(localidadeF -> {
			log.debug("m=teste, msg=\"busca localidade F\", localidade={}", localidadeF);
			assertThat(localidadeF.getDistancia(), equalTo(16));
		});

	}
}
