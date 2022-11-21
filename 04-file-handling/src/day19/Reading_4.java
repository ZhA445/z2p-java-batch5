package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Reading_4 {

	public static void main(String[] args) throws IOException {
		
		//readAllBytes();
			//readString();
		readWithBufferReader();
	}

	private static void readWithBufferReader() {
		Path path = Path.of("src/employee1.txt");
		try(BufferedReader reader = Files.newBufferedReader(path)){
			List<String> list = reader.lines()
										.filter(line -> line.contains("aung"))
										.toList();
			System.out.println(list);
		}
		catch (Exception e) {
			e.printStackTrace();	}
	}

	private static void readString() throws IOException {
		Path path = Path.of("src/employee.txt");
		
		String data = Files.readString(path);
		System.out.println("output => " + data);
	}

	private static void readAllBytes() throws IOException {
Path path = Path.of("src/employee.txt");
		
		byte[] byteArr = Files.readAllBytes(path);
		
		for(var value: byteArr) {
			//String tmp = String.valueOf(value);
			System.out.println(value);
		}
		
		System.out.println("data => " + new String(byteArr));

		
	}
}
