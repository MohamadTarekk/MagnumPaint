package paint.controller;

public class SaveFile extends FileOperation {
	
	public SaveFile(MyFile fileType, String filePath) {
		
		super(fileType);
		myFile.save(filePath);
	}
}
