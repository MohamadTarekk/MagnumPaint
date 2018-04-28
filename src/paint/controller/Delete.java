package paint.controller;

import paint.model.Shape;

public class Delete implements Command {

	private PaintController theController;
	private Shape theShape;
	
	public Delete(PaintController currentController, Shape currentShape) {
		
		theController = currentController;
		theShape = currentShape;
	}

	@Override
	public void excute() {
		
		theController.removeShape(theShape);
	}
}
