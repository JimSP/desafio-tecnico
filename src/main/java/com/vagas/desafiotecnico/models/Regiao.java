package com.vagas.desafiotecnico.models;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/***
 * Representa um conjunto de Localidades interligadas de um Ponto. (é um Grafo)
 * 
 * 
 * @author alexandre
 *
 */
@Data
@Builder
@EqualsAndHashCode(of="ponto")
@ToString(of="ponto")
@KeySpace("Regiao")
public final class Regiao implements Serializable {

	private static final long serialVersionUID = -577863310022723755L;

	@Id
	private String ponto;
	private Set<Localidade> localidades;

	public void addLocalidade(final Localidade localidade) {
		localidades.add(localidade);
	}

}
