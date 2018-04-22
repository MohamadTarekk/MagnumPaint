package paint.model;

import java.util.HashMap;

public class Square extends Rectangle {

    public Square() {
    	
        properties = new HashMap<>();
        properties.put("Width", 0.0);
        properties.put("Height", 0.0);
    }
}
