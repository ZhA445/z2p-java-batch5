package day9;


public class Employee {
	static int noOfEmployee = 3;
	static int nextId = 1;
	String name;
	int salary;
	
	final int empId;
	
	public Employee() throws AppException{
		if(nextId > noOfEmployee) {
			throw new AppException("Sorry! Limited number has been reached");
		}
		empId = nextId;
		nextId++;
	}
	
	public void init(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public void changeData(String newName, int newSalary) {
		if(!this.name.equalsIgnoreCase(newName))
			this.name = newName;
		if(this.salary != newSalary)
			this.salary = newSalary;
	}
	
	public void showData() {
		//System.out.println(this.empId + "\t" + this.name + "\t" + this.salary);
		System.out.format("%d \t %s \t %d\n" , this.empId,this.name,this.salary);
	}
	
	public static void changeNoOfEmployee(int count) { //count = 5
		//this.name = "aung"
		//super();
		noOfEmployee = count;
		//salary = 1000;
	}	
	
	public void viewInfo() {
		System.out.println("Total emp : " + noOfEmployee);//access static data
		System.out.println("-----Current Employee-----");
		this.showData();
		System.out.println("Next emp' id: " +  nextId);
	}
}
