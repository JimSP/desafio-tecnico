package com.vagas.desafiotecnico.api;

import java.math.BigInteger;
import java.util.List;

import com.vagas.desafiotecnico.dtos.CandidatoDto;
import com.vagas.desafiotecnico.dtos.CandidaturaDto;

/***
 * interface da api rest para criação de Candidaturas e pesquisa de Candidatos
 * para uma Vaga, ponderados pela pontuação.
 * 
 * @author alexandre
 *
 */
public interface CandidaturasRestInterface {

	/***
	 * cria uma candidatura para um Candidato em uma Vaga
	 * 
	 * @param candidaturaDto
	 * @return CandidaturaDto
	 */
	CandidaturaDto post(final CandidaturaDto candidaturaDto);

	/***
	 * conslta os candidados de uma Vaga, por id_vaga os Candidatos listados por
	 * essa pesquisa possuem pontuação ponderada de acordo com a sua localização e o
	 * menor caminho para a Vaga.
	 * 
	 * @param idVaga
	 * @return List<CandidatoDto>
	 */
	List<CandidatoDto> get(final BigInteger idVaga);

}