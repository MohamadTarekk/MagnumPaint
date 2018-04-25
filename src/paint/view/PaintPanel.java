package paint.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;

import paint.controller.PaintController;

@SuppressWarnings("serial")
public class PaintPanel extends JPanel implements MouseListener , MouseMotionListener {

	@SuppressWarnings("unused")
	private PaintController paintController;
	
	public PaintPanel(PaintController paintController) {
		
		this.paintController = paintController;
	}
	
	private int x, y;
	 
	ArrayList <Point> Points = new ArrayList<Point>();
 
	public PaintPanel() {
		setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize( new Dimension( 800, 400 ) );
    }
 
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
	       
      }

	
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x = arg0.getX();
        y = arg0.getY();
        Points.add(new Point(x, y));
        repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x = arg0.getX();
        y = arg0.getY();
        Points.add(new Point(x, y));
        repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub	
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
        x = arg0.getX();
        y = arg0.getY();
        Points.add(new Point(x, y));
        repaint();		
        
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub
        x = arg0.getX();
        y = arg0.getY();
        Points.add(new Point(x, y));
        repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
