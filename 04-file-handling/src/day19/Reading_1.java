package day19;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reading_1 {

	public static void main(String[] args) {
		
		//define location
		Path path = Path.of("src/employee1.txt");
		
		//process
		try(Stream<String> lines = Files.lines(path)) {
			List<String> names = lines.filter(str -> str.contains("aung"))
									.collect(Collectors.toList());
			System.out.println(names);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//close
		
		
	}
}
