package com.vagas.desafiotecnico.dtos;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public final class CandidaturaDto implements ApiStatusDto{
	
	private Integer codigo;
	private String mensagem;

	@NotNull(message="id_pessoa invalido.")
	private BigInteger idCandidato;
	
	@NotNull(message="id_vaga invalido.")
	private BigInteger idVaga;

	@JsonCreator
	public CandidaturaDto(
			@JsonProperty("codigo") final Integer codigo,
			@JsonProperty("mensagem") final String mensagem,
			@JsonProperty("id_pessoa") final BigInteger idCandidato,
			@JsonProperty("id_vaga") final BigInteger idVaga) {
		this.idCandidato = idCandidato;
		this.idVaga = idVaga;
	}
}
