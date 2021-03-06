package model;

import java.awt.Color;

import physics.Circle;
import physics.Vect;

public class Ball {
	private Vect velocity;
	private double radius;
	private double xpos;
	private double ypos;
	private Color colour;
	private String ballName;
	private boolean stopped;

	// x, y coordinates and x,y velocity
	public Ball(String name, double x, double y, double xv, double yv) {
		xpos = x*20; // Centre coordinates
		ypos = y*20;
		colour = Color.BLUE;
		velocity = new Vect(xv, yv);
		radius = 7;
		stopped = false;
	}

	public Vect getVelo() {
		return velocity;
	}

	public void setVelo(Vect v) {
		velocity = v;
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

	public void setExactX(double x) {
		xpos = x;
	}

	public void setExactY(double y) {
		ypos = y;
	}

	public void stop() {
		stopped = true;
	}

	public void start() {
		stopped = false;
	}

	public boolean stopped() {
		return stopped;
	}

	public Color getColour() {
		return colour;
	}
	
	public Vect getCentreOfBall(){
		Vect cen = new Vect (getExactX(),getExactY());
		return cen;
	}
	
	public String getName(){
		return ballName;
	}

}
