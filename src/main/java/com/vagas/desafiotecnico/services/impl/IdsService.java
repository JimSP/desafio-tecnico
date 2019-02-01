package com.vagas.desafiotecnico.services.impl;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazelcast.flakeidgen.FlakeIdGenerator;
import com.vagas.desafiotecnico.services.IdsInterface;

@Service
public class IdsService implements IdsInterface {

	@Autowired
	private FlakeIdGenerator flakeIdGenerator;
	
	/* (non-Javadoc)
	 * @see com.vagas.desafiotecnico.services.impl.IdsInterface#novoId()
	 */
	@Override
	public BigInteger novoId() {
		return BigInteger.valueOf(flakeIdGenerator.newId());
	}
}
