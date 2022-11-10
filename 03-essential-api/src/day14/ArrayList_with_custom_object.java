package day14;

import java.util.ArrayList;
import java.util.List;

class Phone{
	String name;
	int price;
	public Phone(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
}

public class ArrayList_with_custom_object {

	public static void main(String[] args) {
		
		List<Phone> list = new ArrayList<>();
		
		var obj1 = new Phone("samsaung", 200000);
		
		list.add(obj1);
		list.add(new Phone("iphone", 3000000));
		list.add(new Phone("Vivo", 1900000));
		list.add(new Phone("Mi", 3000000));
		
		Phone obj2 = list.get(0);
		System.out.println("Name: " + obj2.name);
		System.out.println("Price:" + obj2.price);
		
		//display all
		list.forEach(obj -> {
			System.out.println("Name: " + obj.name);
			System.out.println("Price: " + obj.price + " ks.");
		});
		
	}
}
