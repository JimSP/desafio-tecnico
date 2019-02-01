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
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@KeySpace("Candidato")
public final class Candidato implements Serializable {

	private static final long serialVersionUID = 6540841297261002412L;

	@Id
	private BigInteger id;
	private String nome;
	private String profissao;
	private Ponto localizacao;
	private NivelExperiencia nivel;
	private Integer pontuacao;
}
