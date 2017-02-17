package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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


	public Board1(int w, int h, Model1 m) {
		// Observe changes in Model
		m.addObserver(this);
		width = w;
		height = h;
		gm = m;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	// Fix onscreen size
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
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
			g2.fillRoundRect(x, y, width, height, width, height);
		}
		
		
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
			repaint();
		}
	
}
