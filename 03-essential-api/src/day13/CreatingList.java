package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatingList {

	public static void main(String[] args) {
		
		//create 1 (empty / not modified)
		List<String> list1 = List.of();
		
//		list1.add("juice");
		
		//create 1
		List<String> list2 =  List.of("Juice" , "Coffee");
		
		Integer[] arr = {100 , 200 };
		
		//way 3(from existing data, not modified)
		List<Integer> list3 = Arrays.asList(arr);
		
		//list3.add(300);
		
		//way 4(empty / modified)
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(300);
		
		//way5 (from existing data, modified)
		List<Integer> list5 = new ArrayList<>(Arrays.asList(arr));
		list5.add(500);
		System.out.println(list5);
	}
}
