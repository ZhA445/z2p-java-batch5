package day14.assigment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

	private static List<String> categorylist = new ArrayList<>();
	private static List<Author> authorlist = new ArrayList<>();
	private static List<Book> booklist = new ArrayList<>();
	
	public static void main(String[] args) {
		
		init();
	}

	private static void init() {
		
		// add category
		String[ ] categories = {"category 1" , "category 2" ,  "category 3" , "category 4"};
		categorylist.addAll(Arrays.asList(categories));
		
		//add author
		List<Author> authors = List.of(
			new Author("Aung Aung", "Myanmar"),
			new Author("Kyaw Kyaw", "India")
		);
		authorlist.addAll(authors);
		
		//add book
		var book1 = new Book();
		book1.setCode(1001);
		book1.setTitle("Title 1");
		book1.setPublishDate(LocalDate.now());
		book1.setCategory(categorylist.get(0));
		book1.setAuthor(authorlist.get(1));
		
		var book2 = new Book();
		book2.setCode(1002);
		book2.setTitle("Title 2");
		book2.setPublishDate(LocalDate.now());
		book2.setCategory(categorylist.get(1));
		book2.setAuthor(authorlist.get(1));
		
		booklist.add(book1);
		booklist.add(book2);
		
	}
}
