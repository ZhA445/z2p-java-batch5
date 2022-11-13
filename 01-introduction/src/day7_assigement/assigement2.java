package day7_assigement;

import java.util.Scanner;

public class assigement2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Write a sentence: ");
		String input = sc.nextLine();
		
		if(input.contains("?")) {
			if(input.contains("do")) {
				System.out.println("This is simple present tense.");
			}
			else if(input.contains("does")) {
				System.out.println("This is simple present tense.");
			}
			else {
				System.out.println("This is a question.");
			}
		}
		else {
			System.out.println("This is a sentence.");
		}
		
	}
}
