package paint.model;

import java.util.HashMap;

public class Circle extends Ellipse {

    public Circle() {
    	
        properties = new HashMap<>();
        properties.put("Width", 0.0);
        properties.put("Height", 0.0);
    }
}
