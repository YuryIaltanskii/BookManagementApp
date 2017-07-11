package com.mule.support;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookService {

	static BookDao bookDao;

	public BookService() {
		bookDao = BookDao.instance;
	}

	public void createBook(Book book) {
		bookDao.getBooks().put(book.getTitle(), book);
	}

	public Book getBook(String title) {
		return bookDao.getBooks().get(title);
	}

	public Map<String, Book> getBook() {
		return bookDao.getBooks();
	}

	public List<Book> getBookAsList() {
		List<Book> bookList = new ArrayList<Book>();
		bookList.addAll(bookDao.getBooks().values());
		return bookList;
	}
	
	public List<Book> getBookByTitle() {
		List<Book> bookList = new ArrayList<Book>();
		bookList.addAll(bookDao.getBooks().values());
		return bookList;
	}
	
	public int getAnimalsCount() {
		return bookDao.getBooks().size();
	}

	public Book deleteBook(String id) {
		return bookDao.getBooks().remove(id);
	}


}