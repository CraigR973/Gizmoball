package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Absorber;
import model.Ball;
import model.Model;
import model.TriangleGizmo;

public class Board extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	protected int width;
	protected int height;
	protected Model gm;
	private RoundRectangle2D rr = new RoundRectangle2D.Float(100, 100, 240, 160, 10, 10);

	public Board(int w, int h, Model m) {
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

		Ball b = gm.getBall();
		if (b != null) {
			g2.setColor(b.getColour());
			int x = (int) (b.getExactX() - b.getRadius());
			int y = (int) (b.getExactY() - b.getRadius());
			int width = (int) (2 * b.getRadius());
			g2.fillOval(x, y, width, width);
		}

		Absorber abs = gm.getAbsorber();
		if (abs != null) {
			g2.setColor(abs.getColour());
			int x = (int) abs.getXPos();
			int y = (int) abs.getYPos();
			int width = (int) abs.getWidth();
			int height = (int) abs.getHeight();
			g2.fillRect(x, y, width, height);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}
}
