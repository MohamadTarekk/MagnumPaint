package paint.model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;

public class Square extends AbstractShape {

    public Square() {
    	
        properties = new HashMap<>();
        properties.put("Width", 0.0);
        properties.put("Height", 0.0);
    }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object clone() throws CloneNotSupportedException {

		Shape copy = new Square();
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
        width = height =  Math.min(width, height);
        Map<String, Double> newProperties = new HashMap<String, Double>();
		newProperties.put("Width", width);
		newProperties.put("Height", height);
		setProperties(newProperties);
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

	@Override
	public boolean contains(int x, int y) {

		if( (x >= position.getX() && x <= position.getX()+properties.get("Width")) &&
				(y >= position.getY() && y <= position.getY()+properties.get("Height")) ) {
			return true;
		}
		return false;
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
