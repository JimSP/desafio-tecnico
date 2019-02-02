package com.vagas.desafiotecnico.services;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vagas.desafiotecnico.exceptions.SistemaIndisponivelException;
import com.vagas.desafiotecnico.models.Candidato;
import com.vagas.desafiotecnico.models.Candidatura;
import com.vagas.desafiotecnico.models.NivelExperiencia;
import com.vagas.desafiotecnico.models.Ponto;
import com.vagas.desafiotecnico.models.Vaga;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CalcularPontuacaoCandidatoServiceTeste {

	private Candidato candidato;

	private Candidatura candidaturaB;
	private Candidatura candidaturaC;
	private Candidatura candidaturaD;
	private Candidatura candidaturaE;
	private Candidatura candidaturaF;

	@Autowired
	private CalcularPontuacaoCandidatoInterface calcularPontuacaoCandidatoService;

	@Autowired
	private CandidatosInterface candidatosService;

	@Autowired
	private VagasInterface vagasService;

	@Autowired
	private CandidaturasInterface candidaturaService;

	@Before
	public void condicoesIniciais() {
		
		log.debug("m=condicoesIniciais");
		
		candidato = Candidato.builder().localizacao(Ponto.A).nivel(NivelExperiencia.ESTAGIARIO).build();
		candidatosService.salvar(candidato);

		final Vaga vagaB = Vaga.builder().localizacao(Ponto.B).nivel(NivelExperiencia.ESTAGIARIO).build();
		final Vaga vagaC = Vaga.builder().localizacao(Ponto.C).nivel(NivelExperiencia.PLENO).build();
		final Vaga vagaD = Vaga.builder().localizacao(Ponto.D).nivel(NivelExperiencia.JUNIOR).build();
		final Vaga vagaE = Vaga.builder().localizacao(Ponto.E).nivel(NivelExperiencia.SENIOR).build();
		final Vaga vagaF = Vaga.builder().localizacao(Ponto.F).nivel(NivelExperiencia.ESPECIALISTA).build();
		final Vaga vagaNoMeioDoNada = Vaga.builder().localizacao(Ponto.Y).nivel(NivelExperiencia.ESPECIALISTA).build();

		vagasService.salvar(vagaB);
		vagasService.salvar(vagaC);
		vagasService.salvar(vagaD);
		vagasService.salvar(vagaE);
		vagasService.salvar(vagaF);
		vagasService.salvar(vagaNoMeioDoNada);

		candidaturaB = candidaturaService.candidatar(candidato, vagaB);
		candidaturaC = candidaturaService.candidatar(candidato, vagaC);
		candidaturaD = candidaturaService.candidatar(candidato, vagaD);
		candidaturaE = candidaturaService.candidatar(candidato, vagaE);
		candidaturaF = candidaturaService.candidatar(candidato, vagaF);
	}

	@Test
	public void calcularParaCandidaturas() {
		
		log.debug("m=calcularParaCandidaturas");
		
		assertThat(calcularPontuacaoCandidatoService.calcular(candidaturaB).getCandidato().getPontuacao(), equalTo(87));
		assertThat(calcularPontuacaoCandidatoService.calcular(candidaturaC).getCandidato().getPontuacao(), equalTo(50));
		assertThat(calcularPontuacaoCandidatoService.calcular(candidaturaD).getCandidato().getPontuacao(), equalTo(75));
		assertThat(calcularPontuacaoCandidatoService.calcular(candidaturaE).getCandidato().getPontuacao(), equalTo(25));
		assertThat(calcularPontuacaoCandidatoService.calcular(candidaturaF).getCandidato().getPontuacao(), equalTo(12));
	}

	@Test(expected = SistemaIndisponivelException.class)
	public void calcularParaVagaInexistente() {
		
		log.debug("m=calcularParaVagaInexistente");
		
		calcularPontuacaoCandidatoService.calcular(
				Candidatura
					.builder()
					.candidato(candidato)
					.vaga(
							Vaga
								.builder()
								.localizacao(Ponto.Z)
								.build())
					.build());
	}
}
