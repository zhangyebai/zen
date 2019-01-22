package com.boot.zen.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

	@Value("${spring.redisson.url}")
	private String url;

	@Value("${spring.redisson.database}")
	private int database;

	@Bean(destroyMethod = "shutdown", value = "redissonClient")
	RedissonClient redissonClient(){
		Config config = new Config();
		config.useSingleServer().setDatabase(database).setAddress(url);
		return Redisson.create(config);
	}

	@Bean(destroyMethod = "shutdown", value = "redissonReactiveClient")
	RedissonReactiveClient redissonReactiveClient(){
		Config config = new Config();
		config.useSingleServer().setDatabase(database).setAddress(url);
		return Redisson.createReactive(config);
	}

}
