package paint.controller;

import java.awt.Color;

import paint.model.AbstractShape;

public class ChangeColor implements Command {

	AbstractShape shape;
	Color newColor;
	Color newFillColor;
	
	public ChangeColor(AbstractShape currentShape, Color newColor, Color newFillColor) {
		this.shape = currentShape;
		this.newColor = newColor;
		this.newFillColor = newFillColor;
	}
	
	@Override
	public void excute() {
		shape.setColor(newColor);
		shape.setFillColor(newFillColor);
	}
}
