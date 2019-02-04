package com.vagas.desafiotecnico.system;

public interface FeatureToggleCommand<T> {
	
	FeatureToggleStatus getFeatureToggleStatus();
	void setFeatureToggleStatus(final FeatureToggleStatus featureToggleStatus);

	/***
	 * Habilita/Ativa funcionalidade
	 */
	void habilitar();

	/***
	 * Desabilita/Desativa funcionalidade
	 */
	void desabilitar();
	
	/***
	 * Obtem a funcao alvo
	 * 
	 * @return FunctionFeatureToggle
	 */
	T getFunctionFeatureToggle();

}