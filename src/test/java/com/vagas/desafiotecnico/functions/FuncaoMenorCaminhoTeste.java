package com.vagas.desafiotecnico.functions;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vagas.desafiotecnico.creators.CriadorRegiaoTeste;
import com.vagas.desafiotecnico.models.Localidade;
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
		
		final Localidade localidadeA = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.A);
		log.debug("m=teste, msg=\"busca localidade A\", localidade={}", localidadeA);
		
		final Localidade localidadeB = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.B);
		log.debug("m=teste, msg=\"busca localidade B\", localidade={}", localidadeB);
		
		final Localidade localidadeC = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.C);
		log.debug("m=teste, msg=\"busca localidade C\", localidade={}", localidadeC);
		
		final Localidade localidadeD = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.D);
		log.debug("m=teste, msg=\"busca localidade D\", localidade={}", localidadeD);
		
		final Localidade localidadeE = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.E);
		log.debug("m=teste, msg=\"busca localidade E\", localidade={}", localidadeE);
		
		final Localidade localidadeF = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.F);
		log.debug("m=teste, msg=\"busca localidade F\", localidade={}", localidadeF);

		funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeA);

		assertThat(localidadeA.getDistancia(), equalTo(0));
		assertThat(localidadeB.getDistancia(), equalTo(5));
		assertThat(localidadeC.getDistancia(), equalTo(12));
		assertThat(localidadeD.getDistancia(), equalTo(8));
		assertThat(localidadeE.getDistancia(), equalTo(16));
		assertThat(localidadeF.getDistancia(), equalTo(16));
	}
}
