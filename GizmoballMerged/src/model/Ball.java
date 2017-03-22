package model;

import java.awt.Color;
import java.util.ArrayList;

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
	ArrayList<String> keyConnections = new ArrayList<String>();
	ArrayList<String> connections = new ArrayList<String>();
	boolean isConnect = false;
	boolean isKeyConnect = false;

	
	public Ball(String name, double x, double y, double xv, double yv) {
		xpos = x*20; 
		ypos = y*20;
		colour = Color.BLUE;
		velocity = new Vect(xv, yv);
		radius = 5;
		stopped = false;
	}

	public Vect getVelo() {
		return velocity;
	}

	public void setName(String name)
	{
		ballName = name;
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
	
	public void addConnections(String connect)
	{
		isConnect = true;
		connections.add(connect);
	}
	
	public ArrayList<String> getConnections()
	{
		return connections;
	}
	
	public void addKeyConnections(String connect)
	{
		isKeyConnect = true;
		keyConnections.add(connect);
	}
	
	public ArrayList<String> getKeyConnections()
	{
		return keyConnections;
	}

}
