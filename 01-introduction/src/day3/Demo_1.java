package day3;

public class Demo_1 {
	public static void main(String[] args) {
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Employee.changeCompanyName("Myanmar It Consulting");
		
		emp1.empNo = 1001;
		emp1.name = "Kyaw Kyaw";
		
		emp2.empNo = 1002;
		emp2.name = "Aung Aung";
		
		System.out.println("----emp1' data----");
		emp1.display();//accessing instance method
		Employee.displayCompanyName();//accessing static method
		System.out.println("..............");
		System.out.println("----emp2' data----");
		emp2.display();
		Employee.displayCompanyName();
		
	}
}
