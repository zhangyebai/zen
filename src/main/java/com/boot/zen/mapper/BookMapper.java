package com.boot.zen.mapper;

import com.boot.zen.bean.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "bookMapper")
public interface BookMapper {

	List<Book> listAllBooks();
}
