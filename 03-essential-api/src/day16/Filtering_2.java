package day16;

import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Filtering_2 {

	public static void main(String[] args) {
		//create stream
		
		Stream<Integer> stream = Stream.iterate(1,i -> i + 1)
								.limit(15);
		
		Predicate<Integer> evens = value -> value % 2 == 0;
		stream.filter(num -> num >= 2 && num <= 10)
				//.filter(num -> num%2 == 0)
				.filter(evens)
				.forEach(System.out::println);
		
	}	
}
