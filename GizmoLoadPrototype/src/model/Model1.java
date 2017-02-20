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
				double value1 = Double.parseDouble(st.nextToken());
				double value2 = Double.parseDouble(st.nextToken());
				if(cGizmo.equals("Triangle"))
				{
					
					Triangle t = new Triangle(name, value1, value2);
					triangles.add(t);
				}
				else if(cGizmo.equals("Square"))
				{
					Square sq = new Square(name, value1, value2);
					squares.add(sq);
					
				}
				else if(cGizmo.equals("Circle"))
				{
					Circle1 c = new Circle1(name, value1, value2);
					circles.add(c);
				}
				else if(cGizmo.equals("LeftFlipper"))
				{
					LeftFlipper lf = new LeftFlipper(name, value1, value2);
					leftFlippers.add(lf);
				}
				else if(cGizmo.equals("RightFlipper"))
				{
					RightFlipper rf = new RightFlipper(name, value1, value2);
					rightFlippers.add(rf);
				}
				else if(cGizmo.equals("Absorber"))
				{
					Absorber a = new Absorber(name, value1, value2);
					absorbers.add(a);
				}
//				else if(cGizmo.equals("Ball"))
//				{
//					double value3;
//					double value4;
//					name = st.nextToken();
//					value1 = Double.parseDouble(st.nextToken());
//					value2 = Double.parseDouble(st.nextToken());
//					value3 = Double.parseDouble(st.nextToken());
//					value4 = Double.parseDouble(st.nextToken());
//					Ball1 b = new Ball1(name, value1, value2, value3, value4);
//					balls.add(b);
//				}
			}
		}
		
//		gws = new Walls1(0, 0, 500, 500);
//		ball = new Ball1(50, 250, 300, 300);
//		absorber = new Absorber(500,25,0,475);
//		tri = new Triangle(450,500,500,0,50,0);
//		tri1 = new Triangle(50,0,0,0,50,0);
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
	

}