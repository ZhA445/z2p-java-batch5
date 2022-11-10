package day12oopassigement;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Student: ");
		int all = sc.nextInt();
		Student[] stud = new Student[all];

		for (var i = 0; i < all; i++) {
			System.out.println("Enter student id: ");
			int id = sc.nextInt();
			System.out.println("Enter student name: ");
			String name = sc.nextLine();
			sc.nextLine();
			System.out.println("Enter student's mark: ");
			int mark = sc.nextInt();
			stud[i] = new Student(id, name, mark);
		}

		System.out.println("ID \t Name \t Marks");
		System.out.println("-------------------");
		for (var i = 0; i < stud.length; i++) {
			stud[i].display();
		}

		System.out.println(
				" 1.Student search by id. \n 2.Max mark of student. \n 3.average mark. \n choose the number: ");
		int num = sc.nextInt();
		if (num == 1) {
			System.out.println("Enter student's id to search: ");
			int id1 = sc.nextInt();

			for (var i = 0; i < stud.length; i++) {
				if (id1 == stud[i].findById()) {
					stud[i].display();
					break;
				}
			}
			
			

		} else if (num == 2) {
			int maxMark = stud[0].getMark();
			for (var i = 1; i < stud.length; i++) {
				if (maxMark < stud[i].getMark()) {
					maxMark = stud[i].getMark();
				}
				System.out.println("Max mark: " + maxMark);
			}

		} else if (num == 3) {
			int avgMark = 0;
			for (var i = 0; i < stud.length; i++) {
				avgMark += stud[i].getMark();
			}
			int avgMark1 = avgMark / all;
			System.out.println("All student of average mark: " + avgMark1 + "marks");
		} else {
			System.err.print("Invalid number!");
		}
	}

	private static void Exception() {
		// TODO Auto-generated method stub

	}
}
