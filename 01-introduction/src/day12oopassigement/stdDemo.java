package day12oopassigement;

import java.util.Scanner;

public class stdDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many student: ");
		int std = sc.nextInt();
		ClassStudent[] student = new ClassStudent[std];

		for (var i = 0; i < std; i++) {
			System.out.println("Enter Student's id: ");
			int id = sc.nextInt();
			System.out.println("Enter Student's Name: ");
			sc.nextLine();
			String stdname = sc.nextLine();

			System.out.println("Enter Student's mark: ");
			int stdmark = sc.nextInt();
			student[i] = new ClassStudent(id, stdname, stdmark);
		}

		System.out.println("ID \t Name \t Mark");
		System.out.println("-------------------");
		for (var i = 0; i < student.length; i++) {
			student[i].display();
		}

		System.out.println(
				" 1.Student search by id. \n 2.Max mark of student. \n 3.average mark. \n choose the number: ");
		int num = sc.nextInt();

		switch (num) {
		case 1:
			System.out.println("Enter student's id to search: ");
			int id1 = sc.nextInt();

			for (var i = 0; i < student.length; i++) {
				if (id1 == student[i].getStudentId()) {
					System.out.println("ID \t Name \t Mark");
					System.out.println("-------------------");
					student[i].display();
				}
			}
			
//				System.err.println("Student's id- " + id1 + " is not found!");
			
			break;

		case 2:
			int maxMark = student[0].getMark();
			int a = 0;
			for (var j = 0; j < student.length; j++) {
				if (maxMark < student[j].getMark()) {
					maxMark = student[j].getMark();
					a = j;
				}
			}
			System.out.println(student[a].getName() + " get max mark: " + maxMark);
			break;
		case 3:
			int avg = 0;
			for(var i =0; i< student.length; i++) {
				avg += student[i].getMark();
			}
			int avgmark = avg / std;
			System.out.println("All students get " + avgmark + " average marks.");
			break;
		default:
			break;
		}

	}
}
