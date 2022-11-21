package day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Defining_Path {

	public static void main(String[] args) throws IOException {
		
		Path path1 = Path.of("C:\\Users\\zinht\\CPP\\testing.cpp");
		
		System.out.println("exists: "+Files.exists(path1));
		
		Path path2 = Path.of("./src/day18/hello.txt");
		
		System.out.println("exists: " +Files.exists(path2));
		System.out.println("Relative path: " + path2);
		System.out.println("Absolute path: " + path2.toAbsolutePath());
		
		//create file
		if(!Files.exists(path1)) {
			Files.createFile(path1);
			System.out.println("creating file...");
		}
		//create directory
		path1 = Path.of("./testing");
		if(!Files.exists(path1)){
			Files.createDirectories(path1);
			System.out.println("Creating directory...");
		}
		//delete file or directory
		Files.delete(path1);
		System.out.println("delete success");
		
		//delete non-empty folder
		path1 = Path.of("./test");
		
		//delete only files
//		Files.walk(path1) //Stream<Path>
//				.map(p -> p.toFile())
//				.forEach( f -> {
//					System.out.println(f);
//					if(f.isFile()) {
//						System.out.println("f -> " + f.delete());
//					}
//				});
//		
//		//delete foler
//		Files.walk(path1) //Stream<Path>
//		.map(p -> p.toFile())
//		.forEach( f -> {
//				System.out.println("f -> " + f.delete());
//		});
//		Files.delete(path1);
//		System.out.println("deleted...");
//		
		//copy
		Path source = Path.of("./src/day18/hello.txt");
		Path dest = Path.of("./data/hello-another-1.txt");
		
//		Files.copy(source, dest ,StandardCopyOption.REPLACE_EXISTING);
//		System.out.println("copying...");
		
		//move(cut)
		Files.move(source, dest);
		System.out.println("Moving...");
		
	}
}
