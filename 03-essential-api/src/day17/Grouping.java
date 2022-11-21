package day17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import day16.Employee;

public class Grouping {

	public static void main(String[] args) {
		List<Employee> emplist = Arrays.asList(
				new Employee("Kyaw Kyaw", 9800, "yangon"),
				new Employee("aung aung", 6000, "mandalay"),
				new Employee("maung maung", 10000, "mandalay"),
				new Employee("yuri", 6000, "yangon"),
				new Employee("Jeon", 6000, "monywa")
				);
		
		//count by city
		Map<String, Long> counting = emplist.stream()
											.collect(Collectors.groupingBy(emp -> emp.getCity(), Collectors.counting()));
		
		
		//total salary by each city
		Map<String, Integer> sum = emplist.stream()
										.collect(Collectors.groupingBy(
												emp -> emp.getCity(),
												Collectors.summingInt(emp -> emp.getSalary())
												)
												);
		
		//avg salary in each city
		Map<String, Double> avg = emplist.stream()
										.collect(Collectors.groupingBy(
												emp -> emp.getCity(),
												Collectors.averagingDouble(emp -> emp.getSalary())
												)
												);
		
		System.out.println("no of employee in each city: " + counting);
		System.out.println("Total salary in each city: " + sum);
		System.out.println("avg salary in each city: " + avg);
		
		//employees in each salary
		Map<Integer, List<Employee>> salary = emplist.stream()
													.collect(Collectors.groupingBy(emp -> emp.getSalary()));
		
		System.out.println("-----Employee in each salary -----");
		salary.forEach((k,v) -> {
			System.out.println("Salary : " + k );
			v.forEach(emp -> {
				System.out.printf("\t %s(%s)\n",emp.getName(),emp.getCity() );
			});
		});
		
		//employee names in each city
		Map<String, List<String>> names = emplist.stream()
												.collect(Collectors.groupingBy(
														emp -> emp.getCity(), //key
														Collectors.mapping(
																emp -> emp.getName(), //obj -> string
																Collectors.toList()) 
														));
		System.out.println("-----Employee names in each city-----");
		names.forEach((k,v)-> {
			System.out.println(k);
			System.out.println("\t" + v);
			System.out.println("------------");
		});
		
		//employees who stay in the same city
		Map<String, List<Employee>> employees = emplist.stream()
													.collect(
															Collectors.collectingAndThen(Collectors.groupingBy(emp -> emp.getCity()),
																	map -> map.entrySet() //Map<City, list<Employee>>
																			.stream()
																			.filter(value -> value.getValue().size()>1)
																			.collect(Collectors.toMap(
																					value -> value.getKey(), //city(key)
																					value -> value.getValue() //List<emp>(value)
																					)
																					)
																	)
															);
		System.out.println("-----employee who stay in the same city----");
		employees.forEach((k,v)->{
			System.out.println(k);
			v.forEach(obj->{
				System.out.println("\t" + obj.getName());
			});
		});
	}
}
