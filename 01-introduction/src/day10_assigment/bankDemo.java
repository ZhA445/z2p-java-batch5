package day10_assigment;

import java.awt.Choice;
import java.util.Scanner;

public class bankDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank bank = new Bank(3152, "Zin Htet", 3129, "zhhhh6");
			System.out.println(" 1.Deposit \n 2.Withdraw \n 3.Changepassword \n 4.Info \n Choose the number: ");

			int select = sc.nextInt();
			switch (select) {
			case 1:
				System.out.println("How many want to deposit: ");
				int dep = sc.nextInt();
				bank.deposit(dep);
				break;
			case 2:
				System.out.println("How much you want to withdraw: ");
				int with = sc.nextInt();
				bank.withdraw(with);
				break;
			case 3:
				System.out.println("Enter new password : ");
				String pw = sc.nextLine();
				sc.nextLine();
				bank.changepassword(pw);
				break;
			case 4:
				bank.show();
				break;
			default:
				System.err.println("Invalid input!");
			}
		
	}
}
