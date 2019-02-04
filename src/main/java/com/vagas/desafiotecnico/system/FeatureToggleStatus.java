package com.vagas.desafiotecnico.system;

public enum FeatureToggleStatus {
	DESABILITADO, HABILITADO;

	public Boolean habilitado() {
		return HABILITADO.equals(this);
	}
}
