package com.vagas.desafiotecnico.services;

import java.math.BigInteger;

import com.vagas.desafiotecnico.models.Vaga;

/***
 * interface de Serviço para manutenção de Vaga
 * 
 * @author alexandre
 *
 */
public interface VagasInterface {

	/***
	 * cria uma Vaga
	 * 
	 * @param vaga
	 * @return Vaga
	 */
	Vaga salvar(final Vaga vaga);

	/***
	 * busca uma vaga pelo seu identificador único, idVaga
	 * 
	 * @param idVaga
	 * @return Vaga
	 */
	Vaga buscarVaga(final BigInteger idVaga);

}