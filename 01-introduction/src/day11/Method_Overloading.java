package day11;

import java.util.Arrays;

public class Method_Overloading {

	public static void main(String[] args) {
		 
		System.out.println("100+200 = " + Addition.add(100, 200));
		System.out.println("2.3 + 5.3 = " + Addition.add(2.3f, 5.3f));
		System.out.println("Java + Programming = " + Addition.add("Java ", "Programming"));
		
		int[] arr = new int[] {100,200,300};
		//System.out.println("Sum of [100+200+300] = " + Addition.add(new int[] {100,200,300}));
		System.out.println("Sum of [100,200,300] = " + Addition.add(arr));
	}
}

//concrete class

class Addition{
	static int add(int a, int b) {
		return(a+b);
	}
	
	static float add(float a,float b) {
		return(a+b);
	}
	
	static String add (String a , String b) {
		return(a+b);
	}
	
	static int add(int[] input) {
		return Arrays.stream(input).sum();
	}
}