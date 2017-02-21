package model;

import java.awt.Color;

import physics.LineSegment;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class VerticalLine {

	private int xpos;
	private int ypos;
	private int width;
	private LineSegment ls;
	private Color colour;

	public VerticalLine(int x, int y, int w) {
		xpos = x;
		ypos = y;
		width = w;
		ls = new LineSegment(x, y, x + w, y);
		colour = Color.GREEN;
	}

	public LineSegment getLineSeg() {
		return ls;
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
	
	public Color getColour(){
		return colour;
	}

}
