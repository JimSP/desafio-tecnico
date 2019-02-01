package com.vagas.desafiotecnico.models;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode(of= "ponto")
@ToString(of= {"ponto", "distancia"})
public final class Localidade implements Serializable{

	private static final long serialVersionUID = 31381883527734073L;

	private final Ponto ponto;
	private final Map<Localidade, Integer> localidadesVisinhas;
	private Integer distancia;
	private List<Localidade> localidades;
	
	public void addLocalidadeVisinha(final Localidade destino, final int distancia) {
	    localidadesVisinhas.put(destino, distancia);
	}	
}