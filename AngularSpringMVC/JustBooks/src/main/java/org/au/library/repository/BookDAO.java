package org.au.library.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.au.library.model.Book;
import org.au.library.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

	@Autowired
	JdbcTemplate jdbctemplate;

	public List<Book> All() {
		return jdbctemplate.query("select * from book", new RowMapper<Book>() {
			public Book mapRow(ResultSet rs, int i) throws SQLException {
				return new Book(rs.getString("name"), rs.getString("id"), rs.getString("author"), rs.getInt("price"),
						rs.getString("description"));
			}
		});

	}
	
	public Book get(String id)
	{
		List<Book> books = jdbctemplate.query("select * from book where id=\""+id +"\";", new RowMapper<Book>() {
			public Book mapRow(ResultSet rs, int i) throws SQLException {
				return new Book(rs.getString("name"), rs.getString("id"), rs.getString("author"), rs.getInt("price"),
						rs.getString("description"));
			}
		});
		return books.get(0);
	}
	
	
	
	  public Book create(Book book) {
	  jdbctemplate.update("insert into book (name,id,author,price,description)" + "values(?,?,?,?,?)",
			  new Object[] {book.getName(),book.getId(),book.getAuthor(),book.getPrice(),book.getDescription()});
		  return new Book();
	  }

	public Cart createBookToCart(Cart bookToCreate) {
	
	 jdbctemplate.update("insert into cart2 (id)" + "values(?)",
				  new Object[] {bookToCreate.getId()});
	Cart cart = new Cart(bookToCreate.getId());
	return cart;
	
	}

	public List<Cart> AllcartBooks() {

		return jdbctemplate.query("select * from cart2 ", new RowMapper<Cart>() {
			public Cart mapRow(ResultSet rs, int i) throws SQLException {
				return new Cart( rs.getString("id"));
			}
		});
	}
	 
}
