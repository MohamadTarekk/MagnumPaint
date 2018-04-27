package paint.controller;

import java.awt.Color;
import java.awt.Point;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import paint.model.Shape;
import paint.model.ShapeFactory;

public class JSON implements MyFile {

	Data data = Data.getInstance();

	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	@Override
	public void save(String filePath) {
		
		ArrayList<Shape> myList = data.getDrawingsList();
		
		JSONArray shapes = new JSONArray();
		
		for(Shape s : myList) {
			JSONObject shape = new JSONObject();
			
			shape.put("type", ""+s.getClass().getSimpleName());
			//shape.put("name", ""+s.getName());
			shape.put("redStroke", ""+s.getColor().getRed());
			shape.put("greenStroke", ""+s.getColor().getGreen());
			shape.put("blueStroke", ""+s.getColor().getBlue());
			shape.put("redFill", ""+s.getFillColor().getRed());
			shape.put("greenFill", ""+s.getFillColor().getGreen());
			shape.put("blueFill", ""+s.getFillColor().getBlue());
			shape.put("x", ""+s.getPosition().getX());
			shape.put("y", ""+s.getPosition().getY());
			Map<String, Double> properties = s.getProperties();
			Set set = properties.entrySet();
			Iterator iterator = set.iterator();
			while(iterator.hasNext()) {
				Map.Entry mapEntry = (Map.Entry)iterator.next();
				shape.put(mapEntry.getKey(), ""+mapEntry.getValue());
			}
			shapes.add(shape);
			//((Map) shapes).put(s.getName(), shape);
			try {
				FileWriter fw = new FileWriter(filePath);
				fw.write(shapes.toString());
				fw.flush();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void load(String filePath) {
		
        JSONParser parser = new JSONParser();

        try {

        	Shape shape;
        	JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filePath));
            System.out.println(jsonArray);
            /*
            String name = (String) jsonArray.get("Circle 1").toString();
            System.out.println(name);
            */
            for(Object o : jsonArray) {
            	JSONObject obj = (JSONObject)o;
            	String name = (String) obj.get("type");
            	
            	shape = new ShapeFactory().getShape(name);
            	
            	/*
	            if(name.equals("Circle"))
	            	shape = new Circle();
	            else if(name.equals("Ellipse"))
	            	shape = new Ellipse();
	            else if(name.equals("Square"))
	            	shape = new Square();
	            else if(name.equals("Rectangle"))
	            	shape = new Rectangle();
	            else if(name.equals("Line"))
	            	shape = new Line();
	            else 
	            	shape = new Triangle();
	            //*/
            	
	            shape.setColor(new Color(Integer.parseInt((String)obj.get("redStroke")), Integer.parseInt((String)obj.get("greenStroke")), Integer.parseInt((String)obj.get("blueStroke"))));
	            shape.setFillColor(new Color(Integer.parseInt((String)obj.get("redFill")), Integer.parseInt((String)obj.get("greenFill")), Integer.parseInt((String)obj.get("blueFill"))));
	            shape.setPosition(new Point((int)Double.parseDouble(obj.get("x").toString()), (int)Double.parseDouble(obj.get("y").toString())));  
	            data.addShape(shape);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
