package com.vagas.desafiotecnico.services;

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
	 * busca a Regiao carregada no Cluster
	 * 
	 * @return Regiao
	 */
	Regiao buscar();

	/***
	 * verifica se a região foi carregada no Cluster
	 * 
	 * @return Boolean
	 */
	Boolean existeRegiao();

}