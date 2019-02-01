package com.vagas.desafiotecnico.services.impl;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vagas.desafiotecnico.exceptions.SistemaIndisponivelException;
import com.vagas.desafiotecnico.models.Regiao;
import com.vagas.desafiotecnico.repositories.RegiaoRepository;
import com.vagas.desafiotecnico.services.RegioesInterface;

@Service
public class RegioesService implements RegioesInterface {
	
	private static final BigInteger ID_REGIAO = BigInteger.ONE;
	
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.impl.RegioesInterface#salvar(com.vagas.desafiotecnico.entity.Regiao)
	 */
	@Override
	@Transactional
	public Regiao salvar(final Regiao regiao) {
		regiao.setId(ID_REGIAO);
		return regiaoRepository.save(regiao);
	}
	
	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.impl.RegioesInterface#buscar()
	 */
	@Override
	public Regiao buscar() {
		return regiaoRepository.findById(ID_REGIAO)
				.orElseThrow(() -> new SistemaIndisponivelException(
						"Sistema indiponivel no momento, tente novamente em alguns minutos."));
	}
	
	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.impl.RegioesInterface#existeRegiao()
	 */
	@Override
	public Boolean existeRegiao() {
		return regiaoRepository.existsById(ID_REGIAO);
	}
}
