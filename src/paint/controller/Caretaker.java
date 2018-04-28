package paint.controller;

import java.util.ArrayList;

class Caretaker {
   
	final ArrayList<Memento> statesList;
	
	public Caretaker() {
		
		statesList = new ArrayList<>();
	}

	public void addMemento(Memento memento, int index) {
		
		if(index>19)
			statesList.remove(0);
		statesList.add(memento);
	}
   
	public Memento getMemento(int index) {
		
		return index>19 ? statesList.get(19) : statesList.get(index);
	}
} 