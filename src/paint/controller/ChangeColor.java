package paint.controller;

import java.awt.Color;

import paint.model.Shape;

public class ChangeColor implements Command {

	private PaintController theController;
	private Shape oldShape;
	private Shape newShape;
	
	public ChangeColor(PaintController theController, Shape currentShape, Color newColor, Color newFillColor) {
		
		oldShape = currentShape;
		newShape = currentShape;
		newShape.setColor(newColor);
		newShape.setFillColor(newFillColor);
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