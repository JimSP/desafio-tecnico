package com.vagas.desafiotecnico.dtos;

import java.math.BigInteger;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class CandidatoDto implements ApiStatusDto{
	
	private Integer codigo;
	private String mensagem;
	
	@JsonProperty("id_candidatura")
	private BigInteger id;
	
	@NotBlank(message="nome deve ser preenchido.")
	private String nome;
	
	@NotBlank(message="profissao deve ser preenchido.")
	private String profissao;
	
	@NotBlank(message="localizacao deve possuir 1 (um) caracter entre A-Z.")
	@Size(min=1, max=1, message="localizacao deve possuir 1 (um) caracter entre A-Z.")
	private String localizacao;
	
	@NotNull(message="nivel invalido.")
	private Integer nivel;
	
	private Integer pontuacao;

	@JsonCreator
	public CandidatoDto(
			@JsonProperty("codigo") final Integer codigo,
			@JsonProperty("mensagem") final String mensagem,
			@JsonProperty("id_candidatura") final BigInteger id,
			@JsonProperty("nome") final String nome,
			@JsonProperty("profissao") final String profissao,
			@JsonProperty("localizacao") final String localizacao,
			@JsonProperty("nivel") final Integer nivel,
			@JsonProperty("score") final Integer pontuacao) {
		this.codigo = codigo;
		this.mensagem = mensagem;
		this.id = id;
		this.nome = nome;
		this.profissao = profissao;
		this.localizacao = localizacao;
		this.nivel = nivel;
		this.pontuacao = pontuacao;
	}
}
