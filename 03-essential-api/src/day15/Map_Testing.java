package day15;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map_Testing {

	public static void main(String[] args) {
		//create
		Map<String, String> foods = new HashMap<>();
		
		//add
		foods.put("orange", "fruit");
		foods.put("grape", "fruit");
		
		//create immutable map obj
		var anotherFood2 = Map.of("mango", "fruit", "potato", "vegatable");
		foods.putAll(anotherFood2);
		
		foods.forEach((k,v)->{
			System.out.println(k+" => " +v);
		});
		
		var anotherFood3 = Map.ofEntries(
				Map.entry("coffee", "juice"),
				Map.entry("Lemon", "juice")
				);
		foods.putAll(anotherFood3);
		
		foods.putIfAbsent("kiwi", "juice");
		System.out.println("After add, foods: " + foods);
		System.out.println("value of kiwi: " + foods.get("kiwi"));
		System.out.println("contains 'coffee' Key? " + foods.containsKey("coffee"));
		System.out.println("contains 'coffee' value?" + foods.containsValue("coffee"));
		
		//only keys
		Set<String> keys = foods.keySet();
		System.out.println("keys: " + keys);
		
		//only values
		Collection<String> values = foods.values();
		System.out.println("values: " + values);
		
		//remove
		
		//update
		
	}
	
}
