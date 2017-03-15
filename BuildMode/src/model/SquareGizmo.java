package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

public class SquareGizmo {
	private Color colour;
	private double width;
	private double height;
	private double xpos;
	private double ypos;
	private LineSegment ls1;
	private LineSegment ls2;
	private LineSegment ls3;
	private LineSegment ls4;
	
	public SquareGizmo(double w, double h, double x, double y){
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
	
	public LineSegment getLineSegs(int i){
		ArrayList<LineSegment> lss = new ArrayList<LineSegment>();
		
		lss.add(ls1);
		lss.add(ls2);
		lss.add(ls3);
		lss.add(ls4);
		
		return lss.get(i);
	}
	
	public Circle getCorners(int i){
		ArrayList<Circle> corners = new ArrayList<Circle>();
		
		Circle corner1 = new Circle(xpos, ypos, 0);
		Circle corner2 = new Circle(xpos + width, ypos, 0);
		Circle corner3 = new Circle(xpos, ypos + height, 0);
		Circle corner4 = new Circle(xpos + width, ypos + height, 0);
		
		corners.add(corner1);
		corners.add(corner2);
		corners.add(corner3);
		corners.add(corner4);
		
		return corners.get(i);
	}
	
	public Vect getCornerCentres(int i){
		ArrayList<Vect> corCen = new ArrayList<Vect>();
		
		Vect cen1 = new Vect(getXPos(),getYPos());
		Vect cen2 = new Vect(getXPos() + width,getYPos());
		Vect cen3 = new Vect(getXPos(),getYPos() + height);
		Vect cen4 = new Vect(getXPos() + width,getYPos() + height);
		
		corCen.add(cen1);
		corCen.add(cen2);
		corCen.add(cen3);
		corCen.add(cen4);
		
		return corCen.get(i);
	}
}
