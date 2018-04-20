package paint.model;

import java.awt.*;
import java.util.*;

public interface Shape {
	
	public void setPosition(java.awt.Point position);
	public Point getPosition();
	/* update shape specific properties (e.g., radius) */
	public void setProperties(java.util.Map<String, Double> properties);
	public Map<String, Double> getProperties();
	public void setColor(Color color);
	public Color getColor();
	public void setFillColor(Color color);
	public Color getFillColor();
	/* redraw the shape on the canvas,
	 for swing, you will cast canvas to java.awt.Graphics */
	public void draw(Object canvas);
	/* create a deep clone of the shape */
	public Object clone() throws CloneNotSupportedException;
}
