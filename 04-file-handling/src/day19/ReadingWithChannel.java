package day19;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadingWithChannel {

	public static void main(String[] args) {
		try(RandomAccessFile file = new
				RandomAccessFile("src/employee.txt", "r")){
			//get file channel
			FileChannel channel = file.getChannel();
			int file_size = (int) channel.size();
			//create buffer
			ByteBuffer buffer = ByteBuffer.allocate(file_size);
			
			//read
			channel.read(buffer);
			
			//flip
			buffer.flip();
			
			String data = new String(buffer.array(),0,buffer.limit());
			System.out.println(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
