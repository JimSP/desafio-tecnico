package com.vagas.desafiotecnico.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.FlakeIdGeneratorConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.flakeidgen.FlakeIdGenerator;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import com.hazelcast.spring.transaction.HazelcastTransactionManager;
import com.hazelcast.spring.transaction.ManagedTransactionalTaskContext;

@Configuration
public class HazelcastConfiguration {

	@Bean("hazelcastInstance")
	public HazelcastInstance hazelcastInstante(@Autowired final Config config) {
		return Hazelcast.getOrCreateHazelcastInstance(config);
	}

	@Bean
	public CacheManager cacheManager(@Autowired final HazelcastInstance hazelcastInstance) {
		return new HazelcastCacheManager(hazelcastInstance);
	}

	@Bean
	public Config config() {
		return new Config("hazelcastInstante").addFlakeIdGeneratorConfig(flakeIdGeneratorConfig());
	}

	@Bean
	public FlakeIdGeneratorConfig flakeIdGeneratorConfig() {
		return new FlakeIdGeneratorConfig("flakeIdGenerator");
	}

	@Bean
	public FlakeIdGenerator flakeIdGenerator(@Autowired final HazelcastInstance hazelcastInstance) {
		return hazelcastInstance.getFlakeIdGenerator("flakeIdGenerator");
	}

	@Bean
	public HazelcastTransactionManager hazelcastTransactionManager(
			@Autowired final HazelcastInstance hazelcastInstance) {
		return new HazelcastTransactionManager(hazelcastInstance);
	}

	@Bean
	public ManagedTransactionalTaskContext managedTransactionalTaskContext(
			@Autowired final HazelcastTransactionManager hazelcastTransactionManager) {
		return new ManagedTransactionalTaskContext(hazelcastTransactionManager);
	}
}
