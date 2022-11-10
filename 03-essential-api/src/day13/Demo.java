package day13;

public class Demo {

	public static void main(String[] args) {
		
		//no using lambda expression
		Operation add = new Addition();
		Operation div = new Division();
		
		Operation sub = new Operation() {
			
			@Override
			public int calculate(int num1, int num2) {
				return num1 - num2;
			}
		};
		System.out.println("100+200 = " + add.calculate(100, 200));
		System.out.println("1000/200 = " + div.calculate(1000, 200));
		System.out.println("1000 - 200= " + sub.calculate(1000, 200));
		
		
		//using lambda expression
		System.out.println("--------------------");
		
		Operation add_1 = (a,b) -> a + b;
		Operation div_1 = (num1,num2) -> num1 / num2;
		Operation sub_1 = (a,b) -> a - b;
		Operation mod = (i,j) -> i % j;
		
		System.out.println("100 + 200 = " + add_1.calculate(100, 200));
		System.out.println("100 / 200 = " + div_1.calculate(100, 200));
		System.out.println("100 - 200 = " + sub_1.calculate(100, 200));
	}
}
