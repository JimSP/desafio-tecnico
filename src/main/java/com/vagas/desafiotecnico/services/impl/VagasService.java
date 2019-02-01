package com.vagas.desafiotecnico.services.impl;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.vagas.desafiotecnico.exceptions.VagaNaoExisteException;
import com.vagas.desafiotecnico.models.Vaga;
import com.vagas.desafiotecnico.repositories.VagasRepository;
import com.vagas.desafiotecnico.services.IdsInterface;
import com.vagas.desafiotecnico.services.VagasInterface;

@Component
public class VagasService implements VagasInterface {

	@Autowired
	private VagasRepository vagasRepository;
	
	@Autowired
	private IdsInterface idsService;
	
	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.impl.VagasInterface#salvar(com.vagas.desafiotecnico.models.Vaga)
	 */
	@Override
	@Transactional
	public Vaga salvar(final Vaga vaga) {
		vaga.setId(idsService.novoId());
		return vagasRepository.save(vaga);
	}
	
	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.impl.VagasInterface#buscarVaga(java.math.BigInteger)
	 */
	@Override
	public Vaga buscarVaga(final BigInteger idVaga) {
		return vagasRepository.findById(idVaga)
				.orElseThrow(() -> new VagaNaoExisteException(idVaga));
	}
}
