package com.vagas.desafiotecnico.dtos;

import java.math.BigInteger;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class VagaDto implements ApiStatusDto{

	private Integer codigo;
	private String mensagem;
	
	@Id
	private BigInteger id;

	@NotBlank(message="empresa deve ser preenchido.")
	private String empresa;
	
	@NotBlank(message="titulo deve ser preenchido.")
	private String titulo;
	
	@NotBlank(message="descricao deve ser preenchido.")
	private String descricao;
	
	@NotBlank(message="localizacao deve possuir 1 (um) caracter entre A-Z.")
	@Size(min=1, max=1, message="localizacao deve possuir 1 (um) caracter entre A-Z.")
	private String localizacao;
	
	@NotNull(message="nivel invalido.")
	private Integer nivel;
	
	@JsonCreator
	public VagaDto(
			@JsonProperty("codigo") final Integer codigo,
			@JsonProperty("mensagem") final String mensagem,
			@JsonProperty("id_vaga") final BigInteger id,
			@JsonProperty("empresa") final String empresa,
			@JsonProperty("titulo") final String titulo,
			@JsonProperty("descricao") final String descricao,
			@JsonProperty("localizacao") final String localizacao,
			@JsonProperty("nivel")final Integer nivel) {
		this.id = id;
		this.empresa = empresa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.localizacao = localizacao;
		this.nivel = nivel;
	}
}
