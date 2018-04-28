package paint.controller;

import paint.model.Shape;

public class Resize implements Command {

	private PaintController theController;
	private Shape oldShape;
	private Shape newShape;
	
	public Resize(PaintController currentController, Shape currentShape, double width, double height) {
		
		theController = currentController;
		oldShape = currentShape;
		newShape = currentShape;
		newShape.resize(width, height);
	}

	@Override
	public void excute() {
		
		theController.updateShape(oldShape, newShape);
	}
}
