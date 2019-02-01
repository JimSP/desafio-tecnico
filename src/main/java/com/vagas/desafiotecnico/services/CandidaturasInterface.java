package com.vagas.desafiotecnico.services;

import java.math.BigInteger;
import java.util.List;

import com.vagas.desafiotecnico.exceptions.CandidatoNaoExisteException;
import com.vagas.desafiotecnico.exceptions.VagaNaoExisteException;
import com.vagas.desafiotecnico.models.Candidato;
import com.vagas.desafiotecnico.models.Candidatura;
import com.vagas.desafiotecnico.models.Vaga;

/***
 * interface de Serviço para manutenção de Candidatura
 * 
 * @author alexandre
 *
 */
public interface CandidaturasInterface {

	/***
	 * efetiva a candidatura de um Candidato para uma Vaga, é necessario que o Candidato e a Vaga existam.
	 * 
	 * 
	 * @param candidato
	 * @param vaga
	 * @return Candidatura
	 * 
	 * {@link CandidatoNaoExisteException}
	 * {@link VagaNaoExisteException}
	 */
	Candidatura candidatar(final Candidato candidato, final Vaga vaga);

	/***
	 * busca as Candidaturas de uma Vaga pelo identificador unico da Vaga, idVaga. 
	 * 
	 * @param idVaga
	 * @return List<Candidatura>
	 */
	List<Candidatura> buscarCandidatura(final BigInteger idVaga);

}