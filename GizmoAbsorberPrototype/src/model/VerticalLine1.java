package model;

import java.awt.Color;

import physics.LineSegment;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class VerticalLine1 {

	private int xpos;
	private int ypos;
	private int width;
	private int height;
	private LineSegment ls;
	private Color colour;

	public VerticalLine1(int x, int y, int w, int h) {
		xpos = x;
		ypos = y;
		width = w;
		height = h;
		ls = new LineSegment(x, y, x, y + h);
		colour = Color.GREEN;
	}

	public LineSegment getLineSeg() {
		return ls;
	}
	
	public void setLineSeg(LineSegment l){
		ls = l;
	}

	public int getX() {
		return xpos;
	}

	public int getY() {
		return ypos;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Color getColour(){
		return colour;
	}

}
