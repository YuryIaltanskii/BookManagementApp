package com.mule.support;

import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class Book {

    private String title;
    private String author;
    private Integer pages;
    private String id; // Must be unique per book
    
    public Book() {
    }

    public Book(String title, String author, int pages, String id) {
    	this.title = title;
    	this.author = author;
    	this.pages = pages;
    	this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    @XmlElement
    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }
    @XmlElement
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getId() {
        return id;
    }
    @XmlElement
    public void setId(String id) {
        this.id = id;
    }

}
