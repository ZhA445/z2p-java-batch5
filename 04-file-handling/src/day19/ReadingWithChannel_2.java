package day19;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ReadingWithChannel_2 {

	public static void main(String[] args) {
		Path path = Path.of("src/employee.txt");
		
		try(FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)){
			int size = 50;
			
			if(channel.size()<size)
				size = (int) channel.size();
			
			//create buffer
			ByteBuffer buffer = ByteBuffer.allocate(size);
			
			while(channel.read(buffer)>0) {
				buffer.flip();
				String data = new String(buffer.array(),0,buffer.limit());
				
				System.out.println("data => " + data);
				
				buffer.clear();
			}
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
	}
}
