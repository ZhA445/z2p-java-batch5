package base.model;

import java.time.LocalDate;

public class Book {

	private int id;
	private int code;
	private String title;
	private Author author;
	private BookCategory category;
	private LocalDate publish;
	private Member borrow_by;
	private LocalDate borrow_date;
	private LocalDate return_date;
	
	//set get borrow
	public LocalDate getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(LocalDate borrow_date) {
		this.borrow_date = borrow_date;
	}
	
	//set get return
	public LocalDate getReturn_date() {
		return return_date;
	}
	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}
	//set get id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//set get code
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	//set get title 
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	//normal author
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	//normal category
	public BookCategory getCategory() {
		return category;
	}
	public void setCategory(BookCategory category) {
		this.category = category;
	}
	
	//set and get category Name
	
	public String getCategoryName() {
		return this.category.getName();
	}
	public void setCategoryName() {
		this.category.getName();
	}
	
	// set and get author name
	public String getAuthorName() {
		return this.author.getName();
	}
	public void setAuthorName() {
		this.author.getName();
	}
	
	//set get publish date
	public LocalDate getPublish() {
		return publish;
	}
	public void setPublish(LocalDate publish) {
		this.publish = publish;
	}
	
	//set get borrow by
	public Member getBorrow_by() {
		return borrow_by;
	}
	public void setBorrow_by(Member borrow_by) {
		this.borrow_by = borrow_by;
	}
	//borrow by get name
	public void setBorrowBy() {
		this.borrow_by.getName();
	}
	
}
