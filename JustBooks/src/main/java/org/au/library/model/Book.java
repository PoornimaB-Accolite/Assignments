package org.au.library.model;

public class Book {
	
	private String name;
	private String id;
	private String author;
	private int price;
	private String description;
	public Book() {
		super();
	}
	public Book(String name, String id, String author, int price, String description) {
		super();
		this.name = name;
		this.id = id;
		this.author = author;
		this.price = price;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
