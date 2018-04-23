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

	@Override
	public boolean contains(int x, int y) {
		
		int dxc, dyc, dxl, dyl, cross;
		float threshold = 0.1f;
		dxc = x - position.x;
		dyc = y - position.y;
		dxl = (int) (properties.get("x2") - position.x);
		dyl = (int) (properties.get("y2") - position.y);
		cross = dxc * dyl - dyc * dxl;
		if(Math.abs(cross) > threshold)
			return false;
		if (Math.abs(dxl) >= Math.abs(dyl))
			  return dxl > 0 ? 
			  	position.x <= x && x <= properties.get("x2") :
			  		properties.get("x2") <= x && x <= position.x;
			else
			  return dyl > 0 ? 
			  	position.y <= y && y <= properties.get("y2") :
		  		properties.get("y2") <= y && y <= position.y;
	}
}
