package day12_oopassigement_2;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		try (Scanner sc= new Scanner(System.in)){
			String show = """
					1. For person
					2. For Teacher
					Choose number: 
					""";
			System.out.print(show);
			
			int port = sc.nextInt();
			if(port == 1) {
				System.out.println("Enter Name: " );
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter NRC No. ");
				String nrc = sc.nextLine();
				System.out.println("Enter address: ");
				String addres = sc.nextLine();
				System.out.println("Enter phone: ");
				String ph = sc.nextLine();
				
				Person person = new Person(name, nrc, addres, ph);
				
				person.showInfo();
				
				Person.nrcinfo(nrc);
			}
			else if(port == 2) {
				System.out.println("Enter Name: " );
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter NRC No. ");
				String nrc = sc.nextLine();
				System.out.println("Enter address: ");
				String addres = sc.nextLine();
				System.out.println("Enter phone: ");
				String ph = sc.nextLine();
				System.out.println("Enter position : ");
				String pos = sc.nextLine();
				System.out.println("Enter deparment: ");
				String dep = sc.nextLine();
				System.out.println("Enter salary: ");
				int sal = sc.nextInt();
				
				
				Teacher teacher = new Teacher(name, nrc, addres, ph, pos, dep, sal);
				teacher.showInfo();
				
				String yes = null;
				do {
					String select = """
							1. Update position & salary
							2. Update Department
							Choose Number: 
							""";
					System.out.println(select);
					int sele = sc.nextInt();
					if(sele == 1) {
						System.out.println("Enter your new Position: ");
						String nePos = sc.nextLine();
						sc.nextLine();
						System.out.println("Enter new Salary: ");
						int nesal = sc.nextInt();
						
						teacher.promote(nePos, nesal);
					}
					else if(sele == 2) {
						System.out.println("Enter your department: ");
						sc.nextLine();
						String nedep = sc.nextLine();
						
						teacher.depar(nedep);
					}
					else {
						System.err.println("Invalid Number!");
					}
					System.out.println("If you want to go back press y : ");
					yes = sc.nextLine();
				} while (yes.equals("y"));
			}
			else {
				System.err.println("Invalid number!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
