package paint.controller;

import java.awt.Color;

import paint.model.Shape;

public class ChangeColor implements Command {

	private PaintController theController;
	private Shape oldShape;
	private Shape newShape;
	private Color newColor;
	private Color newFillColor;
	
	public ChangeColor(PaintController theController, Shape currentShape, Color newColor, Color newFillColor) {
		oldShape = currentShape;
		newShape = currentShape;
		this.newColor = newColor;
		this.newFillColor = newFillColor;
	}
	
	@Override
	public void excute() {
		newShape.setColor(newColor);
		newShape.setFillColor(newFillColor);
		theController.updateShape(oldShape, newShape);
	}
	
	@Override
	public void undo() {
		theController.updateShape(newShape, oldShape);
	}
}