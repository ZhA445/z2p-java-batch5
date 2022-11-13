package day6_assigement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		String[] town = { "Yankin", "Tarmwe", "San Chaung", "PazonTaung" };
		int[] time = { 5, 10, 20, 50 };
		String[] food = { "Pizza", "Burger", "Milk Tea", "Spicy Noodle" };
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Available Menu-----");
		for (var i = 0; i < food.length; i++) {
			System.out.print(i + 1 + ". " + food[i] + "\n");
		}
		System.out.print("Please choose item:  ");
		int menu = sc.nextInt();

		if (menu == 1) {
			System.out.println("-----Delivary Township-----");
			for (var i = 0; i < town.length; i++) {
				System.out.print(i + 1 + ". " + town[i] + "\t(" + time[i] + "min)" + "\n");
			}
			System.out.print("Please choose Township: ");
			int township = sc.nextInt();
			if (township == 1) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1]).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else {
					System.err.println("Invalid!");
				}
				
			} else if (township == 2) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
			} else if (township == 3) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
			} else if (township == 4) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
			} else {
				System.err.println("Invalid Township!");
			}
		} else if (menu == 2) {
			System.out.println("-----Delivary Township-----");
			for (var i = 0; i < town.length; i++) {
				System.out.print(i + 1 + ". " + town[i] + "\t(" + time[i] + "min)" + "\n");
			}
			System.out.print("Please choose Township: ");
			int township = sc.nextInt();
			if (township == 1) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
				
			} else if (township == 2) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
			} else if (township == 3) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
			} else if (township == 4) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
			} else {
				System.err.println("Invalid Township!");
			}
		} else if (menu == 3) {
			System.out.println("-----Delivary Township-----");
			for (var i = 0; i < town.length; i++) {
				System.out.print(i + 1 + ". " + town[i] + "\t(" + time[i] + "min)" + "\n");
			}
			System.out.print("Please choose Township: ");
			int township = sc.nextInt();
			if (township == 1) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
				
			} else if (township == 2) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
			} else if (township == 3) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
			} else if (township == 4) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
			} else {
				System.err.println("Invalid Township!");
			}
		} else if (menu == 4) {
			System.out.println("-----Delivary Township-----");
			for (var i = 0; i < town.length; i++) {
				System.out.print(i + 1 + ". " + town[i] + "\t(" + time[i] + "min)" + "\n");
			}
			System.out.print("Please choose Township: ");
			int township = sc.nextInt();
			if (township == 1) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
				
			} else if (township == 2) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
			} else if (township == 3) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
			} else if (township == 4) {
				order(sc);
				int ordertype = sc.nextInt();
				if(ordertype == 1) {
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalTime localtime = LocalTime.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						System.out.println("Duration: " + time[township - 1] + " mins");
						break;
					}
					System.out.println("Arrival Time : " + localtime.plusMinutes(time[township - 1])
							.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));

					System.out.println("------- Thank you for your ordering ------");
				}
				else if (ordertype == 2) {
					System.out.println("Enter deliver date day: ");
					int day = sc.nextInt();
					for (var i = 0; i < food.length; i++) {
						System.out.println("Item Name: " + food[menu - 1]);
						break;
					}
					LocalDate localdate = LocalDate.now();
					for (var a = 0; a < town.length; a++) {
						System.out.println("Your Address: " + town[township - 1]);
						break;
					}
					System.out.println("Arrival Date " + localdate.plusDays(day).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

					System.out.println("------- Thank you for your ordering ------");
				}
			} else {
				System.err.println("Invalid Township!");
			}
		} else {
			System.err.println("Invalid menu!");
		}

	}

	private static void order(Scanner sc) {
		System.out.println("-----Order Type-----");
		System.out.print(" 1. Order Now? \n 2. Preorder? \n Please choose: ");
	}
}
