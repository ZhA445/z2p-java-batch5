package com.mmit.model;

import java.time.LocalDate;

public class Book {

	private int code;
	private String title;
	private float price;
	private LocalDate publish_date;
	private Category category;
	private Author author;
	private User created_by;
	
	//code
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	//title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	//price
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	//publish date
	public LocalDate getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(LocalDate publish_date) {
		this.publish_date = publish_date;
	}
	
	//category
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	//author
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	//created by
	public User getCreated_by() {
		return created_by;
	}
	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}
	
	
	public String getEntryBy() {
		return this.created_by.getUser_name();
	}
	
	public String getAuthorName() {
		return this.author.getName();
	}
	
	public String getCategoryName() {
		return this.category.getName();
	}
}
