package com.vagas.desafiotecnico.api;

import com.vagas.desafiotecnico.dtos.VagaDto;

/***
 * interface da api rest para criação de Vagas
 * 
 * @author alexandre
 *
 */
public interface VagasRestInterface {

	/***
	 * cria uma vaga.
	 * 
	 * @param vaga
	 * @return Vaga
	 */
	VagaDto post(final VagaDto vagaDto);

}