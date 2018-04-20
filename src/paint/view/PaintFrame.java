package paint.view;

import javax.swing.JFrame;

import paint.controller.PaintController;

@SuppressWarnings("serial")
public class PaintFrame extends JFrame {

	private PaintPanel paintPanel;
	
	public PaintFrame(PaintController paintController) {
		
		paintPanel = new PaintPanel(paintController);
		setupFrame();
	}
	
	private void setupFrame() {
		
		this.setContentPane(paintPanel);
		this.setSize(800, 600);
        this.setTitle("Paint");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
