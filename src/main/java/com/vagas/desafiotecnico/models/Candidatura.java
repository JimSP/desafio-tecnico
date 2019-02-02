package com.vagas.desafiotecnico.models;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/***
 * Representa o interesse de um Candidato por uma Vaga
 * 
 * @author alexandre
 *
 */
@Data
@Builder
@EqualsAndHashCode(of="id")
@AllArgsConstructor
@NoArgsConstructor
@KeySpace("Candidatura")
public class Candidatura implements Serializable{

	private static final long serialVersionUID = 2030992311010169545L;
	
	@Id
	private BigInteger id;
	private Candidato candidato;
	private Vaga vaga;

}
