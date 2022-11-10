package day12.HasA;

public class Book {

	String name;
	int price;
	Author author;//Has-A relationship
	public Book(String name, int price, Author author) {
		super();
		this.name = name;
		this.price = price;
		this.author = author;
	}
}
