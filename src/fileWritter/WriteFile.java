package fileWritter;


import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import file_reader.ReadFile;

public class WriteFile {

	public void writeAFile(String path) {
		try (FileWriter createFile = new FileWriter(path)) {
			
			String content= "This string will be in the new file created by this program";
			createFile.write(content);
		} catch (IOException err) {
			System.out.println("error");
		}
		new ReadFile().readsFile(path);
	}
	
	public void writeImageFile(String path, byte[] imgByte) {
		try(FileOutputStream newImg= new FileOutputStream(path)){
			newImg.write(imgByte);
		}catch(IOException err) {
			System.out.print("Error while fetching resource");
		}
	}
}
