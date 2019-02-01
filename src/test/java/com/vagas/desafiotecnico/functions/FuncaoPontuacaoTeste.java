package com.vagas.desafiotecnico.functions;

import static org.junit.Assert.assertThat;

import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vagas.desafiotecnico.models.D;
import com.vagas.desafiotecnico.models.N;
import com.vagas.desafiotecnico.models.NivelExperiencia;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FuncaoPontuacaoTeste {

	@Autowired
	private FuncaoPontuacao funcaoPontuacao;

	@Test
	public void calcular() {
		
		log.debug("m=calcular");
		
		assertThat(funcaoPontuacao.calcular(
				N.builder()
				.nivelExperienciaCandidato(NivelExperiencia.ESPECIALISTA)
						.nivelExperienciaEsperado(NivelExperiencia.ESTAGIARIO)
						.build(),
				D.MAIOR_QUE_DEZ_E_MENOR_OU_IGUAL_QUE_QUINZE)
				.getPontuacao(), equalTo(Integer.valueOf(125)));
		
		assertThat(funcaoPontuacao.calcular(
				N.builder()
				.nivelExperienciaCandidato(NivelExperiencia.ESPECIALISTA)
						.nivelExperienciaEsperado(NivelExperiencia.JUNIOR)
						.build(),
				D.MAIOR_QUE_DEZ_E_MENOR_OU_IGUAL_QUE_QUINZE)
				.getPontuacao(), equalTo(Integer.valueOf(112)));
		
		assertThat(funcaoPontuacao.calcular(
				N.builder()
				.nivelExperienciaCandidato(NivelExperiencia.ESPECIALISTA)
						.nivelExperienciaEsperado(NivelExperiencia.PLENO)
						.build(),
				D.MAIOR_QUE_DEZ_E_MENOR_OU_IGUAL_QUE_QUINZE)
				.getPontuacao(), equalTo(Integer.valueOf(100)));
		
		assertThat(funcaoPontuacao.calcular(
				N.builder()
				.nivelExperienciaCandidato(NivelExperiencia.ESPECIALISTA)
						.nivelExperienciaEsperado(NivelExperiencia.SENIOR)
						.build(),
				D.MAIOR_QUE_DEZ_E_MENOR_OU_IGUAL_QUE_QUINZE)
				.getPontuacao(), equalTo(Integer.valueOf(87)));
		
		assertThat(funcaoPontuacao.calcular(
				N.builder()
				.nivelExperienciaCandidato(NivelExperiencia.ESPECIALISTA)
						.nivelExperienciaEsperado(NivelExperiencia.ESPECIALISTA)
						.build(),
				D.MAIOR_QUE_DEZ_E_MENOR_OU_IGUAL_QUE_QUINZE)
				.getPontuacao(), equalTo(Integer.valueOf(75)));
	}

}
