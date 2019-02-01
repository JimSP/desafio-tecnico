package com.vagas.desafiotecnico.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@KeySpace("Regiao")
public final class Regiao implements Serializable {

	private static final long serialVersionUID = -577863310022723755L;

	@Id
	private BigInteger id;
	private Set<Localidade> localidades;

	public void addLocalidade(final Localidade localidade) {
		localidades.add(localidade);
	}

}
