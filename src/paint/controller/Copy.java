package paint.controller;

import paint.model.Shape;

public class Copy implements Command {

	PaintController theController;
	Shape theShape;
	Shape theCopy;
	
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
		theController.data.addShape(theCopy);
	}

	@Override
	public void undo() {
		theController.data.removeShape(theCopy);
	}
}
