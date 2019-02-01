package com.vagas.desafiotecnico.services;

import java.math.BigInteger;

import com.vagas.desafiotecnico.models.Candidato;

/***
 * interface de Serviço para manutenção de Candidato.
 * 
 * @author alexandre
 *
 */
public interface CandidatosInterface {

	/***
	 * cria um candidato
	 * 
	 * @param candidato
	 * @return Candidato
	 */
	Candidato salvar(final Candidato candidato);

	/***
	 * busca um Candidato pelo identificador unico, idCandidato
	 * 
	 * @param idCandidato
	 * @return Candidato
	 */
	Candidato buscarCandidato(final BigInteger idCandidato);

}