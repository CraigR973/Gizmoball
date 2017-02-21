package model;

import java.util.ArrayList;
import java.util.Observable;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;


public class Model extends Observable{
	
	private Absorber absorber;
	private Ball ball;
	private Walls gws;
	private TriangleGizmo tri;
	private TriangleGizmo tri1;
	private SquareGizmo sq;
	private CircleGizmo cir;
	private CircleGizmo cir1;
	private boolean keyPressed = false;
	int counter = 0;
	public Model() {
		gws = new Walls(0, 0, 400, 400);
		ball = new Ball(390, 390, 200, 200);
		absorber = new Absorber(400,25,0,375);
		tri = new TriangleGizmo(380,0,20,20);
		tri1 = new TriangleGizmo(120,140,20,20);
		sq = new SquareGizmo (20, 20, 280, 270);
		cir = new CircleGizmo(200, 10);
		cir1 = new CircleGizmo(90, 40);
	}
	
	public void moveBall() {

		double moveTime = 0.05; // 0.05 = 20 times per second as per Gizmoball

		if (ball != null && !ball.stopped()) {
			System.out.println("The ball is currently: X " + ball.getExactX() + " Y: " + ball.getExactY());
			CollisionDetails cd = timeUntilCollision();
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

			if(ball.getExactX() > 400 || ball.getExactY() > 400){
				ball.setExactX( 392.5);
				ball.setExactY( 380.5);
			}
			// Notify observers ... redraw updated view
			this.setChanged();
			this.notifyObservers();
		}

	}
	
	private Ball movelBallForTime(Ball ball, double time) {

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
	
	private CollisionDetails timeUntilCollision() {
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
		if (counter == 0) {
		LineSegment ls = absorber.getAbsLineSeg();
		time = Geometry.timeUntilWallCollision(ls, ballCircle, ballVelocity);
		if (time < shortestTime) {
			shortestTime = time;
			// newVelo = Geometry.reflectWall(ls, ball.getVelo(), 1.0);
			// System.out.println("APPROACHING ABSORBER");
			if (time < 0.05) {
				System.out.println("Collision");
				ball.setExactX( 392.5);
				ball.setExactY( 380.5);
				while (keyPressed == false) {
					System.out.println("Ball stopped in absorber");
					ball.stop();
					System.out.println("Ball stopped: " + ball.stopped());
					System.out.println("Current velo: " + ball.getVelo());
					break;
				}
				System.out.println("Ball left absorber");
				Vect velo = new Vect(0, 400);
				newVelo = Geometry.reflectWall(ls, velo, 1.0);
				ball.setVelo(velo);
				counter ++;
			}
		}
		}
		
			
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
			time = Geometry.timeUntilCircleCollision(sq.getCorner1(), ballCircle, ballVelocity);
			if(time < shortestTime){
				shortestTime = time;
				newVelo = Geometry.reflectCircle(sq.getCornerCentre(), ball.getCentreOfBall(), ball.getVelo(), 1.0);
			}
			time = Geometry.timeUntilWallCollision(sqls2, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(sqls2, ball.getVelo(), 1.0);
				System.out.println("APPROACHING SQUARE");
			}
			time = Geometry.timeUntilCircleCollision(sq.getCorner2(), ballCircle, ballVelocity);
			if(time < shortestTime){
				shortestTime = time;
				newVelo = Geometry.reflectCircle(sq.getCornerCentre2(), ball.getCentreOfBall(), ball.getVelo(), 1.0);
			}
			time = Geometry.timeUntilWallCollision(sqls3, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(sqls3, ball.getVelo(), 1.0);
				System.out.println("APPROACHING SQUARE");
			}
			time = Geometry.timeUntilCircleCollision(sq.getCorner3(), ballCircle, ballVelocity);
			if(time < shortestTime){
				shortestTime = time;
				newVelo = Geometry.reflectCircle(sq.getCornerCentre3(), ball.getCentreOfBall(), ball.getVelo(), 1.0);
			}
			time = Geometry.timeUntilWallCollision(sqls4, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(sqls4, ball.getVelo(), 1.0);
				System.out.println("APPROACHING SQUARE");
			}
			time = Geometry.timeUntilCircleCollision(sq.getCorner4(), ballCircle, ballVelocity);
			if(time < shortestTime){
				shortestTime = time;
				newVelo = Geometry.reflectCircle(sq.getCornerCentre4(), ball.getCentreOfBall(), ball.getVelo(), 1.0);
			}
			
			
			
			LineSegment tls1 = tri.getLineSeg1();
			LineSegment tls2 = tri.getLineSeg2();
			LineSegment tls3 = tri.getLineSeg3();
			time = Geometry.timeUntilWallCollision(tls1, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(tls1, ball.getVelo(), 1.0);
				System.out.println("APPROACHING TRIANGLE");
			}
			time = Geometry.timeUntilCircleCollision(tri.getCorner1(), ballCircle, ballVelocity);
			if(time < shortestTime){
				shortestTime = time;
				newVelo = Geometry.reflectCircle(tri.getCornerCentre(), ball.getCentreOfBall(), ball.getVelo(), 1.0);
			}
			
			time = Geometry.timeUntilWallCollision(tls2, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(tls2, ball.getVelo(), 1.0);
				System.out.println("APPROACHING TRIANGLE");
			}
			time = Geometry.timeUntilCircleCollision(tri.getCorner2(), ballCircle, ballVelocity);
			if(time < shortestTime){
				shortestTime = time;
				newVelo = Geometry.reflectCircle(tri.getCornerCentre2(), ball.getCentreOfBall(), ball.getVelo(), 1.0);
			}
			
			time = Geometry.timeUntilWallCollision(tls3, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(tls3, ball.getVelo(), 1.0);
				System.out.println("APPROACHING TRIANGLE");
			}
			time = Geometry.timeUntilCircleCollision(tri.getCorner3(), ballCircle, ballVelocity);
			if(time < shortestTime){
				shortestTime = time;
				newVelo = Geometry.reflectCircle(tri.getCornerCentre3(), ball.getCentreOfBall(), ball.getVelo(), 1.0);
			}
			
			
			
			
			
			LineSegment tl1 = tri1.getLineSeg1();
			LineSegment tl2 = tri1.getLineSeg2();
			LineSegment tl3 = tri1.getLineSeg3();
			time = Geometry.timeUntilWallCollision(tl1, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(tl1, ball.getVelo(), 1.0);
				System.out.println("APPROACHING TRIANGLE");
			}
			time = Geometry.timeUntilCircleCollision(tri1.getCorner1(), ballCircle, ballVelocity);
			if(time < shortestTime){
				shortestTime = time;
				newVelo = Geometry.reflectCircle(tri1.getCornerCentre(), ball.getCentreOfBall(), ball.getVelo(), 1.0);
			}
			time = Geometry.timeUntilWallCollision(tl2, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(tl2, ball.getVelo(), 1.0);
				System.out.println("APPROACHING TRIANGLE");
			}
			time = Geometry.timeUntilCircleCollision(tri1.getCorner2(), ballCircle, ballVelocity);
			if(time < shortestTime){
				shortestTime = time;
				newVelo = Geometry.reflectCircle(tri1.getCornerCentre2(), ball.getCentreOfBall(), ball.getVelo(), 1.0);
			}
			time = Geometry.timeUntilWallCollision(tl3, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(tl3, ball.getVelo(), 1.0);
				System.out.println("APPROACHING TRIANGLE");
			}
			time = Geometry.timeUntilCircleCollision(tri1.getCorner3(), ballCircle, ballVelocity);
			if(time < shortestTime){
				shortestTime = time;
				newVelo = Geometry.reflectCircle(tri1.getCornerCentre3(), ball.getCentreOfBall(), ball.getVelo(), 1.0);
			}
			
			
			
			
			time = Geometry.timeUntilCircleCollision(cir.getCircle1(), ballCircle, ballVelocity);
			if(time < shortestTime){
				shortestTime = time;
				newVelo = Geometry.reflectCircle(cir.getCircleCentre(), ball.getCentreOfBall(), ball.getVelo(), 1.0);
			}
			
			time = Geometry.timeUntilCircleCollision(cir1.getCircle1(), ballCircle, ballVelocity);
			if(time < shortestTime){
				shortestTime = time;
				newVelo = Geometry.reflectCircle(cir1.getCircleCentre(), ball.getCentreOfBall(), ball.getVelo(), 1.0);
			}
				
		return new CollisionDetails(shortestTime, newVelo);
	}
	
	public Absorber getAbsorber(){
		return absorber;
	}
	
	
	public Ball getBall(){
		return ball;
	}
	
	public void setBallSpeed(int x, int y){
		ball.setVelo(new Vect(x, y));
	}
	
	public TriangleGizmo getTriangle(){
		return tri;
	}
	
	public TriangleGizmo getTriangle1(){
		return tri1;
	}
	
	public SquareGizmo getSquare(){
		return sq;
	}
	
	public CircleGizmo getCircle1(){
		return cir;
	}
	
	public CircleGizmo getCircle2(){
		return cir1;
	}
	
	public void releaseBall() {
		System.out.println("Release Ball called");
		keyPressed = true;
		ball.start();

	}

	public void captureBall() {
		keyPressed = false;
	}
}
