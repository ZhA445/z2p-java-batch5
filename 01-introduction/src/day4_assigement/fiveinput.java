package day4_assigement;

import java.util.Scanner;

public class fiveinput {
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("How many number you want to type: ");
			var num = sc.nextInt();
			//String[] number;
			//number = new String[num];
			int positives =0;
			int negatives =0;
			int zero =0;
			for(var i = 0; i<num ; i++) {
				
				System.out.println("Enter any number");
				
				int num1 = sc.nextInt();
				
				if(num1>0) {
					positives += 1;
				}
				else if(num1<0) {
					negatives +=1;
				}
				else {
					zero+=1;
				}	
			}
			System.out.println("Number of positive: " + positives);
			System.out.println("Number of negative: " + negatives);
			System.out.println("Number of Zero: " + zero);
		}
		 
		
		
		
		
	}
}
		
	