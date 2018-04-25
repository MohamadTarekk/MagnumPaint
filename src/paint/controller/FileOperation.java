package paint.controller;

public abstract class FileOperation {
	
	protected MyFile myFile;
	protected String filePath;
	
	public FileOperation(MyFile fileType, String myFilePath) {
		
		myFile = fileType;	
		filePath = myFilePath;
	}
	
}
