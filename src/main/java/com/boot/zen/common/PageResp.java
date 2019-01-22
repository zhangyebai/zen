package com.boot.zen.common;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class PageResp<T> {

	@JSONField(ordinal = 0)
	private int code;
	@JSONField(ordinal = 1)
	private String message;
	@JSONField(ordinal = 2)
	private Pagination pagination;
	@JSONField(ordinal = 3)
	private List<T> data;

	public PageResp(int code, String message, Pagination pagination, List<T> data){
		this.code = code;
		this.message = message;
		this.pagination = pagination;
		this.data = data;
	}

	public PageResp<T> setCode(int code){
		this.code = code;
		return this;
	}

	public int getCode(){
		return this.code;
	}

	public PageResp<T> setMessage(String message){
		this.message = message;
		return this;
	}

	public String getMessage(){
		return this.message;
	}

	public PageResp<T> setPagination(Pagination pagination){
		this.pagination = pagination;
		return this;
	}

	public Pagination getPagination(){
		return this.pagination;
	}

	public PageResp<T> setData(List<T> data){
		this.data = data;
		return this;
	}

	public List<T> getData(){
		return this.data;
	}
}
