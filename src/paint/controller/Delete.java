package paint.controller;

import paint.model.Shape;

public class Delete implements Command {

	PaintController theController;
	Shape theShape;
	
	public Delete(PaintController currentController, Shape currentShape) {
		
		theController = currentController;
		theShape = currentShape;
	}

	@Override
	public void excute() {
		theController.data.removeShape(theShape);
	}

	@Override
	public void undo() {
		theController.addShape(theShape);
	}
}
