package com.boot.zen.service;

import org.redisson.api.RLockReactive;
import org.redisson.api.RedissonReactiveClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

@Service
public class IndexService {

	private RedissonReactiveClient redissonReactiveClient;
	@Autowired
	@Qualifier(value = "redissonReactiveClient")
	public void setRedissonReactiveClient(RedissonReactiveClient redissonReactiveClient) {
		this.redissonReactiveClient = redissonReactiveClient;
	}

	public static final String LOCKER = "redis_index_locker";
	public static final String ID = "redis_index_id";
	public static final String PRE_FIX = "INDEX_ID_";

	public Mono<String> index(){
		RLockReactive lockReactive = redissonReactiveClient.getLock(LOCKER);
		lockReactive.lock(3, TimeUnit.SECONDS).subscribe();
		Mono<String> idx = redissonReactiveClient.getAtomicLong(ID)
				.addAndGet(1)
				.flatMap(d -> Mono.just(PRE_FIX + String.valueOf(d)));

		lockReactive.unlock().subscribe();
		return idx;
	}
}
