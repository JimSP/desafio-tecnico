package com.vagas.desafiotecnico.performancing;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

import com.vagas.desafiotecnico.creators.CriadorLocalidade;
import com.vagas.desafiotecnico.models.Localidade;
import com.vagas.desafiotecnico.models.Regiao;

public final class CriaMegaRegiaoParaTestePerformance {
	
	private static final Random RANDOM = new Random(System.nanoTime());
	
	private CriaMegaRegiaoParaTestePerformance() {
		
	}

	public static Regiao criar(final Localidade localidade, final Integer qtdLocalidade, final Consumer<String> localidadesCriadasConsumer) {
		final Regiao.RegiaoBuilder builder = Regiao.builder();
		builder.id(BigInteger.TEN);
		
		final Set<Localidade> localidades = new HashSet<>();
		int i = 0;
		Localidade localidadeVizinha = null;
		while(i < qtdLocalidade) {
			
			final String uuidLocalidade = UUID.randomUUID().toString();
			final Localidade novaLocalidade = CriadorLocalidade.criarLocalidade(uuidLocalidade);
			localidadesCriadasConsumer.accept(uuidLocalidade);
			
			localidade.addLocalidadeVisinha(novaLocalidade, 10);
			
			if(localidadeVizinha != null) {
				final List<Localidade> localidadesVizinhasAdjacentes = new ArrayList<>();
				localidadesVizinhasAdjacentes.add(novaLocalidade);
				localidadeVizinha.setLocalidades(localidadesVizinhasAdjacentes);
			}
			
			final Integer qtdLocalidadeVisinhas = geraQuantidadeCidadesVizinhas();
			
			int j = 0;
			while(j < qtdLocalidadeVisinhas) {
				localidadeVizinha = CriadorLocalidade.criarLocalidade(UUID.randomUUID().toString());
				novaLocalidade.addLocalidadeVisinha(localidadeVizinha, 10);
				j++;
			}

			localidades.add(novaLocalidade);
			i++;
		}
		
		return builder.localidades(localidades).build();
	}

	private static Integer geraQuantidadeCidadesVizinhas() {
		while(true) {
			final Integer qtd = RANDOM.nextInt(4);
			
			if(qtd != 0) {
				return qtd;
			}
		}
	}
}
