package paint.controller;

// import java.util.ArrayList;

// import paint.model.Shape;

public class Clear implements Command{
	
	private PaintController theController;
	// private ArrayList<Shape> deleted = new ArrayList<Shape>();
	
	public Clear(PaintController currentController) {
		
		theController = currentController;
	}
	
	@Override
	public void excute() {
		
		// deleted = theController.getDrawingsList();
		theController.clearDrawingsList();
	}

	@Override
	public void undo() {
		
		// theController.restoreDrawingsList(deleted);
	}
}
