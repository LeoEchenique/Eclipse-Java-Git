package file_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader.*;

public class ReadFile {

	
	public void readsFile() {
		try {
			FileReader tbRead= new FileReader("C:/Users/Leo/.eclipse/hello/src/file_reader/JavaNotes.md"); // this stream needs to be closed
			int unicodeChar= tbRead.read();

			while(unicodeChar != -1) {
				
				unicodeChar= tbRead.read();
				char letras= (char) unicodeChar;
				System.out.print(letras);
			}
			
			tbRead.close();
		} catch(IOException e){
			System.out.println("error"); 
		}
	}
	
}
