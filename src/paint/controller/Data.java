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
	private FixedStack<Command> History = new FixedStack<Command>(20);
	private FixedStack<Command> Redo = new FixedStack<Command>(20);
	
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
	
	public void addCommand(Command command) {
		History.push(command);
	}
	
	public Command undo() {
		if (!History.isEmpty())
			return Redo.push(History.pop());
		return null;
	}
	
	public Command redo() {
		if (!Redo.isEmpty())
			return History.push(Redo.pop());
		return null;
	}
	
	public void clearRedo() {
		Redo.removeAllElements();
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
