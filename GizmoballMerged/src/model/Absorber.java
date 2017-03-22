package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.LineSegment;

public class Absorber {
	private Color colour;
	private double width;
	private double height;
	private double xpos;
	private double ypos;
	private LineSegment ls;
	private LineSegment ls1;
	private LineSegment ls2;
	ArrayList<LineSegment> lss = new ArrayList<LineSegment>();
	private String absName;
	ArrayList<String> keyConnections = new ArrayList<String>();
	ArrayList<String> connections = new ArrayList<String>();
	boolean isConnect = false;
	boolean isKeyConnect = false;
	
	public Absorber(String name, double x, double y, double w, double h){
//		double w = 400;
//		double h = 20;
		colour = Color.MAGENTA;
		width = w*20;
		height = h*20;
		xpos = x*20;
		ypos = y*20;
		ls = new LineSegment(xpos, ypos+height - 1, xpos + width, ypos+height-1);
		ls1 = new LineSegment(xpos, ypos, xpos, ypos+height);
		ls2 = new LineSegment(xpos+width, ypos, xpos+width, ypos+height);
		lss.add(ls);
		lss.add(ls2);
		lss.add(ls1);
		setName(name);
	}
	
	public void setName(String name)
	{
		absName = name;
	}
	
	public Color getColour(){
		return colour;
	}
	
	public void setColour()
	{
		colour = Color.GREEN;
	}
	
	public void setColour1() {
		colour = Color.MAGENTA;
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
	
	public void addConnections(String connect)
	{
		isConnect = true;
		connections.add(connect);
	}
	
	public ArrayList<String> getConnections()
	{
		return connections;
	}
	
	public void addKeyConnections(String connect)
	{
		isKeyConnect = true;
		keyConnections.add(connect);
	}
	
	public ArrayList<String> getKeyConnections()
	{
		return keyConnections;
	}
	
	public double setXPos(){
		return (xpos + width - 10);
	}
	
	public double setYPos(){
		return (ypos + height/2);
	}
	
	public void releaseBall(Ball b){
		b.start();
	}
	
	public void captureBall(Ball b){
		b.stop();
	}
	
	public ArrayList<LineSegment> getLs(){
		return lss;
	}
}
