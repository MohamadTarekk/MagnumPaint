package paint.controller;

public abstract class FileOperation {
	
	protected MyFile myFile;
	
	public FileOperation(MyFile fileType) {
		
		myFile = fileType;	
	}
}
