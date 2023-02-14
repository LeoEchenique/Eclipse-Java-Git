package file_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public void readsFile(String path) {
		try (FileReader tbRead = new FileReader(path)) {

			BufferedReader buff = new BufferedReader(tbRead);
			// this stream needs to be closed, but in java7 came a new feature made it in
			// the line above, it's a "Try with resources"
			// the instance is created inside the try statement, and it will be
			// automatically closed at the end of the block,
			// regardless of whether an exception occurs or not. This simplifies the code
			// and helps prevent resource leaks.
			String line="";
			while (line != null) {
				line = buff.readLine();
				if(line != null) System.out.println(line);
				
			}
		} catch (IOException e) {
			System.out.println("error");
		}
	}

}
