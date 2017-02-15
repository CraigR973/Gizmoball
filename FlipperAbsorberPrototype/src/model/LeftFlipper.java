package model;

import java.awt.Color;

import physics.Angle;
import physics.LineSegment;
import physics.Vect;

public class LeftFlipper {
	
	private Vect velocity;
	private Color colour;
	private double width;
	private double height;
	private double xpos;
	private double ypos;
	private double xpos2;
	private double ypos2;
	private LineSegment ls;
	

	

	
	public LeftFlipper(double w, double h, double x, double y, double a, double b){
		colour = Color.RED;
		
		width = w;
		height = h;
		xpos = x;
		ypos = y;
		xpos2 = a;
		ypos2 = b;
		ls = new LineSegment(x, y, x + w, y);
	}
	
		public Vect getVelo() {
			return velocity;
		}
		
		public void setVelo(Vect v) {
			velocity = v;
		}
	
	
	
	public Color getColour(){
		return colour;
	}
	

	
	public LineSegment getLFlipLineSeg(){
		return ls;
	}
	
	public double getXPos(){
		return xpos;
	}
	
	public double getYPos(){
		return ypos;
	}
	
	public void setXPos(double x){
		xpos = x;
	}
	
	public void setYPos(double y){
		ypos = y;
	}
	
	public double getXPos2(){
		return xpos2;
	}
	
	public double getYPos2(){
		return ypos2;
	}
	
	public double getHeight(){
		return height;
	}
	
	public double getWidth(){
		return width;
	}
	public String getName(){
		return "lFlip1";
	}
}
