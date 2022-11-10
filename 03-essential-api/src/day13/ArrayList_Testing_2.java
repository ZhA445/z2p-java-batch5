package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayList_Testing_2 {

	public static void main(String[] args) {
		
		String[] data = {"Aung Aung", "Kyaw Kyaw","Mg Mg", "Jeon"};
		ArrayList<String> names = new ArrayList<>(Arrays.asList(data));
		
		names.add("Yuki");
		
		System.out.println(names);
		
		//sort
		Collections.sort(names);
		System.out.println("After sorting: " + names);
		
//		Collections.reverse(names);
//		System.out.println("After reverse: " + names);
		
		
		int index = Collections.binarySearch(names, "Aung Aung");
		System.out.println("Index = " + index);
		
		if(names.contains("Jk"))
			System.out.println("Exist");
		
		//remove
		names.remove("Jeon");
		System.out.println("After remove: " + names);
		
		names.removeIf(str -> str.endsWith("ung"));
		System.out.println("After remove: " + names);
		
	}
}
