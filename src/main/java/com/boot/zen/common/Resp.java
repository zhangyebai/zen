package com.boot.zen.common;


import com.alibaba.fastjson.annotation.JSONField;


/**
 * @author zhangyebai
 * @node 由于Reactive RestFul Http Api使用的是fastjson手动实现的bean<-->object的转换，所以用@JSONField确定了一下顺序
 *
 * */
public class Resp<T> {

	@JSONField(ordinal = 0)
	private int code;
	@JSONField(ordinal = 1)
	private String message;
	@JSONField(ordinal = 2)
	private T data;

	public Resp(int code, String message, T data){
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Resp<T> setCode(int code){
		this.code = code;
		return this;
	}

	public int getCode(){
		return this.code;
	}

	public Resp<T> setMessage(String message){
		this.message = message;
		return this;
	}

	public String getMessage(){
		return this.message;
	}

	public Resp<T> setData(T data){
		this.data = data;
		return this;
	}

	public T getData(){
		return this.data;
	}
}
