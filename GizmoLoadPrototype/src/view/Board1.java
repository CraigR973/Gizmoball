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
import model.Circle1;
import model.LeftFlipper;
import model.Model1;
import model.RightFlipper;
import model.Square;
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
		String shape = "Square";
		
		if(shape.equals("Square"))
		{for (Square sq : gm.getSquare()) {
			g2.setColor(sq.getColour());
			g2.fillRect((int)sq.getXPos(), (int)sq.getYPos(), (int)sq.getWidth(), (int)sq.getHeight());
		}
		
		String shape1 = "Circle";
		if(shape1.equals("Circle"))
		{for (Circle1 c: gm.getCircle()) {
			g2.setColor(c.getColour());
			int width = (int) (2 * (int)c.getRadius());
			g2.fillOval((int)c.getExactX(), (int)c.getExactY(), width, width);
		}
		
		String shape2 = "Triangle";
		if(shape2.equals("Triangle"))
		{for (Triangle t: gm.getTriangle()) {
			g2.setColor(t.getColour());
			int x1 = (int)t.getXpos1();
			int x2 = (int)t.getXpos2();
			int x3 = (int)t.getXpos3();
			int y1 = (int)t.getYpos1();
			int y2 = (int)t.getYpos2();
			int y3 = (int)t.getYpos3();
			g2.drawPolygon(new int[] {x1, x2, x3}, new int[] {y1,y2,y3}, 3);
			g2.fillPolygon(new int[] {x1, x2, x3}, new int[] {y1,y2,y3}, 3);
		}
		
		String shape3 = "Absorber";
		if(shape3.equals("Absorber"))
		{for (Absorber a: gm.getAbsorber()) {
			g2.setColor(a.getColour());
			int x = (int)a.getXPos();
			int y = (int)a.getYPos();
			int width = (int)a.getWidth();
			int height = (int)a.getHeight();
			g2.fillRect(x, y, width, height);
		}
		
		String shape4 = "LeftFlipper";
		if(shape4.equals("LeftFlipper"))
		{for (LeftFlipper lf: gm.getLFlipper()) {
			g2.setColor(lf.getColour());
			int x = (int)lf.getXPos();
			int y = (int)lf.getYPos();
			int width = (int)lf.getWidth();
			int height = (int)lf.getHeight();
			g2.fillRoundRect(x, y, width, height, 15, 15);
		}
		
		String shape5 = "RightFlipper";
		if(shape5.equals("RightFlipper"))
		{for (RightFlipper rf: gm.getRFlipper()) {
			g2.setColor(rf.getColour());
			int x = (int)rf.getXPos();
			int y = (int)rf.getYPos();
			int width = (int)rf.getWidth();
			int height = (int)rf.getHeight();
			g2.fillRoundRect(x, y, width, height, 15, 15);
		}
		
		String shape6 = "Ball";
		if(shape6.equals("Ball"))
		{for (Ball1 b: gm.getBall()) {
			g2.setColor(b.getColour());
			int x = (int) (b.getExactX() - b.getRadius());
			int y = (int) (b.getExactY() - b.getRadius());
			int width = (int) (2 * b.getRadius());
			g2.fillOval(x, y, width, width);
		}


		}
	}
		}
		}
		}
		}
		}
	}
		
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
//	}

	@Override
	public void update(Observable arg0, Object arg1) {
			repaint();
		}
	
	public void addShape(String shape){
	}
	
}
