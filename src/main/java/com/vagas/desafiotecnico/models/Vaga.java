package com.vagas.desafiotecnico.models;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@KeySpace("Vaga")
public final class Vaga implements Serializable{

	private static final long serialVersionUID = -8355760081967135125L;
	
	@Id
	private BigInteger id;
	private String empresa;
	private String titulo;
	private String descricao;
	private Ponto localizacao;
	private NivelExperiencia nivel;
	
}
