 package paint.controller;
 
 import paint.model.Shape;
 import paint.view.PaintFrame;
 
 public class PaintController implements DrawingEngine {
 
 	private PaintFrame paintFrame;
	private Shape currentShape;
	private Command currentCommand;
	private CommandInvoker perform;
	private CommandUndo undo;
<<<<<<< HEAD
	
	//ALL THE DRAWING DATA
	private Data data = Data.getInstance();
	
=======
 	
	// ALL THE DRAWING DATA
	protected Data data = Data.getInstance();
 	
>>>>>>> 3f1ec7ea2b2c80a71b9ea9d8db4191bdc62ead93
	public PaintController() {
		
	}
 	
	public void start() {
		
		paintFrame = new PaintFrame(this);
 	}
 
	public void setCurrentShape(Shape currentShape) {
		
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
	
<<<<<<< HEAD
	@Override
	public void refresh(Object canvas) {
		//((java.awt.Graphics)canvas).
		for (Shape s : getShapes()) {
			s.draw((java.awt.Graphics)canvas);
		}
	}

	@Override
	public void addShape(Shape shape) {
		
=======
 	@Override
 	public void refresh(Object canvas) {
 		
 	}
 
 	@Override
 	public void addShape(Shape shape) {
 		
>>>>>>> 3f1ec7ea2b2c80a71b9ea9d8db4191bdc62ead93
		data.addShape(shape);
 	}
 
 	@Override
 	public void removeShape(Shape shape) {
 		
		data.removeShape(shape);
<<<<<<< HEAD
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		
		data.replaceShape(oldShape, newShape);
	}

	@Override
	public Shape[] getShapes() {
=======
 	}
 
 	@Override
 	public void updateShape(Shape oldShape, Shape newShape) {
 		
 	}
 
 	@Override
 	public Shape[] getShapes() {
>>>>>>> 3f1ec7ea2b2c80a71b9ea9d8db4191bdc62ead93
		
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