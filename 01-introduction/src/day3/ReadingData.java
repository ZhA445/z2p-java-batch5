package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadingData {
	public static void main(String[] args) throws IOException {
		
		//create 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//operate
		System.out.println("Enter name: ");
		String name = br.readLine();
		System.out.println("Enter salary: ");
		double salary = Double.parseDouble(br.readLine());
		System.out.println("Enter age: ");
		int age = Integer.parseInt(br.readLine());
		
		System.out.println("----Profile----");
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);
		System.out.println("Age: " + age);
		
		  
		//close
		br.close();
	}
}
