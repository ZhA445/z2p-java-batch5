package day12oopassigement;

public class Student {

	private int id;
	private String name;
	private int mark;


	public Student(int id ,String name, int mark) {
		super();
		this.id= id;
		this.name= name;
		this.mark = mark;
	}

	public void display() {
		System.out.print(id +"\t");
		System.out.print(name + "\t");
		System.out.print(mark + "\n");
	}
	
//	public void findById(int id1) {
//		if(id1 == id) {
//			System.out.println("ID \t Name \t mark");
//			display();
//		}
//		else {
//			System.err.println("Student's id " + id1 +" is not found!");
//		}
//	}
	public int findById() {
		return this.id = id;
	}
	
	public int getMark() {
		return this.mark = mark;
	}

}

	

	