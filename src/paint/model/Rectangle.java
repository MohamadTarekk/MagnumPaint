package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;

public class Rectangle extends AbstractShape {

    public Rectangle() {
    	
        properties = new HashMap<>();
        properties.put("Width", 0.0);
        properties.put("Height", 0.0);
    }

	@Override 
	public void draw(Object canvas) {
		
		((Graphics2D) canvas).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
		((Graphics2D) canvas).setColor(getFillColor());
		((Graphics2D) canvas).fillRect((int) position.getX(),
				(int) position.getY(),
				(int) properties.get("Width").intValue(),
				(int) properties.get("Height").intValue());

		((Graphics2D) canvas).setStroke(new BasicStroke(2));
		((Graphics2D) canvas).setColor(getColor());
		((Graphics2D) canvas).drawRect((int) position.getX(),
				(int) position.getY(),
				(int) properties.get("Width").intValue(),
				(int) properties.get("Height").intValue());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object clone() throws CloneNotSupportedException {

		Shape copy = new Rectangle();
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
		
        ((Graphics2D) canvas).setColor(new Color(0,0,0,0.0f));
        ((Graphics2D) canvas).fillRect((int) position.getX(),
        		(int) position.getY(),
        		(int) properties.get("Width").intValue(),
        		(int) properties.get("Height").intValue());

        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(Color.LIGHT_GRAY);
        ((Graphics2D) canvas).drawRect((int) position.getX(),
        		(int) position.getY(),
        		(int) properties.get("Width").intValue(),
        		(int) properties.get("Height").intValue());
	}

	@Override
	public boolean contains(int x, int y) {

		if( (x >= position.getX() && x <= position.getX()+properties.get("Width")) &&
				(y >= position.getY() && y <= position.getY()+properties.get("Height")) ) {
			return true;
		}
		return false;
	}

	@Override
	public void calculateDimensions(Point startPoint, Point endPoint) {
		
		double x = Math.min(startPoint.getX(), endPoint.getX());
        double y = Math.min(startPoint.getY(), endPoint.getY());
        setPosition(new Point((int)x, (int)y));
        double width = Math.abs(startPoint.getX() - endPoint.getX());
        double height = Math.abs(startPoint.getY() - endPoint.getY());
        Map<String, Double> newProperties = new HashMap<String, Double>();
		newProperties.put("Width", width);
		newProperties.put("Height", height);
		setProperties(newProperties);
	}

	@Override
	public double getWidth() {
		
		return properties.get("Width");
	}

	@Override
	public double getHeight() {

		return properties.get("Height");
	}
}
