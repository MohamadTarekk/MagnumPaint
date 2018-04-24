package paint.controller;

import java.awt.Point;

import paint.model.Shape;

public class Move implements Command {

	private PaintController theController;
	private Shape oldShape;
	private Shape newShape;
	
	
	
	public Move(PaintController currentController, Shape currentShape, Point p1, Point p2) {
		theController = currentController;
		oldShape = currentShape;
		newShape = currentShape;
		newShape.move(p1, p2);
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
