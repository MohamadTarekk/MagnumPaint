package paint.model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.HashMap;

public class Line extends AbstractShape {

    public Line() {
    	
        properties = new HashMap<>();
        properties.put("x2", 0.0);
        properties.put("y2", 0.0);
    }

	@Override
	public void draw(Object canvas) {
		
        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawLine((int) position.getX(),
        		(int) position.getY(),
        		(int) properties.get("x2").intValue(),
        		(int) properties.get("y2").intValue());
	}
}
