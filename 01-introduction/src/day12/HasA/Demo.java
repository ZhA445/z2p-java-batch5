package day12.HasA;

public class Demo {

	public static void main(String[] args) {
		
		Author auth = new Author("Mya Than Tint", "Myaing");
		
		Book book = new Book("War and Peace", 15000, auth);
		
		System.out.println("Book Name: " + book.name);
		System.out.println("Book Price: " + book.price);
		System.out.println("Author name: " + auth.name);
		System.out.println("Author nativeTown: " + auth.nativeTown);
	}
}
