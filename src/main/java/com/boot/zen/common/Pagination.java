package com.boot.zen.common;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zhangyebai
 * 由于涉及到分页,且与PageHelper中的Page名称一样，容易造成误解
 * 故由Page改成Pagination
 * field:
 * 		page: 请求的当前页
 * 		size: 请求的当前页大小
 * 		pages: 符合请求的总页数
 * 		total: 符合请求的总条数
 * */
public class Pagination {
	@JSONField(ordinal = 0)
	private int page;
	@JSONField(ordinal = 1)
	private int size;
	@JSONField(ordinal = 2)
	private int pages;
	@JSONField(ordinal = 3)
	private long total;

	public Pagination(int page, int size, int pages, long total){
		this.page = page;
		this.size = size;
		this.pages = pages;
		this.total = total;
	}

	public Pagination(){
		this(1, 0, 1, 0);
	}


	public Pagination setPage(int page){
		this.page = page;
		return this;
	}

	public int getPage(){
		return this.page;
	}

	public Pagination setSize(int size){
		this.size = size;
		return this;
	}

	public int getSize(){
		return this.size;
	}

	public Pagination setPages(int pages){
		this.pages = pages;
		return this;
	}

	public int getPages(){
		return this.pages;
	}

	public Pagination setTotal(long total){
		this.total = total;
		return this;
	}

	public long getTotal(){
		return this.total;
	}
}
