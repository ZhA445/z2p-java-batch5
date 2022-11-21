package day17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import day16.Employee;

public class Reduction {

	public static void main(String[] args) {
		List<Employee> emplist = Arrays.asList(
				new Employee("Kyaw Kyaw", 9800, "yangon"),
				new Employee("aung aung", 6000, "mandalay"),
				new Employee("maung maung", 10000, "mandalay"),
				new Employee("yuri", 6000, "yangon"),
				new Employee("Jeon", 6000, "monywa")
				);
		
		// built-in reduction
		
		int totalSalary = emplist.stream()
								.mapToInt(emp -> emp.getSalary())
								.sum();
		
		double avgSalary = emplist.stream()
								.mapToDouble(emp -> emp.getSalary())
								.average()
								.getAsDouble();
		
		int maxSalary = emplist.stream()
								.mapToInt(emp  -> emp.getSalary())
								.max()
								.getAsInt();
		
		long count = emplist.stream()
							.filter(emp -> emp.getSalary() > 6000 )
							.count();
		
		Employee maxEmp = emplist.stream()
								.max(Comparator.comparingInt(emp -> emp.getSalary()))
								.get();
		
		Employee miniEmp = emplist.stream()
								.min((e1,e2) -> e1.getSalary() - e2.getSalary())
								.get();
		
		
		System.out.println("Total Salary : " + totalSalary);
		System.out.println("Average salary: " + avgSalary);
		System.out.println("Maximum salary: " + maxSalary);
		System.out.println("No of employee: " + count);
		System.out.println("Employee who get max salary : " + maxEmp);
		System.out.println("Employee who get min salary : " + miniEmp);
		System.out.println("--------------");
		//custom reduction
		totalSalary = emplist.stream()
							.map(emp -> emp.getSalary())
							.reduce(0, (sal1,sal2) -> sal1 + sal2);
		
		int minSalary = emplist.stream()
								.map(emp -> emp.getSalary())
								.reduce(Integer::min)
								.get();
		
		miniEmp = emplist.stream()
						.reduce((s1,s2) -> s1.getSalary() < s2.getSalary() ? s1 : s2)
						.get();
		
		System.out.println("Total salary : " + totalSalary);
		System.out.println("min value: " + Integer.min(100, 200));
		System.out.println("Min salary:" + minSalary );
		System.out.println("Employee who got min salary: " + miniEmp);
		
	}
}
