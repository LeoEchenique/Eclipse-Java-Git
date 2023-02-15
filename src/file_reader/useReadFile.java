package file_reader;

import fileWritter.WriteFile;

public class useReadFile {

	public static void main(String[] args) {

	 //new ReadFile().readsFile("C:/Users/Leo/.eclipse/hello/src/file_reader/JavaNotes.md");
	byte[] imgByte= new ReadFile().readImageFile("C:\\Users\\Leo\\.eclipse\\hello\\src\\crazy.png");
	
	// method to write the resource ([]Byte) in specified path
		new WriteFile().writeImageFile("C:\\Users\\Leo\\.eclipse\\hello\\src\\IMAGENNUEVA.png", imgByte);
		
	}

}
