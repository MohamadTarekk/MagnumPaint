package paint.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import paint.controller.PaintController;


@SuppressWarnings("serial")
public class PaintFrame extends JFrame {

	protected PaintController paintController;
	private PaintPanel paintPanel;
	
	JPanel bottomPanel;

	JButton btnLine;
	JButton btnEllipse;
	JButton btnRectangle;
	JButton btnBrush;
	
	JButton btnColor;
	JButton btnFill;

	Color strokeColor=Color.BLACK, fillColor=Color.BLACK;

	ImageIcon iconLine;
	ImageIcon iconEllipse;
	ImageIcon iconRectangle;
	ImageIcon iconBrush;
	ImageIcon iconColor;
	ImageIcon iconFill;
	ImageIcon iconRefresh;
	ImageIcon iconUndo;
	ImageIcon iconSave;
	ImageIcon iconLoad;

	Box theBox; 
	JButton btnRefresh;
	JButton btnUndo;
	JButton btnSave;
	JButton btnLoad;
	
	public PaintFrame(PaintController paintController) {
		
		this.paintController = paintController;
		paintPanel = new PaintPanel(paintController);
		setupFrame();
	}
	
	private void setupFrame() {
		
		this.setContentPane(paintPanel);
		this.setSize(800, 600);
        this.setTitle("Magnum Paint");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new PaintPanel(), BorderLayout.CENTER);
        this.setVisible(true);
       
	
	 /*static public void main( String[] args )
	    {
	        SwingUtilities.invokeLater( new Runnable()
	        {
	            public void run()
	            {
	                // creates a frame, adds your JPanel to it and displays it
	                JFrame frame = new JFrame( "Test Window" );
	                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	                frame.add( new PaintPanel() );
	                frame.pack();
	                frame.setVisible( true );
	               
	    		}
	    		
	        });
	    }*/
	
		 bottomPanel=new JPanel();		
		 
		 iconLine = new ImageIcon("./src/line.png");
		 iconEllipse = new ImageIcon("./src/ellipse.png");
		 iconRectangle = new ImageIcon("./src/rectangle.png");
		 iconBrush = new ImageIcon("./src/brush.png");
		 iconRefresh = new ImageIcon("./src/refresh.png");
		 iconUndo = new ImageIcon("./src/undo.png");
		 iconSave = new ImageIcon("./src/save.png");
		 iconLoad = new ImageIcon("./src/load.png");
			 
		 btnLine = new JButton();
	     btnColor = new JButton();
	     btnEllipse = new JButton();
	     btnBrush = new JButton();
	     btnRectangle = new JButton();
	     btnUndo = new JButton();
		 btnRefresh = new JButton();
		 btnSave = new JButton();
		 btnFill = new JButton();
		 btnLoad = new JButton();
			 
		 btnLine.setIcon(iconLine);
		 btnEllipse.setIcon(iconEllipse);
		 btnRectangle.setIcon(iconRectangle);
		 btnBrush.setIcon(iconBrush);
		 btnUndo.setIcon(iconUndo);
		 btnRefresh.setIcon(iconRefresh);
				
		 theBox = Box.createHorizontalBox();
					
		 theBox.add(btnUndo);
		 theBox.add(btnRefresh);
		 theBox.add(btnLine);
		 theBox.add(btnEllipse);
		 theBox.add(btnRectangle);
		 theBox.add(btnBrush);
		 theBox.add(btnSave);
		 theBox.add(btnLoad);
		 theBox.add(btnLoad);
			 
		 btnColor =ColorButton(true);
	     btnFill =ColorButton(false);
				
		 bottomPanel.add(theBox);
		 this.add(bottomPanel, BorderLayout.SOUTH);
		 //this.add(new PaintPanel(), BorderLayout.CENTER);
		 this.pack();
		 this.setResizable(false);
		 this.setVisible(true);		 		
}
	


	/*public void addButtonActionListener(ActionListener listener){
		btnLine.addActionListener(listener);
		btnEllipse.addActionListener(listener);
		btnRectangle.addActionListener(listener);
		btnBrush.addActionListener(listener);
		btnColor.addActionListener(listener);
		btnFill.addActionListener(listener);
		btnRefresh.addActionListener(listener);
		btnUndo.addActionListener(listener);
		btnSave.addActionListener(listener);
		btnLoad.addActionListener(listener);
	}*/

	public JButton ColorButton(final boolean stroke){
		JButton theBut = new JButton();
		theBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				if(stroke){
					strokeColor = JColorChooser.showDialog(null,  "Pick a Stroke", Color.BLACK);
				} else {
					fillColor = JColorChooser.showDialog(null,  "Pick a Fill", Color.BLACK);
				}
			
			}
		});
    
		return theBut;  
	}

}
