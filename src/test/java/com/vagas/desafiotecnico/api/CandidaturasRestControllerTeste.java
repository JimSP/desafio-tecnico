package com.vagas.desafiotecnico.api;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.vagas.desafiotecnico.dtos.CandidatoDto;
import com.vagas.desafiotecnico.dtos.CandidaturaDto;
import com.vagas.desafiotecnico.dtos.MensagemErroDto;
import com.vagas.desafiotecnico.dtos.VagaDto;
import com.vagas.desafiotecnico.models.NivelExperiencia;
import com.vagas.desafiotecnico.models.Ponto;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Slf4j
public class CandidaturasRestControllerTeste {

	private static final String URL_POST_PESSOAS = "http://localhost:%s/v1/pessoas";
	private static final String URL_POST_VAGAS = "/v1/vagas";
	private static final String URL_POST_CANDIDATURA = "http://localhost:%s/v1/candidaturas";
	private static final String URL_GET_RANKING = "/v1/vagas/{id_vaga}/candidaturas/ranking";

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int serverPort;

	@Test
	public void postAndGetOKTeste() {
		
		log.debug("m=postAndGetOKTeste");

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		final CandidatoDto candidato = criarCandidato(headers, Ponto.A, NivelExperiencia.ESTAGIARIO);
		log.debug("m=postAndGetOKTeste, msg=\"candidato criado\", candidato={}", candidato);
		assertNotNull(candidato.getId());
		
		final VagaDto vaga = criarVaga(headers, Ponto.E, NivelExperiencia.SENIOR);
		log.debug("m=postAndGetOKTeste, msg=\"vaga criada\", candidato={}", vaga);
		assertNotNull(vaga.getId());
		
		final CandidaturaDto candidatura = criarCandidatura(headers, candidato, vaga);
		log.debug("m=postAndGetOKTeste, msg=\"candidatura efetuada\", candidatura={}", candidatura);

		final List<CandidatoDto> candidatos = buscarRanckingDoCandidato(candidatura);
		log.debug("m=postAndGetOKTeste, msg=\"buscar rancking dos candidato\", candidatos.size={}", candidatos.size());

		assertThat(candidatos.get(0).getPontuacao(), equalTo(25));
	}

	@Test
	public void postNotFoundTeste() {
		
		log.debug("m=postNotFoundTeste");
		
		final CandidaturaDto candidatura = CandidaturaDto.builder().idCandidato(BigInteger.TEN).idVaga(BigInteger.ONE)
				.build();

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		final HttpEntity<CandidaturaDto> httpEntity = new HttpEntity<>(candidatura, headers);

		final ResponseEntity<CandidaturaDto> postResponseEntity = restTemplate
				.postForEntity(String.format(URL_POST_CANDIDATURA, serverPort), httpEntity, CandidaturaDto.class);

		assertThat(postResponseEntity.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
	}

	@Test
	public void getNotFoundTeste() {
		
		log.debug("m=getNotFoundTeste");
		
		final ResponseEntity<MensagemErroDto> responseEntity = restTemplate.exchange(
				String.format(URL_GET_RANKING, serverPort), HttpMethod.GET, null, MensagemErroDto.class,
				Collections.singletonMap("id_vaga", Long.MIN_VALUE));

		assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
	}

	private CandidatoDto criarCandidato(final HttpHeaders headers, final Ponto ponto,
			final NivelExperiencia nivelExperiencia) {
		final CandidatoDto candidato = CandidatoDto.builder().localizacao(ponto.name()).nivel(nivelExperiencia.getNivel())
				.nome("JUNIT TEST").profissao("TESTADOR").build();

		final HttpEntity<CandidatoDto> httpEntityCandidato = new HttpEntity<>(candidato, headers);

		final ResponseEntity<CandidatoDto> responseEntity = restTemplate
				.postForEntity(String.format(URL_POST_PESSOAS, serverPort), httpEntityCandidato, CandidatoDto.class);

		assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.CREATED));

		return responseEntity.getBody();
	}

	private VagaDto criarVaga(final HttpHeaders headers, final Ponto ponto, final NivelExperiencia nivelExperiencia) {
		final VagaDto vaga = VagaDto.builder().localizacao(ponto.name()).nivel(nivelExperiencia.getNivel())
				.descricao("DESCRICAO VAGA TESTADOR").empresa("LOJA DE TESTES").titulo("TITULO VAGA TESTADOR").build();

		final HttpEntity<VagaDto> httpEntityVaga = new HttpEntity<>(vaga, headers);

		final ResponseEntity<VagaDto> responseEntity = restTemplate
				.postForEntity(String.format(URL_POST_VAGAS, serverPort), httpEntityVaga, VagaDto.class);

		assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.CREATED));

		return responseEntity.getBody();
	}

	private CandidaturaDto criarCandidatura(final HttpHeaders headers, final CandidatoDto candidato,
			final VagaDto vaga) {

		final CandidaturaDto candidatura = CandidaturaDto.builder().idCandidato(candidato.getId()).idVaga(vaga.getId())
				.build();

		final HttpEntity<CandidaturaDto> httpEntityCandidatura = new HttpEntity<>(candidatura, headers);

		final ResponseEntity<CandidaturaDto> postResponseEntity = restTemplate.postForEntity(
				String.format(URL_POST_CANDIDATURA, serverPort), httpEntityCandidatura, CandidaturaDto.class);

		final CandidaturaDto candidaturaOK = postResponseEntity.getBody();

		assertThat(postResponseEntity.getStatusCode(), equalTo(HttpStatus.CREATED));
		return candidaturaOK;
	}

	private List<CandidatoDto> buscarRanckingDoCandidato(final CandidaturaDto candidaturaOK) {

		final ResponseEntity<List<CandidatoDto>> getResponseEntity = restTemplate.exchange(
				String.format(URL_GET_RANKING, serverPort), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<CandidatoDto>>() {
				}, Collections.singletonMap("id_vaga", candidaturaOK.getIdVaga().longValue()));

		assertThat(getResponseEntity.getStatusCode(), equalTo(HttpStatus.OK));

		return getResponseEntity.getBody();
	}

}
