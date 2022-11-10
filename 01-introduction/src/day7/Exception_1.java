package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exception_1 {
	
	static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		
		br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name: ");
		var name = br.readLine();
		System.out.println("Enter salary: ");
		var salary = Integer.parseInt(br.readLine());
		
		System.out.println("Name: " + name);
		System.out.println("salary: " + salary);
	}
}
