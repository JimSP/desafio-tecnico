package com.vagas.desafiotecnico;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.testing.EqualsTester;
import com.vagas.desafiotecnico.dtos.CandidatoDto;
import com.vagas.desafiotecnico.dtos.CandidaturaDto;
import com.vagas.desafiotecnico.dtos.VagaDto;
import com.vagas.desafiotecnico.models.Candidato;
import com.vagas.desafiotecnico.models.Candidatura;
import com.vagas.desafiotecnico.models.Localidade;
import com.vagas.desafiotecnico.models.NivelExperiencia;
import com.vagas.desafiotecnico.models.Ponto;
import com.vagas.desafiotecnico.models.Pontuacao;
import com.vagas.desafiotecnico.models.Regiao;
import com.vagas.desafiotecnico.models.Vaga;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DesafioTecnicoApplicationTests {

	@Test
	public void contextLoads() {
		log.debug("m=contextLoads");
	}

	@Test
	public void equalsAndHashCodeTesteOK() {

		final CandidatoDto candidatoDto = CandidatoDto
				.builder()
				.codigo(0)
				.id(BigInteger.TEN)
				.localizacao("X")
				.mensagem("OK")
				.nivel(3)
				.nome("NOME")
				.pontuacao(Integer.MAX_VALUE)
				.build();
		
		final Candidato candidato = Candidato
				.builder()
				.id(BigInteger.TEN)
				.localizacao(Ponto.P)
				.nivel(NivelExperiencia.JUNIOR)
				.nome("NOME")
				.pontuacao(Integer.MAX_VALUE)
				.build();

		final VagaDto vagaDto = VagaDto
				.builder()
				.codigo(0)
				.descricao("DESCRICAO")
				.empresa("EMPRESA")
				.id(BigInteger.ONE)
				.localizacao("Y")
				.mensagem("OK")
				.nivel(5)
				.titulo("TITULO")
				.build();
		
		final Vaga vaga = Vaga
				.builder()
				.descricao("DESCRICAO")
				.empresa("EMPRESA")
				.id(BigInteger.ONE)
				.localizacao(Ponto.T)
				.nivel(NivelExperiencia.PLENO)
				.titulo("TITULO")
				.build();

		final CandidaturaDto candidaturaDto = CandidaturaDto
				.builder()
				.codigo(0)
				.mensagem("OK")
				.idCandidato(BigInteger.ZERO)
				.idVaga(BigInteger.TEN)
				.build();
		
		final Candidatura candidatura = Candidatura
				.builder()
				.candidato(candidato)
				.vaga(vaga)
				.id(BigInteger.ONE)
				.build();
		
		final Localidade localidadeB = Localidade
				.builder()
				.distancia(Integer.MIN_VALUE)
				.ponto(Ponto.B)
				.build();
		
		final Localidade localidadeC = Localidade
				.builder()
				.distancia(Integer.MIN_VALUE)
				.ponto(Ponto.C)
				.build();

		final Localidade localidadeA = Localidade
				.builder()
				.distancia(Integer.MIN_VALUE)
				.ponto(Ponto.A)
				.localidades(Arrays.asList(localidadeB, localidadeC))
				.build();

		final Regiao regiao = Regiao
				.builder()
				.id(BigInteger.ONE)
				.localidades(new HashSet<Localidade>(Arrays.asList(localidadeA)))
				.build();

		final Pontuacao pontuacao = Pontuacao.builder().build();

		new EqualsTester()
			.addEqualityGroup(candidatoDto, candidatoDto)
			.addEqualityGroup(candidato, candidato)
			.addEqualityGroup(vagaDto, vagaDto)
			.addEqualityGroup(vaga, vaga)
			.addEqualityGroup(candidaturaDto, candidaturaDto)
			.addEqualityGroup(candidatura, candidatura)
			.addEqualityGroup(regiao, regiao)
			.addEqualityGroup(localidadeA, localidadeA)
			.addEqualityGroup(pontuacao, pontuacao)
			.testEquals();
	}
}
