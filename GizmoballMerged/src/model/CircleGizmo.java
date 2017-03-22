package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;


public class CircleGizmo {


	private double radius;
	private double xpos;
	private double ypos;
	private Color colour;
	private LineSegment radLs;
	private String circleName;
	ArrayList<String> keyConnections = new ArrayList<String>();
	ArrayList<String> connections = new ArrayList<String>();
	boolean isConnect = false;
	boolean isKeyConnect = false;


	public CircleGizmo(String name, double x, double y) {
		xpos = (x*20)+10; // Centre coordinates
		ypos = (y*20)+10;
		colour = Color.GREEN;
		radius = 10;
		radLs = new LineSegment(x+20,y+20,x-20,y-20);
		setName(name);
	}
	
	public void setName(String n){
		circleName = n;
	}
	
	public String getName(){
		return circleName;
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


	public Color getColour() {
		return colour;
	}
	
	public void setLs(int x1, int y1, int x2, int y2){
		radLs = new LineSegment(x1+20,1+20,x2-20,y2-20);
	}
	
	public LineSegment getLineSeg(){

		return radLs;
	}
	
	
	public Vect getCircleCentre(){
		Vect cen = new Vect(getExactX(),getExactY());
		return cen;
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

	public void setColour(Color c) {
		// TODO Auto-generated method stub
		colour = c;
	}
	
	public boolean isConnect() {
		return isKeyConnect;
	}

}