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
	private double initWidth;
	private double initHeight;
	private double xpos;
	private double ypos;
	private double initX;
	private Angle angle;
	String flipperName;
	// private LineSegment ls1;
	private LineSegment ls2;
	// private LineSegment ls3;
	private LineSegment ls4;
	ArrayList<String> keyConnections = new ArrayList<String>();
	ArrayList<String> connections = new ArrayList<String>();
	boolean isConnect = false;
	boolean isKeyConnect = false;
	int rotated;
	ArrayList<Circle> corners = new ArrayList<Circle>();
	ArrayList<LineSegment> lss = new ArrayList<LineSegment>();
	ArrayList<Vect> corCen = new ArrayList<Vect>();

	public RightFlipper(String name, double x, double y) {
		rotated = 0;
		colour = Color.YELLOW;
		double w = 10;
		double h = 40;
		width = w;
		height = h;
		xpos = x * 20 + 10;
		ypos = y * 20;
		setInits();
		setName(name);
		setLineSegs();
		setCorners();
		setCornerCentres();
	}

	public void setName(String n) {
		flipperName = n;
	}

	public String getName() {
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

	public void setColour() {
		colour = Color.decode("#ffba6e");
	}

	public void setColour1() {
		colour = Color.WHITE;
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

	public void setLineSegs() {
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
			cen4 = new Vect(getXPos() + 5 + width, getYPos() + height - 5);
		} else {
			cen1 = new Vect(getXPos() + 5, getYPos() + 5);
			cen4 = new Vect(getXPos() + width - 5, getYPos() + 5);
		}
		corCen.add(cen1);
		corCen.add(cen4);
	}

	public void setInits() {
		initWidth = width;
		initHeight = height;
		initX = xpos;
	}

	public void rotateLines() {
		width = initHeight;
		height = initWidth;
		xpos = initX - 30;
		rotated++;
		clear();
		setLineSegs();
		setCorners();
		setCornerCentres();
	}

	public void unrotateLines() {
		width = initWidth;
		height = initHeight;
		xpos = initX;
		rotated--;
		clear();
		setLineSegs();
		setCorners();
		setCornerCentres();
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