package com.vagas.desafiotecnico.functions.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.vagas.desafiotecnico.functions.FuncaoMenorCaminho;
import com.vagas.desafiotecnico.models.Caminho;
import com.vagas.desafiotecnico.models.Localidade;
import com.vagas.desafiotecnico.models.Regiao;

/***
 * Componente bsuca de Localidades e busca do menor caminho para uma Localidade
 * data uma Região
 * 
 * @author alexandre
 *
 */
@Component("funcaoMenorCaminho")
public class FuncaoMenorCaminhoImpl implements FuncaoMenorCaminho {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vagas.desafiotecnico.functions.FuncaoBuscaLocalidade#
	 * buscarMenorCaminhoDaRegiao(com.vagas.desafiotecnico.models.Regiao,
	 * com.vagas.desafiotecnico.models.Localidade)
	 */
	@Override
	@Cacheable("cache-regiao-menor-caminho-localidade")
	public Regiao buscarMenorCaminhoDaRegiao(final Regiao regiao, final Localidade localidade) {
		localidade.setDistancia(0);
		final Set<Localidade> localidadesCurtas = new HashSet<>();
		final Set<Localidade> localidadesDesconsideradas = new HashSet<>();

		localidadesDesconsideradas.add(localidade);

		while (!localidadesDesconsideradas.isEmpty()) {
			final Localidade localidadeAtual = obterMenoresDistancias(localidadesDesconsideradas);
			localidadesDesconsideradas.remove(localidadeAtual);

			Optional.ofNullable(localidadeAtual).ifPresent(localidadeAtualPresent -> {
				final Map<Localidade, Integer> localidadesVisinhas = localidadeAtual.getLocalidadesVisinhas();
				if (localidadesVisinhas != null && !localidadesVisinhas.isEmpty()) {
					for (final Entry<Localidade, Integer> distanciaAdjacente : localidadesVisinhas.entrySet()) {
						final Localidade localidadeAdjacente = distanciaAdjacente.getKey();
						final Integer distancia = distanciaAdjacente.getValue();

						if (!localidadesCurtas.contains(localidadeAdjacente)) {
							calcularMinimaDistancia(localidadeAdjacente, distancia, localidadeAtual);
							localidadesDesconsideradas.add(localidadeAdjacente);
						}
					}
				}
				localidadesCurtas.add(localidadeAtual);
			});
		}

		regiao.setLocalidades(localidadesCurtas);

		return regiao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vagas.desafiotecnico.functions.FuncaoBuscaLocalidade#
	 * buscarMenorCaminhoDaRegiao(com.vagas.desafiotecnico.models.Regiao,
	 * com.vagas.desafiotecnico.models.Localidade,
	 * com.vagas.desafiotecnico.models.Localidade)
	 */
	@Override
	@Cacheable("cache-regiao-menor-caminho-ponto-ponto")
	public Caminho buscarMenorCaminhoDaRegiao(final Regiao regiao, final Localidade localidadeOrigem,
			final Localidade localidadeDestino) {

		buscarMenorCaminhoDaRegiao(regiao, localidadeOrigem);
		
		return Caminho
				.builder()
				.distancia(localidadeDestino.getDistancia())
				.localidadeOrigem(localidadeOrigem)
				.localidadeDestino(localidadeDestino)
				.percurso(null)
				.build();
	}
}
