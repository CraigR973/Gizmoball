package model;
import java.awt.Color;
import physics.Angle;
import physics.LineSegment;
import physics.Vect;
public class RightFlipper {
	
	private Vect velocity;
	private Color colour;
	private double width;
	private double height;
	private double xpos;
	private double ypos;
	private LineSegment ls;
	private Angle angle;
	String flipperName;
	
	
	public RightFlipper(String name, double x, double y){
		colour = Color.WHITE;
		double a = 1.0;
		double b = 1.0;
		double w = 10;
		double h = 40;
		width = w;
		height = h;
		xpos = x*20;
		ypos = y*20;
		angle = new Angle(a,b);
		ls = new LineSegment(x, y, x + w, y);
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
	
	
	public double getHeight(){
		return height;
	}
	
	public double getWidth(){
		return width;
	}
}