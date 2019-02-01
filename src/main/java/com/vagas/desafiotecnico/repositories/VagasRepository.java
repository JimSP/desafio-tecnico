package com.vagas.desafiotecnico.repositories;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.vagas.desafiotecnico.models.Vaga;

@Repository
public interface VagasRepository extends PagingAndSortingRepository<Vaga, BigInteger>{

}
