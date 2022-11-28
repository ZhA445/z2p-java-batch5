package day12_oopassigement_2;

public class Teacher extends Person{

	private String position;
	private String department;
	private int salary;
	
	
	public Teacher(String name, String nrcno, String address, String phone, String position, String department,
			int salary) {
		super(name, nrcno, address, phone);
		this.position = position;
		this.department = department;
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Position - " + position);
		System.out.println("Department - " + department);
		System.out.println("Salary - " + salary);
	}
	
	public void promote(String nePos, int nesal) {
		System.out.println("Positin - " + nePos);
		System.out.println("Department - " + department);
		System.out.println("Salary - " + nesal);
		
	}
	public void depar(String nedep) {
		System.out.println("Position - " + position);
		System.out.println("Department - " + nedep);
		System.out.println("Salary - " + salary);	
	}
	
	
}
