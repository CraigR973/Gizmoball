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
import model.Model1;
import model.Triangle;


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
//		
//		Ball1 b = gm.getBall();
//		if (b != null) {
//			g2.setColor(b.getColour());
//			int x = (int) (b.getExactX() - b.getRadius());
//			int y = (int) (b.getExactY() - b.getRadius());
//			int width = (int) (2 * b.getRadius());
//			g2.fillOval(x, y, width, width);
//		}
//		
//		Absorber abs = gm.getAbsorber();
//		if(abs != null){
//			g2.setColor(abs.getColour());
//			int x = (int)abs.getXPos();
//			int y = (int)abs.getYPos();
//			int width = (int)abs.getWidth();
//			int height = (int)abs.getHeight();
//			g2.fillRect(x, y, width, height);
//		}
//		
//		Triangle tri = gm.getTriangle();
//		if(tri != null){
//			g2.setColor(tri.getColour());
//			int x1 = (int)tri.getXpos1();
//			int x2 = (int)tri.getXpos2();
//			int x3 = (int)tri.getXpos3();
//			int y1 = (int)tri.getYpos1();
//			int y2 = (int)tri.getYpos2();
//			int y3 = (int)tri.getYpos3();
//			g2.drawPolygon(new int[] {x1, x2, x3}, new int[] {y1,y2,y3}, 3);
//			g2.fillPolygon(new int[] {x1, x2, x3}, new int[] {y1,y2,y3}, 3);
//		}
//		
//		Triangle tri1 = gm.getTriangle1();
//		if(tri1 != null){
//			g2.setColor(tri1.getColour());
//			int x1 = (int)tri1.getXpos1();
//			int x2 = (int)tri1.getXpos2();
//			int x3 = (int)tri1.getXpos3();
//			int y1 = (int)tri1.getYpos1();
//			int y2 = (int)tri1.getYpos2();
//			int y3 = (int)tri1.getYpos3();
//			g2.drawPolygon(new int[] {x1, x2, x3}, new int[] {y1,y2,y3}, 3);
//			g2.fillPolygon(new int[] {x1, x2, x3}, new int[] {y1,y2,y3}, 3);
//		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
			repaint();
		}
	
}
