package paint.model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.HashMap;

public class Ellipse extends AbstractShape {

    public Ellipse() {
    	
        properties = new HashMap<>();
        properties.put("Width", 0.0);
        properties.put("Height", 0.0);
    }

	@Override
	public void draw(Object canvas) {
		
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
	public boolean select(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
}
