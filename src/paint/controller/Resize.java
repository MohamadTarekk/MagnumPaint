package paint.controller;

import java.awt.Point;

import paint.model.Shape;

public class Resize implements Command {

	private PaintController theController;
	private Shape oldShape;
	private Shape newShape;
	
	public Resize(PaintController currentController, Shape currentShape, String anchor, Point endPoint) {
		
		theController = currentController;
		oldShape = currentShape;
		newShape = currentShape;
		newShape.resize(anchor, endPoint);
	}

	@Override
	public void excute() {
		
		theController.updateShape(oldShape, newShape);
	}

	@Override
	public void undo() {
		
		theController.updateShape(newShape, oldShape);
	}
}
