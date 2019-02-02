package com.vagas.desafiotecnico.dtos;

public enum StatusCodeDto {

	CODIGO_SUCESSO("OK", 0),
	CODIGO_ERRO_CANDIDATO_NAO_EXISTE("Pessoa nao exite, pessoa_id=%s", 1),
	CODIGO_ERRO_VAGA_NAO_EXISTE("Vaga nao exite, vaga_id=%s", 2),
	CODIGO_ERRO_CANDIDATURA_NAO_EXISTE("Nao existe candidatura para a vaga, vaga_id=%s", 3),
	CODIGO_ERRO_CAMINHO_NAO_ENCONTRADO("caminho nao encontrado", 98),
	CODIGO_ERRO_SISTEMA_INDIPONIVEL("sistema indisponivel no momento", 99);

	private StatusCodeDto(final String mensagem, final Integer codigo) {
		this.mensagem = mensagem;
		this.codigo = codigo;
	}

	private final String mensagem;
	private final Integer codigo;

	public String getMensagem() {
		return mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

}
