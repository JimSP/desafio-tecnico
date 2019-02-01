package com.vagas.desafiotecnico.repositories;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.vagas.desafiotecnico.models.Candidato;

@Repository
public interface CandidatosRepository extends PagingAndSortingRepository<Candidato, BigInteger>{

}
