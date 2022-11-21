package day10_assigment;

import java.util.Scanner;

public class Bank {

	private int Accno;
	private String holderName;
	private int Pin;
	private String password;
	private int balance = 1000000;
	Scanner sc = new Scanner(System.in);
	public Bank(int accno, String holderName, int pin, String password) {
		super();
		Accno = accno;
		this.holderName = holderName;
		Pin = pin;
		this.password = password;
		
	}
	public int getAccno() {
		return Accno;
	}
	public void setAccno(int accno) {
		Accno = accno;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public int getPin() {
		return Pin;
	}
	public void setPin(int pin) {
		Pin = pin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void deposit(int depo) {
		this.balance += depo;
		System.out.println("Total amount: " + balance + " ks.");
	}
	
	public void withdraw(int wd) {
		if(wd>balance) {
			System.err.println("Check your balance!");
		}
		else {
			System.out.println("Enter pin no. ");
			int pin1 = sc.nextInt();
			if(pin1 != Pin) {
				System.err.println("Invalid Pin No!");
			}
			else {
				int amount = balance - wd;
				System.out.println("Withdraw Success..");
				System.out.println("You have " + amount + " ks");
				balance = amount;
			}
		}
	}
	
	public void changepassword(String pass) {
		System.out.println("Enter your pin no: " );
		int pinno = sc.nextInt();
		if(pinno != Pin) {
			System.err.println("Invalid pin no!");
		}
		else {
			password = pass;
			System.out.println("Success change.");
		}
	}
	public void show() {
		System.out.println("Name: " + holderName);
		System.out.println("Account no. " + Accno);
		System.out.println("Password : " + password);
		System.out.println("Balance : " + balance);
	}
	
}
