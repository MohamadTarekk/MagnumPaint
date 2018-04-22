package paint.model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.HashMap;

public class Triangle extends AbstractShape {

    public Triangle() {
    	
        properties = new HashMap<>();
        properties.put("x2", 0.0);
        properties.put("x3", 0.0);
        properties.put("y2", 0.0);
        properties.put("y3", 0.0);
    }

	@Override
	public void draw(Object canvas) {
		
        ((Graphics2D) canvas).setColor(getFillColor());
        ((Graphics2D) canvas).fillPolygon(new int[] {(int) position.getX(),
        			(int) properties.get("x2").intValue(),
        			(int) properties.get("x3").intValue()},
        		new int[] {(int) position.getY(),
    				(int) properties.get("y2").intValue(),
    				(int) properties.get("y3").intValue()},
        		3);

        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawPolygon(new int[] {(int) position.getX(),
    			(int) properties.get("x2").intValue(),
    			(int) properties.get("x3").intValue()},
    		new int[] {(int) position.getY(),
				(int) properties.get("y2").intValue(),
				(int) properties.get("y3").intValue()},
    		3);
	}
}
