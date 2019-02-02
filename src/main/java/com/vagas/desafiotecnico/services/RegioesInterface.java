package com.vagas.desafiotecnico.services;

import com.vagas.desafiotecnico.models.Ponto;
import com.vagas.desafiotecnico.models.Regiao;

/***
 * interface de Serviço para manutenção de Regiao
 * 
 * @author alexandre
 *
 */
public interface RegioesInterface {

	/***
	 * cria uma Regiao
	 * 
	 * @param regiao
	 * @return Regiao
	 */
	Regiao salvar(final Regiao regiao);

	/***
	 * busca a Regiao carregada no Cluster com distancias à partir de um Ponto.
	 * 
	 * @return Regiao
	 */
	Regiao buscar(final Ponto ponto);

	/***
	 * verifica se a região foi carregada no Cluster
	 * 
	 * @return Boolean
	 */
	Boolean existeRegiao();

}