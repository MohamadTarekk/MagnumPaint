package paint.controller;

import java.awt.Point;

import paint.model.Shape;

public class Resize implements Command {

	private PaintController theController;
	private Shape oldShape;
	private Shape newShape;
	
	public Resize(PaintController currentController, Shape currentShape, Point p1, Point p2, String anchor) {
		
		theController = currentController;
		oldShape = currentShape;
		newShape = currentShape;
		newShape.resize(p1, p2, anchor);
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
