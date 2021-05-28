package com.dhakad.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dhakad.entity.Book;
import com.dhakad.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bs;
	@RequestMapping("/input")
	public ModelAndView showInput() {
		ModelAndView mv=new ModelAndView("dataentry-spring-form.jsp");
		mv.addObject("book", new Book());
		return mv;
	}
	
	 @RequestMapping("/saveBook")
	public ModelAndView c_save(@Valid @ModelAttribute("book")Book book,BindingResult result) {

		 if(result.hasErrors()) {
				ModelAndView mv=new ModelAndView("dataentry-spring-form.jsp");
				return mv;

		 }
		 
		bs.saveBook(book);
		ModelAndView mv=new ModelAndView("result.jsp");
		return mv;
	}
	
	 @RequestMapping("/searchBook")
	 public String ShowSearchForm() {
		 return "searchform.jsp";
	 }
	 @RequestMapping("/processsearch")
	 public ModelAndView searchBookByCode(@RequestParam("id")int id) {
		 Book book=bs.getBookById(id);
		 ModelAndView mv=new ModelAndView("bookdetails.jsp");
		 mv.addObject("book",book);
		 
		 return mv;
	 }
	 @RequestMapping("/showall")
	 public ModelAndView showBooks() {
		 List<Book> books= bs.getAllBooks();
		 ModelAndView mv=new ModelAndView("showbooks.jsp");
		 mv.addObject("books", books);
		 return mv;
	 }
	 @RequestMapping("/deleteBook")
	 public ModelAndView deletebook(@RequestParam("id") int id) {
		 bs.deleteBookById(id);
		 ModelAndView mv=new ModelAndView("redirect:showall");
		 return mv;
	 }
	 
	 
	 //below two method is update book using spring form
	 
	 @RequestMapping("/changeBook")
	 public ModelAndView updateBook(@RequestParam("id") int id) {
		Book book=bs.getBookById(id);
		ModelAndView mv=new ModelAndView("spring-form.jsp");
		mv.addObject("book", book);
		return mv;
		
	 }
	
	 @RequestMapping("/updateChange")
	public ModelAndView saveChanges(@ModelAttribute("book") Book book) {
		bs.saveBook(book);
		ModelAndView mv=new ModelAndView("redirect:showall");
		return mv;
	}
	 
	 
	 
	 
/*  
 * 
 * 		update Book using without spring form	 
 */

/*	 @RequestMapping("/changeBook")
	 public ModelAndView updateBook(@RequestParam("id") int id) {
		Book book=bs.getBookById(id);
		System.out.println(book);
		ModelAndView mv=new ModelAndView("updateForm.jsp");
		mv.addObject("book", book);
		return mv;
		
	 }
	
	 @RequestMapping("/processChange")
	public ModelAndView saveChanges(@ModelAttribute("book") Book book) {
		bs.saveBook(book);
		System.out.println(book);
		ModelAndView mv=new ModelAndView("redirect:showall");
		return mv;
	}
	
*/
	 
	 
	  
	 
	 
}
