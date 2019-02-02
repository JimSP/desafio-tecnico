package com.vagas.desafiotecnico.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vagas.desafiotecnico.creators.CriadorRegiaoTeste;
import com.vagas.desafiotecnico.models.Regiao;
import com.vagas.desafiotecnico.services.RegioesInterface;

@Component
public class CriaRegiaoTestCommandLineRunner implements CommandLineRunner {

	@Autowired
	private RegioesInterface regioesService;

	@Override
	public void run(String... args) throws Exception {

		if (!regioesService.existeRegiao()) {
			final Regiao regiaoA = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirA();
			regioesService.salvar(regiaoA);
			
			final Regiao regiaoB = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirB();
			regioesService.salvar(regiaoB);
			
			final Regiao regiaoC = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirC();
			regioesService.salvar(regiaoC);
			
			final Regiao regiaoD = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirD();
			regioesService.salvar(regiaoD);
			
			final Regiao regiaoE = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirE();
			regioesService.salvar(regiaoE);
			
			final Regiao regiaoF = CriadorRegiaoTeste.criarRegiaoDeTesteAPartirF();
			regioesService.salvar(regiaoF);
		}
	}

}
