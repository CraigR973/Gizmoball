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
		//System.out.println(balls);
		//System.out.println(abs);
		if (balls.get(0) != null && !balls.get(0).stopped()) {
			//System.out.println(balls.get(0).getVelo());
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
		if(!balls.isEmpty()){
		ball.setVelo(new Vect(x, y));
		}
	}

	public void releaseBall() {
		for(int i = 0; i < balls.size(); i++){
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
	
	public ArrayList<Absorber> getAbs(){
		return abs;
	}
	
	public ArrayList<Ball> getBalls(){
		return balls;
	}
	
	public ArrayList<LeftFlipper> getLFlipper() {
		return leftFlippers;
	}

	public ArrayList<RightFlipper> getRFlipper() {
		return rightFlippers;
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
	
	public void addLeftFlipper(LeftFlipper leftFlipper){
		leftFlippers.add(leftFlipper);
	}
	
	public void addRightFlipper(RightFlipper rightFlipper){
		rightFlippers.add(rightFlipper);
	}
	
	
	public void save(){
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
					System.out.println(value1);
					System.out.println(value2);
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
				else if(cGizmo.equals("Rotate"))
				{
					
				}
			}
		}
	}
	
	public void load(){
		loadBoard();
		//System.out.println("starting ball");
		Vect v = new Vect(500,500);
		balls.get(0).setVelo(v);
		//System.out.println(abs);
		this.setChanged();
		this.notifyObservers();
	}
	
}
