package com.vagas.desafiotecnico.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.vagas.desafiotecnico.system.FeatureToggleStatus;

@Configuration
@ConfigurationProperties
public class FeatureToggleFuncaoMenorCaminhoProperties {

	private FeatureToggleStatus featureToggleStatus = FeatureToggleStatus.HABILITADO;
	
	private Boolean utilizarMetodoPorRegiao = Boolean.TRUE;

	public FeatureToggleStatus getFeatureToggleStatus() {
		return featureToggleStatus;
	}

	public void setFeatureToggleStatus(FeatureToggleStatus featureToggleStatus) {
		this.featureToggleStatus = featureToggleStatus;
	}

	public Boolean getUtilizarMetodoPorRegiao() {
		return utilizarMetodoPorRegiao;
	}

	public void setUtilizarMetodoPorRegiao(Boolean utilizarMetodoPorRegiao) {
		this.utilizarMetodoPorRegiao = utilizarMetodoPorRegiao;
	}
}
