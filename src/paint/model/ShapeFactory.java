package paint.model;

public class ShapeFactory {
	
	public Shape getShape(String shapeType) {
	   
		if(shapeType.equalsIgnoreCase("ELLIPSE")) {
	   		return new Ellipse();
	   	}
		else if(shapeType.equalsIgnoreCase("CIRCLE")) {  
	   		return new Circle(); 
	   	}
	   	else if(shapeType.equalsIgnoreCase("RECTANGLE")) {  
		   	return new Rectangle(); 
	   	}
	   	else if(shapeType.equalsIgnoreCase("SQUARE")) {
	   		return new Square();
	   	}
	   	else if(shapeType.equalsIgnoreCase("TRIANGLE")) {  
	   		return new Triangle();
	   	}
	   	else if(shapeType.equalsIgnoreCase("LINE")) {
	   		return new Line();
	   	}
	   	return null;
	}
}