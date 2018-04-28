package paint.controller;

/*import java.awt.Color;

import paint.model.Shape;
import paint.model.ShapeFactory;
//*/

public class PaintRunner {

	public static void main(String[] args) {

		PaintController paintController = new PaintController();
		paintController.start();
		
		/*Shape shape = new ShapeFactory().getShape("Rectangle");
		Shape s = new ShapeFactory().getShape("Circle");
		Shape e = new ShapeFactory().getShape("Triangle");
		
		shape.setColor(Color.BLACK);
		s.setColor(Color.BLUE);
		e.setColor(Color.magenta);
		
		paintController.addShape(shape);
		paintController.addShape(s);
		paintController.addShape(e);
		
		paintController.removeShape(shape);
		
		System.out.println(paintController.getDrawingsList().size());

		paintController.undo();
		//paintController.redo();
		
		System.out.println(paintController.getDrawingsList().size());
		//*/
	}
}
