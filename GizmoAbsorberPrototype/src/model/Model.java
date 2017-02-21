package model;

import java.util.ArrayList;
import java.util.Observable;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

public class Model extends Observable {
	private Absorber absorber;
	private Ball ball;
	private Walls gws;
	private boolean keyPressed = false;
	private Vect physics;
	private double friction;
	private double grav;
	
	public Model() {
		gws = new Walls(0, 0, 400, 400);
		ball = new Ball(0, 385, 0, 0);
		absorber = new Absorber(400, 25, 0, 375);
		friction = 2.5;
		grav = 69;
	}

	public void moveBall() {

		//Ball moves 50 times per second
		double moveTime = 0.02; // 0.02 = 50 times per second as per Gizmoball
		if (ball != null && !ball.stopped()) {
			double xVel = ball.getVelo().x();
			double yVel = ball.getVelo().y();
			
			if(xVel > 0){
				xVel -= friction;
			}else if(xVel < 0){
				xVel += friction;
			}
			yVel += grav;
			
			physics = new Vect(xVel,yVel);
			
			ball.setVelo(physics);
			
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
			
			if(ball.getExactX() > 400 || ball.getExactY() > 380){
				ball.setExactX(385);
				ball.setExactY(385);
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
		// Find Time Until Collision and also, if there is a collision, the new
		// speed vector.
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
				// System.out.println("APPROACHING WALL");
			}

		}

		// Time to collide with absorber
		LineSegment ls = absorber.getAbsLineSeg();
		time = Geometry.timeUntilWallCollision(ls, ballCircle, ballVelocity);
		if (time < shortestTime) {
			shortestTime = time;
			// newVelo = Geometry.reflectWall(ls, ball.getVelo(), 1.0);
			// System.out.println("APPROACHING ABSORBER");
			if (time < 0.02) {
				System.out.println("Collision");
				ball.setExactX(385);
				ball.setExactY(385);
				while (keyPressed == false) {
					ball.setVelo(new Vect(0,0));
					System.out.println("Ball stopped in absorber");
					ball.stop();
					System.out.println("Ball stopped: " + ball.stopped());
					System.out.println("Current velo: " + ball.getVelo());
					System.out.println("X: " + ball.getExactX() + " Y: " + ball.getExactY());
					break;
				}
				System.out.println("Ball left absorber");
				Vect velo = new Vect(0,1650);//(50 * L * 20));
				newVelo = Geometry.reflectWall(ls, velo, 1.0);
				ball.setVelo(velo);
				System.out.println(ball.getVelo().x());
				System.out.println(ball.getVelo().y());
			}

		}
		return new CollisionDetails(shortestTime, newVelo);
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
}
