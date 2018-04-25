package paint.controller;

public class SaveFile extends FileOperation {
	
	public SaveFile(PaintController currentController, MyFile myFileType, String myFilePath) {
		super(myFileType, myFilePath);
		myFile.save(currentController);
	}
}
