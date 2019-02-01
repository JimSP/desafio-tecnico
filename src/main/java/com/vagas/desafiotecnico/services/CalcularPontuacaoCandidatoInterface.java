package com.vagas.desafiotecnico.services;

import com.vagas.desafiotecnico.models.Candidatura;

/***
 * interface de Serviço para calcular a Pontuacao de uma Candidatura
 * 
 * @author alexandre
 *
 */
public interface CalcularPontuacaoCandidatoInterface {

	/***
	 * Efetua o calculo de uma Candidatura
	 * 
	 * @param candidatura
	 * @return Candidatura
	 */
	Candidatura calcular(final Candidatura candidatura);

}