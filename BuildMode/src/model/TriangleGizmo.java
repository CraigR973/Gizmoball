package model;

import java.awt.Color;
import java.util.ArrayList;

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
	boolean hit = false;
	
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
	
	public LineSegment getLinSegs(int i){
		ArrayList<LineSegment> lss = new ArrayList<LineSegment>();
		
		lss.add(ls1);
		lss.add(ls2);
		lss.add(ls3);
		
		return lss.get(i);
	}
	
	public Circle getCorners(int i){
		ArrayList<Circle> corners = new ArrayList<Circle>();
		
		Circle corner1 = new Circle(xpos1, ypos1, 0);
		Circle corner2 = new Circle(xpos2, ypos2, 0);
		Circle corner3 = new Circle(xpos3, ypos3, 0);
		
		corners.add(corner1);
		corners.add(corner2);
		corners.add(corner3);
		
		return corners.get(i);
	}
	
	public Vect getCornerCentres(int i){
		ArrayList<Vect> cornerCentres = new ArrayList<Vect>();
		
		Vect cen1 = new Vect(getXpos1(),getYpos1());
		Vect cen2 = new Vect(getXpos2(),getYpos2());
		Vect cen3 = new Vect(getXpos3(),getYpos3());
		
		cornerCentres.add(cen1);
		cornerCentres.add(cen2);
		cornerCentres.add(cen3);
		
		return cornerCentres.get(i);
	}
	
	public void setColour(Color c){
		colour = c;
	}
}
