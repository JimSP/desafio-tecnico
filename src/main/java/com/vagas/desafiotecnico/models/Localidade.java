package com.vagas.desafiotecnico.models;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/***
 * Representa um Ponto e seus caminhos para outra localidadesVisinhas. A
 * distancia de uma dada Localidade é calculada pela FuncaoMenorCaminho
 * 
 * (É um Nó e suas arestas, que são representadas por localidadesVisinhas, ou
 * seja, a ligação entre dois Nós adjacentes do Grafo)
 * 
 * @author alexandre
 *
 */
@Data
@Builder
@EqualsAndHashCode(of = "ponto")
@ToString(of = { "ponto", "distancia" })
public final class Localidade implements Serializable {

	private static final long serialVersionUID = 31381883527734073L;

	private final String ponto;
	private final Map<Localidade, Integer> localidadesVisinhas;
	private Integer distancia;
	private List<Localidade> localidades;

	public void addLocalidadeVisinha(final Localidade destino, final int distancia) {
		localidadesVisinhas.put(destino, distancia);
	}
}