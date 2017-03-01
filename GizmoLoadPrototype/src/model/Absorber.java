package model;
import java.awt.Color;
import java.util.ArrayList;

import physics.LineSegment;
public class Absorber {
	private Color colour;
	private double width;
	private double height;
	private double xpos;
	private double ypos;
	private String absName;
	private LineSegment ls;
	ArrayList<Integer> connections = new ArrayList<Integer>();
	ArrayList<Integer> keyConnections = new ArrayList<Integer>();
	
	public Absorber(String name, double x, double y){
		double w = 500;
		double h = 25;
		colour = Color.MAGENTA;
		width = w;
		height = h;
		xpos = x*20;
		ypos = y*20;
		ls = new LineSegment(x, y+h-1, x + w, y+h-1);
	}
	
	public void setName(String n){
		absName = n;
	}
	
	public Color getColour(){
		return colour;
	}
	
	public LineSegment getAbsLineSeg(){
		return ls;
	}
	
	public double getXPos(){
		return xpos;
	}
	
	public double getYPos(){
		return ypos;
	}
	
	public double getHeight(){
		return height;
	}
	
	public double getWidth(){
		return width;
	}
	public String getName(){
		return absName;
	}
	
	public ArrayList<Integer> getConnectons()
	{
		return connections;
	}
	
	public ArrayList<Integer> getKeyConnectons()
	{
		return keyConnections;
	}
}