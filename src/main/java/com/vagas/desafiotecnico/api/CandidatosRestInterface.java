package com.vagas.desafiotecnico.api;

import com.vagas.desafiotecnico.dtos.CandidatoDto;

/***
 * interface da api rest para criação de Candidatos
 * 
 * @author alexandre
 *
 */
public interface CandidatosRestInterface {

	/***
	 * cria um candidato
	 * 
	 * @param candidatoDto
	 * @return candidatoDto
	 */
	CandidatoDto post(final CandidatoDto candidatoDto);

}