package paint.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import paint.controller.PaintController;


public class PaintFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected PaintController paintController;
	private PaintPanel paintPanel;
	
	public PaintFrame(PaintController paintController) {
		
		this.paintController = paintController;
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
	 static public void main( String[] args )
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
	    }
		
		//private JPanel contentPane;
		private JPanel bottomPanel;
		
		private JButton btnLine;
		private JButton btnEllipse;
		private JButton btnRectangle;
		private JButton btnBrush;
		private JButton btnColor;
		
		private ImageIcon iconLine;
		private ImageIcon iconEllipse;
		private ImageIcon iconRectangle;
		private ImageIcon iconBrush;
		private ImageIcon iconColor;
		private ImageIcon iconFill;
		private ImageIcon iconRefresh;
		private ImageIcon iconUndo;
		private ImageIcon iconSave;
		private ImageIcon iconLoad;
		
		private Box theBox; 
		private JButton btnFill;
		private JButton btnRefresh;
		private JButton btnUndo;
		private JButton btnSave;
		private JButton btnLoad;
		
		public PaintFrame(PaintPanel DrawingBoard){
		
			setTitle("Magnum Paint");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			
			 bottomPanel=new JPanel();		
			 iconLine = new ImageIcon("line.png");
			 iconEllipse = new ImageIcon("ellipse.png");
			 iconRectangle = new ImageIcon("rectangle.png");
			 iconBrush = new ImageIcon("brush.png");
			 iconColor = new ImageIcon("color.png");
			 iconFill = new ImageIcon("fill.png");
			 iconRefresh = new ImageIcon("refresh.png");
			 iconUndo = new ImageIcon("undo.png");
			 iconSave = new ImageIcon("save.png");
			 iconLoad = new ImageIcon("load.png");
			 
			 btnLine = new JButton(iconLine);
				
				btnLine.setBounds(236, 492, 70, 70);
				//contentPane.add(btnLine);
				
				btnEllipse = new JButton(iconEllipse);
				btnEllipse.setBounds(334, 492, 70, 70);
				//contentPane.add(btnEllipse);
				
				btnRectangle = new JButton(iconRectangle);
				btnRectangle.setBounds(442, 492, 70, 70);
				//contentPane.add(btnRectangle);
				
				btnColor = new JButton(iconColor);
				
				
				btnBrush = new JButton(iconBrush);
				getContentPane().add(DrawingBoard, BorderLayout.CENTER);
				
				theBox = Box.createHorizontalBox();
				
				btnUndo = new JButton(iconUndo);
				theBox.add(btnUndo);
				
				btnRefresh = new JButton(iconRefresh);
				theBox.add(btnRefresh);
				
				
				
				theBox.add(btnLine);
				theBox.add(btnEllipse);
				theBox.add(btnRectangle);
				theBox.add(btnBrush);
				theBox.add(btnColor);
				
				btnFill = new JButton(iconFill);
				theBox.add(btnFill);
				
				btnSave = new JButton(iconSave);
				theBox.add(btnSave);
				
				btnLoad = new JButton(iconLoad);
				theBox.add(btnLoad);
				bottomPanel.add(theBox);
				
		}
	}



