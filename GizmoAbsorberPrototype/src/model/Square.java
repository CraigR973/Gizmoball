package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.LineSegment;

public class Square {

	private Color colour;
	private double width;
	private double height;
	private double xpos;
	private double ypos;
	private LineSegment ls;
	private String squareName;
	ArrayList<Integer> connections = new ArrayList<Integer>();
	ArrayList<Integer> keyConnections = new ArrayList<Integer>();
	
	public Square(String name, double x, double y){
		double w = 20;
		double h = 20;
		colour = Color.RED;
		width = w;
		height = h;
		xpos = x * 20;
		ypos = y * 20;
		setName(name);
	}
	
	public void setName(String n){
		squareName = n;
	}
	
	public Color getColour(){
		return colour;
	}
	
	public LineSegment getSquareLineSeg(){
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
		return squareName;
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
