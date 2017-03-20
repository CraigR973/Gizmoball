package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

public class TriangleGizmo {

	private double xpos1;
	private double xpos2;
	private double xpos3;
	private double ypos1;
	private double ypos2;
	private double ypos3;
	private double ogX1;
	private double ogX2;
	private double ogX3;
	private double ogY1;
	private double ogY2;
	private double ogY3;
	private Color colour;
	private LineSegment ls1;
	private LineSegment ls2;
	private LineSegment ls3;
	private double width;
	private double height;
	private String triangleName;
	private int angle = 0;

	private ArrayList<Vect> cornerCentres = new ArrayList<Vect>();
	private ArrayList<Circle> corners = new ArrayList<Circle>();
	private ArrayList<LineSegment> lss = new ArrayList<LineSegment>();

	int rotations = 0;
	ArrayList<String> keyConnections = new ArrayList<String>();
	ArrayList<String> connections = new ArrayList<String>();
	boolean isConnect = false;
	boolean isKeyConnect = false;

	// x1 = top left, x2 = bottom, x3 = top right, y1 = top left, y2 = bottom,
	// y3 = top right
	public TriangleGizmo(String name, double x1, double y1) {
		double w = 20;
		double h = 20;
		xpos1 = x1 * 20;
		xpos2 = (x1 * 20) + w;
		xpos3 = xpos2;
		ypos1 = y1 * 20;
		ypos2 = y1 * 20;
		ypos3 = ypos2 + h;
		width = w;
		height = h;
		colour = Color.BLUE;
		ls1 = new LineSegment(xpos1, ypos2, xpos2, ypos2);
		ls2 = new LineSegment(xpos2, ypos2, xpos3, ypos3);
		ls3 = new LineSegment(xpos1, ypos1, xpos3, ypos3);
		setName(name);
		resetAngle();
		ogX1 = xpos1;
		ogX2 = xpos2;
		ogX3 = xpos3;
		ogY1 = ypos1;
		ogY2 = ypos2;
		ogY3 = ypos3;
		setCorners();
		setCornerCentres();
		setLineSegs();
	}

	public void setName(String n) {
		triangleName = n;
	}

	public String getName() {
		return triangleName;
	}

	public Color getColour() {
		return colour;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public double getXpos1() {
		return xpos1;
	}

	public double getXpos2() {
		return xpos2;
	}

	public double getXpos3() {
		return xpos3;
	}

	public double getYpos1() {
		return ypos1;
	}

	public double getYpos2() {
		return ypos2;
	}

	public double getYpos3() {
		return ypos3;
	}

	public LineSegment getLineSeg1() {
		return ls1;
	}

	public LineSegment getLineSeg2() {
		return ls2;
	}

	public LineSegment getLineSeg3() {
		return ls3;
	}

	public Circle getCorner1() {
		Circle corner = new Circle(xpos1, ypos1, 0);
		return corner;
	}

	public Circle getCorner2() {
		Circle corner = new Circle(xpos2, ypos2, 0);
		return corner;
	}

	public Circle getCorner3() {
		Circle corner = new Circle(xpos3, ypos3, 0);
		return corner;
	}

	public Vect getCornerCentre() {
		Vect cen = new Vect(getXpos1(), getYpos1());
		return cen;
	}

	public Vect getCornerCentre2() {
		Vect cen = new Vect(getXpos2(), getYpos2());
		return cen;
	}

	public Vect getCornerCentre3() {
		Vect cen = new Vect(getXpos3(), getYpos3());
		return cen;
	}

	public LineSegment getLinSegs(int i) {
		// ArrayList<LineSegment> lss = new ArrayList<LineSegment>();
		//
		// lss.add(ls1);
		// lss.add(ls2);
		// lss.add(ls3);

		return lss.get(i);
	}

	public void setLineSegs() {
		ls1 = new LineSegment(xpos1, ypos1, xpos2, ypos2);
		ls2 = new LineSegment(xpos2, ypos2, xpos3, ypos3);
		ls3 = new LineSegment(xpos1, ypos1, xpos3, ypos3);

		lss.add(ls1);
		lss.add(ls2);
		lss.add(ls3);
	}

	public Circle getCorners(int i) {
		// ArrayList<Circle> corners = new ArrayList<Circle>();

		return corners.get(i);
	}

	public void setCorners() {
		Circle corner1 = new Circle(xpos1, ypos1, 0);
		Circle corner2 = new Circle(xpos2, ypos2, 0);
		Circle corner3 = new Circle(xpos3, ypos3, 0);

		corners.add(corner1);
		corners.add(corner2);
		corners.add(corner3);
	}

	public Vect getCornerCentres(int i) {
		// ArrayList<Vect> cornerCentres = new ArrayList<Vect>();

		return cornerCentres.get(i);
	}

	public void setCornerCentres() {
		Vect cen1 = new Vect(getXpos1(), getYpos1());
		Vect cen2 = new Vect(getXpos2(), getYpos2());
		Vect cen3 = new Vect(getXpos3(), getYpos3());

		cornerCentres.add(cen1);
		cornerCentres.add(cen2);
		cornerCentres.add(cen3);
	}

	public void setColour(Color c) {
		colour = c;
	}

	public void addRotation()
	{
		if(rotations <= 3)
		{
			rotations +=1;
			rotate();
		}
		else
		{
			rotations = 0;
			rotate();
		}
	}
	
	public int rotate() {
		System.out.println("Angle: " + angle);
		angle = (angle + 90) % 360;
		rotateLs();
		// setRotatedLineSegs();
		return angle;
	}

	public int getRotation() {
		return angle;
	}
	
	public int getNoRotations()
	{
		return rotations;
	}

	// public void rotateLs() {
	// setCorners();
	// setCornerCentres();
	// Circle c1 = corners.get(0);
	// Circle c2 = corners.get(1);
	// Circle c3 = corners.get(3);
	// Vect cen1 = cornerCentres.get(0);
	// Vect cen2 = cornerCentres.get(1);
	// Vect cen3 = cornerCentres.get(2);
	// if (angle == 0) {
	//// setOriginalCoordinates();
	// ls1 = new LineSegment(xpos1, ypos1, xpos2, ypos2);
	// ls2 = new LineSegment(xpos2, ypos2, xpos3, ypos3);
	// ls3 = new LineSegment(xpos1, ypos1, xpos3, ypos3);
	// }
	// if (angle == 90) {
	//// setOriginalCoordinates();
	//// xpos1 = xpos1 + 20;
	//// ypos1 = ypos1 + 20;
	//// xpos3 = xpos3 - 20;
	// ls1 = new LineSegment(xpos1 + 20, ypos1 + 20, xpos2, ypos2);
	// ls2 = new LineSegment(xpos2, ypos2, xpos3 - 20, ypos3);
	// ls3 = new LineSegment(xpos1 + 20, ypos1 + 20, xpos3 - 20, ypos3);
	// c1 = new Circle(xpos1+20, ypos1+20,0);
	// c3 = new Circle(xpos3-20,ypos3,0);
	// cen1 = new Vect(xpos1+20,ypos1+20);
	// cen3 = new Vect(xpos3-20,ypos3);
	//// ls1 = new LineSegment(xpos1, ypos1, xpos2, ypos2);
	//// ls2 = new LineSegment(xpos2, ypos2, xpos3, ypos3);
	//// ls3 = new LineSegment(xpos1 , ypos1 , xpos3 , ypos3);
	//// System.out.println("xpos1 at first rotate yo ahaha " + xpos1);
	//
	// System.out.println("ypos1 at first rotate yo ahaha " + ypos1);
	// }
	// if (angle == 180) {
	//// setOriginalCoordinates();
	//// xpos2 -= 20;
	//// ypos2 +=20;
	//// ls1 = new LineSegment(xpos1, ypos1, xpos2, ypos2 );
	//// ls2 = new LineSegment(xpos2 , ypos2 , xpos3, ypos3);
	//// ls3 = new LineSegment(xpos1, ypos1, xpos3, ypos3);
	// ls1 = new LineSegment(xpos1, ypos1, xpos2 - 20, ypos2 + 20);
	// ls2 = new LineSegment(xpos2 - 20, ypos2 + 20, xpos3, ypos3);
	// ls3 = new LineSegment(xpos1, ypos1, xpos3, ypos3);
	// c2 = new Circle(xpos2-20, ypos2+20,0);
	// cen2 = new Vect(xpos2-20, ypos2+20);
	// }
	// if (angle == 270) {
	//// setOriginalCoordinates();
	//// ypos1+=20;
	//// xpos2-=20;
	//// ypos3-=20;
	//// ls1 = new LineSegment(xpos1, ypos1 , xpos2 , ypos2);
	//// ls2 = new LineSegment(xpos2, ypos2, xpos3, ypos3 );
	//// ls3 = new LineSegment(xpos1, ypos1 , xpos3, ypos3 );
	// ls1 = new LineSegment(xpos1, ypos1 + 20, xpos2 - 20, ypos2);
	// ls2 = new LineSegment(xpos2, ypos2, xpos3, ypos3 - 20);
	// ls3 = new LineSegment(xpos1, ypos1 + 20, xpos3, ypos3 - 20);
	// c1 = new Circle(xpos1, ypos1+20,0);
	// c2 = new Circle(xpos2 - 20, ypos2, 0);
	// c3 = new Circle(xpos3, ypos3-20, 0);
	// cen1 = new Vect(xpos1, ypos1+20);
	// cen2 = new Vect(xpos2 - 20, ypos2);
	// cen3 = new Vect(xpos3, ypos3-20);
	// }
	// }

	public void rotateLs() {
		setOriginalCoordinates();
		if (angle == 0) {
			ls1 = new LineSegment(xpos1, ypos1, xpos2, ypos2);
			ls2 = new LineSegment(xpos2, ypos2, xpos3, ypos3);
			ls3 = new LineSegment(xpos1, ypos1, xpos3, ypos3);
			clear();
		}
		if (angle == 90) {
			xpos1 += 20;
			ypos1 += 20;
			xpos3 -= 20;
			clear();
		}
		if (angle == 180) {
			xpos2 -= 20;
			ypos2 += 20;
			ls1 = new LineSegment(xpos1, ypos1, xpos2, ypos2);
			ls2 = new LineSegment(xpos2, ypos2, xpos3, ypos3);
			ls3 = new LineSegment(xpos1, ypos1, xpos3, ypos3);
			clear();
		}
		if (angle == 270) {
			ypos1 += 20;
			xpos2 -= 20;
			ypos3 -= 20;
			ls1 = new LineSegment(xpos1, ypos1, xpos2, ypos2);
			ls2 = new LineSegment(xpos2, ypos2, xpos3, ypos3);
			ls3 = new LineSegment(xpos1, ypos1, xpos3, ypos3);
			clear();
		}
		setLineSegs();
		setCornerCentres();
		setCorners();
	}

	public void resetAngle() {
		angle = 0;
	}


	public void setOriginalCoordinates() {
		xpos1 = ogX1;
		xpos2 = ogX2;
		xpos3 = ogX3;
		ypos1 = ogY1;
		ypos2 = ogY2;
		ypos3 = ogY3;
	}

	public void clear() {
		lss.clear();
		corners.clear();
		cornerCentres.clear();
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
