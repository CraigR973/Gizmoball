package model;

import java.awt.Color;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;


public class CircleGizmo {

//	private Vect velocity;
	private double radius;
	private double xpos;
	private double ypos;
	private Color colour;
	private LineSegment radLs;
	private String circleName;

//	private boolean stopped;

	// x, y coordinates and x,y velocity
	public CircleGizmo(String name, double x, double y) {
		xpos = x*20; // Centre coordinates
		ypos = y*20;
		colour = Color.GREEN;
		radius = 10;
		radLs = new LineSegment(x+20,y+20,x-20,y-20);
		setName(name);
	}
	
	public void setName(String n){
		circleName = n;
	}
	

	public double getRadius() {
		return radius;
	}

	public Circle getCircle() {
		return new Circle(xpos, ypos, radius);
	}

	// Ball specific methods that deal with double precision.
	public double getExactX() {
		return xpos;
	}

	public double getExactY() {
		return ypos;
	}


	public Color getColour() {
		return colour;
	}
	
	public void setLs(int x1, int y1, int x2, int y2){
		radLs = new LineSegment(x1,y1,x2,y2);
	}
	
	public Vect getCircleCentre(){
		Vect cen = new Vect(getExactX(),getExactY());
		return cen;
	}

}