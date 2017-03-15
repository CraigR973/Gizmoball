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

	private ArrayList<Absorber> abs = new ArrayList<Absorber>();
	private ArrayList<Ball> balls = new ArrayList<Ball>();
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
		absorber = new Absorber(400, 20, 0, 380);
		abs.add(absorber);
		balls.add(ball);
		physicsLoop = new PhysicsLoop(balls, gws, abs, keyPressed, squares, circs, tris);

	}

	public void start() {
		if (ball != null && !ball.stopped()) {
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

	public ArrayList<Absorber> getAbs() {
		return abs;
	}

	public ArrayList<Ball> getBalls() {
		return balls;
	}

	public void addSquare(SquareGizmo sq) {
		squares.add(sq);
	}

	public void addCircle(CircleGizmo c) {
		circs.add(c);
	}

	public void addTriangle(TriangleGizmo t) {
		tris.add(t);
	}

	public void addAbsorber(Absorber a) {
		absorber = a;
	}

	public void addSquareGizmo(int x, int y) {
		SquareGizmo sqg = new SquareGizmo(20, 20, x * 20, y * 20);
		checkGizmos(x, y);
		squares.add(sqg);
		this.notifyObservers();
		this.setChanged();
	}

	public void addCircleGizmo(int x, int y) {
		CircleGizmo cg = new CircleGizmo(x * 20 + 10, y * 20 + 10);
		checkGizmos(x, y);
		circs.add(cg);
		this.notifyObservers();
		this.setChanged();
	}

	public void addTriangleGizmo(int x, int y) {
		TriangleGizmo tg = new TriangleGizmo(x * 20, y * 20, 20, 20);
		checkGizmos(x, y);
		tris.add(tg);
		this.notifyObservers();
		this.setChanged();
	}

	public void deleteGizmo(int x, int y) {
		for (int i = 0; i < tris.size(); i++) {
			if (tris.get(i).getXpos1() == x * 20 && tris.get(i).getYpos1() == y * 20) {
				tris.remove(i);
			}
		}
		for (int i = 0; i < circs.size(); i++) {
			if (circs.get(i).getExactX() == x * 20 + 10 && circs.get(i).getExactY() == y * 20 + 10) {
				circs.remove(i);
			}
		}
		for (int i = 0; i < squares.size(); i++) {
			if (squares.get(i).getXPos() == x * 20 && squares.get(i).getYPos() == y * 20) {
				squares.remove(i);
			}
		}
		for (int i = 0; i < abs.size(); i++) {
			if (abs.get(i).getYPos() == y * 20) {
				abs.remove(i);
			}
		}
		this.notifyObservers();
		this.setChanged();
	}

	public void addAbsorberGizmo(int y) {
		Absorber a = new Absorber(400, 20, 0, y * 20);
		abs.add(a);
		this.notifyObservers();
		this.setChanged();
	}

	public void addBallGizmo(int x, int y) {
		if (balls.size() > 1) {
			Ball b = new Ball(x * 20, y * 20, 50, 50);
			balls.add(b);
			this.notifyObservers();
			this.setChanged();
		} else {
			System.out.println("too many balls");
		}
	}

	public void checkGizmos(int x, int y){
		for(int i = 0; i < tris.size(); i++){
			if(tris.get(i).getXpos1() == x*20 && tris.get(i).getYpos1() == y*20){
				tris.remove(i);
			}
		}
		for(int i = 0; i < circs.size(); i++){
			if(circs.get(i).getExactX() == x*20+10 && circs.get(i).getExactY() == y*20+10){
				circs.remove(i);
			}
		}
		for(int i = 0; i < squares.size(); i++){
			if(squares.get(i).getXPos() == x*20 && squares.get(i).getYPos() == y*20){
				squares.remove(i);
			}
		}
		for(int i = 0; i < balls.size(); i++){
			if(balls.get(i).getExactX() == x*20 && balls.get(i).getExactY() == y*20){
				balls.remove(i);
			}
		}
	}
}
