package day12_oopassigement_4;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("To calculate Area and Volume define a number: ");
//		int av = sc.nextInt();
//		Shape cube = new Cube(av);
		Shape[] shape = new Shape[2];
		
		shape[0] = new Cube(5);
		shape[1] = new Circle(7);
		
		for (var i  = 0 ; i < shape.length ; i++) {
			if(i == 0) {
				System.out.println("Area of Cube : " + shape[i].Area());
				System.out.println("Volume of Cube : " + shape[i].Volume());
			}
			else {
				System.out.println("Area of Circle : " + shape[i].Area());
			}
		}
	}
}
