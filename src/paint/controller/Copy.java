package paint.controller;

import paint.model.Shape;

public class Copy implements Command {

	private PaintController theController;
	private Shape theShape;
	private Shape theCopy;
	
	public Copy(PaintController currentController, Shape currentShape) {
		
		theController = currentController;
		theShape = currentShape;
		try { 
			theCopy = (Shape) theShape.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excute() {
		
		theController.addShape(theCopy);
	}

	@Override
	public void undo() {
		
		theController.removeShape(theCopy);
	}
}
