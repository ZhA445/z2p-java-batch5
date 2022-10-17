package day3;

public class Operators {
	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 200;
		
		System.out.println("100 + 200 = " + (num1 + num2));
		System.out.println("100 == 200? " + (num1==num2));
		System.out.println("100> 50 && 200<300? " +(num1>50 && num2<300));
		
		int result = num1 > num2 ? num2 : num1;
		System.out.println("Result = " + result);
		
		num1 += 20;
		System.out.println("num1 =" + num1);
	}
}
