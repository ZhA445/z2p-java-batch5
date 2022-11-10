package day9;

public class Demo {
	public static void main(String[] args) {
		try {
			//create obj
			Employee emp1 = new Employee();
			var emp2 = new Employee();
			var emp3 = new Employee();
			
			//init data
			emp1.init("Zin", 10000000);
			emp2.init("Htet", 500000);
			emp3.init("Aung", 6000000);
			//show data
			System.out.println("ID \t Name \t Salary");
			System.out.println("-----------------------");
			emp1.showData();
			emp2.showData();
			emp3.showData();
			
			emp3.changeData("Cherry", 10000);
			System.out.println("After change emp1' data");
			emp3.showData();
			
			Employee.changeNoOfEmployee(5);
			
			emp3.viewInfo();
			
			var emp4 = new Employee();
			emp4.showData();
			
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
	}
}
