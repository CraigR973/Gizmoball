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
	private LineSegment ls;
	private Angle angle;
	
	
	
	public LeftFlipper(double w, double h, double x, double y, double a, double b){
		colour = Color.RED;
		
		width = w;
		height = h;
		xpos = x;
		ypos = y;
		angle = new Angle(a,b);
		ls = new LineSegment(x, y, x + w, y);
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
	public String getName(){
		return "lFlip1";
	}
}