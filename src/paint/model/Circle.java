package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;

public class Circle extends AbstractShape {

    public Circle() {
    	
        properties = new HashMap<>();
        properties.put("Width", 0.0);
        properties.put("Height", 0.0);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object clone() throws CloneNotSupportedException {

		Shape copy = new Circle();
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
	public void draw(Object canvas) {
		
		((Graphics2D) canvas).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        ((Graphics2D) canvas).setColor(getFillColor());
        ((Graphics2D) canvas).fillOval((int) position.getX(),
        		(int) position.getY(),
        		(int) properties.get("Width").intValue(),
        		(int) properties.get("Height").intValue());

        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawOval((int) position.getX(),
        		(int) position.getY(),
        		(int) properties.get("Width").intValue(),
        		(int) properties.get("Height").intValue());
	}

	@Override
	public void drawGuide(Object canvas) {
		
        ((Graphics2D) canvas).setColor(new Color(0,0,0,0.0f));
        ((Graphics2D) canvas).fillOval((int) position.getX(),
        		(int) position.getY(),
        		(int) properties.get("Width").intValue(),
        		(int) properties.get("Height").intValue());

        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(Color.LIGHT_GRAY);
        ((Graphics2D) canvas).drawOval((int) position.getX(),
        		(int) position.getY(),
        		(int) properties.get("Width").intValue(),
        		(int) properties.get("Height").intValue());
	}

	@Override
	public boolean contains(int x, int y) {

		double width, height, test;
		width = properties.get("Width");
		height = properties.get("Height");
		test = (Math.pow(x-(position.x+width/2), 2))/(Math.pow(width/2, 2)) +
				(Math.pow(y-(position.y+height/2), 2))/(Math.pow(height/2, 2));
		return (test <= 1);
	}

	@Override
	public void calculateDimensions(Point startPoint, Point endPoint) {
		
		double x = Math.min(startPoint.getX(), endPoint.getX());
        double y = Math.min(startPoint.getY(), endPoint.getY());
        double width = Math.abs(startPoint.getX() - endPoint.getX());
        double height = Math.abs(startPoint.getY() - endPoint.getY());
        int coord = coordinate(startPoint, endPoint);
        switch(coord) {
        case 1:
            y += height - Math.min(width, height);
        	break;
        case 2:
            x += width - Math.min(width, height);
            y += height - Math.min(width, height);
        	break;
        case 3:
            x += width - Math.min(width, height);
        	break;
        default: 
        	break;
        }
        setPosition(new Point((int)x, (int)y));
        width = height = Math.min(width, height);
        Map<String, Double> newProperties = new HashMap<String, Double>();
		newProperties.put("Width", width);
		newProperties.put("Height", height);
		setProperties(newProperties);
	}
	
	public int coordinate(Point start, Point end) {
		
		if(start.getX()<end.getX() && start.getY()>end.getY())
			return 1;
		else if(start.getX()>end.getX() && start.getY()>end.getY())
			return 2;
		else if(start.getX()>end.getX() && start.getY()<end.getY())
			return 3;
		else
			return 4;
	}
}
