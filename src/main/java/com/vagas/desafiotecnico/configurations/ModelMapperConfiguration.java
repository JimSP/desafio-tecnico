package com.vagas.desafiotecnico.configurations;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vagas.desafiotecnico.models.NivelExperiencia;
import com.vagas.desafiotecnico.models.Ponto;

@Configuration
public class ModelMapperConfiguration {
	
	
	private final AbstractConverter<Integer, NivelExperiencia> converterIntegerToNivelExceriencia = new AbstractConverter<Integer, NivelExperiencia>() {
		@Override
		protected NivelExperiencia convert(final Integer nivel) {
			return NivelExperiencia.of(nivel);
		}
	};
	
	private final AbstractConverter<NivelExperiencia, Integer> converterNivelExcerienciaToInteger = new AbstractConverter<NivelExperiencia, Integer>() {
		@Override
		protected Integer convert(final NivelExperiencia nivelExperiencia) {
			return nivelExperiencia.getNivel();
		}
	};
	
	private final AbstractConverter<String, Ponto> converterStringToPonto = new AbstractConverter<String, Ponto>() {
		@Override
		protected Ponto convert(final String localidade) {
			return Ponto.valueOf(localidade);
		}
	};
	
	private final AbstractConverter<Ponto, String> converterPontoToString = new AbstractConverter<Ponto, String>() {
		@Override
		protected String convert(final Ponto ponto) {
			return ponto.name();
		}
	};
	
	@Bean
	public ModelMapper modelMapper() {
		final ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(converterIntegerToNivelExceriencia);
		modelMapper.addConverter(converterNivelExcerienciaToInteger);
		modelMapper.addConverter(converterStringToPonto);
		modelMapper.addConverter(converterPontoToString);
	    return modelMapper;
	}
}
