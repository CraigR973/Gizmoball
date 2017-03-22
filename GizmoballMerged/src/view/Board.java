package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Absorber;
import model.Ball;
import model.Model;
import model.RightFlipper;
import model.SquareGizmo;
import model.TriangleGizmo;
import model.CircleGizmo;
import model.LeftFlipper;

public class Board extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	protected int width;
	protected int height;
	protected Model gm;
	private boolean buildMode = false;

	private boolean keyPress = false;

	public Board(int w, int h, Model m) {
		
		m.addObserver(this);
		width = w;
		height = h;
		gm = m;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		if (buildMode == true) {
		//	g2.setColor(Color.GRAY);
			for (int i = 0; i < 500; i += 20) {
				g2.fillRect(i, 0, 1, 400);
			}
			for (int i = 0; i < 500; i += 20) {
				g2.fillRect(0, i, 400, 1);
			}
		}

		for (int i = 0; i < gm.getBalls().size(); i++) {
			Ball b = gm.getBalls().get(i);
			if (b != null) {
				g2.setColor(b.getColour());
				int x = (int) (b.getExactX() - b.getRadius());
				int y = (int) (b.getExactY() - b.getRadius());
				int width = (int) (2 * b.getRadius());
				g2.fillOval(x, y, width, width);
			}
		}

		for (int i = 0; i < gm.getAbs().size(); i++) {
			Absorber abs = gm.getAbs().get(i);
			if (abs != null) {
				g2.setColor(abs.getColour());
				int x = (int) abs.getXPos();
				int y = (int) abs.getYPos();
				int width = (int) abs.getWidth();
				int height = (int) abs.getHeight();
				g2.fillRect(x, y, width, height);
			}
		}

		for (int i = 0; i < gm.getTriangles().size(); i++) {
			TriangleGizmo tri = gm.getTriangles().get(i);
			if (tri != null) {
					g2.setColor(tri.getColour());
					int x1 = (int) tri.getXpos1();
					int x2 = (int) tri.getXpos2();//-20;
					int x3 = (int) tri.getXpos3();
					int y1 = (int) tri.getYpos1();//+20;
					int y2 = (int) tri.getYpos2();
					int y3 = (int) tri.getYpos3();//-20;
					g2.drawPolygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);
					g2.fillPolygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);
			}
		}

		for (int i = 0; i < gm.getSquares().size(); i++) {
			SquareGizmo sq = gm.getSquares().get(i);
			if (sq != null) {
				g2.setColor(sq.getColour());
				int x = (int) sq.getXPos();
				int y = (int) sq.getYPos();
				int width = (int) sq.getWidth();
				int height = (int) sq.getHeight();
				g2.fillRect(x, y, width, height);
			}
		}

		for (int i = 0; i < gm.getCircles().size(); i++) {
			CircleGizmo cir = gm.getCircles().get(i);
			if (cir != null) {
				g2.setColor(cir.getColour());
				int x = (int) (cir.getExactX() - cir.getRadius());
				int y = (int) (cir.getExactY() - cir.getRadius());
				int width = (int) (2 * cir.getRadius());
				g2.fillOval(x, y, width, width);
			}
		}

		for (int i = 0; i < gm.getLFlipper().size(); i++) {
			LeftFlipper lf = gm.getLFlipper().get(i);
			if (lf != null) {
				g2.setColor(lf.getColour());
				int x = (int) lf.getXPos();
				int y = (int) lf.getYPos();
				int width = (int) lf.getWidth();
				int height = (int) lf.getHeight();
				g2.fillRoundRect(x, y, width, height, 15, 15);
			}
		}

		for (int i = 0; i < gm.getRFlipper().size(); i++) {
			RightFlipper rf = gm.getRFlipper().get(i);
			if (rf != null) {
				g2.setColor(rf.getColour());
				int x = (int) rf.getXPos();
				int y = (int) rf.getYPos();
				int width = (int) rf.getWidth();
				int height = (int) rf.getHeight();
				g2.fillRoundRect(x, y, width, height, 15, 15);
			}
		}

		if (buildMode == false) {
			g2.setColor(Color.BLACK);
			for (int i = 0; i < 500; i += 20) {
				g2.fillRect(i, 0, 1, 500);
			}
			for (int i = 0; i < 500; i += 20) {
				g2.fillRect(0, i, 500, 1);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

	public void flipMode(boolean mode) {
		buildMode = mode;
		if (buildMode == true) {
			buildMode = false;
		} else {
			buildMode = true;
		}
		this.repaint();
	}
	
	public void rotateLeftFlipper(Graphics2D g2, LeftFlipper lFlip, int x, int y, int h, int w) {
		g2.setColor(lFlip.getColour());
		g2.fillRoundRect(x, y, h, w, w / 2, h / 2);
		g2.dispose();
	}

	public void stopRotateLeftFlipper(Graphics2D g2, LeftFlipper lFlip, int x, int y, int h, int w) {
		g2.setColor(lFlip.getColour());
		g2.fillRoundRect(x, y, w, h, w / 2, h / 2);
		g2.dispose();
	}
	
	public void keyPressDetect() {
		keyPress = true;
	}

	public void keyPressDetectNon() {
		keyPress = false;
	}
}