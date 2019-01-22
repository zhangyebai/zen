package com.boot.zen.ctrl;

import com.boot.zen.bean.Book;
import com.boot.zen.common.Resp;
import com.boot.zen.mapper.BookMapper;
import com.boot.zen.service.IndexService;
import com.boot.zen.util.ReactRespUtil;
import com.boot.zen.util.RespUtil;
import org.redisson.api.RedissonReactiveClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class IndexCtrl {

	//@Autowired
	//private BookMapper bookMapper;

	private RedissonReactiveClient redissonReactiveClient;
	@Autowired
	@Qualifier(value = "redissonReactiveClient")
	public void setRedissonReactiveClient(RedissonReactiveClient redissonReactiveClient){
		this.redissonReactiveClient = redissonReactiveClient;
	}

	@Autowired
	private IndexService indexService;

	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Mono<String> hello(){
		return Mono.just("hello from reactive web project by spring boot 2.0");
	}

	@GetMapping(value = "/index", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Mono<Integer> getIndex(){
		return Mono.just(1);
	}

	@GetMapping(value = "/redis/keys", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Mono<Resp<List<String>>> getKeysInRedis(){
		return redissonReactiveClient.getKeys()
				.getKeysByPattern("*")
				.collectList().flatMap(l -> Mono.just(RespUtil.ok(l)));
	}

	@GetMapping(value = "/lock/index", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Mono<Resp<String>> index(){
		return indexService.index().flatMap(idx-> Mono.just(RespUtil.ok(idx)));
	}

}
