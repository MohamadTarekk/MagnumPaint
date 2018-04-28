package paint.controller;

import java.awt.Point;

import paint.model.Shape;

public class Move implements Command {

	private PaintController theController;
	private Shape oldShape;
	private Shape newShape;
	
	
	
	public Move(PaintController currentController, Shape currentShape, Point endPoint) {
		theController = currentController;
		oldShape = currentShape;
		newShape = currentShape;
		newShape.move(endPoint);
	}

	@Override
	public void excute() {
		
		theController.updateShape(oldShape, newShape);
	}
}
