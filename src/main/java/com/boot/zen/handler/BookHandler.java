package com.boot.zen.handler;

import com.boot.zen.service.BookService;
import com.boot.zen.util.ReactRespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component(value = "bookHandler")
public class BookHandler {
	private BookService bookService;
	@Autowired
	public void setBookService(BookService bookService){
		this.bookService = bookService;
	}

	public Mono<ServerResponse> listAllBooks(ServerRequest request){
		return ReactRespUtil.ok(bookService.listAllBooks().collectList().cast(Object.class));
	}

	public Mono<ServerResponse> listBooks(ServerRequest request){
		int page = Integer.valueOf(request.queryParam("page").orElse("1"));
		int size = Integer.valueOf(request.queryParam("size").orElse("20"));
		return ReactRespUtil.page(bookService.listBooks(page, size));
	}

	public Mono<ServerResponse> getBookById(ServerRequest request){
		return ReactRespUtil.ok(bookService.getBookById(request.pathVariable("id")));
	}

}
