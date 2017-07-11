package com.mule.support;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;


@Path("/books")
public class BooksResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	@Context
	String id;

	BookService bookService;
	
	public BooksResource(){
		bookService = new BookService();
	}

	// Get the book list
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Book> getBooksAsHtml() {
		return bookService.getBookAsList();
	}
	
	// Search book by name - search request
	@GET
	@Path("{title}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Book getBook(@PathParam("title") String title) {
		Book book = bookService.getBook(title);
		return book;
	}


	//POST can be used to modify the existing entity putting the same id into request
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createBook(@FormParam("title") String title,
			@FormParam("author") String author,
			@FormParam("pages") int pages,
			@FormParam("id") String id,
			@Context HttpServletResponse servletResponse) throws IOException {
		Book book = new Book(title, author, pages, id);
		bookService.createBook(book);
		servletResponse.sendRedirect("./books/");
	}
	
	// Delete book by name (Was unable to configure the search method properly, so the only way to make it work (search request) was to use book title instead of id)
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Book deleteBook(@PathParam("id") String id){
	      return bookService.deleteBook(id);
	  }

}