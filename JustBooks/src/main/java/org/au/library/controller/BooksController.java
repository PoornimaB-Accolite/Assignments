package org.au.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.au.library.model.Book;
import org.au.library.model.Cart;
import org.au.library.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

	@Autowired
	BookDAO bookdao;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Book> getAll() {

		/*
		 * List<Book> books=new ArrayList(); books.add(new
		 * Book("Marvel Comics","1021","Stanlee",120,"I can do this all day")); return
		 * books;
		 */
		return bookdao.All();

	}

	@RequestMapping(value = "/cartbooks", method = RequestMethod.GET)
	public List<Cart> getAllCartBooks() {

		return bookdao.AllcartBooks();

	}

	/*
	 * @RequestMapping(value="/books/1/get",method=RequestMethod.GET) public Book
	 * getFirstBook() {
	 * 
	 * List<Book> books=new ArrayList(); return new
	 * Book("Marvel Comics","1021","Stanlee",120,"I can do this all day");
	 * 
	 * }
	 */
	@RequestMapping(value = "/books/get/{bookId}", method = RequestMethod.GET)
	public Book getBookById(@PathVariable(value = "bookId") String bookId) {
		return bookdao.get(bookId);
	}

	@RequestMapping(value = "/booksinsert", method = RequestMethod.POST)
	public Book create(@RequestBody Book bookToCreate) {
		return bookdao.create(bookToCreate);
	}

	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	public Cart createbook(@RequestBody Cart bookToCreate) {
		return bookdao.createBookToCart(bookToCreate);
	}

}
