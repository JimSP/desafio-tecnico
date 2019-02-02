package com.vagas.desafiotecnico.general;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

import com.google.common.testing.EqualsTester;
import com.vagas.desafiotecnico.dtos.CandidatoDto;
import com.vagas.desafiotecnico.dtos.CandidaturaDto;
import com.vagas.desafiotecnico.dtos.StatusCodeDto;
import com.vagas.desafiotecnico.dtos.VagaDto;
import com.vagas.desafiotecnico.models.Candidato;
import com.vagas.desafiotecnico.models.Candidatura;
import com.vagas.desafiotecnico.models.Localidade;
import com.vagas.desafiotecnico.models.NivelExperiencia;
import com.vagas.desafiotecnico.models.Ponto;
import com.vagas.desafiotecnico.models.Pontuacao;
import com.vagas.desafiotecnico.models.Regiao;
import com.vagas.desafiotecnico.models.Vaga;

public class EqualsAndHashCodeTeste {
	
	private static final int TRES = 3;
	private static final int CINCO = 5;
	private static final String NOME = "NOME";
	private static final String TITULO = "TITULO";
	private static final String EMPRESA = "EMPRESA";
	private static final String DESCRICAO = "DESCRICAO";

	private final CandidatoDto candidatoDto = CandidatoDto
			.builder()
			.codigo(0)
			.id(BigInteger.TEN)
			.localizacao("X")
			.mensagem("OK")
			.nivel(TRES)
			.nome(NOME)
			.pontuacao(Integer.MAX_VALUE)
			.build();
	
	private final Candidato candidato = Candidato
			.builder()
			.id(BigInteger.TEN)
			.localizacao(Ponto.P)
			.nivel(NivelExperiencia.JUNIOR)
			.nome(NOME)
			.pontuacao(Integer.MAX_VALUE)
			.build();

	private final VagaDto vagaDto = VagaDto
			.builder()
			.codigo(StatusCodeDto.CODIGO_SUCESSO.getCodigo())
			.descricao(DESCRICAO)
			.empresa(EMPRESA)
			.id(BigInteger.ONE)
			.localizacao(Ponto.Y.name())
			.mensagem(StatusCodeDto.CODIGO_SUCESSO.getMensagem())
			.nivel(CINCO)
			.titulo(TITULO)
			.build();
	
	private final Vaga vaga = Vaga
			.builder()
			.descricao(DESCRICAO)
			.empresa(EMPRESA)
			.id(BigInteger.ONE)
			.localizacao(Ponto.T)
			.nivel(NivelExperiencia.PLENO)
			.titulo(TITULO)
			.build();

	private final CandidaturaDto candidaturaDto = CandidaturaDto
			.builder()
			.codigo(0)
			.mensagem(StatusCodeDto.CODIGO_SUCESSO.getMensagem())
			.idCandidato(BigInteger.ZERO)
			.idVaga(BigInteger.TEN)
			.build();
	
	private final Candidatura candidatura = Candidatura
			.builder()
			.candidato(candidato)
			.vaga(vaga)
			.id(BigInteger.ONE)
			.build();
	
	private final Localidade localidadeB = Localidade
			.builder()
			.distancia(Integer.MIN_VALUE)
			.ponto(Ponto.B.name())
			.build();
	
	final Localidade localidadeC = Localidade
			.builder()
			.distancia(Integer.MIN_VALUE)
			.ponto(Ponto.C.name())
			.build();

	private final Localidade localidadeA = Localidade
			.builder()
			.distancia(Integer.MIN_VALUE)
			.ponto(Ponto.A.name())
			.localidades(Arrays.asList(localidadeB, localidadeC))
			.build();

	private final Regiao regiao = Regiao
			.builder()
			.id(BigInteger.ONE)
			.localidades(new HashSet<Localidade>(Arrays.asList(localidadeA)))
			.build();

	private final Pontuacao pontuacao = Pontuacao.builder().pontos(BigDecimal.TEN).build();
	
	
	
	private final CandidatoDto outroCandidatoDto = CandidatoDto
			.builder()
			.codigo(StatusCodeDto.CODIGO_SUCESSO.getCodigo())
			.id(BigInteger.TEN)
			.localizacao(Ponto.X.name())
			.mensagem(StatusCodeDto.CODIGO_SUCESSO.getMensagem())
			.nivel(TRES)
			.nome(NOME)
			.pontuacao(Integer.MAX_VALUE)
			.build();
	
	private final Candidato outroCandidato = Candidato
			.builder()
			.id(BigInteger.TEN)
			.localizacao(Ponto.P)
			.nivel(NivelExperiencia.JUNIOR)
			.nome(NOME)
			.pontuacao(Integer.MAX_VALUE)
			.build();

	private final VagaDto outraVagaDto = VagaDto
			.builder()
			.codigo(0)
			.descricao(DESCRICAO)
			.empresa(EMPRESA)
			.id(BigInteger.ONE)
			.localizacao(Ponto.Y.name())
			.mensagem(StatusCodeDto.CODIGO_SUCESSO.getMensagem())
			.nivel(CINCO)
			.titulo(TITULO)
			.build();
	
	private final Vaga outraVaga = Vaga
			.builder()
			.descricao(DESCRICAO)
			.empresa(EMPRESA)
			.id(BigInteger.ONE)
			.localizacao(Ponto.T)
			.nivel(NivelExperiencia.PLENO)
			.titulo(TITULO)
			.build();

	private final CandidaturaDto outraCandidaturaDto = CandidaturaDto
			.builder()
			.codigo(StatusCodeDto.CODIGO_SUCESSO.getCodigo())
			.mensagem(StatusCodeDto.CODIGO_SUCESSO.getMensagem())
			.idCandidato(BigInteger.ZERO)
			.idVaga(BigInteger.TEN)
			.build();
	
	private final Candidatura outraCandidatura = Candidatura
			.builder()
			.candidato(candidato)
			.vaga(vaga)
			.id(BigInteger.ONE)
			.build();
	
	private final Localidade outrAlocalidadeB = Localidade
			.builder()
			.distancia(Integer.MIN_VALUE)
			.ponto(Ponto.B.name())
			.build();
	
	final Localidade outroLocalidadeC = Localidade
			.builder()
			.distancia(Integer.MIN_VALUE)
			.ponto(Ponto.C.name())
			.build();

	private final Localidade outroLocalidadeA = Localidade
			.builder()
			.distancia(Integer.MIN_VALUE)
			.ponto(Ponto.A.name())
			.localidades(Arrays.asList(localidadeB, localidadeC))
			.build();

	private final Regiao outraRegiao = Regiao
			.builder()
			.id(BigInteger.ONE)
			.localidades(new HashSet<Localidade>(Arrays.asList(outrAlocalidadeB)))
			.build();

	private final Pontuacao outroPontuacao = Pontuacao.builder().pontos(BigDecimal.TEN).build();

	@Test
	public void equalsAndHashCodeTesteMesmoObjeto() {

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
	
	@Test
	public void equalsAndHashCodeTesteOutroObjeto() {

		new EqualsTester()
			.addEqualityGroup(candidatoDto, outroCandidatoDto)
			.addEqualityGroup(candidato, outroCandidato)
			.addEqualityGroup(vagaDto, outraVagaDto)
			.addEqualityGroup(vaga, outraVaga)
			.addEqualityGroup(candidaturaDto, outraCandidaturaDto)
			.addEqualityGroup(candidatura, outraCandidatura)
			.addEqualityGroup(regiao, outraRegiao)
			.addEqualityGroup(localidadeA, outroLocalidadeA)
			.addEqualityGroup(pontuacao, outroPontuacao)
			.testEquals();
	}

}
