package com.hibernate.assignment.Hibernate_Assignment1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.pojos.Author;
import com.hibernate.pojos.Book;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();

		// Adding in the Author table

		Author a1 = new Author();
		a1.setAuthor_Id(1);
		a1.setAuthorName("Kuvempu");
		a1.setmLanguage("Kannada");
		session.save(a1);

		Author a2 = new Author();
		a2.setAuthor_Id(2);
		a2.setAuthorName("Robin");
		a2.setmLanguage("English");
		session.save(a2);

		Author a3 = new Author();
		a3.setAuthor_Id(3);
		a3.setAuthorName("GourGopal");
		a3.setmLanguage("English");
		session.save(a3);

		Author a4 = new Author();
		a4.setAuthor_Id(4);
		a4.setAuthorName("Joseph");
		a4.setmLanguage("english");
		session.save(a4);

		session.getTransaction().commit();

		// Adding data into book Table
		Book b1 = new Book();
		b1.setAuthorId(1);
		b1.setBookId(1);
		b1.setBookTitle("Kolalu");
		session.save(b1);

		Book b2 = new Book();
		b2.setAuthorId(2);
		b2.setBookId(2);
		b2.setBookTitle("xyz");
		session.save(b2);

		Book b3 = new Book();
		b3.setAuthorId(2);
		b3.setBookId(3);
		b3.setBookTitle("abc");
		session.save(b3);

		Book b4 = new Book();
		b4.setAuthorId(3);
		b4.setBookId(4);
		b4.setBookTitle("pqr");
		session.save(b4);

		Book b5 = new Book();
		b5.setAuthorId(4);
		b5.setBookId(5);
		b5.setBookTitle("xyz");
		session.save(b2);

		session.getTransaction().commit();

//Querying Part
		List<Author> authorList = new ArrayList<Author>();
		Criteria cri1 = session.createCriteria(Author.class);
		// Search author by Name
		cri1.add(Restrictions.eq("authorName", "Kuvempu"));
		authorList = cri1.list();
		System.out.println(authorList.get(0));

		// Search author by Id
		cri1.add(Restrictions.eq("author_Id", 1));
		System.out.println(cri1.list());

		// Joining Query
		List<Author> alist = new ArrayList<Author>();
		Criteria cri2 = session.createCriteria(Author.class);
		alist = cri2.list();
		System.out.println(alist);
//List Details Of All Authors and their books
		for (Author a : alist) {

			System.out.println("Author Name : " + a.getAuthorName());
			System.out.println("Author Id : " + a.getAuthor_Id());
			System.out.println("Author Language : " + a.getmLanguage());
			System.out.println("Author Books : " + (!a.getBooks().isEmpty() ? a.getBooks() : " No books"));
		}

		List<Book> blist = new ArrayList<Book>();
		Criteria cri3 = session.createCriteria(Book.class);
		blist = cri3.list();
// List All Books
		System.out.println("All The books List");
		int i = 0;
		for (Book b : blist) {
			Criteria cri4 = session.createCriteria(Author.class);
			cri4.add(Restrictions.eq("author_Id", b.getAuthorId()));
			Author auth = (Author) cri4.list().get(0);
			System.out.print("Author Of the book is :");
			System.out.println(auth.getAuthorName());
			System.out.println("---------------------------------");
			System.out.println("Book Title : " + b.getBookTitle());
			System.out.println("Book Id : " + b.getBookId());
		}
	}
}
