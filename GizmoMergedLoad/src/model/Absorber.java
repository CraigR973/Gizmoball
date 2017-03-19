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
	private LineSegment ls;
	private String absName;
	ArrayList<String> keyConnections = new ArrayList<String>();
	ArrayList<String> connections = new ArrayList<String>();
	boolean isConnect = false;
	boolean isKeyConnect = false;
	
	public Absorber(String name, double x, double y){
		double w = 400;
		double h = 20;
		colour = Color.MAGENTA;
		width = w;
		height = h;
		xpos = x;
		ypos = y*20;
		ls = new LineSegment(xpos, ypos+h-1, xpos + w, ypos+h-1);
		setName(name);
	}
	
	public void setName(String name)
	{
		absName = name;
	}

	
	public Color getColour(){
		return colour;
	}
	
	public LineSegment getAbsLineSeg(){
		return ls;
	}
	
	public double getXPos(){
		System.out.println(xpos);
		return xpos;
	}
	
	public double getYPos(){
		System.out.println(ypos);
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
