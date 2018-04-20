package paint.view;

import javax.swing.JPanel;

import paint.controller.PaintController;

@SuppressWarnings("serial")
public class PaintPanel extends JPanel {

	private PaintController paintController;
	
	public PaintPanel(PaintController paintController) {
		
		this.paintController = paintController;
	}
}
