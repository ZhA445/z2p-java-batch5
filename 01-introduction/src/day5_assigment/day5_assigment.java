package day5_assigment;

import java.util.Scanner;

public class day5_assigment {

	public static void main(String[] args) {
		String[] brand = {
			"lenovo" , "hp" , "samsaung","acer" , "dell" , "asus"
		};
		
		String[] cpu = {
				"corei3" , "corei5" , "corei7" , "corei9"
		};
		
		double[][] prices = {
				{230.21,400.21,294.25,693.33,340.44,691.99},
				{529.483,920.483,676.66,1594.66,783.012,1591.57},
				{552.504,96.504,706.08,1663.99,817.056,1660.776},
				{690.63,12.63,882.6,2079.99,1021.32,2075.97}
		};
		for(var i = 0; i<6; i++) {
			System.out.print("\t \t" + brand[i] + "\t" );
		}
		System.out.println("\n");
		for(var i = 0; i<4 ; i++) {
			System.out.print(cpu[i] + "\t");
			for(var a= 0; a<6;a++) {
				System.out.print("\t"+prices[i][a] + "\t");

			}
			System.out.println("\n");
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose brand: ");
		String brand1 = sc.nextLine();
		for(var i = 0; i<6; i++) {
			if(brand1.equalsIgnoreCase(brand[i])) {
				System.out.println("Enter cpu: ");
				String cpu1 = sc.nextLine();
				for(var a = 0 ; a<4; a++) {
					if(cpu1.equalsIgnoreCase(cpu[a])) {
						System.out.println("Enter currencies range: ");
						int amount = sc.nextInt();
						System.out.println(prices[a][i] * amount + " Ks.");
						break;
					}
				}
			}
		}
//		if(brand1.equalsIgnoreCase("lenovo")) {
//			System.out.println("Enter cpu: ");
//			String cpu1 = sc.nextLine();
//			if(cpu1.equalsIgnoreCase(cpu[])) {
//				System.out.println(prices[0][0]);
//			}
//		}
		
		
	}
}
