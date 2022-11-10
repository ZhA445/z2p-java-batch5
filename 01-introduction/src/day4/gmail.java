package day4;

import java.util.Scanner;

public class gmail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email");
		String email = sc.nextLine();
		System.out.println("Enter password");
		String pass = sc.nextLine();
		
		if(email.equals("zh@gmail.com")&& pass.equals("zh")) {
			System.out.println("Log in success");
		}else {
			System.out.println("Try again");
		}
		sc.close();
	}
}
