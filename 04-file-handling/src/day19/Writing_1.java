package day19;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Writing_1 {

	public static void main(String[] args) throws IOException {

		// write_1();
		//write_2();
		write_3();
	}

	private static void write_3() {
		Path path = Path.of("data/tester1.txt");
		
		try(BufferedWriter writer = Files.newBufferedWriter(path)){
			writer.write("Java Programming");
			writer.write("\nPhp");
			writer.newLine();
			writer.write("Javascript");
			writer.newLine();
			writer.write("Node js");
			System.out.println("Sava data...");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void write_2() throws IOException {
		Path path = Path.of("testing.txt");

		Files.write(path, "Hlaing".getBytes(), StandardOpenOption.CREATE_NEW);
		System.out.println("save data...");

	}

	private static void write_1() throws IOException {
		Path path = Path.of("testing.txt");

		List<String> list = List.of("yangon", "mandalay", "pyin oo lwin");

		// write
		Files.write(path, list);
		Files.write(path, "Insein".getBytes(), StandardOpenOption.APPEND);
		System.out.println("save data...");

	}
}
