package Day10_inheritance;

public class Student extends Person{

	private int rno;
	
	public Student() {
		System.out.println("Student's default constructor");
	}
	
	public Student(int rno , String name, String phone) {
		super(name,phone);
		this.rno = rno;
		System.out.println("Student's argument constructor");
	}
	
	public int getRno() {
		return rno;
	}
	
}
