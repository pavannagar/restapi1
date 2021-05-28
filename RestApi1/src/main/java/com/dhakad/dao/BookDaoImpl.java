package com.dhakad.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.dhakad.entity.Book;
@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sf;

	public Book saveBook(Book book) {
		
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.saveOrUpdate(book);
		tr.commit();
		s.close();
		return book;
	}

	@Override
	public Book deleteBookById(int id) {
	
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		Book book=s.get(Book.class, id);
		s.delete(book);
		tr.commit();
		s.close();
		return book;
	}

	@Override
	public Book getBookById(int id) {
		Session s=sf.openSession();
		Book book=s.get(Book.class, id);
		s.close();
		return book;
	}

	
	@Override
	public List<Book> getAllBooks() {
		Session s=sf.openSession();
		
									//  ***NOTE***
		String hql="from Book";	 	//here in your query Entity name is used 
		  							// so same class/entity name use (i make a mistake)
		
		
		//String hql="from book";	<- this is wrong because book is not a class Our entity Class Name Is Book ( where B is capital )
		
									//  i use book instead of Book (' B ') is Capital
									// and dont use ("Select from book")
									// select is use when we fetch selected column
		
		
		Query query=s.createQuery(hql);
		List<Book> books=query.list();
		s.close();
		return books;
	}




}
