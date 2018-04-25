package paint.controller;

public class LoadFile extends FileOperation{
	
	public LoadFile(PaintController currentController, MyFile myFileType, String myFilePath) {
		super(myFileType, myFilePath);
		myFile.load(currentController);
	}
}
