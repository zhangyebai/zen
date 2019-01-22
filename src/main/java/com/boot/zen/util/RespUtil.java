package com.boot.zen.util;

import com.boot.zen.common.Pagination;
import com.boot.zen.common.PageResp;
import com.boot.zen.common.Property;
import com.boot.zen.common.Resp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;


/**
 * @author zhangyebai
 * */
public class RespUtil {

	private RespUtil(){}


	public static <T> Resp<T> ok(int code, String message, T data){
		return new Resp<>(code, message, data);
	}

	public static <T> Resp<T> ok(T data){
		return ok(Property.Code.OK, Property.Message.OK, data);
	}

	public static <T> Resp<T> ok(int code, T data){
		return ok(code, Property.Message.OK, data);
	}

	public static <T> Resp<T> ok(String message, T data){
		return ok(Property.Code.OK, message, data);
	}

	public static <T> Resp<T> err(int code, T data){
		return ok(code, Property.Message.ERROR, data);
	}

	public static <T> Resp<T> err(String message, T data){
		return ok(Property.Code.ERROR, message, data);
	}

	public static <T> PageResp<T> page(int code, String message, PageInfo<T> data){
		if (null == data){
			return new PageResp<>(code, message, new Pagination(1, 0, 1, 0), null);
		}
		return new PageResp<>(code,
				message,
				new Pagination(data.getPageNum(), data.getPageSize(), data.getPages(), data.getTotal()),
				data.getList());
	}

	public static <T> PageResp<T> page(int code, PageInfo<T> data){
		return page(code, Property.Message.OK, data);
	}

	public static <T> PageResp<T> page(String message, PageInfo<T> data){
		return page(Property.Code.OK, message, data);
	}

	public static <T> PageResp<T> page(PageInfo<T> data){
		return page(Property.Code.OK, Property.Message.OK, data);
	}
}
