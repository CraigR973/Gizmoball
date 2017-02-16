package model;
import java.awt.Color;
import physics.Circle;
import physics.LineSegment;
public class Circle1 {
//	private Vect velocity;
	private double radius;
	private double xpos;
	private double ypos;
	private Color colour;
	private LineSegment radLs;
	private String circleName;
//	private boolean stopped;
	
	// x, y coordinates and x,y velocity
	public Circle1(String name, double x, double y) {
		xpos = x; // Centre coordinates
		ypos = y;
		colour = Color.ORANGE;
		radius = 20;
		radLs = new LineSegment(x+20,y+20,x-20,y-20);
		setName(name);
	}
	
	public void setName(String n){
		circleName = n;
	}
	
	public String getName()
	{
		return circleName;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public Circle getCircle1() {
		return new Circle(xpos, ypos, radius);
	}
	
	// Ball specific methods that deal with double precision.
	public double getExactX() {
		return xpos;
	}
	
	public double getExactY() {
		return ypos;
	}
	
//	public void setExactX(double x) {
//		xpos = x;
//	}
//
//	public void setExactY(double y) {
//		ypos = y;
//	}
	public Color getColour() {
		return colour;
	}
	
	public void setLs(int x1, int y1, int x2, int y2){
		radLs = new LineSegment(x1,y1,x2,y2);
	}
}
