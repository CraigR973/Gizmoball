package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Angle;
import physics.Circle;
import physics.LineSegment;
import physics.Vect;

public class LeftFlipper {

	private Vect velocity;
	private Color colour;
	private double width;
	private double height;
	private double xpos;
	private double ypos;
	private double initWidth;
	private double initHeight;
	private Angle angle;
	private int rotation;
	String flipperName;
	private LineSegment ls2;
	private LineSegment ls4;
	private ArrayList<LineSegment> lss = new ArrayList<LineSegment>();
	ArrayList<String> keyConnections = new ArrayList<String>();
	ArrayList<String> connections = new ArrayList<String>();
	boolean isConnect = false;
	boolean isKeyConnect = false;
	private int rotated;

	ArrayList<Vect> corCen = new ArrayList<Vect>();
	ArrayList<Circle> corners = new ArrayList<Circle>();

	public LeftFlipper(String name, double x, double y) {
		rotated = 0;
		colour = Color.YELLOW;
		double a = 1.0;
		double b = 1.0;
		double w = 10;
		double h = 40;
		width = w;
		height = h;
		xpos = x * 20;
		ypos = y * 20;
		angle = new Angle(a, b);
		setName(name);
		ls2 = new LineSegment(xpos, ypos + 5, xpos, ypos + h - 5);
		ls4 = new LineSegment(xpos + w, ypos + 5, xpos + w, ypos + h - 5);
		rotation = 0;
		setInits();
		setLs();
		setCorners();
		setCornerCentres();
	}

	public void setName(String n) {
		flipperName = n;
	}

	public String getName() {
		return flipperName;
	}

	public void setColour() {
		colour = Color.PINK;
	}

	public void setColour1() {
		colour = Color.WHITE;
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

	public Color getColour() {
		return colour;
	}

	public double getXPos() {
		return xpos;
	}

	public double getYPos() {
		return ypos;
	}

	public void setXPos(double x) {
		xpos = x;
	}

	public void setYPos(double y) {
		ypos = y;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public LineSegment getLineSegs(int i) {
		

		return lss.get(i);
	}

	public Circle getCorners(int i) {

		return corners.get(i);
	}

	public void setCorners() {
		Circle corner1 = new Circle(0, 0, 0);
		Circle corner4 = new Circle(0, 0, 0);

		if (rotated == 0) {
			corner1 = new Circle(xpos + 5, ypos + 5, 5);
			corner4 = new Circle(xpos + 5, ypos + height - 5, 5);
		} else {
			corner1 = new Circle(xpos + 5, ypos + 5, 5);
			corner4 = new Circle(xpos + width - 5, ypos + 5, 5);
		}

		corners.add(corner1);
		corners.add(corner4);
	}

	public Vect getCornerCentres(int i) {

		return corCen.get(i);
	}

	public void setCornerCentres() {
		Vect cen1 = new Vect(0, 0);
		Vect cen4 = new Vect(0, 0);
		if (rotated == 0) {
			cen1 = new Vect(getXPos() + 5, getYPos() + 5);
			cen4 = new Vect(getXPos() + 5, getYPos() + height - 5);
		} else {
			cen1 = new Vect(getXPos() + 5, getYPos() + 5);
			cen4 = new Vect(getXPos() + width - 5, getYPos() + 5);
		}
		corCen.add(cen1);
		corCen.add(cen4);
	}

	public void rotateLines() {
		width = initHeight;
		height = initWidth;
		rotated++;
		clear();
		setLs();
		setCorners();
		setCornerCentres();
	}

	public void unrotateLines() {
		width = initWidth;
		height = initHeight;
		rotated--;
		clear();
		setLs();
		setCorners();
		setCornerCentres();
	}

	public void setInits() {
		initWidth = width;
		initHeight = height;
	}

	public void setLs() {
		if (rotated == 0) {
			ls2 = new LineSegment(xpos, ypos + 5, xpos, ypos + height - 5);
			ls4 = new LineSegment(xpos + width, ypos + 5, xpos + width, ypos + height - 5);
		} else {
			ls2 = new LineSegment(xpos + 5, ypos, xpos + width - 5, ypos);
			ls4 = new LineSegment(xpos + 5, ypos + height, xpos + width - 5, ypos + height);
		}

		lss.add(ls2);
		lss.add(ls4);
	}

	public void clear() {
		lss.clear();
		corners.clear();
		corCen.clear();
	}

	public void addConnections(String connect) {
		isConnect = true;
		connections.add(connect);
	}

	public ArrayList<String> getConnections() {
		return connections;
	}

	public void addKeyConnections(String connect) {
		isKeyConnect = true;
		keyConnections.add(connect);
	}

	public ArrayList<String> getKeyConnections() {
		return keyConnections;
	}

}