package day10_assigment;

import java.util.Scanner;

public class Demo{


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bankaccount obj = new Bankaccount(123456, "Zin Htet", "2121332","21221");
		
		System.out.println(" 1.Deposit \n 2.Withdraw \n 3.Changepassword \n 4.Info \n Choose the number: " );
		
		int num = sc.nextInt();
		if(num == 1) {
			System.out.print("How many want you to deposit: ");
			int depo = sc.nextInt();
			obj.deposit(depo);
		}
		else if(num == 2) {
			System.out.print("How many want you to withdraw");
			int wd = sc.nextInt();
			obj.withdaw(wd);
		}
		else if(num == 3) {	
			System.out.print("Enter your new password: ");
			String password1 = sc.nextLine();
			sc.nextLine();
			obj.changepassword(password1);
		}
		else if(num == 4) {
			obj.show();
		}
		else {
			System.err.println("Invalid number!");
		}
			
	}
	
}
