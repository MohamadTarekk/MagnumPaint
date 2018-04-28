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
	private boolean drawing = false; // drawing a new shape or editing
	private boolean shapeSelected = false;
	private int mode = 0; // 0: draw, 1: select, 2: resize, 3: move.

	/* first we check for mode
	 * if it's 0, perform a new drawing*/
	
	//ALL THE DRAWING DATA
	private Data data = Data.getInstance();
	
	private Caretaker caretaker = new Caretaker();
	private Originator originator = new Originator();
	private static int saveFiles = 0, current = 0;
	
	public void start() {
		
		paintFrame.blowUp(this);
 	}
 
	public void setCurrentShape(Shape currentShape) {
		
		this.currentShape = currentShape;
	}

	public void selectShape(int x, int y) {
		
		currentShape = data.selectShape(x, y);
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
		originator.set(myList);
		caretaker.addMemento(originator.storeInMemento(), current);
		saveFiles++;
		current++;
	}
	
	public void performCommand(Command currentCommand) {
		
		this.currentCommand = currentCommand;
		perform.go(currentCommand);
	}
	
	public void newDrawing() {
		
		data.clearDrawingsList();
		caretaker = new Caretaker();
	}
	
	@Override
	public void refresh(Object canvas) {
		
		System.out.println(getDrawingsList().size());
		paintFrame.drawingBoard.repaint();
		/*for (int i = getShapes().length-1; i>=0; i--) {
			getShapes()[i].draw(canvas);
		}
		if (drawing) {
			currentShape.draw(canvas);
		}*/	
	}

 	@SuppressWarnings("unchecked")
	@Override
 	public void addShape(Shape shape) {
		
 		data.addShape(shape);
 		ArrayList<Shape> myList = (ArrayList<Shape>) getDrawingsList().clone();
		originator.set(myList);
		caretaker.addMemento(originator.storeInMemento(), current);
		saveFiles++;
		current++;
 	}
 
 	@SuppressWarnings("unchecked")
	@Override
 	public void removeShape(Shape shape) {
 		
		data.removeShape(shape);
 		ArrayList<Shape> myList = (ArrayList<Shape>) getDrawingsList().clone();
		originator.set(myList);
		caretaker.addMemento(originator.storeInMemento(), current);
		saveFiles++;
		current++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		
		data.replaceShape(oldShape, newShape);
 		ArrayList<Shape> myList = (ArrayList<Shape>) getDrawingsList().clone();
		originator.set(myList);
		caretaker.addMemento(originator.storeInMemento(), current);
		saveFiles++;
		current++;
	}

 	@Override
 	public Shape[] getShapes() {
		
		Shape[] array = new Shape[data.getDrawingsList().size()];
		data.getDrawingsList().toArray(array); // fill the array
		return array;
 	}
 
 	@Override
 	public void undo() {
 		
 		if(current>=1) {
 			current--;
 			setDrawingsList(originator.restoreFromMemento(caretaker.getMemento(current)));
 		}
 	}
 
 	@Override
 	public void redo() {
 		
 		if(current<saveFiles-1) {
 			current++;
 			setDrawingsList(originator.restoreFromMemento(caretaker.getMemento(current)));
 		}
 	}
	public boolean extension(String path) {
 		
 		return path.endsWith(".xml");
 	}
 	
 	@Override
 	public void save(String path) {
 		
 		if(extension(path)) {
 			new SaveFile(new XML(), path);
 		} else {
 			new SaveFile(new JSON(), path);
 		}
 	}
 
 	@Override
 	public void load(String path) {
 		
 		if(extension(path)) {
 			new LoadFile(new XML(), path);
 		} else {
 			new LoadFile(new JSON(), path);
 		}
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
 	*/	
 }