package day13;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_Testing {

	public static void main(String[] args) {
		
		//create 
		ArrayList<Integer> list = new ArrayList<>();
		
		//add
		list.add(1000);
		list.add(2000);
		list.add(0, 3000);
		
		//output
		System.out.println("list[0] : " + list.get(0));
		System.out.println("data: " + list);
		
		//update
		list.set(2, 5000);
		System.out.println("after update: " + list);
		
		//remove
		list.remove(1);
		System.out.println("after remove: " + list);
		
		System.out.println("max value: " + Collections.max(list) );
		
		//remove all
		list.clear();
		System.out.println("size: " + list.size());
		
		System.out.println("-----all data-----");
//		for(var i=0;i< list.size(); i++)
//			System.out.println(list.get(i));
//		
//		var i = 0;
//		while(i < list.size())
//		{
//			System.out.println(list.get(i));
//			i++;
//		}
		for(Integer data: list) {
			System.out.println(data);
		}
	}
}
