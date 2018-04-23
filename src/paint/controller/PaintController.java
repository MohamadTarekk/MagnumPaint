package paint.controller;

import paint.model.Shape;
import paint.view.PaintFrame; 

public class PaintController implements DrawingEngine {

	private PaintFrame paintFrame;
	private Shape currentShape;
	private Command currentCommand;
	private CommandInvoker perform;
	private CommandUndo undo;
	
	//ALL THE DRAWING DATA
	protected Data data = Data.getInstance();
	
	public PaintController() {
		
	}
	
	public void start() {
		
		paintFrame = new PaintFrame(this);
	}

	public void setCurrntShape(Shape currentShape) {
		
		this.currentShape = currentShape;
	}

	public void setCurrentCommand(Command currentCommand) {
		
		this.currentCommand = currentCommand;
	}
	
	public void applyCommand() {
		
		perform = new CommandInvoker(currentCommand);
	}
	
	public void undoCommand() {
		
		undo = new CommandUndo(currentCommand);
	}
	
	@Override
	public void refresh(Object canvas) {
		
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
		
	}

	@Override
	public Shape[] getShapes() {
		
		Shape[] array = new Shape[data.getDrawingsList().size()];
		data.getDrawingsList().toArray(array); // fill the array
		return array;
	}

	@Override
	public void undo() {
		
	}

	@Override
	public void redo() {
		
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
