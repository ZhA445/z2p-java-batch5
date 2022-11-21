package day19;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reading_2 {

	public static void main(String[] args) {
		Path path = Path.of("src/employee1.txt");
		
		try(BufferedReader reader = Files.newBufferedReader(path)){
			String line = null;
			while((line = reader.readLine())!= null) {
				System.out.println(line);
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
