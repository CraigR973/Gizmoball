package model;

import java.awt.Color;
import physics.LineSegment;

public class Absorber {
	private Color colour;
	private double width;
	private double height;
	private double xpos;
	private double ypos;
	private LineSegment ls;
	
	public Absorber(double w, double h, double x, double y){
		colour = Color.MAGENTA;
		width = w;
		height = h;
		xpos = x;
		ypos = y;
		ls = new LineSegment(x, y+h-0.5, x + w, y+h-0.5);
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
		return "abs1";
	}
}
