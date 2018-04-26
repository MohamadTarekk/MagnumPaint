package paint.controller;

import java.util.ArrayList;

import paint.model.Shape;

public class Drawings {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public void addShape(Shape newShape) {
		shapes.add(0, newShape);
	}
	
	public void removeShape(Shape theshape) {
		for (Shape s : shapes) {
			if (s.getPosition().getX() == theshape.getPosition().getX() && s.getPosition().getY() == theshape.getPosition().getY())
				shapes.remove(s);
		}
	}
	
	public Shape selectShape(int x, int y) {
		for (Shape s : shapes) {
			if(s.contains(x, y))
				return s;
		}
		return null;
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	
	public void clearShapes() {
		shapes.clear();
	}
	
	public void restoreShapes(ArrayList<Shape> deleted) {
		shapes = deleted;
	}
	
}