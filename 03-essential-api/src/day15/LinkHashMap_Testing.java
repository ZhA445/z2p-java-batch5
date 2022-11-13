package day15;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class LinkHashMap_Testing {

	public static void main(String[] args) {
		// linkHasMap();
		tree_Map();
	}

	private static void tree_Map() {
		TreeMap<Integer, String> students = new TreeMap<>();

		students.put(1, "Aung Aung");
		students.put(11, "Naung Naung");
		students.put(2, "Kyaw Kyaw");

		System.out.println("students: " + students);
		students.replace(2, "NaNa");
		System.out.println("2 => " + students.get(2));
	}

	private static void linkHasMap() {
		LinkedHashMap<Integer, String> students = new LinkedHashMap<>();

		students.put(1, "Aung Aung");
		students.put(11, "Naung Naung");
		students.put(2, "Kyaw Kyaw");

		System.out.println("students: " + students);
		students.replace(2, "NaNa");
		System.out.println("2 => " + students.get(2));

	}
}
