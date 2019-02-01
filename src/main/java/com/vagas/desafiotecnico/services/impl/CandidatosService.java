package com.vagas.desafiotecnico.services.impl;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vagas.desafiotecnico.exceptions.CandidatoNaoExisteException;
import com.vagas.desafiotecnico.models.Candidato;
import com.vagas.desafiotecnico.repositories.CandidatosRepository;
import com.vagas.desafiotecnico.services.CandidatosInterface;
import com.vagas.desafiotecnico.services.IdsInterface;

@Service
public class CandidatosService implements CandidatosInterface {

	@Autowired
	private CandidatosRepository candidatosRepository;

	@Autowired
	private IdsInterface idsService;

	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.impl.CandidatosInterface#salvar(com.vagas.desafiotecnico.models.Candidato)
	 */
	@Override
	@Transactional
	public Candidato salvar(final Candidato candidato) {
		candidato.setId(idsService.novoId());
		return candidatosRepository.save(candidato);
	}

	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.impl.CandidatosInterface#buscarCandidato(java.math.BigInteger)
	 */
	@Override
	public Candidato buscarCandidato(final BigInteger idCandidato) {
		return candidatosRepository.findById(idCandidato)
				.orElseThrow(() -> new CandidatoNaoExisteException(idCandidato));
	}
}
