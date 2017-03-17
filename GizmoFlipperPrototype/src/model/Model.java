package model;

import java.util.ArrayList;
import java.util.Observable;

import physics.Angle;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;


public class Model extends Observable{
	private Absorber absorber;
	private Ball ball;
	private Walls gws;
	private boolean hitAbs = false;
	private LeftFlipper leftFlipper;
	
	public Model() {
		gws = new Walls(0, 0, 500, 500);
		ball = new Ball(40, 405, 300, 300);
		absorber = new Absorber(500,25,0,475);
		leftFlipper = new LeftFlipper(20, 60, 250, 250, 1.0, 0.0);
	}
	
	public void moveBall() {

		double moveTime = 0.05; // 0.05 = 20 times per second as per Gizmoball

		if (ball != null && !ball.stopped()) {

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
	
	public void rotateLeftFlip() {
		leftFlipper = rotateLeftFlipper(leftFlipper);
		this.setChanged();
		this.notifyObservers();
	}
	
	public LeftFlipper rotateLeftFlipper(LeftFlipper leftFlipper) {
		double newA = 0.0;
		double newB = 1.0;
	
		newA = leftFlipper.getXPos();
		newB = leftFlipper.getYPos();
		leftFlipper.setXPos(newA);
		leftFlipper.setYPos(newB);
		
		
		//leftFlipper.setAngle(newA);
		
		return leftFlipper;
		
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
		return new CollisionDetails(shortestTime, newVelo);
	}
	
	public Absorber getAbsorber(){
		return absorber;
	}
	
	
	public Ball getBall(){
		return ball;
	}
	
	public LeftFlipper getLeftFlipper(){
		return leftFlipper;
	}
	
	public void setBallSpeed(int x, int y){
		ball.setVelo(new Vect(x, y));
	}
}
