package paint.controller;

public class Clear implements Command{
	
	private PaintController theController;
	
	public Clear(PaintController currentController) {
		
		theController = currentController;
	}
	
	@Override
	public void excute() {
		
		theController.clearDrawingsList();
	}

}
