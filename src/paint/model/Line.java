package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;

public class Line extends AbstractShape {

    public Line() {
    	
        properties = new HashMap<>();
        properties.put("x2", 0.0);
        properties.put("y2", 0.0);
    }

	@Override
	public void draw(Object canvas) {
		
		((Graphics2D) canvas).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawLine((int) position.getX(),
        		(int) position.getY(),
        		(int) properties.get("x2").intValue(),
        		(int) properties.get("y2").intValue());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		Shape copy = new Line();
		copy.setColor(color);
		copy.setFillColor(fillColor);
		copy.setPosition(position);
		Map newProp = new HashMap<>();
		for(Map.Entry s : properties.entrySet()) {
			newProp.put(s.getKey(), s.getValue());
		}
		copy.setProperties(newProp);
		return copy;
	}

	@Override
	public void drawGuide(Object canvas) {
		
        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(Color.LIGHT_GRAY);
        ((Graphics2D) canvas).drawLine((int) position.getX(),
        		(int) position.getY(),
        		(int) properties.get("x2").intValue(),
        		(int) properties.get("y2").intValue());
	}

	@Override
	public boolean contains(int x, int y) {
		
		double x1 = position.getX();
		double y1 = position.getY();
		double x2 = properties.get("x2");
		double y2 = properties.get("y2");
		double slope = (y2 - y1) / (x2 - x1);
		double equation = (y - y1) / (x - x1);
		return Math.abs(slope-equation)<0.01f && x>=Math.min(x1, y1) && x<=Math.max(x2, y2);
	}

	@Override
	public void calculateDimensions(Point startPoint, Point endPoint) {

        setPosition(startPoint);
        Map<String, Double> newProperties = new HashMap<String, Double>();
		newProperties.put("x2", endPoint.getX());
		newProperties.put("y2", endPoint.getY());
		setProperties(newProperties);		
	}

	@Override
	public double getWidth() {
		
		return properties.get("x2") - position.getX();
	}

	@Override
	public double getHeight() {

		return properties.get("y2") - position.getY();
	}
}
