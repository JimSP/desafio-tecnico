package com.vagas.desafiotecnico.services.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vagas.desafiotecnico.exceptions.CandidaturaNaoExisteExceptions;
import com.vagas.desafiotecnico.models.Candidato;
import com.vagas.desafiotecnico.models.Candidatura;
import com.vagas.desafiotecnico.models.Vaga;
import com.vagas.desafiotecnico.repositories.CandidaturasRepository;
import com.vagas.desafiotecnico.services.CandidaturasInterface;
import com.vagas.desafiotecnico.services.IdsInterface;

@Service
public class CandidaturaService implements CandidaturasInterface {

	@Autowired
	private CandidaturasRepository candidaturasRepository;

	@Autowired
	private IdsInterface idsService;

	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.impl.CandidaturasInterface#candidatar(com.vagas.desafiotecnico.models.Candidato, com.vagas.desafiotecnico.models.Vaga)
	 */
	@Override
	@Transactional
	public Candidatura candidatar(final Candidato candidato, final Vaga vaga) {
		return candidaturasRepository
				.save(Candidatura
						.builder()
						.id(idsService.novoId())
						.candidato(candidato)
						.vaga(vaga)
						.build());
	}

	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.impl.CandidaturasInterface#buscarCandidatura(java.math.BigInteger)
	 */
	@Override
	public List<Candidatura> buscarCandidatura(final BigInteger idVaga) {
		final List<Candidatura> result = Collections.synchronizedList(new ArrayList<>());
		
			candidaturasRepository
				.findAll()
				.forEach(candidatura -> {
					if(idVaga.equals(candidatura.getVaga().getId())){
						result.add(candidatura);
					}
				});
			
			if(result.isEmpty()) {
				throw new CandidaturaNaoExisteExceptions(idVaga);
			}

		return result;
	}
}
