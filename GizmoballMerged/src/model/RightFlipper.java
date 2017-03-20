package model;
import java.awt.Color;
import java.util.ArrayList;

import physics.Angle;
import physics.Circle;
import physics.LineSegment;
import physics.Vect;
public class RightFlipper {
	
	private Vect velocity;
	private Color colour;
	private double width;
	private double height;
	private double xpos;
	private double ypos;
	private Angle angle;
	String flipperName;
	//private LineSegment ls1;
	private LineSegment ls2;
	//private LineSegment ls3;
	private LineSegment ls4;
	ArrayList<String> keyConnections = new ArrayList<String>();
	ArrayList<String> connections = new ArrayList<String>();
	boolean isConnect = false;
	boolean isKeyConnect = false;
	
	
	public RightFlipper(String name, double x, double y){
		colour = Color.WHITE;
		double a = 1.0;
		double b = 1.0;
		double w = 10;
		double h = 40;
		width = w;
		height = h;
		xpos = x*20+10;
		ypos = y*20;
		angle = new Angle(a,b);
		setName(name);
		ls2 = new LineSegment(xpos, ypos + 5, xpos, ypos + h - 5);
		ls4 = new LineSegment(xpos + w, ypos + 5, xpos + w, ypos + h - 5);
	}
	
		public void setName(String n){
			flipperName = n;
		}
		
		public String getName(){
			return flipperName;
		}
	
		public Vect getVelo() {
			return velocity;
		}
		
		public void setVelo(Vect v) {
			velocity = v;
		}
		
		public Angle getAngle() {
			return angle;
		}
		
		public void setAngle(Angle ang) {
			angle = ang;
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
	
	public void setXPos(double x){
		xpos = x;
	}
	
	public void setYPos(double y){
		ypos = y;
	}
	
	
	public double getHeight(){
		return height;
	}
	
	public double getWidth(){
		return width;
	}
	
	public LineSegment getLineSegs(int i){
		ArrayList<LineSegment> lss = new ArrayList<LineSegment>();
		
		lss.add(ls2);
		lss.add(ls4);
		
		return lss.get(i);
	}

	public Circle getCorners(int i){
		ArrayList<Circle> corners = new ArrayList<Circle>();
		
		Circle corner1 = new Circle(xpos + 5, ypos + 5, 5);
		Circle corner4 = new Circle(xpos + 5, ypos + height - 5, 5);
		
		corners.add(corner1);
		corners.add(corner4);
		
		return corners.get(i);
	}

	public Vect getCornerCentres(int i){
		ArrayList<Vect> corCen = new ArrayList<Vect>();
		
		Vect cen1 = new Vect(getXPos() + 5,getYPos()+5);
		Vect cen4 = new Vect(getXPos() + 5 + width,getYPos() + height - 5);
		
		corCen.add(cen1);
		corCen.add(cen4);
		
		return corCen.get(i);
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
}