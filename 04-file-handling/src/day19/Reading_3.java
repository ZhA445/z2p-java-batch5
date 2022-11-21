package day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Reading_3 {

	public static void main(String[] args) throws IOException {
		
		//define location
		Path path = Path.of("src/employee.txt");
		
		//read
		List<String> lines = Files.readAllLines(path);
		
		//convert line to object
		List<Employee> empList = lines.stream()
										.map(Employee::convertLineToObject)
										.toList();
		
		empList.forEach(emp -> {
			System.out.println("Id : " + emp.getId());
			System.out.println("Name : " + emp.getName());
			System.out.println("City : " + emp.getCity());
			System.out.println("---------------");
		});
		
	}
}
