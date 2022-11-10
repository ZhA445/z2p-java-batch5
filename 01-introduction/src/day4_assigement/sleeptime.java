package day4_assigement;

import java.time.LocalTime;
import java.util.Scanner;

public class sleeptime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Time type: hh:mm");
		System.out.print("Enter your go bed time: ");
		LocalTime gobed = LocalTime.parse(sc.nextLine());
		
		System.out.println("Enter your get up time: ");
		LocalTime getup = LocalTime.parse(sc.nextLine());
		
		int gobed1 = gobed.getHour();
		int getup1 = getup.getHour();
		
		int sleeptime = 0;
		if(gobed1<= 12) {
			if(gobed1<6) {
				for(var a = 0; a <6 - gobed1; a++) {
					sleeptime +=0;
					break;
				}
			}
			else if(gobed1>=6) {
				for(var i = 0; i< 12-gobed1 ; i++) {
					sleeptime += 1;
				}
			}
		}
		if(getup1 <= 12) {
			if(gobed1>=6) {
				for(var i = 0; i< getup1 ; i++) {
					sleeptime += 1;
				}
			}
			else if(gobed1<6) {
				for(var i = 0; i<getup1- gobed1; i++) {
					sleeptime +=1;
				}
			}
		}	
		System.out.println("Your sleeptime is : " + sleeptime +"hr");
		
		if(sleeptime<7) {
			System.out.println("You are vary hardworking!");
		}
		else if(sleeptime>= 8) {
			if(sleeptime<=12) {
				System.out.println("Yor are abnormal!");
			}
			else {
				System.out.println("You are so lazy!");
			}
		}
		
	}
}

//Scanner sc = new Scanner(System.in);
//System.out.println("Time type: hh:mm");
//System.out.print("Enter your go bed time: ");
//LocalTime gobed = LocalTime.parse(sc.nextLine());
//
//System.out.println("Enter your get up time: ");
//LocalTime getup = LocalTime.parse(sc.nextLine());
//
//long sleeptime = Duration.between(gobed, getup).getSeconds();
//long sleeptimem = sleeptime/60;
//long sleeptimeh = sleeptimem /60;
//System.out.println(sleeptimeh);

//LocalTime gobed = LocalTime..parse(sc.nextLine());
//System.out.println("Enter your get up time: ");
//LocalTime getup = LocalTime.parse(sc.nextLine());
//	
//long gobed1 = Duration.between(gobed, getup).getSeconds();
//System.out.println(gobed1);
