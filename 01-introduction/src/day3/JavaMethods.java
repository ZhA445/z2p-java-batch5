package day3;

public class JavaMethods {
	
	int num1 = 100; //instance fields
	static int num2 =200;//static fields
	
	static void staticMethod1() {//static method
		//num1 = 300;//can't use(num1is instance data)
		num2 = 300; // ok( num2 is static data)\
		staticMethod2();
		//this.num1 = 300; (this and super can't use)
	}
	
	void instanceMethod1() {//instance method
		System.out.println("This is instance method");
		num1 = 300;
		num2 = 400;
		staticMethod1();
		staticMethod2();
	}
	
	static void staticMethod2() {
		System.out.println("This is static method 2");
	}
	public static void main(String[] args) {
		
	}
}
