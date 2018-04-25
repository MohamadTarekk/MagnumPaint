package paint.controller;

import java.util.ArrayList;

import paint.model.Shape;

public class JSON implements Save {

	Data data = Data.getInstance();

	@Override
	public boolean checkFile(String filePath) {

		return false;
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
