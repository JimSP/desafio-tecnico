package com.vagas.desafiotecnico.models;

import java.io.Serializable;
import java.util.Set;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode(of = { "localidadeOrigem", "localidadeDestino", "distancia" })
@ToString(of = { "localidadeOrigem", "localidadeDestino", "distancia" })
public final class Caminho implements Serializable{

	private static final long serialVersionUID = 41607028309163050L;

	private final Localidade localidadeOrigem;
	private final Localidade localidadeDestino;
	private final Integer distancia;
	private Set<Localidade> percurso;
}
