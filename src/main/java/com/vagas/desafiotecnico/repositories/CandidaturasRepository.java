package com.vagas.desafiotecnico.repositories;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.vagas.desafiotecnico.models.Candidatura;

@Repository
public interface CandidaturasRepository extends PagingAndSortingRepository<Candidatura, BigInteger> {


}
