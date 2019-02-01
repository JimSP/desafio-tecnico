package com.vagas.desafiotecnico.services;

import java.math.BigInteger;

/***
 * interface de Serviço para geração de Ids únicos no Cluster
 * 
 * @author alexandre
 *
 */
public interface IdsInterface {

	/***
	 * cria um identificador único no Cluster
	 * @return BigInteger
	 */
	BigInteger novoId();

}