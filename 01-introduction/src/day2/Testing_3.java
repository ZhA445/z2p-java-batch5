package day2;

import java.util.Scanner;

public class Testing_3 {
	static final int MIN_PRICE=1000;
	static final float RATE = 1.5f;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter price: ");
		int price = sc.nextInt();
		if(price< MIN_PRICE) {
			price = MIN_PRICE;
		}
		System.out.println("Price = " +price);
		System.out.println("Expense = " + price * RATE);
//		System.out.println("Zin Htet Aung");
	}
}

