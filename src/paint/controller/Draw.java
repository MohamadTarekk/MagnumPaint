package paint.controller;

import paint.model.Shape;

public class Draw implements Command {

	private PaintController theController;
	private Shape theShape;
	
	public Draw(PaintController currentController, Shape currentShape) {
		
		theController = currentController;
		theShape = currentShape;
	}

	public Draw() {
		// TO OVERCOME THE GARBAGE COLLECTOR THAT CAUSES A NULLPOINTEREXCEPTION
	}

	@Override
	public void excute() {
		
		theController.addShape(theShape);;
	}
}
