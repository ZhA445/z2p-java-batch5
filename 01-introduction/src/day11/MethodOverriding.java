package day11;

public class MethodOverriding {

	public static void main(String[] args) {
		Teacher teacher = new Teacher("U Kyaw", "Tutor");
		
		teacher.showInfo();
		
		Person person = new Person("U Aung");
		person.showInfo();
		
		Person person2 = new Teacher("Jeon", "lecturer");
		person2.showInfo();
	}
}
