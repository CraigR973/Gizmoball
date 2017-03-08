package model;

import java.util.ArrayList;
import java.util.Observable;
import physics.Vect;

public class Model extends Observable {
	private Absorber absorber;
	private Ball ball;
	private Walls gws;
	private boolean keyPressed = false;
	PhysicsLoop physicsLoop;
	private ArrayList<CircleGizmo> circs = new ArrayList<CircleGizmo>();
	private ArrayList<TriangleGizmo> tris = new ArrayList<TriangleGizmo>();
	private ArrayList<SquareGizmo> squares = new ArrayList<SquareGizmo>();

	private TriangleGizmo tri;
	private TriangleGizmo tri1;
	private SquareGizmo sq;
	private SquareGizmo sq1;
	private CircleGizmo cir;
	private CircleGizmo cir1;
	int counter = 0;

	public Model() {

		tri = new TriangleGizmo(380, 0, 20, 20);
		tri1 = new TriangleGizmo(120, 140, 20, 20);
		sq = new SquareGizmo(20, 20, 280, 270);
		sq1 = new SquareGizmo(20, 20, 180, 170);
		cir = new CircleGizmo(200, 10);
		cir1 = new CircleGizmo(90, 40);
		circs.add(cir);
		circs.add(cir1);
		tris.add(tri);
		tris.add(tri1);
		squares.add(sq);
		squares.add(sq1);
		gws = new Walls(0, 0, 400, 400);
		ball = new Ball(0, 385, 0, 0);
		absorber = new Absorber(400, 25, 0, 375);
		physicsLoop = new PhysicsLoop(ball, gws, absorber, keyPressed, squares, circs, tris);

	}

	public void start() {
		if (ball != null && !ball.stopped()) {
			System.out.println(ball.getVelo());
			physicsLoop.moveBall();
			this.setChanged();
			this.notifyObservers();
		}
	}

	public Absorber getAbsorber() {
		return absorber;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBallSpeed(int x, int y) {
		ball.setVelo(new Vect(x, y));
	}

	public void releaseBall() {
		System.out.println("Release Ball called");
		keyPressed = true;
		ball.start();
	}

	public void captureBall() {
		keyPressed = false;
	}
	public ArrayList<CircleGizmo> getCircles() {
		return circs;
	}

	public ArrayList<TriangleGizmo> getTriangles() {
		return tris;
	}

	public ArrayList<SquareGizmo> getSquares() {
		return squares;
	}
	
	public void addSquare(SquareGizmo sq){
		squares.add(sq);
	}
	
	public void addCircle(CircleGizmo c){
		circs.add(c);
	}
	
	public void addTriangle(TriangleGizmo t){
		tris.add(t);
	}
	
	public void addAbsorber(Absorber a){
		absorber = a;
	}
}
