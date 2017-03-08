package model;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Observable;
import java.util.StringTokenizer;

import physics.Angle;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;
import view.Board1;
public class Model1 extends Observable{
	fileReader file = new fileReader();
	saveFile savefile = new saveFile();
	addGizmo addGizmos = new addGizmo();
	deleteGizmo deleteGizmos = new deleteGizmo();
	AddFlipper addFlippers = new AddFlipper();
	private Absorber absorber;
	private Ball1 ball;
	private Triangle tri;
	private Triangle tri1;
	private Board1 board;
	private Square sq;
	
	ArrayList<Circle1> circles = new ArrayList<Circle1>();
	ArrayList<Triangle> triangles = new ArrayList<Triangle>();
	ArrayList<Square> squares = new ArrayList<Square>();
	ArrayList<LeftFlipper> leftFlippers = new ArrayList<LeftFlipper>();
	ArrayList<RightFlipper> rightFlippers = new ArrayList<RightFlipper>();
	ArrayList<Absorber> absorbers = new ArrayList<Absorber>();
	ArrayList<Ball1> balls = new ArrayList<Ball1>();

	private Walls1 gws;
	private boolean hitAbs = false;
	private LeftFlipper leftFlipper;
	private AffineTransform rotate;
	int offset = 5;
	
	public Model1() {
//		gws = new Walls1(0, 0, 500, 500);
//		ball = new Ball1(40, 405, 300, 300);
//		absorber = new Absorber(500,25,0,475);
//		leftFlipper = new LeftFlipper(20, 60, 250, 250, 1.0, 0.0);
		rotate = new AffineTransform();
	}
	
	public void moveBall() {
		double moveTime = 0.05; // 0.05 = 20 times per second as per Gizmoball
		if (ball != null && !ball.stopped()) {
			CollisionDetails1 cd = timeUntilCollision();
			double tuc = cd.getTuc();
			if (tuc > moveTime) {
				// No collision ...
				ball = movelBallForTime(ball, moveTime);
			} else {
				// We've got a collision in tuc
				ball = movelBallForTime(ball, tuc);
				// Post collision velocity ...
				ball.setVelo(cd.getVelo());
			}
			// Notify observers ... redraw updated view
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	
	public void load()
	{
	ArrayList<String> gizmos = new ArrayList<String>();
	file.readFile();
	gizmos = file.getGizmos();
	for(int i = 0; i < gizmos.size(); i++)
	{
		StringTokenizer st = new StringTokenizer(gizmos.get(i));  
		if(st.hasMoreTokens()){
			//System.out.println(st.nextToken());
			String cGizmo = st.nextToken();
			String name = st.nextToken();
			String value1 = st.nextToken();
			String value2 = st.nextToken();

			if(cGizmo.equals("Triangle"))
			{
				double value1d = Double.parseDouble(value1);
				double value2d = Double.parseDouble(value2);
				addTriangle(name, value1d, value2d);
			}
			else if(cGizmo.equals("Square"))
			{
				double value1d = Double.parseDouble(value1);
				double value2d = Double.parseDouble(value2);
				addSquare(name, value1d, value2d);
			}
			else if(cGizmo.equals("Circle"))
			{
				double value1d = Double.parseDouble(value1);
				double value2d = Double.parseDouble(value2);
				addCircle(name, value1d, value2d);
			}
			else if(cGizmo.equals("LeftFlipper"))
			{
				double value1d = Double.parseDouble(value1);
				double value2d = Double.parseDouble(value2);
				addLeftFlipper(name, value1d, value2d);
			}
			else if(cGizmo.equals("RightFlipper"))
			{
				double value1d = Double.parseDouble(value1);
				double value2d = Double.parseDouble(value2);
				addRightFlipper(name, value1d, value2d);
			}
			else if(cGizmo.equals("Absorber"))
			{
				double value1d = Double.parseDouble(value1);
				double value2d = Double.parseDouble(value2);
				addAbsorber(name, value1d, value2d);
			}
			else if(cGizmo.equals("Ball"))
			{
				double value1d = Double.parseDouble(value1);
				double value2d = Double.parseDouble(value2);
				double value3 = Double.parseDouble(st.nextToken());
				double value4 = Double.parseDouble(st.nextToken());
				addBall(name, value1d, value2d, value3, value4);
			}
			else if(cGizmo.equals("Connect"))
			{
				
			}
			else if(cGizmo.equals("Key Connect"))
			{
				
			}
			else if(cGizmo.equals("Rotate"))
			{
				
			}
		}
		this.setChanged();
		this.notifyObservers();
	}
	}
	
	
	private Ball1 movelBallForTime(Ball1 ball, double time) {
		double newX = 0.0;
		double newY = 0.0;
		double xVel = ball.getVelo().x();
		double yVel = ball.getVelo().y();
		newX = ball.getExactX() + (xVel * time);
		newY = ball.getExactY() + (yVel * time);
		ball.setExactX(newX);
		ball.setExactY(newY);
		return ball;
	}
	
	public void rotateLeft() {
		leftFlipper = rotate(leftFlipper);
		this.setChanged();
		this.notifyObservers();
	}
	
	public LeftFlipper rotate(LeftFlipper leftFlipper) {
		double newA = 0.0;
		double newB = 0.0;
		newA = 0.0;
		newB = -1.0;
		leftFlipper.setAngle(newA,newB);
		return leftFlipper;
		
	} 
	
/*	public void rotateLeftFLip() {
		leftFlipper = rotateLeftFlipper(leftFlipper);
		this.setChanged();
		this.notifyObservers();
	}
	
	public LeftFlipper rotateLeftFlipper(LeftFlipper leftFlipper) {
		double newA = 0.0;
		double newB = 1.0;
	
		newA = 0.0;
		newB = -1.0;
		
		
	//	leftFlipper.setAngle(newA);
		
		return leftFlipper;
		
	} */
	
	
	private CollisionDetails1 timeUntilCollision() {
		// Find Time Until Collision and also, if there is a collision, the new speed vector.
		// Create a physics.Circle from Ball
		Circle ballCircle = ball.getCircle();
		Vect ballVelocity = ball.getVelo();
		Vect newVelo = new Vect(0, 0);
		// Now find shortest time to hit a vertical line or a wall line
		double shortestTime = Double.MAX_VALUE;
		double time = 0.0;
		// Time to collide with 4 walls
		ArrayList<LineSegment> lss = gws.getLineSegments();
		for (LineSegment line : lss) {
			time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(line, ball.getVelo(), 1.0);
				System.out.println("APPROACHING WALL");
			}
			
		}
		// Time to collide with absorber
			LineSegment ls = absorber.getAbsLineSeg();
			time = Geometry.timeUntilWallCollision(ls, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(ls, ball.getVelo(), 1.0);
				System.out.println("APPROACHING ABSORBER");
			}
			
			//Detect collision with absorber and move ball
			if(time<0.09){
				System.out.println("Collision");
				Vect velo = new Vect(0,100);
				newVelo = Geometry.reflectWall(ls, velo, 1.0);
				ball.setExactX(480);
				ball.setExactY(465);
			}
		return new CollisionDetails1(shortestTime, newVelo);
	}
	
	
	public LeftFlipper getLeftFlipper(){
		return leftFlipper;
	}
	
	public void setBallSpeed(int x, int y){
		ball.setVelo(new Vect(x, y));
	}
	
	public void save(){
		savefile.save();
	}
	
	public void addGizmo(String gizmo, double x, double y)
	{
		double x1 = x;
		double y1 = y;
		String gizmo1 = gizmo;
		addGizmo.add(gizmo1, x1, y1);
	}
	
	public void addFlipper(String gizmo, double x, double y)
	{
		double x1 = x;
		double y1 = y;
		String gizmo1 = gizmo;
		addFlippers.add(gizmo1, x1, y1);
	}
	
	public void addAbsorber(double x, double y)
	{
		double x1 = x;
		double y1 = y;
		
	}
	
	public void deleteGizmo(String gizmo, double x, double y)
	{
		double x1 = x;
		double y1 = y;
		String gizmo1 = gizmo;
		String name = null;
		if(gizmo1.equals("Triangle"))
		{
			name = "T"+x1+y1;
		}
		else if(gizmo1.equalsIgnoreCase("Square"))
		{
			name = "S"+x1+y1;
		}
		else if(gizmo1.equalsIgnoreCase("Circle"))
		{
			name = "C"+x1+y1;
		}
		deleteGizmo.delete(gizmo1,name);
	}

	public void addTriangle(String name, double x, double y)
	{
		Triangle t = new Triangle(name, x, y);
		triangles.add(t);
	}

	public void addSquare(String name, double x, double y)
	{
		Square sq = new Square(name, x, y);
		squares.add(sq);
	}
	
	public void addCircle(String name, double x, double y)
	{
		Circle1 c = new Circle1(name, x, y);
		circles.add(c);
	}
	
	public void addLeftFlipper(String name, double x, double y)
	{
		LeftFlipper lf = new LeftFlipper(name, x, y);
		leftFlippers.add(lf);
	}
	
	public void addRightFlipper(String name, double x, double y)
	{
		RightFlipper rf = new RightFlipper(name, x, y);
		rightFlippers.add(rf);
	}
	
	public void addAbsorber(String name, double x, double y)
	{
		Absorber a = new Absorber(name, x, y);
		absorbers.add(a);
	}
	
	public void addBall(String name, double x, double y, double xv, double yv)
	{
		Ball1 b = new Ball1(name, x, y, xv, yv);
		balls.add(b);
	}
	
	public void deleteTriangle(int index)
	{
		triangles.remove(index);
	}

	public void deleteSquare(int index)
	{
		squares.remove(index);
	}
	
	public void deleteCircle(int index)
	{
		squares.remove(index);
	}
	
	public void deleteLeftFlipper(int index)
	{
		leftFlippers.remove(index);
	}
	
	public void deleteRightFlipper(int index)
	{
		rightFlippers.remove(index);
	}
	
	public void deleteAbsorber(int index)
	{
		absorbers.remove(index);
	}
	
	public void deleteBall(int index)
	{
		balls.remove(index);
	}
	
	public ArrayList<Square> getSquare() {
		return squares;
	}
	
	public ArrayList<Circle1> getCircle() {
		return circles;
	}
	
	public ArrayList<Triangle> getTriangle() {
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
	
	public ArrayList<Ball1> getBall() {
		return balls;
	}
}