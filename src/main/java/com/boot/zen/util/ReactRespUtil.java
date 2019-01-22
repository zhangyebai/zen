package com.boot.zen.util;

import com.alibaba.fastjson.JSON;
import com.boot.zen.common.Property;
import com.github.pagehelper.PageInfo;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


/**
 * @author zhangyebai
 * @descript err means non-pageable response wrapper
 * 			 error means pageable response wrapper
 * */
public class ReactRespUtil {
	private ReactRespUtil(){}

	public static <T> Mono<ServerResponse> ok(int code, String message, Mono<T> data){
		return data.flatMap(d-> Mono.just(JSON.toJSONString(RespUtil.ok(code, message, d), true)))
				.flatMap(ctx ->
						ServerResponse.ok()
								.contentType(MediaType.APPLICATION_JSON)
								.syncBody(ctx)
				).switchIfEmpty(
						ServerResponse.ok()
								.contentType(MediaType.APPLICATION_JSON)
								.syncBody(JSON.toJSONString(RespUtil.ok(code, message, null), true))
				);
	}

	public static <T> Mono<ServerResponse> ok(int code, Mono<T> data){
		return ok(code, Property.Message.OK, data);
	}

	public static <T> Mono<ServerResponse> ok(String message, Mono<T> data){
		return ok(Property.Code.OK, message, data);
	}

	public static <T> Mono<ServerResponse> ok(Mono<T> data){
		return ok(Property.Code.OK, Property.Message.OK, data);
	}

	public static <T> Mono<ServerResponse> err(int code, Mono<T> data){
		return ok(code, Property.Message.ERROR, data);
	}

	public static <T> Mono<ServerResponse> err(String message, Mono<T> data){
		return ok(Property.Code.ERROR, message, data);
	}

	public static <T> Mono<ServerResponse> err(Mono<T> data){
		return ok(Property.Code.ERROR, Property.Message.ERROR, data);
	}

	public static <T> Mono<ServerResponse> page(int code, String message, Mono<PageInfo<T>> data){
		return data.flatMap(l-> Mono.just(JSON.toJSONString(RespUtil.page(code, message, l), true)))
				.flatMap(ctx->
						ServerResponse.ok()
								.contentType(MediaType.APPLICATION_JSON)
								.syncBody(ctx))
				.switchIfEmpty(ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.syncBody(JSON.toJSONString(RespUtil.page(code, message, null), true))
				);
	}

	public static <T> Mono<ServerResponse> page(int code, Mono<PageInfo<T>> data){
		return page(code, Property.Message.OK, data);
	}

	public static <T> Mono<ServerResponse> page(String message, Mono<PageInfo<T>> data){
		return page(Property.Code.OK, message, data);
	}

	public static <T> Mono<ServerResponse> page(Mono<PageInfo<T>> data){
		return page(Property.Code.OK, Property.Message.OK, data);
	}

	public static <T> Mono<ServerResponse> error(int code, String message, Mono<PageInfo<T>> data){
		return page(code, message, data);
	}

	public static <T> Mono<ServerResponse> error(int code, Mono<PageInfo<T>> data){
		return page(code, Property.Message.ERROR, data);
	}

	public static <T> Mono<ServerResponse> error(Mono<PageInfo<T>> data){
		return page(Property.Code.ERROR, Property.Message.ERROR, data);
	}
}
