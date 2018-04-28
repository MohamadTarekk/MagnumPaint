package paint.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import paint.controller.ChangeColor;
import paint.controller.Clear;
import paint.controller.Copy;
import paint.controller.Delete;
import paint.controller.PaintController;
import paint.controller.Resize;
import paint.model.Line;
import paint.model.ShapeFactory;

@SuppressWarnings("serial")
public class PaintFrame extends JFrame {

	protected PaintController paintController;
	
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

	Color trans = new Color(0.0f, 0.0f, 0.0f, 0.0f);
	public Color strokeColor=Color.black, fillColor=trans;
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
	
	public void blowUp(PaintController thecontroller) {
		paintController = thecontroller;
		setupFrame();
	}
	public PaintPanel drawingBoard;
	private void setupFrame() {
		drawingBoard = new PaintPanel(paintController, this);
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();	
		Border compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		compound = BorderFactory.createCompoundBorder(blackline, compound);	
		((JComponent) this.getContentPane()).setBorder(compound);
		
		this.setSize(800, 600);
        this.setTitle("Magnum Paint");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Panels initialization*/
        bottomPanel=new JPanel();		
		leftPanel1=new JPanel();
		leftPanel2=new JPanel();
		tabbedPane = new JTabbedPane();
		
		/* Initializing color icons*/
        colorIcon = new ColorIcon(Color.black);
        fillIcon = new ColorIcon(trans);
		
		/* Initializing image icons*/
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
		
		/* Initializing buttons*/
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
	    
		/* Setting buttons backgrounds*/
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
		
		/*Setting buttons size*/
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
		
		/* Filling buttons with image icons*/
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
		
		/* Initializing color buttons*/
		ColorButton(btnColor,true);
	    ColorButton(btnFill,false);
	    
	    /* Adding action listeners to the buttons*/
	    //left panel1
	    btnBrush.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				paintController.setShapeSelected(false);
				paintController.setMode(0);
				paintController.setCurrentShape(new ShapeFactory().getShape("BRUSH"));
			}
        });
	    btnLine.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				paintController.setShapeSelected(false);
				paintController.setMode(0);
				paintController.setCurrentShape(new ShapeFactory().getShape("LINE"));
			}
        });
	    btnCircle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				paintController.setShapeSelected(false);
				paintController.setMode(0);
				paintController.setCurrentShape(new ShapeFactory().getShape("CIRCLE"));
			}
        });
	    btnEllipse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				paintController.setShapeSelected(false);
				paintController.setMode(0);
				paintController.setCurrentShape(new ShapeFactory().getShape("ELLIPSE"));
			}
        });
	    btnSquare.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				paintController.setShapeSelected(false);
				paintController.setMode(0);
				paintController.setCurrentShape(new ShapeFactory().getShape("SQUARE"));
			}
        });
	    btnRectangle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				paintController.setShapeSelected(false);
				paintController.setMode(0);
				paintController.setCurrentShape(new ShapeFactory().getShape("RECTANGLE"));
			}
        });
	    btnTriangle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				paintController.setShapeSelected(false);
				paintController.setMode(0);
				paintController.setCurrentShape(new ShapeFactory().getShape("TRIANGLE"));
			}
        });
	    //left panel2
	    btnSelect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				paintController.setShapeSelected(false);
				paintController.setMode(1);
				paintController.refresh(drawingBoard.getGraphics());
			}
        });
	    btnResize.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(paintController.isShapeSelected() && !(paintController.currentShape instanceof Line)) {
					paintController.setMode(2);

					JFrame frame = new JFrame();
					JPanel calcPanel = new JPanel();
					
					frame.setSize(600, 100);
					frame.setTitle("Resize");
					
					JLabel widthLbl = new JLabel("New Width");
					JTextField lengthBtn  = new JTextField(10);
					JLabel heightLbl = new JLabel("New Height");
					JTextField widthBtn = new JTextField(10);
					JButton resizeBtn = new JButton("Resize");
					
					resizeBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							paintController.performCommand(new Resize(paintController, paintController.currentShape, 
									Double.parseDouble(lengthBtn.getText()), Double.parseDouble(widthBtn.getText())));
							paintController.refresh(drawingBoard.getGraphics());
							frame.dispose();
						}
					});
					
					calcPanel.add(widthLbl);
					calcPanel.add(lengthBtn);
					calcPanel.add(heightLbl);
					calcPanel.add(widthBtn);
					calcPanel.add(resizeBtn);
					
					lengthBtn.setText(""+paintController.currentShape.getWidth());
					widthBtn.setText(""+paintController.currentShape.getHeight());
					
					frame.setVisible(true);
					
					frame.add(calcPanel);

				}
			}
        });
	    btnCopy.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (paintController.isShapeSelected()) {
					paintController.performCommand(new Copy(paintController, paintController.currentShape));
					paintController.currentShape = paintController.getShapes()[0];
					paintController.refresh(drawingBoard.getGraphics());
					paintController.setMode(8); // the nothing mode
				}
			}
        });
	    btnMove.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if (paintController.isShapeSelected()) {
					paintController.setMode(3);
				}
			}
        });
	    btnRecolor.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if (paintController.isShapeSelected()) {
					paintController.performCommand(new ChangeColor(paintController, paintController.currentShape, strokeColor, fillColor));
					paintController.refresh(drawingBoard.getGraphics());
					paintController.setMode(8); // the nothing mode
				}
			}
        });
	    btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if (paintController.isShapeSelected()) {
					paintController.performCommand(new Delete(paintController, paintController.currentShape));
					paintController.setDrawing(false);
					paintController.setShapeSelected(false);
					paintController.refresh(drawingBoard.getGraphics());
					paintController.setMode(8); // the nothing mode
				}

			}
        });
	    //bottom panel
	    btnClear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				paintController.performCommand(new Clear(paintController));
				paintController.refresh(drawingBoard.getGraphics());
				paintController.setMode(8); // the nothing mode
			}
		});
	    btnUndo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				paintController.undo();
				paintController.setDrawing(false);
				paintController.setShapeSelected(false);
				paintController.refresh(drawingBoard.getGraphics());
				paintController.setMode(8); // the nothing mode
			}
		});
	    btnRedo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				paintController.redo();
				paintController.refresh(drawingBoard.getGraphics());
				paintController.setMode(8); // the nothing mode
			}
		});
	    
		/* Initializing boxes alignment*/
	    hBox = Box.createHorizontalBox();
		vBox1 = Box.createVerticalBox();
		vBox2 = Box.createVerticalBox();
				
		/*Adding buttons to boxes*/
		//left panel1 box
		//vBox1.add(btnBrush);
		vBox1.add(btnLine);
		vBox1.add(btnCircle);
		vBox1.add(btnEllipse);
		vBox1.add(btnSquare);
		vBox1.add(btnRectangle);
		vBox1.add(btnTriangle);
		//left panel2 box
		vBox2.add(btnSelect);
		vBox2.add(btnResize);
		vBox2.add(btnCopy);
		vBox2.add(btnMove);
		vBox2.add(btnRecolor);
		vBox2.add(btnDelete);
		//bottom panel box
		hBox.add(btnClear);
		hBox.add(btnUndo);
		hBox.add(btnRedo);
		hBox.add(btnColor);
		hBox.add(new JLabel(colorIcon));
		hBox.add(btnFill);
		hBox.add(new JLabel(fillIcon));
		
		/* Adding boxes to the panels*/
		bottomPanel.add(hBox);
		leftPanel1.add(vBox1);
		leftPanel2.add(vBox2);
	    
	    compound = BorderFactory.createCompoundBorder(blackline, compound);	
		hBox.setBorder(compound);
		vBox1.setBorder(compound);
		vBox2.setBorder(compound);
		drawingBoard.setBorder(compound);
		tabbedPane.add(leftPanel1);
		tabbedPane.add(leftPanel2);
	    
		/* Adding panels to the frame*/
		this.add(bottomPanel, BorderLayout.SOUTH);
		this.add(tabbedPane, BorderLayout.WEST);
		this.getRootPane().setDefaultButton(btnBrush);
		this.add(drawingBoard, BorderLayout.CENTER);
		this.setJMenuBar(createMenuBar());
		this.pack();
		this.setVisible(true);		 		
		 
	}

	public JButton ColorButton (JButton theBut,final boolean stroke){
 
		theBut.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(stroke){
					strokeColor = JColorChooser.showDialog(null,  "Pick a Stroke", trans);
			            if (strokeColor != null) {
			                colorIcon.setColor(strokeColor);
			                repaint(); }
				} else {
				
					fillColor = JColorChooser.showDialog(null,  "Pick a Fill", trans);
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
 
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the File Menu.
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        /*menu.getAccessibleContext().setAccessibleDescription("Dealing with Files");*/
        menuBar.add(menu);
 
        //a group of JMenuItems
        iconNew =new ImageIcon("new.jpg");
        JMenuItem itemNew = new JMenuItem("New",iconNew);
        itemNew.setBounds(200,200,30,30);
        int btnN = itemNew.getInsets().left;
        itemNew.setIcon(resizeIcon(iconNew,itemNew.getWidth() - btnN, itemNew.getHeight() - btnN));
        itemNew.setMnemonic(KeyEvent.VK_P);
        /*menuItem.getAccessibleContext().setAccessibleDescription("New");*/
        itemNew.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				//-----------------------------//
				/*ADD CREATING NEW DRAWING HERE*/
				//-----------------------------//
				paintController.newDrawing();
			}
        });
        menuItem = itemNew;
        menu.add(menuItem);
 
        final JMenuItem itemOpen;
        iconOpen =new ImageIcon("open.jpg");
        itemOpen = new JMenuItem("Open",iconOpen);
        itemOpen.setBounds(200,200,30,30);
        int btnO = itemOpen.getInsets().left;
        itemOpen.setIcon(resizeIcon(iconOpen,itemOpen.getWidth() - btnO, itemOpen.getHeight() - btnO));
        itemOpen.setMnemonic(KeyEvent.VK_F);
        final JFileChooser fc = new JFileChooser();
        itemOpen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				//---------------------------------//
				/*ADD OPENING EXISTING DRAWING HERE*/
				//---------------------------------//
                fc.setCurrentDirectory(new java.io.File("."));
                fc.setDialogTitle("Choose The File You Want To Open");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("XML and JSON FILES", "xml", "json");
                fc.setFileFilter(filter);
                //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                if (fc.showOpenDialog(itemOpen) == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(null, "Now Opening: " + fc.getSelectedFile().getAbsolutePath());
                }
                if (fc.getSelectedFile().getPath() != null) {
                	paintController.load(fc.getSelectedFile().getPath());
                	System.out.println(fc.getSelectedFile().getPath());
                }
			}
        });
        menuItem = itemOpen;
        menu.add(menuItem);
       
        menu.addSeparator();
        saveMenu = new JMenu("Save As");
        iconSave =new ImageIcon("save.jpg");
        saveMenu.setBounds(200,200,30,30);
        int btnSa = saveMenu.getInsets().left;
        saveMenu.setIcon(resizeIcon(iconSave,saveMenu.getWidth() - btnSa, saveMenu.getHeight() - btnSa));
        saveMenu.setMnemonic(KeyEvent.VK_S);
 
        final JMenuItem itemSaveXML;
        itemSaveXML = new JMenuItem("XML");
        final JFileChooser fc1 = new JFileChooser();
        itemSaveXML.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				//---------------------------------//
				/*ADD SAVING WITH JFileChooser HERE*/
				//---------------------------------//
                fc1.setCurrentDirectory(new java.io.File("."));
                fc1.setDialogTitle("Choose Where To Save Your XML File");
                fc1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (fc1.showOpenDialog(itemSaveXML) == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(null, "Saved As: " + fc1.getSelectedFile().getAbsolutePath() + ".xml");
                }
                if (fc1.getSelectedFile().getPath() != null) {
                	paintController.save(fc1.getSelectedFile().getPath() + ".xml");
                	System.out.println(fc1.getSelectedFile().getPath());
                }
			}
        });
        menuItem = itemSaveXML;
        saveMenu.add(menuItem);
 
        final JMenuItem itemSaveJSON;
        itemSaveJSON = new JMenuItem("JSON");
        final JFileChooser fc2 = new JFileChooser();
        itemSaveJSON.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				//---------------------------------//
				/*ADD SAVING WITH JFileChooser HERE*/
				//---------------------------------//
                fc2.setCurrentDirectory(new java.io.File("."));
                fc2.setDialogTitle("Choose Where To Save Your JSON");
                fc2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (fc2.showOpenDialog(itemSaveJSON) == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(null, "Saving As: " + fc2.getSelectedFile().getAbsolutePath() + ".json");
                }
                if (fc2.getSelectedFile().getPath() != null) {
                	paintController.save(fc2.getSelectedFile().getPath() + ".json");
                	System.out.println(fc2.getSelectedFile().getPath());
                }
			}
        });
        menuItem = itemSaveJSON;
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
		
	private class ColorIcon implements Icon {

        private static final int WIDE = 55;
        private static final int HIGH = 55;
        private Color color;

        public ColorIcon(Color color) {
            this.color = color;
        }

        /*public Color getColor() {
            return color;
        }*/

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
    
	/*private DecimalFormat format = new DecimalFormat("#.##");
	private JSlider widthSlider = new JSlider(1, 1500, 1);
	private JSlider	heightSlider = new JSlider(1, 1000, 1);
	private ListenForSlider widthListener, heightListener;
	private JLabel widthLabel = new JLabel("Width: 0");
	private JLabel heightLabel = new JLabel("Height: 0");
	private int width = 0;
	private int height = 0;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	private class ListenForSlider implements ChangeListener{
    	
    	// Called when the spinner is changed
    	
    	public void stateChanged(ChangeEvent e) {
    	
    		// Check if the source of the event was the button
    	
    		if(e.getSource() == heightSlider){
    	
    			// Change the value for the label next to the spinner
    			// Use decimal format to make sure only 2 decimals are ever displayed
    	
    			heightLabel.setText("Height: " + format.format(heightSlider.getValue()) );
    			
    			// Set the value for transparency for every shape drawn after
    			
    			height = (int) (heightSlider.getValue());
    			
    		}

    		if(e.getSource() == widthSlider){
    	    	
    			// Change the value for the label next to the spinner
    			// Use decimal format to make sure only 2 decimals are ever displayed
    	
    			widthLabel.setText("Width: " + format.format(widthSlider.getValue()) );
    			
    			// Set the value for transparency for every shape drawn after
    			
    			width = (int) (widthSlider.getValue());
    			
    		}

    	
    	}
    	
    }*/

}