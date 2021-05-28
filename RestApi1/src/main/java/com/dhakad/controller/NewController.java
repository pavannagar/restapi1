package com.dhakad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dhakad.entity.Book;
import com.dhakad.service.BookService;

@RestController
public class NewController {

	@Autowired
	private BookService bs;
	
	//@RequestMapping(value = "/book", method = RequestMethod.GET)
	@GetMapping(value = "book/{id}")
	public String getBook(@PathVariable("id") int id) {
		
		Book book=bs.getBookById(id);
		return book.toString();
	}
	
	@GetMapping(value="books/json/{id}", produces="application/json")
	public Book getSingleBookAsJson(@PathVariable("id") int code) {
		Book book=bs.getBookById(code);
		return book;
	}
	
	@GetMapping(value = "book/json/{id}", produces="application/json")
	public Book getBookJson(@PathVariable("id") int id) {
		
		Book book=bs.getBookById(id);
		return book;
	}
	@GetMapping(value="books" , produces = "application/json ")
	public List<Book> getAllBooks(){
		List<Book> books=bs.getAllBooks();
		return books;
	}
	
	
	@PostMapping(value="book",consumes = "application/json",produces = "application/json")
	public Book addBook(@RequestBody Book book) {
			 bs.saveBook(book);
			return book;
	}
	
	@PutMapping(value="book",consumes = "application/json",produces = "application/json")
	public Book updateBook(@RequestBody Book book) {
			 bs.saveBook(book);
			return book;
	}
	
	@DeleteMapping(value = "book/json/{id}")
	public Book deletebook(@PathVariable("id")int id) {
		Book book=bs.deleteBookById(id);
		return book;
	}
	
}
