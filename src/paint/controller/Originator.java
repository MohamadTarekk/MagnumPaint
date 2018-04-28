package paint.controller;

import java.util.ArrayList;

import paint.model.Shape;

public class Originator {
	
	private ArrayList<Shape> state;
	
	public void set(ArrayList<Shape> state) {
		
	    this.state = state; 
	}

	public Memento storeInMemento() { 
		
	    return new Memento(state); 
	}
	   
	public ArrayList<Shape> restoreFromMemento(Memento memento) {
		   
		state = memento.getState();
		return state;
	}
}