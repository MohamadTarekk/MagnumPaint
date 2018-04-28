package paint.controller;
 
import java.util.ArrayList;

import paint.model.Rectangle;
import paint.model.Shape;
import paint.view.PaintFrame;
 
public class PaintController implements DrawingEngine {
 
	public Shape currentShape = new Rectangle();
	public Command currentCommand = new Draw();
	private PaintFrame paintFrame = new PaintFrame();
	public CommandInvoker perform = new CommandInvoker(); 
	// private CommandUndo undo = new CommandUndo();
	private boolean drawing = false; // drawing a new shape or editing
	private boolean shapeSelected = false;
	private int mode = 0; // 0: draw, 1: select, 2: resize, 3: move.

	/* first we check for mode
	 * if it's 0, perform a new drawing*/
	
	//ALL THE DRAWING DATA
	private Data data = Data.getInstance();
	private Caretaker caretaker = new Caretaker();
	private Originator originator = new Originator();
	private static int index = -1;
	
	public void start() {
		
		paintFrame.blowUp(this);
 	}
 
	public void setCurrentShape(Shape currentShape) {
		
		this.currentShape = currentShape;
	}

	public void selectShape(int x, int y) {
		
		currentShape = data.selectShape(x, y);
		System.out.println(currentShape.getColor());
		if(currentShape == null)
			shapeSelected = false;
		else
			shapeSelected = true;
	}
	
	public boolean isShapeSelected() {
		
		return shapeSelected;
	}

	public void setShapeSelected(boolean shapeSelected) {
		
		this.shapeSelected = shapeSelected;
	}

	public void setDrawing(boolean nowDrawing) {
		
		drawing = nowDrawing;
	}
	
	public boolean nowDrawing() {
		
		return drawing;
	}
	
	public void setMode(int currentMode) {
		
		mode = currentMode;
	}
	
	public int getMode() {
		
		return mode;
	}
	
	public ArrayList<Shape> getDrawingsList(){
		
		return data.getDrawingsList();
	}
	
	public void setDrawingsList(ArrayList<Shape> shapes) {
		
		data.setDrawingsList(shapes);
	}

	@SuppressWarnings("unchecked")
	public void clearDrawingsList() {
		
		data.clearDrawingsList();
 		ArrayList<Shape> myList = (ArrayList<Shape>) getDrawingsList().clone();
 		System.out.println(myList.size());
		originator.set(myList);
		caretaker.addMemento(originator.storeInMemento(), index++);
	}
	
	public void performCommand(Command currentCommand) {
		
		this.currentCommand = currentCommand;
		data.addCommand(currentCommand);
		perform.go(currentCommand);
	}
	
	@Override
	public void refresh(Object canvas) {
		
		System.out.println(getDrawingsList().size());
		for (int i = getShapes().length-1; i>=0; i--) {
			getShapes()[i].draw(canvas);
			//currentShape.setSelected(true);
		}
		if (drawing) {
			currentShape.draw(canvas);
			/*if (currentShape instanceof Ellipse)
	        	currentShape = new ShapeFactory().getShape("ELLIPSE");
			else if (currentShape instanceof Circle)
				currentShape = new ShapeFactory().getShape("CIRCLE");
			else if (currentShape instanceof Rectangle)
				currentShape = new ShapeFactory().getShape("RECTANGLE");
			else if (currentShape instanceof Square)
				currentShape = new ShapeFactory().getShape("SQUARE");
			else if (currentShape instanceof Triangle)
				currentShape = new ShapeFactory().getShape("TRIANGLE");
			else if (currentShape instanceof Line)
				currentShape = new ShapeFactory().getShape("LINE");*/
		}
		
	}
 
 	@SuppressWarnings("unchecked")
	@Override
 	public void addShape(Shape shape) {
		
 		data.addShape(shape);
 		ArrayList<Shape> myList = (ArrayList<Shape>) getDrawingsList().clone();
 		System.out.println(myList.size());
		originator.set(myList);
		caretaker.addMemento(originator.storeInMemento(), index++);
 	}
 
 	@SuppressWarnings("unchecked")
	@Override
 	public void removeShape(Shape shape) {
 		
		data.removeShape(shape);
 		ArrayList<Shape> myList = (ArrayList<Shape>) getDrawingsList().clone();
 		System.out.println(myList.size());
		originator.set(myList);
		caretaker.addMemento(originator.storeInMemento(), index++);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		
		data.replaceShape(oldShape, newShape);
 		ArrayList<Shape> myList = (ArrayList<Shape>) getDrawingsList().clone();
 		System.out.println(myList.size());
		originator.set(myList);
		caretaker.addMemento(originator.storeInMemento(), index++);
	}

 	@Override
 	public Shape[] getShapes() {
		
		Shape[] array = new Shape[data.getDrawingsList().size()];
		data.getDrawingsList().toArray(array); // fill the array
		return array;
 	}
 
 	@Override
 	public void undo() {
 		
		setDrawingsList(originator.restoreFromMemento(caretaker.getMemento(--index)));
 		/*
 		//currentCommand = data.undo();
 		undo.go(data.undo());
 		//*/
 	}
 
 	@Override
 	public void redo() {
 		
		setDrawingsList(originator.restoreFromMemento(caretaker.getMemento(++index)));
 		/*
 		//currentCommand = data.redo();
 		perform.go(data.redo());
 		//*/
 	}
 
 	@Override
 	public void save(String path) {
 		
 	}
 
 	@Override
 	public void load(String path) {
 		
 	}
 	
 	// *************** bonus functions *************** //
 	/*
 	@Override
 	public List<Class<? extends Shape>> getSupportedShapes() {
 
 		return null;
 	}
 
 	@Override
 	public void installPluginShape(String jarPath) {
 		
 	}
 	//*/	
 }