package model;

import java.awt.Color;

import physics.Circle;
import physics.Vect;

public class Ball1 {

	private Vect velocity;
	private double radius;
	private double xpos;
	private double ypos;
	private Color colour;
	private double xVel;
	private double yVel;

	private boolean stopped;

	// x, y coordinates and x,y velocity
	public Ball1(double x, double y, double xv, double yv) {
		xpos = x; // Centre coordinates
		ypos = y;
		xVel = xv;
		yVel = yv;
		colour = Color.BLUE;
		velocity = new Vect(xv, yv);
		radius = 5;
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
	
	public double getYv(){
		return yVel;
	}
	
	public void setYv(double speed){
		yVel = speed;
	}

	public double getXv(){
		return xVel;
	}
}
