package com.dhakad.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhakad.entity.Book;

@Repository
public interface BookDao {

	public Book saveBook(Book book);
	public Book deleteBookById(int id);
	public Book getBookById(int id);
	public List<Book> getAllBooks();

	

}
