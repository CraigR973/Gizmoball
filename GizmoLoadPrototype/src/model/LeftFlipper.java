package model;
import java.awt.Color;
import physics.LineSegment;
public class LeftFlipper {
	private Color colour;
	private double width;
	private double height;
	private double xpos;
	private double ypos;
	private LineSegment ls;
	private String LflipperName;
	
	public LeftFlipper(String name, double x, double y){
		double w = 20;
		double h = 60;
		colour = Color.ORANGE;
		width = w;
		height = h;
		xpos = x;
		ypos = y;
		ls = new LineSegment(x, y+h-1, x + w, y+h-1);
	}
	
	public void setName(String n){
		LflipperName = n;
	}
	
	public Color getColour(){
		return colour;
	}
	
	public LineSegment getFlipperLineSeg(){
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
		return LflipperName;
	}
}