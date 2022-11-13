package day15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSet_Testing {

	public static void main(String[] args) {

//		hashset();
//		linkhashset();
		treeset();
	}

	private static void treeset() {
		// create
		TreeSet<String> set1 = new TreeSet<>();

		// add
		set1.add("Orange");
		set1.add("Apple");
		//set1.add(null); // treeset can't access null value // error
		set1.add("Mango");
		set1.add("Strawberry");
		System.out.println("set1: " + set1);

		// remove
		set1.remove("Mango");
		System.out.println("After remove: set1:" + set1);

		// create immutable set obj
		Set<String> set2 = Set.of("Banana", "Pipeapple");

		set1.addAll(set2);
		System.out.println("After add, set1: " + set1);

		Iterator<String> it = set1.iterator();
		it.forEachRemaining(s -> System.out.println(s));

		Set<String> set3 = set1.descendingSet();
		System.out.println(set3);
	}

	private static void linkhashset() {
		// create
		LinkedHashSet<String> set1 = new LinkedHashSet<>();
		// add
		set1.add("Orange");
		set1.add("Apple");
		set1.add(null);
		set1.add("Mango");
		set1.add("Strawberry");
		System.out.println("set1: " + set1);

		// remove
		set1.remove("Mango");
		System.out.println("After remove: set1:" + set1);

		// create immutable set obj
		Set<String> set2 = Set.of("Banana", "Pipeapple");

		set1.addAll(set2);
		System.out.println("After add, set1: " + set1);

		set1.add("Orange");
		System.out.println(set1);

	}

	private static void hashset() {
		// create mutable set obj
		HashSet<String> set1 = new HashSet<>();

		// add
		set1.add("Orange");
		set1.add("Apple");
		set1.add(null);
		set1.add("Mango");
		set1.add("Strawberry");
		System.out.println("set1: " + set1);

		// remove
		set1.remove("Mango");
		System.out.println("After remove: set1:" + set1);

		// create immutable set obj
		Set<String> set2 = Set.of("Banana", "Pipeapple");

		set1.addAll(set2);
		System.out.println("After add, set1: " + set1);

		set1.add("Orange");
		System.out.println(set1);

	}
}
