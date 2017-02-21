package model;

import java.awt.Color;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

public class TriangleGizmo {
	private int xpos1;
	private int xpos2;
	private int xpos3;
	private int ypos1;
	private int ypos2;
	private int ypos3;
	private Color colour;
	private LineSegment ls1;
	private LineSegment ls2;
	private LineSegment ls3;
	private int width;
	private int height;

	// x1 = top left, x2 = bottom, x3 = top right, y1 = top left, y2 = bottom,
	// y3 = top right
	public TriangleGizmo(int x1, int y1, int w, int h) {
		xpos1 = x1;
		xpos2 = x1 + w;
		xpos3 = xpos2;
		ypos1 = y1;
		ypos2 = y1;
		ypos3 = ypos2 + h;
		width = w;
		height = h;
		colour = Color.YELLOW;
		ls1 = new LineSegment(x1, y1, xpos2, ypos2);
		ls2 = new LineSegment(xpos2, ypos2, xpos3, ypos3);
		ls3 = new LineSegment(x1, y1, xpos3, ypos3);
	}

	public Color getColour() {
		return colour;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getXpos1() {
		return xpos1;
	}

	public int getXpos2() {
		return xpos2;
	}

	public int getXpos3() {
		return xpos3;
	}

	public int getYpos1() {
		return ypos1;
	}

	public int getYpos2() {
		return ypos2;
	}

	public int getYpos3() {
		return ypos3;
	}

	public LineSegment getLineSeg1() {
		return ls1;
	}

	public LineSegment getLineSeg2() {
		return ls2;
	}

	public LineSegment getLineSeg3() {
		return ls3;
	}
	
	public Circle getCorner1() {
		Circle corner = new Circle(xpos1, ypos1, 0);
		return corner;
	}
	
	public Circle getCorner2() {
		Circle corner = new Circle(xpos2, ypos2, 0);
		return corner;
	}
	
	public Circle getCorner3() {
		Circle corner = new Circle(xpos3, ypos3, 0);
		return corner;
	}
	
	public Vect getCornerCentre(){
		Vect cen = new Vect(getXpos1(),getYpos1());
		return cen;
	}
	
	public Vect getCornerCentre2(){
		Vect cen = new Vect(getXpos2(),getYpos2());
		return cen;
	}
	
	public Vect getCornerCentre3(){
		Vect cen = new Vect(getXpos3(),getYpos3());
		return cen;
	}
}
