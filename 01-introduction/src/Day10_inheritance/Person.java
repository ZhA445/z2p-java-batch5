package Day10_inheritance;

public class Person {

	private String name;
	private String phone;
	
	public Person() {
		System.out.println("Person's default constructor");
	}
	
	public Person(String name, String phone) {
		System.out.println("Person's argument constructor");
		this.name = name;
		this.phone = phone;
	}
	
	void display() {
		System.out.println("Name _ : " + name);
		System.out.println("Phone _ : " + phone );
	}
	
}
