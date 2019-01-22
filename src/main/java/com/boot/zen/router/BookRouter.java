package com.boot.zen.router;

import com.boot.zen.handler.BookHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Objects;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.queryParam;

@Configuration
public class BookRouter {

	@Bean
	public RouterFunction<ServerResponse> bookRouteFunction(@Autowired BookHandler bookHandler){

		return RouterFunctions
				.route(GET("/reactor/book/all")
								.and(accept(MediaType.APPLICATION_JSON_UTF8)),
						bookHandler::listAllBooks)
				.andRoute(GET("/reactor/book/id/{id}")
								.and(accept(MediaType.APPLICATION_JSON_UTF8)),
						bookHandler::getBookById)
				.andRoute(GET("/reactor/books")
								.and(accept(MediaType.APPLICATION_JSON_UTF8))
								.and(queryParam("page", Objects::nonNull))
								.and(queryParam("size", Objects::nonNull)),
						bookHandler::listBooks);
	}
}
