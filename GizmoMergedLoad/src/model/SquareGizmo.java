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
	private LineSegment ls;
	private String squareName;
	private LineSegment ls1;
	private LineSegment ls2;
	private LineSegment ls3;
	private LineSegment ls4;
	

	
	public SquareGizmo(String name, double x, double y){
		double w = 20;
		double h = 20;
		colour = Color.BLACK;
		width = w;
		height = h;
		xpos = x * 20;
		ypos = y * 20;
		setName(name);
		ls1 = new LineSegment(xpos, ypos + h, xpos + w, ypos + h);
		ls2 = new LineSegment(xpos, ypos, xpos, ypos + h);
		ls3 = new LineSegment(xpos, ypos, xpos + w, ypos);
		ls4 = new LineSegment(xpos + w, ypos, xpos + w, ypos + h);
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
