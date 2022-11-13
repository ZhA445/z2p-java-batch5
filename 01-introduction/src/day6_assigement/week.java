package day6_assigement;

import java.time.LocalDate;

public class week {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		
		if(date.getDayOfWeek().getValue() == 6) {
			System.out.println("Today is my holiday!");
		}
		else if(date.getDayOfWeek().getValue() == 7) {
			System.out.println("Today is my holiday!");
		}
		else {
			System.out.println("I have no time. I am studying programming language!");
		}
	}
}
