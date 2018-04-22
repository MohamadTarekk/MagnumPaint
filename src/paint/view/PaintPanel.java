package paint.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import paint.controller.PaintController;


@SuppressWarnings("serial")
public class PaintPanel extends JPanel {

	private PaintController paintController;
	
	public PaintPanel(PaintController paintController) {
		
		this.paintController = paintController;
		setupPanel();
	}
	private void setupPanel() {
		JButton btnDraw = new JButton("Press Me!");
		this.add(btnDraw);
	}
}
