package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.StringTokenizer;
import java.util.Timer;

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
	private ArrayList<LeftFlipper> leftFlippers = new ArrayList<LeftFlipper>();
	private ArrayList<RightFlipper> rightFlippers = new ArrayList<RightFlipper>();
	private ArrayList<Absorber> abs = new ArrayList<Absorber>();
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	private LoadReader file = new LoadReader();
	private saveFile savefile = new saveFile();

	int counter = 0;

	public Model() {
		gws = new Walls(0, 0, 400, 400);
		physicsLoop = new PhysicsLoop(balls, gws, abs, keyPressed, squares, circs, tris, leftFlippers, rightFlippers);

	}

	public void start() {
		// System.out.println(balls);
		// System.out.println(abs);
		if (balls.get(0) != null && !balls.get(0).stopped()) {
			// System.out.println(balls.get(0).getVelo());
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
		if (!balls.isEmpty()) {
			ball.setVelo(new Vect(x, y));
		}
	}

	public void releaseBall() {
		for (int i = 0; i < balls.size(); i++) {
			System.out.println("Release Ball called");
			keyPressed = true;
			balls.get(i).start();
		}
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

	public ArrayList<LeftFlipper> getLFlipper() {
		return leftFlippers;
	}

	public ArrayList<RightFlipper> getRFlipper() {
		return rightFlippers;
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

	public void addLeftFlipper(LeftFlipper leftFlipper) {
		leftFlippers.add(leftFlipper);
	}

	public void addRightFlipper(RightFlipper rightFlipper) {
		rightFlippers.add(rightFlipper);
	}

	public void save() {
		savefile.save(tris, squares, circs, leftFlippers, rightFlippers, abs, balls);
	}

	public void loadBoard() {
		System.out.println("Starting load method");
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
					System.out.println("Loading triangle");
					TriangleGizmo t = new TriangleGizmo(name, value1, value2);
					tris.add(t);

				} else if (cGizmo.equals("Square")) {
					SquareGizmo sq = new SquareGizmo(name, value1, value2);
					squares.add(sq);

				} else if (cGizmo.equals("Circle")) {
					CircleGizmo c = new CircleGizmo(name, value1, value2);
					circs.add(c);

				} else if (cGizmo.equals("LeftFlipper")) {
					LeftFlipper lf = new LeftFlipper(name, value1, value2);
					leftFlippers.add(lf);

				} else if (cGizmo.equals("RightFlipper")) {
					RightFlipper rf = new RightFlipper(name, value1, value2);
					rightFlippers.add(rf);

				} else if (cGizmo.equals("Absorber")) {
					Absorber a = new Absorber(name, value1, value2);
					abs.add(a);
					System.out.println(abs);
				} else if (cGizmo.equals("Ball")) {
					double value3 = Double.parseDouble(st.nextToken());
					double value4 = Double.parseDouble(st.nextToken());
					Ball b = new Ball(name, value1, value2, value3, value4);
					balls.add(b);
				}
			}
		}
	}

	public void load() {
		loadBoard();
		// System.out.println("starting ball");
		Vect v = new Vect(500, 500);
		balls.get(0).setVelo(v);
		// System.out.println(abs);
		this.setChanged();
		this.notifyObservers();
	}

	public void addSquareGizmo(int x, int y) {
		String name = "S" + x + y;
		SquareGizmo sqg = new SquareGizmo(name, x, y);
		if (!checkGizmos(x, y)) {
			squares.add(sqg);
		}
		this.notifyObservers();
		this.setChanged();
	}

	public void addCircleGizmo(int x, int y) {
		String name = "C" + x + y;
		CircleGizmo cg = new CircleGizmo(name, x, y);
		if (!checkGizmos(x, y)) {
			circs.add(cg);
		}
		this.notifyObservers();
		this.setChanged();
	}

	public void addTriangleGizmo(int x, int y) {
		String name = "T" + x + y;
		TriangleGizmo tg = new TriangleGizmo(name, x, y);
		if (!checkGizmos(x, y)) {
			tris.add(tg);
		}
		System.out.println(name);
		this.notifyObservers();
		this.setChanged();
	}

	public String deleteGizmo(int x, int y) {
		for (int i = 0; i < tris.size(); i++) {
			if (tris.get(i).getXpos1() == x * 20 && tris.get(i).getYpos1() == y * 20) {
				tris.remove(i);
				this.notifyObservers();
				this.setChanged();
				return "Triangle";
			}
		}
		for (int i = 0; i < circs.size(); i++) {
			if (circs.get(i).getExactX() == x * 20 + 10 && circs.get(i).getExactY() == y * 20 + 10) {
				circs.remove(i);
				this.notifyObservers();
				this.setChanged();
				return "Circle";
			}
		}
		for (int i = 0; i < squares.size(); i++) {
			if (squares.get(i).getXPos() == x * 20 && squares.get(i).getYPos() == y * 20) {
				squares.remove(i);
				this.notifyObservers();
				this.setChanged();
				return "Square";
			}
		}
		for (int i = 0; i < abs.size(); i++) {
			if (abs.get(i).getYPos() == y * 20) {
				abs.remove(i);
				this.notifyObservers();
				this.setChanged();
				return "Absorber";
			}
		}
		for (int i = 0; i < leftFlippers.size(); i++) {
			if (leftFlippers.get(i).getXPos() == x * 20 && leftFlippers.get(i).getYPos() == y * 20) {
				leftFlippers.remove(i);
				this.notifyObservers();
				this.setChanged();
				return "LF";
			}
		}
		for (int i = 0; i < rightFlippers.size(); i++) {
			if (rightFlippers.get(i).getXPos() == x * 20 && rightFlippers.get(i).getYPos() == y * 20) {
				rightFlippers.remove(i);
				this.notifyObservers();
				this.setChanged();
				return "RF";
			}
		}
		for (int i = 0; i < balls.size(); i++) {
			if (balls.get(i).getExactX() == x * 20 && balls.get(i).getExactY() == y * 20) {
				balls.remove(i);

				this.notifyObservers();
				this.setChanged();
				return "Balls";
			}
		}
		this.notifyObservers();
		this.setChanged();

		return null;
	}

	public void addAbsorberGizmo(int y) {
		String name = "A";
		Absorber a = new Absorber(name, 0, 19);
		if (!checkGizmos(0, y)) {
			abs.add(a);
		}
		this.notifyObservers();
		this.setChanged();
	}

	public void addBallGizmo(int x, int y, double xv, double yv) {
		String name = "B";
		System.out.println(balls.size());
		if (balls.size() < 1) {
			Ball b = new Ball(name, x, y, xv, yv);
			if (!checkGizmos(x, y)) {
				balls.add(b);
			}
		} else {
			System.out.println("too many balls");
		}
		this.notifyObservers();
		this.setChanged();
	}

	public void addRFlipperGizmo(int x, int y) {
		String name = "RF" + x + y;
		RightFlipper rf = new RightFlipper(name, x, y);
		if (!checkGizmos(x, y)) {
			rightFlippers.add(rf);
		}
		this.notifyObservers();
		this.setChanged();
	}

	public void addLFlipperGizmo(int x, int y) {
		String name = "LF" + x + y;
		LeftFlipper lf = new LeftFlipper(name, x, y);
		if (!checkGizmos(x, y)) {
			leftFlippers.add(lf);
		}
		this.notifyObservers();
		this.setChanged();
	}

	public boolean checkGizmos(int x, int y) {
		for (int i = 0; i < tris.size(); i++) {
			if (tris.get(i).getXpos1() == x * 20 && tris.get(i).getYpos1() == y * 20) {
				return true;
			}
		}
		for (int i = 0; i < circs.size(); i++) {
			if (circs.get(i).getExactX() == x * 20 + 10 && circs.get(i).getExactY() == y * 20 + 10) {
				return true;
			}
		}
		for (int i = 0; i < squares.size(); i++) {
			if (squares.get(i).getXPos() == x * 20 && squares.get(i).getYPos() == y * 20) {
				return true;
			}
		}
		for (int i = 0; i < balls.size(); i++) {
			if (balls.get(i).getExactX() == x * 20 && balls.get(i).getExactY() == y * 20) {
				return true;
			}
		}
		for (int i = 0; i < rightFlippers.size(); i++) {
			if (rightFlippers.get(i).getXPos() == x * 20 && rightFlippers.get(i).getYPos() == y * 20) {
				return true;
			}
		}
		for (int i = 0; i < leftFlippers.size(); i++) {
			if (leftFlippers.get(i).getXPos() == x * 20 && leftFlippers.get(i).getYPos() == y * 20) {
				return true;
			}
		}
		for (int i = 0; i < abs.size(); i++) {
			if (abs.get(i).getYPos() == y * 20) {
				return true;
			}
		}
		return false;
	}

	public void clearBoard() {
		if (!balls.isEmpty()) {
			balls.clear();
		}
		if (!rightFlippers.isEmpty()) {
			rightFlippers.clear();
		}
		if (!leftFlippers.isEmpty()) {
			leftFlippers.clear();
		}
		if (!squares.isEmpty()) {
			squares.clear();
		}
		if (!circs.isEmpty()) {
			circs.clear();
		}
		if (!tris.isEmpty()) {
			tris.clear();
		}
		if (!abs.isEmpty()) {
			abs.clear();
		}
		this.setChanged();
		this.notifyObservers();
	}

	public void moveGizmoAdd(int x, int y, String giz) {
		switch (giz) {
		case "Square":
			addSquareGizmo(x, y);
			break;
		case "Triangle":
			addTriangleGizmo(x, y);
			break;
		case "Circle":
			addCircleGizmo(x, y);
			break;
		case "Ball":
			addBallGizmo(x, y, 50, 50);
			break;
		}
	}

	public SquareGizmo checkSquares(int x, int y) {
		for (int i = 0; i < squares.size(); i++) {
			if (squares.get(i).getXPos() == x * 20 && squares.get(i).getYPos() == y * 20) {
				return squares.get(i);
			}
		}
		return null;
	}

	public TriangleGizmo checkTriangles(int x, int y) {
		for (int i = 0; i < tris.size(); i++) {
			if (tris.get(i).getXpos1() == x * 20 && tris.get(i).getYpos1() == y * 20) {
				return tris.get(i);
			}
		}
		return null;
	}

	public CircleGizmo checkCircs(int x, int y) {
		for (int i = 0; i < circs.size(); i++) {
			if (circs.get(i).getExactX() == x * 20 + 10 && circs.get(i).getExactY() == y * 20 + 10) {
				return circs.get(i);
			}
		}
		return null;
	}

	public Ball checkBalls(int x, int y) {
		for (int i = 0; i < balls.size(); i++) {
			if (balls.get(i).getExactX() == x * 20 && balls.get(i).getExactY() == y * 20) {
				return balls.get(i);
			}
		}
		return ball;
	}

	public RightFlipper checkRFs(int x, int y) {
		for (int i = 0; i < rightFlippers.size(); i++) {
			if (rightFlippers.get(i).getXPos() == x * 20 && rightFlippers.get(i).getYPos() == y * 20) {
				return rightFlippers.get(i);
			}
		}
		return null;
	}

	public LeftFlipper checkLFs(int x, int y) {
		for (int i = 0; i < leftFlippers.size(); i++) {
			if (leftFlippers.get(i).getXPos() == x * 20 && leftFlippers.get(i).getYPos() == y * 20) {
				return leftFlippers.get(i);
			}
		}
		return null;
	}

	public Absorber checkAbs(int x, int y) {
		for (int i = 0; i < abs.size(); i++) {
			if (abs.get(i).getYPos() == y * 20) {
				return abs.get(i);
			}
		}
		return null;
	}
	
	public void rotate(int x, int y){
		if(checkTriangles(x, y) != null){
			System.out.println("in rotating method of model");
			checkTriangles(x, y).rotate();
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public void flipFlippers(){
		System.out.println("flipFlippers called");
		leftFlippers.get(0).rotateLines();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void unflipFlippers(){
		leftFlippers.get(0).unrotateLines();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setGrav(double g){
		physicsLoop.setGrav(g);
	}
}