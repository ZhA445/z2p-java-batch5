package day7;

public class JavaError {

		public static void main(String[] args) {
			int num= 100;
			display(num);
		}

		private static void display(int i) {
			System.out.println("Num: " + i);
			display(i);
			
		}
}
