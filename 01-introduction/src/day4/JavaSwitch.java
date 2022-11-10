package day4;

import java.util.Scanner;

public class JavaSwitch {
	public static void main(String[] args) {
		
		//switch_statement();
		//multipleValuePerCase();
		//switchExpression();
		switchExpressWithMultipleStatements();
	}

	private static void switchExpressWithMultipleStatements() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Food Name: ");
		String name = sc.nextLine();
		String category = switch(name){
			
		case "burger","pizza","sand wish" -> {
			if(name.equalsIgnoreCase("pizza"))
				System.out.println(name + "is a Italian food.");
			yield "Fast Food";	
		}
		case "yogurt","mile tea"-> {
			yield "Dessert";
		}
		case "monhinga" -> "Burmese Food";
		case "sushi" -> "Japanese Food";
		default -> "unknown";
		};
		System.out.println(name + " is " + category);
		sc.close();
		
	}

	private static void switchExpression() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter food name: ");
		
		String name = sc.nextLine();
		String category = switch(name) {
			case "burger","pizza","sandwish"->"Fast Food";
			case "yogurt","milk tea" -> "Dessert";
			 case "monhinga"->"Burmese Food";
			case "sushi"->"Japanaes Food";
			default -> "unknown";
		
		};
		System.out.println(name +" is " + category);
		sc.close();

		
	}

	private static void multipleValuePerCase() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter food name: ");
		
		String name = sc.nextLine();
		String category;
		
		switch(name) {
		case "burger","pizze","sandwish":
			category = "Fast Food";
			break;
		case"yogurt","milk tea":
			category = "Dessert";
			break;
		case "monhinga":
			category = "Burmase Food";
			break;
		case "sushi":
			category= "Japanese Food";
			break;
		default:
			category= "unknown";
		
		}
		System.out.println(name +" is " + category);
		sc.close();
		
	}

	private static void switch_statement() {
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter food name: ");
		
		String name = sc.nextLine();
		String category;
		
		switch(name) {
		case "burger":
			category = "Fast Food";
			break;
		case "pizza":
			category = "Fast Food";
			break;
		case"sandwish":
			category  = "Fast Food";
			break;
		case"yogurt":
			category = "Dessert";
			break;
		case "milk tea":
			category="Dessert";
			break;
		case "monhinga":
			category = "Burmase Food";
			break;
		case "sushi":
			category= "Japanese Food";
			break;
		default:
			category= "unknown";
		
		}
		System.out.println(name +" is " + category);
		sc.close();
		
	}
	
	
}
