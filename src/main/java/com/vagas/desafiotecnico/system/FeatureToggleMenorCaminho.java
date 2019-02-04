package com.vagas.desafiotecnico.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vagas.desafiotecnico.configurations.FeatureToggleFuncaoMenorCaminhoProperties;
import com.vagas.desafiotecnico.functions.FuncaoMenorCaminho;

@Component("featureToggleMenorCaminho")
@Scope("singleton")
public class FeatureToggleMenorCaminho implements FeatureToggleCommand<FuncaoMenorCaminho> {

	@Autowired 
	private FeatureToggleFuncaoMenorCaminhoProperties featureToggleFuncaoMenorCaminhoProperties;
	
	@Autowired
	private FuncaoMenorCaminho funcaoMenorCaminho;

	public FeatureToggleFuncaoMenorCaminhoProperties getFeatureToggleFuncaoMenorCaminhoProperties() {
		return featureToggleFuncaoMenorCaminhoProperties;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see FunctionFeatureToggle
	 * com.vagas.desafiotecnico.system.FeatureToggleCommanda#
	 * getFunctionFeatureToggle()
	 */
	@Override
	public FuncaoMenorCaminho getFunctionFeatureToggle() {
		return funcaoMenorCaminho;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vagas.desafiotecnico.system.FeatureToggleCommanda#habilitar()
	 */
	@Override
	public void habilitar() {
		this.featureToggleFuncaoMenorCaminhoProperties.setFeatureToggleStatus(FeatureToggleStatus.HABILITADO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vagas.desafiotecnico.system.FeatureToggleCommanda#desabilitar()
	 */
	@Override
	public void desabilitar() {
		this.featureToggleFuncaoMenorCaminhoProperties.setFeatureToggleStatus(FeatureToggleStatus.DESABILITADO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see FeatureToggleStatus
	 * com.vagas.desafiotecnico.system.FeatureToggleCommanda#getFeatureToggleStatus(
	 * )
	 */
	@Override
	public FeatureToggleStatus getFeatureToggleStatus() {
		return featureToggleFuncaoMenorCaminhoProperties.getFeatureToggleStatus();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vagas.desafiotecnico.system.FeatureToggleCommanda#setFeatureToggleStatus(
	 * FeatureToggleStatus)
	 */
	@Override
	public void setFeatureToggleStatus(final FeatureToggleStatus featureToggleStatus) {
		this.featureToggleFuncaoMenorCaminhoProperties.setFeatureToggleStatus(featureToggleStatus);
	}
}
