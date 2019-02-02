package com.vagas.desafiotecnico.functions;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.vagas.desafiotecnico.models.Localidade;
import com.vagas.desafiotecnico.models.Ponto;
import com.vagas.desafiotecnico.models.Regiao;

/***
 * Componente bsuca de Localidades e busca do menor caminho para uma Localidade
 * data uma Região
 * 
 * @author alexandre
 *
 */
@Component
public class FuncaoMenorCaminho {

	/***
	 * busca uma Localidade dado um ponto dada uma Região.
	 * 
	 * 
	 * @param regiao
	 * @param ponto
	 * @return Localidade
	 */
	@Cacheable("buscarLocalidade")
	public Optional<Localidade> buscarLocalidade(Regiao regiao, Ponto ponto) {
		return regiao.getLocalidades()
				.stream()
				.filter(localidade -> localidade.getPonto().equals(ponto.name()))
				.findFirst();
	}

	/***
	 * dada uma Regiao, faz a busca do menor caminho para Localidade. O Calculo é
	 * efetuado para todas as Localidades da Região, considerando a Localidade
	 * informada.
	 * 
	 * Na Região retornada, as localidades no Set<Localidade>
	 * (Regiao.getLocalidades) possuem o campo Localidade.distancia com o valor do
	 * menor caminho setado.
	 * 
	 * @param regiao
	 * @param localidade
	 * @return Regiao
	 */
	@Cacheable("cache-regiao-menor-caminho-localidade")
	public Regiao buscarMenorCaminhoDaRegiao(Regiao regiao, Localidade localidade) {
		localidade.setDistancia(0);
		final Set<Localidade> localidadesCurtas = new HashSet<>();
		final Set<Localidade> localidadesDesconsideradas = new HashSet<>();

		localidadesDesconsideradas.add(localidade);

		while (!localidadesDesconsideradas.isEmpty()) {
			final Localidade localidadeAtual = obterMenoresDistancias(localidadesDesconsideradas);
			localidadesDesconsideradas.remove(localidadeAtual);

			Optional.ofNullable(localidadeAtual).ifPresent(localidadeAtualPresent->{
				final Map<Localidade, Integer> localidadesVisinhas = localidadeAtual.getLocalidadesVisinhas();
				if (localidadesVisinhas != null && !localidadesVisinhas.isEmpty()) {
					for (final Entry<Localidade, Integer> distanciaAdjacente : localidadeAtual.getLocalidadesVisinhas()
							.entrySet()) {
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

	private void calcularMinimaDistancia(final Localidade localidade, final Integer distancia,
			final Localidade localidadeOrigem) {
		final Integer distanciaOrigem = localidadeOrigem.getDistancia();
		if (distanciaOrigem + distancia < localidade.getDistancia()) {
			localidade.setDistancia(distanciaOrigem + distancia);
			final List<Localidade> localidades = localidadeOrigem.getLocalidades();
			localidades.add(localidadeOrigem);
			localidade.setLocalidades(localidades);
		}
	}

	private Localidade obterMenoresDistancias(final Set<Localidade> localidades) {
		Localidade menorLocalidade = null;
		Integer menorDistancia = Integer.MAX_VALUE;

		for (final Localidade localidade : localidades) {
			final Integer distancia = localidade.getDistancia();
			if (distancia < menorDistancia) {
				menorDistancia = distancia;
				menorLocalidade = localidade;
			}
		}
		return menorLocalidade;
	}
}
