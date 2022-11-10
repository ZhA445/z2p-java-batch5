package day8_oop;

public class Phone {
	
	//fields
	String brand; //instance field
	String color;
	int price;
	
	//constructor
	public Phone(String brand, String color) {
		this.brand = brand;
		this.color = color;
		System.out.println("This is arg constructor");
		//this.price = price;
	}
	
	public Phone() {
		System.out.println("This is default constructor");
	}
	//methods
	public void call() {
		System.out.println("Calling processing at here!");
	}
	
	public void takeCamera() {
		System.out.println("Taking photo at here");
	}
	
	{
		System.out.println("This is instance block");
		if(brand.equals("mi")) 
			price = 100;
		else if(brand.equals("samsaung"))
			price = 200;	
	}
	
	static {
		System.out.println("This is static block");
	}
}
