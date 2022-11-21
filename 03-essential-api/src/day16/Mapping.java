package day16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {

	public static void main(String[] args) {
		List<Employee> emplist = Arrays.asList(
				new Employee("Kyaw Kyaw", 9800, "yangon"),
				new Employee("aung aung", 6000, "mandalay"),
				new Employee("maung maung", 10000, "mandalay"),
				new Employee("yuri", 6000, "yangon"),
				new Employee("Jeon", 6000, "monywa")
				);
		
		//distance cities
		List<String> cities = emplist.stream()
									.map(obj -> obj.getCity())
									.distinct()
									.collect(Collectors.toList());
		
		System.out.println("cities: " + cities);
		
		//salary  array
		int[] salaries = emplist.stream()
								.filter(obj -> obj.getSalary() > 6000)
								.mapToInt(obj -> obj.getSalary())
								.toArray();
		
		System.out.println("salaries: " + Arrays.toString(salaries));
		
		//salary list
		List<Integer> salarylist = emplist.stream()
										.map(obj -> obj.getSalary())
										.filter(val -> val < 10000)
										.limit(3)
										.toList();
		System.out.println("salary: " + salarylist);
		
		// max salary
		int max_salary = emplist.stream()
								.mapToInt(emp -> emp.getSalary())
								.max()
								.getAsInt();
		System.out.println("Max salary : " + max_salary);
		
		
	}
}
