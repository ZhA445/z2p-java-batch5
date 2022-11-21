package day16;

import java.util.List;
import java.util.stream.Stream;

public class Filtering {

	public static void main(String[] args) {
		
		List<User> users = List.of(
					new User("Kyaw Kyaw", "admin"),
					new User("Aung Aung", "staff"),
					new User("Maung Maung", "staff"),
					new User("Jeon", "customer"),
					new User("Yuri", "customer")
				);
		
		//create stream
		//Stream<User> streams = users.stream();
		
		users.stream()
			//.filter(user -> user.getRole().equals("staff"))
			.filter(User::IsStaff)
			
			.forEach(obj -> { //create stream
				System.out.println("Name : " + obj.getName());
				System.out.println("Roel : " + obj.getRole());
				System.out.println("--------------");
			});
		
		System.out.println("-----User contains 'aung'-----");
		users.stream()
			.filter(obj -> obj.getName().contains("aung") && obj.getRole().equals("staff"))
			.forEach(obj -> {
				System.out.println("Name : " + obj.getName());
				System.out.println("Roel : " + obj.getRole());
				System.out.println("--------------");
			});
				
	}
}
