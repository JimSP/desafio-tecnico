package com.vagas.desafiotecnico.creators;

import static com.vagas.desafiotecnico.creators.CriadorLocalidade.criarLocalidade;
import static com.vagas.desafiotecnico.creators.CriadorRegiao.criarRegiao;

import com.vagas.desafiotecnico.models.Localidade;
import com.vagas.desafiotecnico.models.Ponto;
import com.vagas.desafiotecnico.models.Regiao;

public class CriadorRegiaoTeste {
	
	private CriadorRegiaoTeste() {
		
	}
	
	public static Regiao criarRegiaoDeTeste() {
		final Localidade localidadeA = criarLocalidade(Ponto.A);
		final Localidade localidadeB = criarLocalidade(Ponto.B);
		final Localidade localidadeC = criarLocalidade(Ponto.C);
		final Localidade localidadeD = criarLocalidade(Ponto.D);
		final Localidade localidadeE = criarLocalidade(Ponto.E);
		final Localidade localidadeF = criarLocalidade(Ponto.F);

		localidadeA.addLocalidadeVisinha(localidadeB, 5);

		localidadeB.addLocalidadeVisinha(localidadeC, 7);
		localidadeB.addLocalidadeVisinha(localidadeD, 3);

		localidadeC.addLocalidadeVisinha(localidadeE, 4);

		localidadeD.addLocalidadeVisinha(localidadeE, 10);
		localidadeD.addLocalidadeVisinha(localidadeF, 8);
		
		return criarRegiao(localidadeA, localidadeB, localidadeC, localidadeD, localidadeE, localidadeF);
	}

}
