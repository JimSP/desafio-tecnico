package com.vagas.desafiotecnico.functions;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.vagas.desafiotecnico.models.Caminho;
import com.vagas.desafiotecnico.models.Localidade;
import com.vagas.desafiotecnico.models.Ponto;
import com.vagas.desafiotecnico.models.Regiao;
import com.vagas.desafiotecnico.system.FunctionFeatureToggle;

public interface FuncaoMenorCaminho extends FunctionFeatureToggle{
	
	/***
	 * busca uma Localidade dado um ponto dada uma Região.
	 * 
	 * @param regiao
	 * @param ponto
	 * @return Optional<Localidade>
	 */
	default Optional<Localidade> buscarLocalidade(final Regiao regiao, final Ponto ponto) {
		return regiao.getLocalidades()
				.stream()
				.filter(localidade -> localidade.getPonto().equals(ponto.name()))
				.findFirst();
	}
	
	/***
	 * busca uma Localidade dado um ponto dada uma Região.
	 * 
	 * @param regiao
	 * @param ponto
	 * @return Optional<Localidade>
	 */
	default Optional<Localidade> buscarLocalidade(final Regiao regiao, final String ponto) {
		return regiao.getLocalidades()
				.stream()
				.filter(localidade -> localidade.getPonto().equals(ponto))
				.findFirst();
	}
	
	/***
	 * Obtem a menor localidade dado um Set de Localidade
	 * 
	 * @param localidades
	 * @return Localidade
	 */
	default Localidade obterMenoresDistancias(final Set<Localidade> localidades) {
		return localidades
				.stream()
				.reduce((a,b)->a.getDistancia() < b.getDistancia() ? a : b)
				.orElse(Localidade.builder().distancia(Integer.MAX_VALUE).build());
	}
	
	default void calcularMinimaDistancia(final Localidade localidade, final Integer distancia,
			final Localidade localidadeOrigem) {
		final Integer distanciaOrigem = localidadeOrigem.getDistancia();
		if (distanciaOrigem + distancia < localidade.getDistancia()) {
			localidade.setDistancia(distanciaOrigem + distancia);
			final List<Localidade> localidades = localidadeOrigem.getLocalidades();
			localidades.add(localidadeOrigem);
			localidade.setLocalidades(localidades);
		}
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
	Regiao buscarMenorCaminhoDaRegiao(final Regiao regiao, final Localidade localidade);
	
	Caminho buscarMenorCaminhoDaRegiao(final Regiao regiao, final Localidade localidadeOrigem, final Localidade localidadeDestino);

}