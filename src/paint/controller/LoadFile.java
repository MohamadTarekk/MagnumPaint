package paint.controller;

public class LoadFile extends FileOperation {
	
	public LoadFile(MyFile fileType, String filePath) {
		super(fileType);
		myFile.load(filePath);
	}
}
