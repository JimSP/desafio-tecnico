package com.vagas.desafiotecnico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.hazelcast.repository.config.EnableHazelcastRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableHazelcastRepositories(basePackages={"com.vagas.desafiotecnico.repositories"})
@EnableTransactionManagement
@EnableCaching
public class DesafioTecnicoApplication {

	public static void main(final String[] args) {
		SpringApplication.run(DesafioTecnicoApplication.class, args);
	}

}

