package day3;

import java.util.Scanner;

public class ReadData_2 {
	public static void main(String[] args) {
		
		//create stream
		Scanner sc = new Scanner(System.in);
		
		//operate
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter salary:");
		double salary = sc.nextDouble();
		System.out.println("Enter age:");
		int age = sc.nextInt();
		sc.nextLine(); //need it when nextType() is used. 
		System.out.println("Enter bonus: " );
		int bonus = Integer.parseInt(sc.nextLine());
		//int bonus = sc.nextInt();
		System.out.println("---Profile---");
		System.out.println("Name: " +name);
		System.out.println("Salary :  " +salary);
		System.out.println("Age :  " + age);
		System.out.println("Bonus: " + bonus) ;
		//close
		sc.close();
	}
}
