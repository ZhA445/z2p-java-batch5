package day7_assigement;

import java.util.Scanner;

public class assigement3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your NRCNO: ");
		String nrc = sc.nextLine();
		
		if(nrc.contains("/")) {
			int start = nrc.indexOf("/");
			int end = nrc.lastIndexOf("(");
			
			String town = nrc.substring(start+1, end);
			System.out.println("Township: "+town);
			
			int start1 = nrc.indexOf(")");
			String tmp = nrc.substring(start1+1, start1+7);
			System.out.println("Number: " +tmp);
		}
	}
}
