package com.boot.zen.service;

import com.boot.zen.bean.Book;
import com.boot.zen.mapper.BookMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
	final List<Book> books = new ArrayList<>();
	public BookService(){
		books.add(new Book("001", "Guide", "python", "python core", 79));
		books.add(new Book("002", "Bulin", "java", "Java Core", 129));
		books.add(new Book("003", "Sharp", "C++", "C Plus Plus Core", 179));
	}

	private BookMapper bookMapper;
	@Autowired
	public void setBookMapper(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	public Flux<Book> listAllBooks(){
		return Flux.fromStream(bookMapper.listAllBooks().stream());
	}

	public Mono<PageInfo<Book>> listBooks(int page, int size){
		return Mono.justOrEmpty(
				PageHelper.startPage(page, size).doSelectPageInfo(()->bookMapper.listAllBooks())
		);
		//return Mono.justOrEmpty(PageHelper.startPage(page, size, true).doSelectPage(() -> bookMapper.listAllBooks()));
	}

	public Mono<Book> getBookById(String id){
		return Flux.fromStream(books.stream()).filter(b -> b.getBookId().equals(id)).singleOrEmpty();
	}

	public Mono<Book> getBookByName(String name){
		return Mono.empty();
	}

	public Flux<Book> getAllBooksByAuthor(String author){
		return Flux.empty();
	}

	public Flux<Book> getBooksByAuthor(int page, int size, String author){
		return Flux.empty();
	}

	public Mono<String> getBookDescriptionById(String id){
		return Mono.empty();
	}

	public Mono<String> getBookDescriptionByName(String name){
		return Mono.empty();
	}
	// update must not change bookId
	public Mono<Integer> updateBookById(Book book){
		return Mono.just(1);
	}

	// update must not change bookId
	public Mono<Integer> updateBookByName(Book book){
		return Mono.just(1);
	}

	public Mono<Integer> deleteBookById(String id){
		return Mono.just(1);
	}

	public Mono<Integer> deleteBookByName(String name){
		return Mono.just(1);
	}
}
