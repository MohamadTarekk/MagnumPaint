package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
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

		if( (x>position.x && x<position.x+properties.get("Width")) &&
				(y<position.y && y>y-properties.get("Height")) )
			return true;
		return false;
	}

	@Override
	public void calculateDimensions() {
		
		Map<String, Double> newProperties = new HashMap<String, Double>();
		Double width;
		Double height;
		width = (Double)Math.abs((double)(position.getX() - endPoint.getX()));
		height = (Double)Math.abs((double)(position.getY() - endPoint.getY()));
		newProperties.put("Width", width);
		newProperties.put("Height", height);
		setProperties(newProperties);
	}

}
