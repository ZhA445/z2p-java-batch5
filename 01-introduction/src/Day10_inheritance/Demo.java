package Day10_inheritance;

public class Demo {

		public static void main(String[] args) {
			//create obj with argument constructor
			Student obj = new Student(1, "Kyaw Kyaw", "091234567898");
			
			System.out.println("----------------");
			// create obj with default constructor
			Student obj2 = new Student();
			
//			System.out.println("Rno_ : " + obj.getRno());
//			obj.display(); // call parent's method
		}
}
