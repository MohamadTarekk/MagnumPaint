package paint.controller;

import java.util.ArrayList;

import paint.model.Shape;

public class Data {

	/* Singleton IMplementation*/
	private static Data singleInstace = null;
	
	private Data() { 
	}
	
	public static Data getInstance(){
		if (singleInstace == null) 
			singleInstace = new Data();
		return singleInstace;
	}
	/* End of implementation*/
	
	private Drawings DrawingsList = new Drawings();
	
	public void addShape(Shape newShape) {
		DrawingsList.addShape(newShape);;
	}
	
	public void removeShape(Shape theshape) {
		DrawingsList.removeShape(theshape);
	}

	public void replaceShape(Shape oldShape, Shape newShape) {
		DrawingsList.removeShape(oldShape);
		DrawingsList.addShape(newShape);
	}
	
	public Shape selectShape(int x, int y) {
		return DrawingsList.selectShape(x, y);
	}
	
	//Method to get the Shapes list to be used in saving a file
	public ArrayList<Shape> getDrawingsList() {
		return DrawingsList.getShapes();
	}

	public void setDrawingsList(ArrayList<Shape> arr) {
		this.DrawingsList.setShapes(arr);
	}

	public void clearDrawingsList() {
		DrawingsList.clearShapes();
	}
	
	public void restoreDrawingsList(ArrayList<Shape> deleted) {
		DrawingsList.restoreShapes(deleted);
	}
}
