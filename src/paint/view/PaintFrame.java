package paint.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

import paint.controller.PaintController;

@SuppressWarnings("serial")
public class PaintFrame extends JFrame {

	protected PaintController paintController;
	private PaintPanel paintPanel;
	
	JPanel bottomPanel;
	JPanel leftPanel1;
	JPanel leftPanel2;
	
	JTabbedPane tabbedPane ;
    //left panel1 contains :
	JButton btnLine;
	JButton btnEllipse;
	JButton btnRectangle;
	JButton btnTriangle;
	JButton btnSquare;
	JButton btnCircle;
	JButton btnBrush;
	//bottom panel contains :
	JButton btnColor;
	JButton btnFill;
	JButton btnRedo;
	JButton btnUndo;
	JButton btnClear;
	//left panel2 contains :
	JButton btnResize;
	JButton btnCopy;
	JButton btnSelect;
	JButton btnDelete;
	JButton btnMove;
	JButton btnRecolor;

	public Color strokeColor=Color.BLACK, fillColor=Color.BLACK;
    //left panel 1 icons
	ImageIcon iconLine;
	ImageIcon iconEllipse;
	ImageIcon iconRectangle;
	ImageIcon iconTriangle;
	ImageIcon iconSquare;
	ImageIcon iconCircle;
	ImageIcon iconBrush;
	//bottom panel 2 icons
	ImageIcon iconColor;
	ImageIcon iconFill;
	ImageIcon iconUndo;
	ImageIcon iconRedo;
	ImageIcon iconClear;
	//left panel 2 icons
	ImageIcon iconResize;
	ImageIcon iconCopy;
	ImageIcon iconSelect;
	ImageIcon iconDelete;
	ImageIcon iconMove;
	ImageIcon iconRecolor;

	Box hBox; 
	Box vBox1;
	Box vBox2;
	
	ColorIcon colorIcon;
	ColorIcon fillIcon;
	
	public PaintFrame(PaintController paintController) {
		
		this.paintController = paintController;
		paintPanel = new PaintPanel(paintController);
		setupFrame();
	}
	
	private void setupFrame() {
		PaintPanel drawingBoard;
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();	
		Border compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		compound = BorderFactory.createCompoundBorder(blackline, compound);	
		((JComponent) this.getContentPane()).setBorder(compound);
		
		this.setSize(800, 600);
        this.setTitle("Magnum Paint");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
         colorIcon = new ColorIcon(Color.black);
         fillIcon = new ColorIcon(Color.black);

		 bottomPanel=new JPanel();		
		 leftPanel1=new JPanel();
		 leftPanel2=new JPanel();
		 tabbedPane = new JTabbedPane();
		 //left panel1
		 iconLine = new ImageIcon("Line.jpg");
		 iconEllipse = new ImageIcon("Ellipse.jpg");
		 iconRectangle = new ImageIcon("Rectangle.jpg");
		 iconTriangle = new ImageIcon("Triangle.jpg");
		 iconSquare = new ImageIcon("Square.jpg");
		 iconCircle = new ImageIcon("Circle.jpg");
		 iconBrush = new ImageIcon("brush.jpg");
		 //bottom panel
		 iconUndo = new ImageIcon("undo.jpg");
		 iconRedo = new ImageIcon("redo.jpg");
		 iconColor = new ImageIcon("color.png");
		 iconFill = new ImageIcon("fill.png");
		 iconClear = new ImageIcon("clear.png");
		 //left panel2
		 iconResize= new ImageIcon("resize.jpg");
		 iconCopy = new ImageIcon("copy.png");
		 iconSelect = new ImageIcon("select.jpg");
		 iconDelete = new ImageIcon("delete.png");
		 iconMove = new ImageIcon("move.jpg");
		 iconRecolor = new ImageIcon("recolor.png");
		 //left panel1  
		 btnLine = new JButton();
	     btnEllipse = new JButton();
	     btnBrush = new JButton();
	     btnRectangle = new JButton();
	     btnTriangle = new JButton();
	     btnSquare = new JButton();
	     btnCircle = new JButton();
	     //bottom panel
	     btnRedo = new JButton();
	     btnUndo = new JButton();
		 btnFill = new JButton();
		 btnColor = new JButton();
		 btnClear = new JButton();
		 //left panel2
		 btnResize= new JButton();
		 btnCopy = new JButton();
	     btnSelect = new JButton();
		 btnDelete = new JButton();
		 btnMove = new JButton();
		 btnRecolor = new JButton();
	     //left panel1
		 btnLine.setBackground(Color.WHITE);
		 btnEllipse.setBackground(Color.WHITE);
		 btnRectangle.setBackground(Color.WHITE);
		 btnTriangle.setBackground(Color.WHITE);
		 btnSquare.setBackground(Color.WHITE);
		 btnCircle.setBackground(Color.WHITE);
		 btnBrush.setBackground(Color.WHITE);
		 //bottom panel
		 btnUndo.setBackground(Color.WHITE);
		 btnRedo.setBackground(Color.WHITE);
		 btnColor.setBackground(Color.WHITE);
		 btnFill.setBackground(Color.WHITE);
		 btnClear.setBackground(Color.WHITE);
		 //left panel2
		 btnResize.setBackground(Color.WHITE);
		 btnCopy.setBackground(Color.WHITE);
		 btnSelect.setBackground(Color.WHITE);
		 btnDelete.setBackground(Color.WHITE);
		 btnMove.setBackground(Color.WHITE);
		 btnRecolor.setBackground(Color.WHITE);
		 //left panel1
		 btnLine.setBounds(200,200,50,50);
		 btnEllipse.setBounds(200,200,50,50);
		 btnRectangle.setBounds(200,200,50,50);
		 btnTriangle.setBounds(200,200,50,50);
		 btnSquare.setBounds(200,200,50,50);
		 btnCircle.setBounds(200,200,50,50);
		 btnBrush.setBounds(200,200,50,50);
		 //bottom panel
		 btnUndo.setBounds(200,200,50,50);
		 btnRedo.setBounds(200,200,50,50);
		 btnColor.setBounds(200,200,50,50);
		 btnFill.setBounds(200,200,50,50);
		 btnClear.setBounds(200,200,50,50);
		 //left panel2
		 btnResize.setBounds(200,200,50,50);
		 btnCopy.setBounds(200,200,50,50);
		 btnSelect.setBounds(200,200,50,50);
		 btnDelete.setBounds(200,200,50,50);
		 btnMove.setBounds(200,200,50,50);
		 btnRecolor.setBounds(200,200,50,50);
		 
         //left panel1
		 int btnL = btnLine.getInsets().left;
		 btnLine.setIcon(resizeIcon(iconLine, btnLine.getWidth() - btnL, btnLine.getHeight() - btnL));
		 int btnE = btnLine.getInsets().left;
		 btnEllipse.setIcon(resizeIcon(iconEllipse, btnEllipse.getWidth() - btnE, btnEllipse.getHeight() - btnE));
		 int btnR = btnLine.getInsets().left;
		 btnRectangle.setIcon(resizeIcon(iconRectangle, btnRectangle.getWidth() - btnL, btnRectangle.getHeight() - btnR));
		 int btnS = btnSquare.getInsets().left;
		 btnSquare.setIcon(resizeIcon(iconSquare, btnSquare.getWidth() - btnS, btnSquare.getHeight() - btnS));
		 int btnT = btnTriangle.getInsets().left;
		 btnTriangle.setIcon(resizeIcon(iconTriangle, btnTriangle.getWidth() - btnT, btnTriangle.getHeight() - btnT));
		 int btnC = btnCircle.getInsets().left;
		 btnCircle.setIcon(resizeIcon(iconCircle, btnCircle.getWidth() - btnC, btnCircle.getHeight() - btnC));
		 int btnB = btnBrush.getInsets().left;
		 btnBrush.setIcon(resizeIcon(iconBrush, btnBrush.getWidth() - btnB, btnBrush.getHeight() - btnB));
		 //bottom panel
		 int btnU = btnUndo.getInsets().bottom;
		 btnUndo.setIcon(resizeIcon(iconUndo, btnUndo.getWidth() - btnU, btnUndo.getHeight() - btnU));
		 int btnRe = btnRedo.getInsets().bottom;
		 btnRedo.setIcon(resizeIcon(iconRedo, btnRedo.getWidth() - btnRe, btnRedo.getHeight() - btnRe));
		 int btnCo = btnColor.getInsets().bottom;
		 btnColor.setIcon(resizeIcon(iconColor, btnColor.getWidth() - btnCo, btnColor.getHeight() - btnCo));
		 int btnF = btnFill.getInsets().bottom;
		 btnFill.setIcon(resizeIcon(iconFill, btnFill.getWidth() - btnF, btnFill.getHeight() - btnF));
		 int btnCl = btnClear.getInsets().bottom;
		 btnClear.setIcon(resizeIcon(iconClear, btnClear.getWidth() - btnCl, btnClear.getHeight() - btnCl));
		 //left panel2
		 int btnRes = btnResize.getInsets().left;
		 btnResize.setIcon(resizeIcon(iconResize, btnResize.getWidth() - btnRes, btnResize.getHeight() - btnRes));
		 int btnCop = btnCopy.getInsets().left;
		 btnCopy.setIcon(resizeIcon(iconCopy, btnCopy.getWidth() - btnCop, btnCopy.getHeight() - btnCop));
		 int btnSel = btnSelect.getInsets().left;
		 btnSelect.setIcon(resizeIcon(iconSelect, btnSelect.getWidth() - btnSel, btnSelect.getHeight() - btnSel));
		 int btnD= btnDelete.getInsets().left;
		 btnDelete.setIcon(resizeIcon(iconDelete, btnDelete.getWidth() - btnD, btnDelete.getHeight() - btnD));
		 int btnM = btnMove.getInsets().left;
		 btnMove.setIcon(resizeIcon(iconMove, btnMove.getWidth() - btnM, btnMove.getHeight() - btnM));
		 int btnRec = btnRecolor.getInsets().left;
		 btnRecolor.setIcon(resizeIcon(iconRecolor, btnRecolor.getWidth() - btnRec, btnRecolor.getHeight() - btnRec));
		 
		 ColorButton(btnColor,true);
	     ColorButton(btnFill,false);
	     
		 hBox = Box.createHorizontalBox();
		 vBox1 = Box.createVerticalBox();
		 vBox2 = Box.createVerticalBox();
					
		 vBox1.add(btnBrush);
		 vBox1.add(btnLine);
		 vBox1.add(btnCircle);
		 vBox1.add(btnEllipse);
		 vBox1.add(btnSquare);
		 vBox1.add(btnRectangle);
		 vBox1.add(btnTriangle);
		 
		 vBox2.add(btnSelect);
		 vBox2.add(btnResize);
		 vBox2.add(btnCopy);
		 vBox2.add(btnMove);
		 vBox2.add(btnRecolor);
		 vBox2.add(btnDelete);
		 
		 hBox.add(btnClear);
		 hBox.add(btnUndo);
		 hBox.add(btnRedo);
		 hBox.add(btnColor);
		 hBox.add(new JLabel(colorIcon));
		 hBox.add(btnFill);
		 hBox.add(new JLabel(fillIcon));
			 	    		
		 bottomPanel.add(hBox);
		 leftPanel1.add(vBox1);
		 leftPanel2.add(vBox2);
	     
	     compound = BorderFactory.createCompoundBorder(blackline, compound);	
		 hBox.setBorder(compound);
		 vBox1.setBorder(compound);
		 vBox2.setBorder(compound);
		 drawingBoard=new PaintPanel();
		 drawingBoard.setBorder(compound);
		 tabbedPane.add(leftPanel1);
		 tabbedPane.add(leftPanel2);
	     
		 this.add(bottomPanel, BorderLayout.SOUTH);
		 this.add(tabbedPane, BorderLayout.WEST);
		 this.getRootPane().setDefaultButton(btnBrush);
		 this.add(drawingBoard, BorderLayout.CENTER);
		 this.setJMenuBar(createMenuBar());
		 this.pack();
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

	public JButton ColorButton (JButton theBut,final boolean stroke){
 
		theBut.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			
				if(stroke){
					strokeColor = JColorChooser.showDialog(null,  "Pick a Stroke", Color.BLACK);
			            if (strokeColor != null) {
			                colorIcon.setColor(strokeColor);
			                repaint(); }
				} else {
				
					fillColor = JColorChooser.showDialog(null,  "Pick a Fill", Color.BLACK);
					 if (fillColor != null) {
			                fillIcon.setColor(fillColor);
			                repaint();  }
				}
			}
				});
		return theBut;  
		}
	
	public JMenuBar createMenuBar() {
		 
        JMenuBar menuBar;
        JMenu menu,saveMenu;
        ImageIcon iconOpen,iconNew,iconSave;
        JMenuItem menuItem;
 
        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the File Menu.
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        /*menu.getAccessibleContext().setAccessibleDescription("Dealing with Files");*/
        menuBar.add(menu);
 
        //a group of JMenuItems
        iconNew =new ImageIcon("new.jpg");
        menuItem = new JMenuItem("New",iconNew);
        menuItem.setBounds(200,200,30,30);
        int btnN = menuItem.getInsets().left;
		menuItem.setIcon(resizeIcon(iconNew,menuItem.getWidth() - btnN, menuItem.getHeight() - btnN));
        menuItem.setMnemonic(KeyEvent.VK_P);
        /*menuItem.getAccessibleContext().setAccessibleDescription("New");*/
        menu.add(menuItem);
 
        iconOpen =new ImageIcon("open.jpg");
        menuItem = new JMenuItem("Open",iconOpen);
		menuItem.setBounds(200,200,30,30);
        int btnO = menuItem.getInsets().left;
		menuItem.setIcon(resizeIcon(iconOpen,menuItem.getWidth() - btnO, menuItem.getHeight() - btnO));
        menuItem.setMnemonic(KeyEvent.VK_F);
        menu.add(menuItem);
       
        menu.addSeparator();
        saveMenu = new JMenu("Save As");
        iconSave =new ImageIcon("save.jpg");
        saveMenu.setBounds(200,200,30,30);
        int btnSa = saveMenu.getInsets().left;
        saveMenu.setIcon(resizeIcon(iconSave,saveMenu.getWidth() - btnSa, saveMenu.getHeight() - btnSa));
        saveMenu.setMnemonic(KeyEvent.VK_S);
 
        menuItem = new JMenuItem("XML");
        saveMenu.add(menuItem);
 
        menuItem = new JMenuItem("Json");
        saveMenu.add(menuItem);
        
        /*menuItem = new JMenuItem("JPG");
        saveMenu.add(menuItem);*/
        
        menu.add(saveMenu);

        return menuBar;
 
    }
	
	private Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();  
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
		return new ImageIcon(resizedImage);
	    }
		
	  class ColorIcon implements Icon {

        private static final int WIDE = 55;
        private static final int HIGH = 55;
        private Color color;

        public ColorIcon(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(color);
            g.fillRect(x, y, WIDE, HIGH);
        }

        public int getIconWidth() {
            return WIDE;
        }

        public int getIconHeight() {
            return HIGH;
        }
    }
}
