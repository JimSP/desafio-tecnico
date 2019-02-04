package com.vagas.desafiotecnico.services.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;

@Service
public class ExecuteOverHazelcastService {

	private HazelcastInstance hazelcastInstance;

	public <T> Future<T> submit(final String name, final Callable<T> callable) {
		return hazelcastInstance.getExecutorService(name).submit(callable);
	}

	public Future<?> submit(final String name, final Runnable runnable) {
		return hazelcastInstance.getExecutorService(name).submit(runnable);
	}
}
