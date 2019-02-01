package com.vagas.desafiotecnico.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class MensagemErroDto implements ApiStatusDto{
	
	private Integer codigo;
	private String mensagem;
	
	@JsonCreator
	public MensagemErroDto(
			@JsonProperty("codigo") final Integer codigo,
			@JsonProperty("mensagem") final String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}
}
