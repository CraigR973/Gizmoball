package model;

import java.awt.Color;
import physics.LineSegment;

public class Triangle {
	private int h;
	private int w;
	private int xpos1;
	private int xpos2;
	private int xpos3;
	private int ypos1;
	private int ypos2;
	private int ypos3;
	private Color colour;
	private LineSegment ls;
	
	
	//x1 = top left, x2 = bottom, x3 = top right, y1 = top left, y2 = bottom, y3 = top right
	public Triangle (int x1, int x2, int x3, int y1, int y2, int y3){
		xpos1 = x1;
		xpos2 = x2;
		xpos3 = x3;
		ypos1 = y1;
		ypos2 = y2;
		ypos3 = y3;
		colour = Color.YELLOW;
		ls = new LineSegment(x1, y1, x2, y2);
	}
	
	public Color getColour(){
		return colour;
	}
	
	public int getHeight(){
		return h;
	}
	
	public int getWidth(){
		return w;
	}
	
	public int getXpos1(){
		return xpos1;
	}
	
	public int getXpos2(){
		return xpos2;
	}
	
	public int getXpos3(){
		return xpos3;
	}
	
	public int getYpos1(){
		return ypos1;
	}
	
	public int getYpos2(){
		return ypos2;
	}
	
	public int getYpos3(){
		return ypos3;
	}
	
	public LineSegment getLineSeg(){
		return ls;
	}
}
