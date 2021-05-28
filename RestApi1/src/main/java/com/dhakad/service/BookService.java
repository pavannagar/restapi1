package com.dhakad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhakad.dao.BookDao;
import com.dhakad.entity.Book;

@Service
public interface BookService {

	
	public Book saveBook(Book book);
	public Book deleteBookById(int id);
	public Book getBookById(int id);
	public List<Book> getAllBooks();

	
}
