package paint.controller;

import java.awt.Color;

import paint.model.Circle;

public class PaintRunner {

	public static void main(String[] args) {

		PaintController paintController = new PaintController();
		paintController.start();
		
		Circle circle = new Circle();
		circle.setColor(Color.blue);
		System.out.println(circle.getColor());
		Circle clonedCircle;
		try {
			clonedCircle = (Circle) circle.clone();
			System.out.println(clonedCircle.getColor());
			System.out.println(circle==clonedCircle);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		Circle c = circle;
		c.setColor(Color.BLACK);
		System.out.println(c==circle);
		System.out.println(circle.getColor() + "\n" + c.getColor());
	}
}
