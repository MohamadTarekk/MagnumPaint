package paint.controller;

import java.awt.Color;

import paint.model.Shape;
import paint.model.Square;

public class ChangeColor implements Command {

	private PaintController theController = new PaintController();
	private Shape oldShape = new Square();
	private Shape newShape = new Square();
	
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
}