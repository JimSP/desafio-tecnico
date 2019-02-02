package com.vagas.desafiotecnico.creators;

import static com.vagas.desafiotecnico.creators.CriadorLocalidade.criarLocalidade;
import static com.vagas.desafiotecnico.creators.CriadorRegiao.criarRegiao;

import com.vagas.desafiotecnico.models.Localidade;
import com.vagas.desafiotecnico.models.Ponto;
import com.vagas.desafiotecnico.models.Regiao;

public final class CriadorRegiaoTeste {
	
	private CriadorRegiaoTeste() {
		
	}
	
	public static Regiao criarRegiaoDeTesteAPartirA() {
		
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
		
		final Regiao regiaoA = criarRegiao(localidadeA, localidadeB, localidadeC, localidadeD, localidadeE, localidadeF);
		regiaoA.setPonto(Ponto.A.name());
		return regiaoA;
	}

	public static Regiao criarRegiaoDeTesteAPartirB() {
		
		final Localidade localidadeA = criarLocalidade(Ponto.A);
		final Localidade localidadeB = criarLocalidade(Ponto.B);
		final Localidade localidadeC = criarLocalidade(Ponto.C);
		final Localidade localidadeD = criarLocalidade(Ponto.D);
		final Localidade localidadeE = criarLocalidade(Ponto.E);
		final Localidade localidadeF = criarLocalidade(Ponto.F);
		
		localidadeB.addLocalidadeVisinha(localidadeA, 5);
		localidadeB.addLocalidadeVisinha(localidadeC, 7);
		localidadeB.addLocalidadeVisinha(localidadeD, 3);
		
		localidadeC.addLocalidadeVisinha(localidadeE, 4);
		
		localidadeD.addLocalidadeVisinha(localidadeE, 10);
		localidadeD.addLocalidadeVisinha(localidadeF, 8);
		
		final Regiao regiao = criarRegiao(localidadeB, localidadeC, localidadeD, localidadeE, localidadeF, localidadeA);
		regiao.setPonto(Ponto.B.name());
		return regiao;
	}
	
	public static Regiao criarRegiaoDeTesteAPartirC() {
		
		final Localidade localidadeA = criarLocalidade(Ponto.A);
		final Localidade localidadeB = criarLocalidade(Ponto.B);
		final Localidade localidadeC = criarLocalidade(Ponto.C);
		final Localidade localidadeD = criarLocalidade(Ponto.D);
		final Localidade localidadeE = criarLocalidade(Ponto.E);
		final Localidade localidadeF = criarLocalidade(Ponto.F);
		
		localidadeC.addLocalidadeVisinha(localidadeB, 7);
		localidadeC.addLocalidadeVisinha(localidadeE, 4);
		
		localidadeB.addLocalidadeVisinha(localidadeA, 5);
		localidadeB.addLocalidadeVisinha(localidadeD, 3);
		
		localidadeD.addLocalidadeVisinha(localidadeE, 10);
		localidadeD.addLocalidadeVisinha(localidadeF, 8);
		
		final Regiao regiao = criarRegiao(localidadeC, localidadeB, localidadeD, localidadeE, localidadeF, localidadeA);
		regiao.setPonto(Ponto.C.name());
		return regiao;
	}
	
	public static Regiao criarRegiaoDeTesteAPartirD() {
		
		final Localidade localidadeA = criarLocalidade(Ponto.A);
		final Localidade localidadeB = criarLocalidade(Ponto.B);
		final Localidade localidadeC = criarLocalidade(Ponto.C);
		final Localidade localidadeD = criarLocalidade(Ponto.D);
		final Localidade localidadeE = criarLocalidade(Ponto.E);
		final Localidade localidadeF = criarLocalidade(Ponto.F);
		
		localidadeD.addLocalidadeVisinha(localidadeB, 3);
		localidadeD.addLocalidadeVisinha(localidadeE, 10);
		localidadeD.addLocalidadeVisinha(localidadeF, 8);
		
		localidadeB.addLocalidadeVisinha(localidadeA, 5);
		localidadeB.addLocalidadeVisinha(localidadeC, 7);
		
		localidadeC.addLocalidadeVisinha(localidadeE, 4);
		
		final Regiao regiao = criarRegiao(localidadeD, localidadeB, localidadeC, localidadeE, localidadeF, localidadeA);
		regiao.setPonto(Ponto.D.name());
		return regiao;
	}
	
	public static Regiao criarRegiaoDeTesteAPartirE() {
		
		final Localidade localidadeA = criarLocalidade(Ponto.A);
		final Localidade localidadeB = criarLocalidade(Ponto.B);
		final Localidade localidadeC = criarLocalidade(Ponto.C);
		final Localidade localidadeD = criarLocalidade(Ponto.D);
		final Localidade localidadeE = criarLocalidade(Ponto.E);
		final Localidade localidadeF = criarLocalidade(Ponto.F);
		
		localidadeE.addLocalidadeVisinha(localidadeC, 4);
		localidadeE.addLocalidadeVisinha(localidadeD, 10);
		
		localidadeC.addLocalidadeVisinha(localidadeB, 7);
		
		localidadeD.addLocalidadeVisinha(localidadeB, 3);
		localidadeD.addLocalidadeVisinha(localidadeF, 8);
		
		localidadeB.addLocalidadeVisinha(localidadeA, 5);

		final Regiao regiao = criarRegiao(localidadeE, localidadeC, localidadeD, localidadeB, localidadeF, localidadeA);
		regiao.setPonto(Ponto.E.name());
		return regiao;
	}
	
	public static Regiao criarRegiaoDeTesteAPartirF() {
		
		final Localidade localidadeA = criarLocalidade(Ponto.A);
		final Localidade localidadeB = criarLocalidade(Ponto.B);
		final Localidade localidadeC = criarLocalidade(Ponto.C);
		final Localidade localidadeD = criarLocalidade(Ponto.D);
		final Localidade localidadeE = criarLocalidade(Ponto.E);
		final Localidade localidadeF = criarLocalidade(Ponto.F);
		
		localidadeF.addLocalidadeVisinha(localidadeD, 8);
		
		localidadeD.addLocalidadeVisinha(localidadeE, 10);
		localidadeD.addLocalidadeVisinha(localidadeB, 3);
		
		localidadeE.addLocalidadeVisinha(localidadeC, 4);
		
		localidadeC.addLocalidadeVisinha(localidadeB, 7);

		localidadeB.addLocalidadeVisinha(localidadeA, 5);
		
		final Regiao regiao = criarRegiao(localidadeF, localidadeD, localidadeE, localidadeC, localidadeB, localidadeA);
		regiao.setPonto(Ponto.F.name());
		return regiao;
	}
}
