package day10_assigment;

import java.util.Scanner;

public class Bankaccount {

	private int accno;
	private String name;
	private String pin;
	private String password;
	private int balance = 1000000;
	Scanner sc = new Scanner(System.in);

	public Bankaccount(int accno,String name,String pin,String password) {
		this.accno = accno;
		this.name = name;
		this.pin = pin;
		this.password = password;
	}
	
	public void withdaw(int wd) {
		if(wd>balance) {
			System.err.print("Check your balance!");
		}else {
			int amount = balance-wd;
			System.out.println("Your new balance : " + amount);
			
		}
		
	}
	
	public void deposit(int depo) {
		
		this.balance += depo;
		System.out.println("Total amount: " + balance);
	}
	
	public void changepassword(String password1) { //new password 1
		try {
			System.out.println("Enter your old password:");
			String password2 = sc.nextLine();
			if(password2.equals(password)) {
				String password = password1;
				System.out.println("Your password had changed!");
			}
			else {
				System.err.println("Wrong Password! Try Again!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void show(){
		System.out.println("Acc.no: " + accno);
		System.out.println("Name: " + name);
		System.out.println("Pin No: " + pin);
		System.out.println("Password :" + "********");
		System.out.println("Original Balance: " + balance);
		
	}

}

	
