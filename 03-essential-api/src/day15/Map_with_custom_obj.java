package day15;

import java.util.HashMap;
import java.util.Map;

class Employee{
	private int empId;
	private String name;
	private String city;
	public Employee(int empId, String name, String city) {
		super();
		this.empId = empId;
		this.name = name;
		this.city = city;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", city=" + city + "]";
	}
	
	
}
public class Map_with_custom_obj {

	public static void main(String[] args) {
		Map<Integer, Employee> employees = new HashMap<>();
		
		var emp1 = new Employee(1001, "Aung Aung", "Yangon");
		employees.put(emp1.getEmpId(), emp1);
		employees.put(1002, new Employee(1002, "Kyaw Kyaw", "Mandalay"));
		employees.put(1003, new Employee(1003, "Maung Maung", "Mandalay"));
		employees.put(1004, new Employee(1004, "Jeon", "Pwin Oo Lwin"));
		
		employees.forEach((k,v) -> {
			System.out.println("Id: " + k);
			System.out.println("Name: " + v.getName());
			System.out.println("City: " + v.getCity());
			System.out.println("-----------------");
		});
	Employee emp2 =	employees.get(1003);
		System.out.println(emp2);
		
		System.out.println("------Employees who live in Mandalay------");
		employees.forEach((id, obj)->{
			if(obj.getCity().equalsIgnoreCase("mandalay"))
			System.out.println(obj);
		});
		
	}
}
