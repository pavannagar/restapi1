package com.dhakad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhakad.dao.BookDao;
import com.dhakad.entity.Book;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bd;

	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bd.saveBook(book);
	}

	@Override
	public Book deleteBookById(int id) {
		// TODO Auto-generated method stub
		return bd.deleteBookById(id);
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return bd.getBookById(id);
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books=bd.getAllBooks();
		return books;
	}
}
