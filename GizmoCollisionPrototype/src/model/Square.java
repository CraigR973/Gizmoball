package model;

import java.awt.Color;
import physics.LineSegment;

public class Square {
	private Color colour;
	private double width;
	private double height;
	private double xpos;
	private double ypos;
	private LineSegment ls1;
	private LineSegment ls2;
	private LineSegment ls3;
	private LineSegment ls4;
	
	public Square(double w, double h, double x, double y){
		colour = Color.GREEN;
		width = w;
		height = h;
		xpos = x;
		ypos = y;
		ls1 = new LineSegment(x, y + h, x + w, y + h);
		ls2 = new LineSegment(x, y, x, y + h);
		ls3 = new LineSegment(x, y, x + w, y);
		ls4 = new LineSegment(x + w, y, x + w, y + h);
	}
	
	public Color getColour(){
		return colour;
	}
	
	public LineSegment getSqLineSeg(){
		return ls1;
	}
	
	public LineSegment getSqLineSeg2(){
		return ls2;
	}
	
	public LineSegment getSqLineSeg3(){
		return ls3;
	}
	
	public LineSegment getSqLineSeg4(){
		return ls4;
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
		return "sq";
	}
}
