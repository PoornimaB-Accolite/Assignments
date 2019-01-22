package com.hibernate.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@Column(name = "authorId")
	public int author_Id;

	@Column(name = "authorName")
	public String authorName;

	@Column(name = "mLanguage")
	public String mLanguage;

	@OneToMany(mappedBy = "authorId", fetch = FetchType.EAGER)
	public List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [author_Id=" + author_Id + ", authorName=" + authorName + ", mLanguage=" + mLanguage + "]";
	}

	public int getAuthor_Id() {
		return author_Id;
	}

	public void setAuthor_Id(int author_Id) {
		this.author_Id = author_Id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getmLanguage() {
		return mLanguage;
	}

	public void setmLanguage(String mLanguage) {
		this.mLanguage = mLanguage;
	}
}
