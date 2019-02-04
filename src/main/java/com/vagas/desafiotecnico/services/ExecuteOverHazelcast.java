package com.vagas.desafiotecnico.services;

import java.io.Serializable;
import java.util.concurrent.Callable;

public interface ExecuteOverHazelcast<T> extends Callable<T>, Serializable{

}
