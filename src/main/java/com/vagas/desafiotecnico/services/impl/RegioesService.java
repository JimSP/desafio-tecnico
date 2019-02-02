package com.vagas.desafiotecnico.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vagas.desafiotecnico.exceptions.SistemaIndisponivelException;
import com.vagas.desafiotecnico.models.Ponto;
import com.vagas.desafiotecnico.models.Regiao;
import com.vagas.desafiotecnico.repositories.RegiaoRepository;
import com.vagas.desafiotecnico.services.RegioesInterface;

@Service
public class RegioesService implements RegioesInterface {
	
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.impl.RegioesInterface#salvar(com.vagas.desafiotecnico.entity.Regiao)
	 */
	@Override
	@Transactional
	public Regiao salvar(final Regiao regiao) {
		return regiaoRepository.save(regiao);
	}
	
	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.impl.RegioesInterface#buscar()
	 */
	@Override
	public Regiao buscar(final Ponto ponto) {
		return regiaoRepository.findById(ponto.name())
				.orElseThrow(() -> new SistemaIndisponivelException(
						"Sistema indiponivel no momento, tente novamente em alguns minutos."));
	}
	
	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.impl.RegioesInterface#existeRegiao()
	 */
	@Override
	public Boolean existeRegiao() {
		return regiaoRepository.count() > 0L;
	}
}
