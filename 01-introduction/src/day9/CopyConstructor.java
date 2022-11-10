package day9;

import java.time.LocalDate;

public class CopyConstructor {

		public static void main(String[] args) {
			
			var date = LocalDate.of(1961, 10, 16);
			
			
			Book book1 = new Book("Detective U San Shar", date, 6500);
			
			System.out.println(book1.toString());
			
			var book2 = new Book(book1);
			
			System.out.println("--------");
			System.out.println(book2);
		}
}
