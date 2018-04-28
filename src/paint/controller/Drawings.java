package paint.controller;

import java.util.ArrayList;
import java.util.Iterator;

import paint.model.Shape;

public class Drawings {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public void addShape(Shape newShape) {
		shapes.add(0, newShape); 
	}
	
	public void removeShape(Shape theshape) {
		for(Iterator<Shape> s = shapes.iterator(); s.hasNext(); ) {
			Shape shape = s.next();
			if(shape==theshape && shape.getPosition()==theshape.getPosition() && shape.getHeight()==theshape.getHeight())
				s.remove();
		}
		/*for (Shape s : shapes) {
			if (s.getPosition().getX() == theshape.getPosition().getX() && s.getPosition().getY() == theshape.getPosition().getY())
				shapes.remove(s);
		}*/
	}
	
	public Shape selectShape(int x, int y) {
		for (Shape s : shapes) {
			if(s.contains(x, y))
				return s;
		}
		/*Square m = new Square();
		m.setColor(Color.RED);
		return m;*/
		return null;
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public void clearShapes() {
		shapes.clear();
	}
	
	public void restoreShapes(ArrayList<Shape> deleted) {
		shapes = deleted;
	}
	
}