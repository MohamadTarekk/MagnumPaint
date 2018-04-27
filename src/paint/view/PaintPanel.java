package paint.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import paint.controller.PaintController;
import paint.controller.Draw;
import paint.model.*;

@SuppressWarnings("serial")
public class PaintPanel extends JPanel {

	private PaintController paintController;
	private PaintFrame paintFrame;
	private Point startPoint, endPoint;
	private int x, y;
	
	public PaintPanel(PaintController paintController, PaintFrame paintFrame) {
		
		this.paintController = paintController;
		this.paintFrame = paintFrame;
		initializeBoard();
		setBackground(Color.WHITE);
        setPreferredSize( new Dimension( 800, 400 ) );
        
	}
	
	public void initializeBoard() {
		
		this.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				// draw a new shape
				if(paintController.getMode() == 0) {
		    		startPoint = new Point(e.getX(), e.getY());
            		endPoint = startPoint;
            		paintController.setDrawing(true);
		       		paintController.currentShape.calculateDimensions(startPoint, endPoint);
		       		paintController.currentShape.setColor(paintFrame.strokeColor);
		       		paintController.currentShape.setFillColor(paintFrame.fillColor);
		       	}
				// selecting a shape
		    	else if (paintController.getMode() == 1) {
		    	}
		    	else {
		    		
		    	}
				
				// editing the selected shape
				if (paintController.isShapeSelected())
				{
					// resize the selected shape
					if (paintController.getMode() == 2) {
						startPoint = new Point(e.getX(), e.getY());
						endPoint = startPoint;
					}
					// copy the selected shape
					else if (paintController.getMode() == 3) {
					}
					// move the selected shape
					else if (paintController.getMode() == 4) {
						
					}
					// re-color the selected shape
					else if (paintController.getMode() == 5) {
					}
					// delete the selected shape
					else if (paintController.getMode() == 6) {
					}
				}

				// refresh the drawing board
				paintController.refresh(getGraphics());
			}
			
			public void mouseReleased(MouseEvent e) {
		        
				// draw a new shape
				if (paintController.getMode() == 0) {
					paintController.setDrawing(false);
					x = e.getX();
					y = e.getY();
					endPoint =new Point(x, y);
					paintController.currentShape.calculateDimensions(startPoint, endPoint);
					paintController.performCommand(new Draw(paintController, paintController.currentShape));
					startPoint = null;
					endPoint = null;
		        
					// get a new shape to draw after mouse released
					if (paintController.currentShape instanceof Ellipse)
						paintController.currentShape = new ShapeFactory().getShape("ELLIPSE");
					else if (paintController.currentShape instanceof Circle)
						paintController.currentShape = new ShapeFactory().getShape("CIRCLE");
					else if (paintController.currentShape instanceof Rectangle)
						paintController.currentShape = new ShapeFactory().getShape("RECTANGLE");
					else if (paintController.currentShape instanceof Square)
						paintController.currentShape = new ShapeFactory().getShape("SQUARE");
					else if (paintController.currentShape instanceof Triangle)
						paintController.currentShape = new ShapeFactory().getShape("TRIANGLE");
					else if (paintController.currentShape instanceof Line)
						paintController.currentShape = new ShapeFactory().getShape("LINE");
				}
				// selecting a shape
		    	else if (paintController.getMode() == 1) {
		    		paintController.selectShape(e.getX(), e.getY());
		    	}
				// editing the selected shape
				if (paintController.isShapeSelected())
				{
					// resize the selected shape
					if (paintController.getMode() == 2) {
						startPoint = new Point(e.getX(), e.getY());
						endPoint = startPoint;
					}
					// copy the selected shape
					else if (paintController.getMode() == 3) {
					}
					// move the selected shape
					else if (paintController.getMode() == 4) {
						
					}
					// re-color the selected shape
					else if (paintController.getMode() == 5) {
					}
					// delete the selected shape
					else if (paintController.getMode() == 6) {
					}
				}
				
				//refresh the drawing board
				paintController.refresh(getGraphics());
			}
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseDragged(MouseEvent e) {
				
				// draw a new shape
				if (paintController.getMode() == 0) {
					x = e.getX();
					y = e.getY();
					endPoint = new Point(x, y);
					paintController.currentShape.calculateDimensions(startPoint, endPoint);
				}
				// selecting a shape
		    	else if (paintController.getMode() == 1) {	
		    	}
				// editing the selected shape
				if (paintController.isShapeSelected())
				{
					// resize the selected shape
					if (paintController.getMode() == 2) {
						startPoint = new Point(e.getX(), e.getY());
						endPoint = startPoint;
					}
					// copy the selected shape
					else if (paintController.getMode() == 3) {
					}
					// move the selected shape
					else if (paintController.getMode() == 4) {
						
					}
					// re-color the selected shape
					else if (paintController.getMode() == 5) {
					}
					// delete the selected shape
					else if (paintController.getMode() == 6) {
					}
				}
				
				// refresh the drawing board
				paintComponent(getGraphics());
				paintController.refresh(getGraphics());
			}
		});
	}
}
	
	 
	/*ArrayList <Point> Points = new ArrayList<Point>();
 
 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		 
	    Color colour = Color.black;
	    g.setColor(colour);
	    ((Graphics2D) g).setStroke(new BasicStroke(2));
	    for(int i=0; i<Points.size()-1; i++) {
	    	Point p1 = null, p2= null;
			p1 = Points.get(i);
			p2 = Points.get(i+1);
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
		}
	       
    }*/


	
/*
	@Override
	public void mouseClicked(MouseEvent e) {

		x = e.getX();
        y = e.getY();
        startPoint = new Point(x, y);
        endPoint = startPoint;
    	paintController.setDrawing(true);
        if (paintController.isBrush())
        	Points.add(new Point(x, y));
        else {
        	paintController.currentShape.setPosition(startPoint);
        	paintController.currentShape.setEndPoint(endPoint);
        }
        paintController.refresh(this.getGraphics());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	*/	// TODO Auto-generated method stub
		/*x = arg0.getX();
        y = arg0.getY();
        Points.add(new Point(x, y));
        repaint();*/
		
/*
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub	
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

        x = e.getX();
        y = e.getY();
        endPoint =new Point(x, y);
        paintController.setDrawing(false);
        if (paintController.isBrush()) {
        	Points.add(new Point(x, y));
        }
        else {
        	paintController.currentShape.setEndPoint(endPoint);
        	paintController.currentShape.setColor(paintFrame.strokeColor);
        	paintController.currentShape.setFillColor(paintFrame.fillColor);
        	paintController.addShape(paintController.currentShape);
        }
        startPoint = null;
        endPoint = null;
        paintController.refresh(this.getGraphics());
	}

	@Override
	public void mouseDragged(MouseEvent e) {

        x = e.getX();
        y = e.getY();
        endPoint = new Point(x, y);
        if (paintController.isBrush()) {
        	Points.add(new Point(x, y));
        }
        else {
        	paintController.currentShape.setEndPoint(endPoint);
        }
        startPoint = null;
        endPoint = null;
        paintController.refresh(this.getGraphics());
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}*/
