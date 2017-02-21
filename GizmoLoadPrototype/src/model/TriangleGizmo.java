package model;
import java.awt.Color;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;
public class TriangleGizmo {
	private double xpos1;
	private double xpos2;
	private double xpos3;
	private double ypos1;
	private double ypos2;
	private double ypos3;
	private Color colour;
	private LineSegment ls1;
	private LineSegment ls2;
	private LineSegment ls3;
	private double width;
	private double height;
	private String triangleName;
	
	// x1 = top left, x2 = bottom, x3 = top right, y1 = top left, y2 = bottom,
	// y3 = top right
	public TriangleGizmo(String name, double x1, double y1) {
		double w = 20;
		double h = 20;
		xpos1 = x1*20;
		xpos2 = (x1*20) + w;
		xpos3 = xpos2;
		ypos1 = y1*20;
		ypos2 = y1*20;
		ypos3 = ypos2 + h;
		width = w;
		height = h;
		colour = Color.BLUE;
		ls1 = new LineSegment(x1, y1, xpos2, ypos2);
		ls2 = new LineSegment(xpos2, ypos2, xpos3, ypos3);
		ls3 = new LineSegment(x1, y1, xpos3, ypos3);
		setName(name);
	}
	
	public void setName(String n){
		triangleName = n;
	}
	
	public String getName(){
		return triangleName;
	}
	
	public Color getColour() {
		return colour;
	}
	public double getHeight() {
		return height;
	}
	public double getWidth() {
		return width;
	}
	public double getXpos1() {
		return xpos1;
	}
	public double getXpos2() {
		return xpos2;
	}
	public double getXpos3() {
		return xpos3;
	}
	public double getYpos1() {
		return ypos1;
	}
	public double getYpos2() {
		return ypos2;
	}
	public double getYpos3() {
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