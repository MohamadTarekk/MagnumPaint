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

=======
>>>>>>> deb697af3afaee63e4e7c0eaf0cd7a9454c860da
	
	//ALL THE DRAWING DATA
	private Data data = Data.getInstance();
	
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

=======
>>>>>>> deb697af3afaee63e4e7c0eaf0cd7a9454c860da
	@Override
	public void refresh(Object canvas) {
		//((java.awt.Graphics)canvas).
		for (Shape s : getShapes()) {
			s.draw((java.awt.Graphics)canvas);
		}
	}

<<<<<<< HEAD
 	@Override
 	public void addShape(Shape shape) {
 		

=======
 
 	@Override
 	public void addShape(Shape shape) {
 		
>>>>>>> deb697af3afaee63e4e7c0eaf0cd7a9454c860da
		data.addShape(shape);
 	}
 
 	@Override
 	public void removeShape(Shape shape) {
 		
		data.removeShape(shape);
<<<<<<< HEAD

=======
>>>>>>> deb697af3afaee63e4e7c0eaf0cd7a9454c860da
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		
		data.replaceShape(oldShape, newShape);
	}
<<<<<<< HEAD

 	@Override
 	public Shape[] getShapes() {

=======
  
 	@Override
 	public Shape[] getShapes() {
>>>>>>> deb697af3afaee63e4e7c0eaf0cd7a9454c860da
		
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