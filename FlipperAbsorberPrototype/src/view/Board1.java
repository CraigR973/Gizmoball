package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Absorber;
import model.Ball1;
import model.LeftFlipper;
import model.Model1;
//import model.VerticalLine;
import model.VerticalLine;
import model.VerticalLine1;
import physics.Geometry;
import physics.LineSegment;


public  class Board1 extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	protected int width;
	protected int height;
	protected Model1 gm;
	private int angle;
	int offset = 5;
	private AffineTransform transform;
	


	public Board1(int w, int h, Model1 m) {
		// Observe changes in Model
		m.addObserver(this);
		width = w;
		height = h;
		gm = m;
		transform = new AffineTransform();
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	

	// Fix onscreen size
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
	
/*	public void createTransformedShape() {
		Rectangle2D myRect = new Rectangle2D.Double(100, 100, 200, 200);
		AffineTransform at = AffineTransform.getRotateInstance(Math.PI / 4, 150, 150);
		Shape rotatedRect = at.createTransformedShape(myRect);
	} */
	
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Rectangle rect = new Rectangle(100, 100, 100, 100);
		


		Graphics2D g2 = (Graphics2D) g;
		
/*transform.setToTranslation((rect.getWidth() - width) / 2, (lFlip.getHeight() - height) / 2);
		
		transform.rotate(Math.toRadians(angle), width / 2, height / 2); */
		
		
		
		//VerticalLine1 bot = gm.getLine();
		// Draw all the vertical lines
		//for (VerticalLine vl : gm.getLines()) {
		//	g2.fillRect(bot.getX(), bot.getY(), bot.getWidth(), 1);
		//}
		
		Ball1 b = gm.getBall();
		if (b != null) {
			g2.setColor(b.getColour());
			int x = (int) (b.getExactX() - b.getRadius());
			int y = (int) (b.getExactY() - b.getRadius());
			int width = (int) (2 * b.getRadius());
			g2.fillOval(x, y, width, width);
		}
		
		Absorber abs = gm.getAbsorber();
		if(abs != null){
			g2.setColor(abs.getColour());
			int x = (int)abs.getXPos();
			int y = (int)abs.getYPos();
			int width = (int)abs.getWidth();
			int height = (int)abs.getHeight();
			g2.fillRect(x, y, width, height);
		}
		
		LeftFlipper lFlip = gm.getLeftFlipper();
		if(lFlip != null){
			g2.setColor(lFlip.getColour());
			int x = (int)lFlip.getXPos();
			int y = (int)lFlip.getYPos();
			int width = (int)lFlip.getWidth();
			int height = (int)lFlip.getHeight();
		//	AffineTransform oldTransform = g2.getTransform();
		//	g2.setTransform(AffineTransform.getRotateInstance(Math.PI/180));
	//transform.setToTranslation((lFlip.getWidth() - width) / 2, (lFlip.getHeight() - height) / 2);
			
	//		transform.rotate(Math.toRadians(angle), width / 2, height / 2);

			//g2.fillRoundRect(x, y, width, height, width, height);
	//		g2.draw(lFlip, transform, this); 
	//		g2.fillRoundRect(x, y, width, height, width, height);
			g2.draw(createRotated());
		//	g2.setTransform(oldTransform); 
			
		}
			
			
	/*	transform.setToTranslation((lFlip.getWidth() - width) / 2, (lFlip.getHeight() - height) / 2);
			
			transform.rotate(Math.toRadians(angle), width / 2, height / 2);

			//g2.fillRoundRect(x, y, width, height, width, height);
			g2.drawImage(lFlip, transform, this); 
		 
		 
/*		VerticalLine1 line = gm.getVerticalLine1();
		if(line != null){
			g2.setColor(line.getColour());
			int x = (int)line.getX();
			int y = (int)line.getY();
			int height = (int)line.getHeight();
			g2.fillRect(x, y, 1, height);

			g2.fillRoundRect(x, y, width, height, width, height); 

		}  */
		
		
	}
	
	public Shape createRotated() {
		RoundRectangle2D lFlipr = new RoundRectangle2D.Float(20, 100, 50, 100, 100, 100);
		AffineTransform at = AffineTransform.getRotateInstance(Math.PI / 4, 150, 150);
		Shape rotatedFlipper = at.createTransformedShape(lFlipr);
		
		return rotatedFlipper;
	} 
	
	public void rotate() {
		angle -= offset;
		if (angle <= 0) {
			angle = 270;
		}
		repaint();
	}
	 

	@Override
	public void update(Observable arg0, Object arg1) {
			repaint();
		}
	
}
