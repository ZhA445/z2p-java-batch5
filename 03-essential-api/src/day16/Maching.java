package day16;

import java.util.List;

public class Maching {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(2,4,6,8,10,11);
		
		boolean result1 = numbers.stream()
				.allMatch(num -> num % 2 == 0);
		boolean result2 = numbers.stream()
				.anyMatch(num -> num % 2 == 0);
		boolean result3 = numbers.stream()
				.noneMatch(num -> num % 2 == 0);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
	}
}
