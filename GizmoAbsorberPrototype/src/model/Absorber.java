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
	private String absName;
	
	
	public Absorber(String name, double x, double y){
		double w = 400;
		double h = 20;
		colour = Color.MAGENTA;
		width = w;
		height = h;
		xpos = x*20;
		ypos = y*20;
		ls = new LineSegment(xpos, ypos+h-1, xpos + w, ypos+h-1);
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
}
