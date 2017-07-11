package com.mule.support;

import java.util.HashMap;
import java.util.Map;

public enum BookDao {
	instance;
	static Book book;

	private Map<String, Book> books = new HashMap<String, Book>();

	private BookDao() {

		//Adding some default data
		Book book = new Book("Pickwick Papers", "Charles Dickens", 500, "1");
		books.put("Pickwick Papers", book);
		book = new Book("Moby Dick", "Mellvile", 500, "2");
		books.put("Moby Dick", book);

	}

	public Map<String, Book> getBooks() {
		return books;
	}
	
	
}