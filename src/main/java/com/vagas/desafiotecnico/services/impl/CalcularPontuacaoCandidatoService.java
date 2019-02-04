package com.vagas.desafiotecnico.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vagas.desafiotecnico.dtos.StatusCodeDto;
import com.vagas.desafiotecnico.exceptions.SistemaIndisponivelException;
import com.vagas.desafiotecnico.functions.FuncaoMenorCaminho;
import com.vagas.desafiotecnico.functions.FuncaoPontuacao;
import com.vagas.desafiotecnico.models.Caminho;
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
import com.vagas.desafiotecnico.system.FeatureToggleCommand;
import com.vagas.desafiotecnico.system.FeatureToggleMenorCaminho;

@Service
public final class CalcularPontuacaoCandidatoService implements CalcularPontuacaoCandidatoInterface {

	@Autowired
	private FuncaoPontuacao funcaoPontuacao;

	@Autowired
	@Qualifier("featureToggleMenorCaminho")
	private FeatureToggleCommand<FuncaoMenorCaminho> featureToggleCommand;
	
	
	@Autowired
	private RegioesInterface regioesService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vagas.desafiotecnico.services.CalcularPontuacaoCandidatoInterface#
	 * calcular(com.vagas.desafiotecnico.models.Candidatura)
	 */
	@Override
	public Candidatura calcular(final Candidatura candidatura) {
		final Regiao regiao = regioesService.buscar(candidatura.getCandidato().getLocalizacao());
		final Integer menorDistancia = buscarMenorDistancia(candidatura, regiao);
		final Pontuacao pontuacao = calcularPontuacao(candidatura, menorDistancia);
		candidatura.getCandidato().setPontuacao(pontuacao.getPontuacao());
		return candidatura;
	}

	protected Integer buscarMenorDistancia(final Candidatura candidatura, final Regiao regiao) {

		final FeatureToggleMenorCaminho featureToggleMenorCaminho = (FeatureToggleMenorCaminho) featureToggleCommand;
		
		if(featureToggleCommand.getFeatureToggleStatus().habilitado()) {
			final FuncaoMenorCaminho funcaoMenorCaminho = featureToggleMenorCaminho.getFunctionFeatureToggle();
			final Candidato candidato = candidatura.getCandidato();
			final Vaga vaga = candidatura.getVaga();
			
			final Optional<Localidade> localidadeCandidato = funcaoMenorCaminho.buscarLocalidade(regiao,
					candidato.getLocalizacao());
			
			final Optional<Localidade> localidadeVaga = funcaoMenorCaminho.buscarLocalidade(regiao, vaga.getLocalizacao());
			if(featureToggleMenorCaminho.getFeatureToggleFuncaoMenorCaminhoProperties().getUtilizarMetodoPorRegiao()) {
				if (localidadeCandidato.isPresent() && localidadeVaga.isPresent()) {
					final Optional<Localidade> localidades = funcaoMenorCaminho
							.buscarMenorCaminhoDaRegiao(regiao, localidadeCandidato.get())
							.getLocalidades()
							.stream()
							.filter(localidade -> localidade.equals(localidadeVaga.get()))
							.findFirst();

					return localidades.orElseThrow(
							() -> new SistemaIndisponivelException(StatusCodeDto.CODIGO_ERRO_SISTEMA_INDIPONIVEL.getMensagem()))
							.getDistancia();
				}
			}else {
				final Optional<Localidade> localidadeOrigem = funcaoMenorCaminho.buscarLocalidade(regiao, candidato.getLocalizacao());
				final Optional<Localidade> localidadeDestino = funcaoMenorCaminho.buscarLocalidade(regiao, vaga.getLocalizacao());
				
				if(localidadeOrigem.isPresent() && localidadeDestino.isPresent()) {
					final Caminho caminho = funcaoMenorCaminho.buscarMenorCaminhoDaRegiao(regiao, localidadeOrigem.get(), localidadeDestino.get());
					return caminho.getDistancia();
				}
			}	
		}

		throw new SistemaIndisponivelException(StatusCodeDto.CODIGO_ERRO_SISTEMA_INDIPONIVEL.getMensagem());

	}

	protected Pontuacao calcularPontuacao(final Candidatura candidatura, final Integer menorDistancia) {
		final N n = N.builder().nivelExperienciaCandidato(candidatura.getCandidato().getNivel())
				.nivelExperienciaEsperado(candidatura.getVaga().getNivel()).build();

		final D d = D.of(menorDistancia);
		return funcaoPontuacao.calcular(n, d);
	}
}
