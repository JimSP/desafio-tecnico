package com.vagas.desafiotecnico.functions;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vagas.desafiotecnico.creators.CriadorRegiaoTeste;
import com.vagas.desafiotecnico.models.Caminho;
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
	public void buscaPorCaminhoAB() {
		
		log.debug("m=buscaPorCaminhoAB");
		
		final Regiao regiao = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirA();
		
		final Optional<Localidade> localidadeOrigem = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.A);
		final Optional<Localidade> localidadeDestino = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.B);
		
		if(localidadeOrigem.isPresent() && localidadeDestino.isPresent()) {
			final Caminho caminho = funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeOrigem.get(), localidadeDestino.get());
			assertThat(caminho.getDistancia(), equalTo(5));
		}else {
			fail();
		}
	}

	@Test
	public void buscaPorCaminhoBC() {
		
		log.debug("m=buscaPorCaminhoBC");
		
		final Regiao regiao = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirA();
		
		final Optional<Localidade> localidadeOrigem = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.B);
		final Optional<Localidade> localidadeDestino = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.C);
		
		if(localidadeOrigem.isPresent() && localidadeDestino.isPresent()) {
			final Caminho caminho = funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeOrigem.get(), localidadeDestino.get());
			assertThat(caminho.getDistancia(), equalTo(7));
		}else {
			fail();
		}
	}
	
	@Test
	public void buscaPorCaminhoBD() {
		
		log.debug("m=buscaPorCaminhoBD");
		
		final Regiao regiao = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirA();
		
		final Optional<Localidade> localidadeOrigem = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.B);
		final Optional<Localidade> localidadeDestino = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.D);
		
		if(localidadeOrigem.isPresent() && localidadeDestino.isPresent()) {
			final Caminho caminho = funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeOrigem.get(), localidadeDestino.get());
			assertThat(caminho.getDistancia(), equalTo(3));
		}else {
			fail();
		}
	}
	
	@Test
	public void buscaPorCaminhoCE() {
		
		log.debug("m=buscaPorCaminhoCE");
		
		final Regiao regiao = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirA();
		
		final Optional<Localidade> localidadeOrigem = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.C);
		final Optional<Localidade> localidadeDestino = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.E);
		
		if(localidadeOrigem.isPresent() && localidadeDestino.isPresent()) {
			final Caminho caminho = funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeOrigem.get(), localidadeDestino.get());
			assertThat(caminho.getDistancia(), equalTo(4));
		}else {
			fail();
		}
	}
	
	@Test
	public void buscaPorCaminhoDE() {
		
		log.debug("m=buscaPorCaminhoDE");
		
		final Regiao regiao = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirA();
		
		final Optional<Localidade> localidadeOrigem = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.D);
		final Optional<Localidade> localidadeDestino = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.E);
		
		if(localidadeOrigem.isPresent() && localidadeDestino.isPresent()) {
			final Caminho caminho = funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeOrigem.get(), localidadeDestino.get());
			assertThat(caminho.getDistancia(), equalTo(10));
		}else {
			fail();
		}
	}
	
	@Test
	public void buscaPorCaminhoAC() {
		
		log.debug("m=buscaPorCaminhoAC");
		
		final Regiao regiao = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirA();
		
		final Optional<Localidade> localidadeOrigem = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.A);
		final Optional<Localidade> localidadeDestino = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.C);
		
		if(localidadeOrigem.isPresent() && localidadeDestino.isPresent()) {
			final Caminho caminho = funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeOrigem.get(), localidadeDestino.get());
			assertThat(caminho.getDistancia(), equalTo(12));
		}else {
			fail();
		}
	}
	
	@Test
	public void buscaPorCaminhoAD() {
		
		log.debug("m=buscaPorCaminhoAD");
		
		final Regiao regiao = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirA();
		
		final Optional<Localidade> localidadeOrigem = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.A);
		final Optional<Localidade> localidadeDestino = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.D);
		
		if(localidadeOrigem.isPresent() && localidadeDestino.isPresent()) {
			final Caminho caminho = funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeOrigem.get(), localidadeDestino.get());
			assertThat(caminho.getDistancia(), equalTo(8));
		}else {
			fail();
		}
	}
	
	@Test
	public void buscaPorCaminhoAE() {
		
		log.debug("m=buscaPorCaminhoAE");
		
		final Regiao regiao = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirA();
		
		final Optional<Localidade> localidadeOrigem = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.A);
		final Optional<Localidade> localidadeDestino = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.E);
		
		if(localidadeOrigem.isPresent() && localidadeDestino.isPresent()) {
			final Caminho caminho = funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeOrigem.get(), localidadeDestino.get());
			assertThat(caminho.getDistancia(), equalTo(16));
		}else {
			fail();
		}
	}
	
	@Test
	public void buscaPorCaminhoAF() {
		
		log.debug("m=buscaPorCaminhoAE");
		
		final Regiao regiao = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirA();
		
		final Optional<Localidade> localidadeOrigem = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.A);
		final Optional<Localidade> localidadeDestino = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.F);
		
		if(localidadeOrigem.isPresent() && localidadeDestino.isPresent()) {
			final Caminho caminho = funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeOrigem.get(), localidadeDestino.get());
			assertThat(caminho.getDistancia(), equalTo(16));
		}else {
			fail();
		}
	}
	
	@Test
	public void buscaPorCaminhoDF() {
		
		log.debug("m=buscaPorCaminhoDE");
		
		final Regiao regiao = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirA();
		
		final Optional<Localidade> localidadeOrigem = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.D);
		final Optional<Localidade> localidadeDestino = funcaoMenorCaminho.buscarLocalidade(regiao, Ponto.F);
		
		if(localidadeOrigem.isPresent() && localidadeDestino.isPresent()) {
			final Caminho caminho = funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeOrigem.get(), localidadeDestino.get());
			assertThat(caminho.getDistancia(), equalTo(8));
		}else {
			fail();
		}
	}
	
	@Test
	public void buscaAteLocalidadeTeste() {

		log.debug("m=buscaAteLocalidadeTeste");

		final Regiao regiao = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirA();

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
