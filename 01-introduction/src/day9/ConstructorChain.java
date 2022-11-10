package day9;


public class ConstructorChain {

	public ConstructorChain() {
		this(100);
		System.out.println("This is default constructor");
	}
	public ConstructorChain(int i) {
		this(i , 200);
		System.out.println("This is 2 args constructor");
	}
	public ConstructorChain(int i,int j) {
		System.out.println("i = " + i + " j = " + j);
		
	}
	
	public static void main(String[] args) {
		ConstructorChain obj = new ConstructorChain();
		
		//Teacher techer = new Teacher("Aung", "mid");
	}
}

class Person{
	String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	class Teacher extends Person{
		String position;
		
		public Teacher(String name, String pos) {
			super(name);
			this.position = pos;
		}
	}
}
