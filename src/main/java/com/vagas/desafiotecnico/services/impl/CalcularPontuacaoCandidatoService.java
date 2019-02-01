package com.vagas.desafiotecnico.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vagas.desafiotecnico.functions.FuncaoMenorCaminho;
import com.vagas.desafiotecnico.functions.FuncaoPontuacao;
import com.vagas.desafiotecnico.models.Candidato;
import com.vagas.desafiotecnico.models.Candidatura;
import com.vagas.desafiotecnico.models.D;
import com.vagas.desafiotecnico.models.Localidade;
import com.vagas.desafiotecnico.models.N;
import com.vagas.desafiotecnico.models.Pontuacao;
import com.vagas.desafiotecnico.models.Regiao;
import com.vagas.desafiotecnico.models.Vaga;
import com.vagas.desafiotecnico.services.CalcularPontuacaoCandidatoInterface;
import com.vagas.desafiotecnico.services.RegioesInterface;

@Service
public final class CalcularPontuacaoCandidatoService implements CalcularPontuacaoCandidatoInterface {

	@Autowired
	private FuncaoPontuacao funcaoPontuacao;
	
	@Autowired
	private FuncaoMenorCaminho funcaoMenorCaminho;
	
	@Autowired
	private RegioesInterface regioesService;

	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.CalcularPontuacaoCandidatoInterface#calcular(com.vagas.desafiotecnico.models.Candidatura)
	 */
	@Override
	public Candidatura calcular(final Candidatura candidatura) {
		final Regiao regiao = regioesService.buscar();
		final Integer menorDistancia = buscarMenorDistancia(candidatura, regiao);
		final Pontuacao pontuacao = calcularPontuacao(candidatura, menorDistancia);
		candidatura.getCandidato().setPontuacao(pontuacao.getPontuacao());
		return candidatura;
	}

	protected Integer buscarMenorDistancia(final Candidatura candidatura, final Regiao regiao) {
		
		final Candidato candidato = candidatura.getCandidato();
		final Vaga vaga = candidatura.getVaga();
		
		final Localidade localidadeCandidato = funcaoMenorCaminho.buscarLocalidade(regiao, candidato.getLocalizacao());
		final Localidade localidadeVaga = funcaoMenorCaminho.buscarLocalidade(regiao, vaga.getLocalizacao());
		
		return funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeCandidato)
				.getLocalidades()
				.stream()
				.filter(predicate -> predicate.equals(localidadeVaga))
				.findFirst()
				.get()
				.getDistancia();
	}
	
	protected Pontuacao calcularPontuacao(final Candidatura candidatura, final Integer menorDistancia) {
		final N n = N
				.builder()
				.nivelExperienciaCandidato(candidatura.getCandidato().getNivel())
				.nivelExperienciaEsperado(candidatura.getVaga().getNivel())
				.build();
		
		final D d = D.of(menorDistancia);
		
		final Pontuacao pontuacao = funcaoPontuacao.calcular(n, d);
		candidatura.getCandidato().setPontuacao(pontuacao.getPontuacao());
		return pontuacao;
	}
}
