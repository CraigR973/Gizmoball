package model;
import java.util.ArrayList;
import java.util.Observable;
import physics.Angle;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;
import view.Board1;

import java.util.StringTokenizer;  

public class Model1 extends Observable{
	fileReader file = new fileReader();
	saveFile savefile = new saveFile();
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
	
	public Model1() {
		
		
		
//		gws = new Walls1(0, 0, 500, 500);
//		ball = new Ball1(50, 250, 300, 300);
//		absorber = new Absorber(500,25,0,475);
//		tri = new Triangle(450,500,500,0,50,0);
		


		Triangle t = new Triangle("T1", 19, 0);
		Triangle t1 = new Triangle("T2", 1, 1);
		
		
		Square sq = new Square("S02", 0, 2);
		Square sq1 = new Square("S12" ,1 ,2);
		Square sq2 = new Square("S22", 2 ,2);
		Square sq3 = new Square("S32", 3, 2);
		Square sq4 = new Square("S42", 4 ,2);
		Square sq5 = new Square("S52", 5, 2);
		Square sq6 = new Square("S62", 6, 2);
		Square sq7 = new Square("S72", 7, 2);
		Square sq8 = new Square("S82" ,8 ,2);
		Square sq9 = new Square("S132" ,13 ,2);
		Square sq10 = new Square("S142", 14 ,2);
		Square sq11 = new Square("S152", 15, 2);
		Square sq12 = new Square("S162", 16, 2);
		Square sq13 = new Square("S172", 17, 2);
		Square sq14 = new Square("S182", 18, 2);
		
		Circle1 c = new Circle1("C43" ,4 ,3);
		Circle1 c1 = new Circle1("C54" ,5, 4);
		Circle1 c2 = new Circle1("C65" ,6 ,5);
		Circle1 c3 = new Circle1("C76" ,7 ,6);
		Circle1 c4 = new Circle1("C99" ,9, 9);
		Circle1 c5 = new Circle1("C109", 10 ,9);
		Circle1 c6 = new Circle1("C1110", 11, 10);
		Circle1 c7 = new Circle1("C129", 12, 9);
		Circle1 c8 = new Circle1("C139", 13, 9);
		Circle1 c9 = new Circle1("C156", 15, 6);
		Circle1 c10 = new Circle1("C165" ,16, 5);
		Circle1 c11 = new Circle1("C174", 17 ,4);
		Circle1 c12 = new Circle1("C183" ,18, 3);
		
		LeftFlipper lf = new LeftFlipper("LF92", 9, 2);
		LeftFlipper lf1 = new LeftFlipper("LF87" ,8 ,7);
		
		RightFlipper rf = new RightFlipper("RF112", 12.5 ,2);
		RightFlipper rf1 = new RightFlipper("RF137", 14 ,7);
		
		Absorber a = new Absorber("A", 0, 19);

		Ball1 b = new Ball1("ball1",1.0 ,11.0, 0.0 ,0.0);
		
		
		triangles.add(t);
		triangles.add(t1);
		squares.add(sq);
		squares.add(sq1);
		squares.add(sq2);
		squares.add(sq3);
		squares.add(sq4);
		squares.add(sq5);
		squares.add(sq6);
		squares.add(sq7);
		squares.add(sq8);
		squares.add(sq9);
		squares.add(sq10);
		squares.add(sq11);
		squares.add(sq12);
		squares.add(sq13);
		squares.add(sq14);
		circles.add(c);
		circles.add(c1);
		circles.add(c2);
		circles.add(c3);
		circles.add(c4);
		circles.add(c5);
		circles.add(c6);
		circles.add(c7);
		circles.add(c8);
		circles.add(c9);
		circles.add(c10);
		circles.add(c11);
		circles.add(c12);
		leftFlippers.add(lf);
		leftFlippers.add(lf1);
		rightFlippers.add(rf);
		rightFlippers.add(rf1);
		absorbers.add(a);
		balls.add(b);
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
				Triangle t = new Triangle(name, value1d, value2d);
				triangles.add(t);
				if(st.hasMoreTokens()){
					
				}
			}
			else if(cGizmo.equals("Square"))
			{
				double value1d = Double.parseDouble(value1);
				double value2d = Double.parseDouble(value2);
				Square sq = new Square(name, value1d, value2d);
				squares.add(sq);
				
			}
			else if(cGizmo.equals("Circle"))
			{
				double value1d = Double.parseDouble(value1);
				double value2d = Double.parseDouble(value2);
				Circle1 c = new Circle1(name, value1d, value2d);
				circles.add(c);
			}
			else if(cGizmo.equals("LeftFlipper"))
			{
				double value1d = Double.parseDouble(value1);
				double value2d = Double.parseDouble(value2);
				LeftFlipper lf = new LeftFlipper(name, value1d, value2d);
				leftFlippers.add(lf);
			}
			else if(cGizmo.equals("RightFlipper"))
			{
				double value1d = Double.parseDouble(value1);
				double value2d = Double.parseDouble(value2);
				RightFlipper rf = new RightFlipper(name, value1d, value2d);
				rightFlippers.add(rf);
			}
			else if(cGizmo.equals("Absorber"))
			{
				double value1d = Double.parseDouble(value1);
				double value2d = Double.parseDouble(value2);
				Absorber a = new Absorber(name, value1d, value2d);
				absorbers.add(a);
			}
			else if(cGizmo.equals("Ball"))
			{
				double value1d = Double.parseDouble(value1);
				double value2d = Double.parseDouble(value2);
				double value3 = Double.parseDouble(st.nextToken());
				double value4 = Double.parseDouble(st.nextToken());
				Ball1 b = new Ball1(name, value1d, value2d, value3, value4);
				balls.add(b);
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
	
//	public void moveBall() {
//		double moveTime = 0.05; // 0.05 = 20 times per second as per Gizmoball
//		if (ball != null && !ball.stopped()) {
//			CollisionDetails1 cd = timeUntilCollision();
//			double tuc = cd.getTuc();
//			if (tuc > moveTime) {
//				// No collision ...
//				ball = movelBallForTime(ball, moveTime);
//			} else {
//				// We've got a collision in tuc
//				ball = movelBallForTime(ball, tuc);
//				// Post collision velocity ...
//				ball.setVelo(cd.getVelo());
//			}
//			// Notify observers ... redraw updated view
//			this.setChanged();
//			this.notifyObservers();
//		}
//	}
	
	private void printSq(){
		System.out.println(circles);
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
	
//	private CollisionDetails1 timeUntilCollision() {
		// Find Time Until Collision and also, if there is a collision, the new speed vector.
		// Create a physics.Circle from Ball
//		Circle ballCircle = ball.getCircle();
//		Vect ballVelocity = ball.getVelo();
//		Vect newVelo = new Vect(0, 0);
//		// Now find shortest time to hit a vertical line or a wall line
//		double shortestTime = Double.MAX_VALUE;
//		double time = 0.0;
//		// Time to collide with 4 walls
//		ArrayList<LineSegment> lss = gws.getLineSegments();
//		for (LineSegment line : lss) {
//			time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
//			if (time < shortestTime) {
//				shortestTime = time;
//				newVelo = Geometry.reflectWall(line, ball.getVelo(), 1.0);
//			System.out.println("APPROACHING WALL");
//			}
			
	//	}
		// Time to collide with absorber
//			LineSegment ls = absorber.getAbsLineSeg();
//			time = Geometry.timeUntilWallCollision(ls, ballCircle, ballVelocity);
//			if (time < shortestTime) {
//				shortestTime = time;
//				newVelo = Geometry.reflectWall(ls, ball.getVelo(), 1.0);
//				System.out.println("APPROACHING ABSORBER");
//			}
			
			//Detect collision with absorber and move ball
//			if(time < 0.05){
//				boolean keyPressed = false;
//				System.out.println("Collision");
//				ball.setExactX(475);
//				ball.setExactY(465);
//				while(keyPressed == false){
//					ball.stop();
//				}
//				Vect velo = new Vect(0,400);
//				newVelo = Geometry.reflectWall(ls, velo, 1.0);
//			}
			
//			LineSegment tls = tri.getLineSeg();
//			time = Geometry.timeUntilWallCollision(tls, ballCircle, ballVelocity);
//			if (time < shortestTime) {
//				shortestTime = time;
//				newVelo = Geometry.reflectWall(tls, ball.getVelo(), 1.0);
//				System.out.println("APPROACHING TRIANGLE");
//			}
			
//			LineSegment tls1 = tri1.getLineSeg();
//			time = Geometry.timeUntilWallCollision(tls1, ballCircle, ballVelocity);
//			if (time < shortestTime) {
//				shortestTime = time;
//				newVelo = Geometry.reflectWall(tls1, ball.getVelo(), 1.0);
//				System.out.println("APPROACHING TRIANGLE");
//			}
//		return new CollisionDetails1(shortestTime, newVelo);
//	}
	
	public void save(){
		savefile.save();
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