package paint.controller;

import java.util.ArrayList;

import paint.model.Shape;

public class JSON implements MyFile {

	Data data = Data.getInstance();

	@Override
	public void checkFile(String filePath) {
		
	}

	@Override
	public void createFile(String filePath) {

	}

	@Override
	public void save(String filePath) {
		
		ArrayList<Shape> myList = data.getDrawingsList();
		
		for(Shape s : myList) {
			
		}
	}

	@Override
	public void load(String filePath) {

	}
}
