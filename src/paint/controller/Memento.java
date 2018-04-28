package paint.controller;

import java.util.ArrayList;
import paint.model.Shape;

public class Memento {
	
	private ArrayList<Shape> state;

	public Memento(ArrayList<Shape> state) {
		
		this.state = state;
	}
	
	public ArrayList<Shape> getState() {
		
		return this.state;
	}
	
}