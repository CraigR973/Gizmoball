package model;

import java.util.ArrayList;
import java.util.Observable;

import physics.Angle;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;


public class Model1 extends Observable{
	private Absorber absorber;
	private Ball1 ball;
	private Walls1 gws;
	private Triangle tri;
	private Triangle tri1;
	private Square sq;
	private Circle1 cir;
	private boolean keyPressed = false;
	
	public Model1() {
		gws = new Walls1(0, 0, 500, 500);
		ball = new Ball1(10, 250, 300, 300);
		//absorber = new Absorber(500,25,0,475);
		tri = new Triangle(450,500,500,0,50,0);
		tri1 = new Triangle(50,0,0,0,50,0);
		sq = new Square (20, 20, 40, 270);
		cir = new Circle1(400, 200, 200, 200);
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
//			LineSegment ls = absorber.getAbsLineSeg();
//			time = Geometry.timeUntilWallCollision(ls, ballCircle, ballVelocity);
//			if (time < shortestTime) {
//				shortestTime = time;
//				newVelo = Geometry.reflectWall(ls, ball.getVelo(), 1.0);
//				System.out.println("APPROACHING ABSORBER");
//			}
			
			//Detect collision with absorber and move ball
//			if(time < 0.05){
//				System.out.println("Collision");
//				ball.setExactX(475);
//				ball.setExactY(465);
////				while(keyPressed == false){
////					ball.stop();
////				}
//				Vect velo = new Vect(0,400);
//				keyPressed = false;
////				newVelo = Geometry.reflectWall(ls, velo, 1.0);
//			}
			
			LineSegment sqls = sq.getSqLineSeg();
			LineSegment sqls2 = sq.getSqLineSeg2();
			LineSegment sqls3 = sq.getSqLineSeg3();
			LineSegment sqls4 = sq.getSqLineSeg4();
			time = Geometry.timeUntilWallCollision(sqls, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(sqls, ball.getVelo(), 1.0);
				System.out.println("APPROACHING SQUARE");
			}
			time = Geometry.timeUntilWallCollision(sqls2, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(sqls2, ball.getVelo(), 1.0);
				System.out.println("APPROACHING SQUARE");
			}
			time = Geometry.timeUntilWallCollision(sqls3, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(sqls3, ball.getVelo(), 1.0);
				System.out.println("APPROACHING SQUARE");
			}
			time = Geometry.timeUntilWallCollision(sqls4, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(sqls4, ball.getVelo(), 1.0);
				System.out.println("APPROACHING SQUARE");
			}
			
			LineSegment tls = tri.getLineSeg();
			time = Geometry.timeUntilWallCollision(tls, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(tls, ball.getVelo(), 1.0);
				System.out.println("APPROACHING TRIANGLE");
			}
			
			LineSegment tls1 = tri1.getLineSeg();
			time = Geometry.timeUntilWallCollision(tls1, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(tls1, ball.getVelo(), 1.0);
				System.out.println("APPROACHING TRIANGLE");
			}
//			
//			LineSegment cirls = cir.getLineSeg();
//			time = Geometry.timeUntilWallCollision(cirls, ballCircle, ballVelocity);
//			if (time < shortestTime) {
//				shortestTime = time;
//				newVelo = Geometry.reflectWall(tls1, ball.getVelo(), 1.0);
//				System.out.println("APPROACHING TRIANGLE");
//			}
			
			
			double radius1 = cir.getRadius();
			double radius2 = ball.getRadius();
			
			double dx = cir.getExactX() - ball.getExactX();
			double dy = cir.getExactY() - ball.getExactY();
			double distance =  Math.sqrt(dx * dx + dy * dy);
			
//			if (distance < radius1 + radius2){
//				cir.setLs(, y1, x2, y2);
//				System.out.println("APPROACHING CIRCLE");
//			}
//			
		return new CollisionDetails1(shortestTime, newVelo);
	}
	
	public Absorber getAbsorber(){
		return absorber;
	}
	
	
	public Ball1 getBall(){
		return ball;
	}
	
	public void setBallSpeed(int x, int y){
		ball.setVelo(new Vect(x, y));
	}
	
	public Triangle getTriangle(){
		return tri;
	}
	
	public Triangle getTriangle1(){
		return tri1;
	}
	
	public Square getSquare(){
		return sq;
	}
	
	public Circle1 getCircle1(){
		return cir;
	}
	
	public void releaseBall(){
		keyPressed = true;
	}
}
