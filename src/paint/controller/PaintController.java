 package paint.controller;
 
 import java.util.ArrayList;

import paint.model.Shape;
 import paint.view.PaintFrame;
 
 public class PaintController implements DrawingEngine {
 
	public Shape currentShape;
	private PaintFrame paintFrame = new PaintFrame();
	private Command currentCommand;
	private CommandInvoker perform;
	private CommandUndo undo;
	private boolean drawing = false;
	private boolean isBrush = true;
	private int mode = 0;
	// 0: draw, 1: select, 2: resize, 3: copy, 4:move, 5: re-color, 6: delete.

	//ALL THE DRAWING DATA
	private Data data = Data.getInstance();
	
	
	public void start() {
		
		paintFrame.blowUp(this);
 	}
 
	public void setCurrentShape(Shape currentShape) {
		
 		this.currentShape = currentShape;
 	}
 
	public void setCurrentCommand(Command currentCommand) {
 		
		this.currentCommand = currentCommand;
 	}
	
	public void setBrush(boolean isBrush) {
		this.isBrush = isBrush;
	}
	
	public boolean isBrush() {
		return isBrush;
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
	
	public void clearDrawingsList() {
		
		data.clearDrawingsList();
	}
	
	public void restoreDrawingsList(ArrayList<Shape> deleted) {
		
		data.restoreDrawingsList(deleted);
	}
	
	@Override
	public void refresh(Object canvas) {
		
		//((java.awt.Graphics)canvas).
		if (!drawing) {
			for (Shape s : getShapes()) {
				s.draw(canvas);
				currentShape.setSelected(true);
			}
		}
		else {
			currentShape.drawGuide((java.awt.Graphics)canvas);
		}
	}
 
 	@Override
 	public void addShape(Shape shape) {
		
 		data.addShape(shape);
 	}
 
 	@Override
 	public void removeShape(Shape shape) {
 		
		data.removeShape(shape);
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		
		data.replaceShape(oldShape, newShape);
	}

 	@Override
 	public Shape[] getShapes() {
		
		Shape[] array = new Shape[data.getDrawingsList().size()];
		data.getDrawingsList().toArray(array); // fill the array
		return array;
 	}
 
 	@Override
 	public void undo() {
 		
 		currentCommand = data.undo();
 		undo.go(currentCommand);	
 	}
 
 	@Override
 	public void redo() {
 		
 		currentCommand = data.redo();
 		perform.go(currentCommand);
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