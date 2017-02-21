package model;

import java.util.ArrayList;
import java.util.Observable;
import physics.Angle;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;
import view.Board;

import java.util.StringTokenizer;

public class Model extends Observable {

	private Ball ball;
	private Walls gws;
	private fileReader file = new fileReader();
	private Absorber absorber;
	private TriangleGizmo tri;
	private TriangleGizmo tri1;
	private Board board;
	private SquareGizmo sq;
	private ArrayList<TriangleGizmo> triangles= new ArrayList<TriangleGizmo>();;
	private ArrayList<SquareGizmo> squares= new ArrayList<SquareGizmo>();;
	private ArrayList<CircleGizmo> circles= new ArrayList<CircleGizmo>();;
	private ArrayList<LeftFlipper> leftFlippers = new ArrayList<LeftFlipper>();;
	private ArrayList<RightFlipper> rightFlippers = new ArrayList<RightFlipper>();;
	private ArrayList<Absorber> absorbers = new ArrayList<Absorber>();;
	private ArrayList<Ball> balls = new ArrayList<Ball>();;

	public Model() {
		ball = new Ball("B", 50, 250, 300, 300);
		
		loadBoard();
	}

	public void loadBoard() {
		ArrayList<String> gizmos = new ArrayList<String>();
		file.readFile();
		gizmos = file.getGizmos();
		for (int i = 0; i < gizmos.size(); i++) {
			StringTokenizer st = new StringTokenizer(gizmos.get(i));
			if (st.hasMoreTokens()) {
				// System.out.println(st.nextToken());
				String cGizmo = st.nextToken();
				String name = st.nextToken();
				double value1 = Double.parseDouble(st.nextToken());
				double value2 = Double.parseDouble(st.nextToken());

				if (cGizmo.equals("Triangle")) {

					TriangleGizmo t = new TriangleGizmo(name, value1, value2);
					triangles.add(t);
				} else if (cGizmo.equals("Square")) {
					SquareGizmo sq = new SquareGizmo(name, value1, value2);
					squares.add(sq);

				} else if (cGizmo.equals("Circle")) {
					CircleGizmo c = new CircleGizmo(name, value1, value2);
					circles.add(c);
				} else if (cGizmo.equals("LeftFlipper")) {
					LeftFlipper lf = new LeftFlipper(name, value1, value2);
					leftFlippers.add(lf);
				} else if (cGizmo.equals("RightFlipper")) {
					RightFlipper rf = new RightFlipper(name, value1, value2);
					rightFlippers.add(rf);
				} else if (cGizmo.equals("Absorber")) {
					Absorber a = new Absorber(name, value1, value2);
					absorbers.add(a);
				} else if (cGizmo.equals("Ball")) {
					double value3 = Double.parseDouble(st.nextToken());
					double value4 = Double.parseDouble(st.nextToken());
					Ball b = new Ball(name, value1, value2, value3, value4);
					balls.add(b);
				}
			}
		}
	}

	



	public ArrayList<SquareGizmo> getSquare() {
		return squares;
	}

	public ArrayList<CircleGizmo> getCircle() {
		return circles;
	}

	public ArrayList<TriangleGizmo> getTriangle() {
		return triangles;
	}

	public ArrayList<Absorber> getAbsorber() {
		return absorbers;
	}

	public ArrayList<LeftFlipper> getLFlipper() {
		return leftFlippers;
	}

	public ArrayList<RightFlipper> getRFlipper() {
		return rightFlippers;
	}

	public ArrayList<Ball> getBall() {
		return balls;
	}
}