package model;

import java.util.ArrayList;
import java.util.Observable;

import physics.Angle;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

public class Model1 extends Observable {
	private Absorber absorber;
	private Ball1 ball;
	private Walls1 gws;
	private boolean keyPressed = false;
	private Vect gravity;

	public Model1() {
		gws = new Walls1(0, 0, 500, 500);
		ball = new Ball1(0, 485, 300, 300);
		absorber = new Absorber(500, 25, 0, 475);
		gravity = new Vect(0,7.9);
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

			ball.setVelo(ball.getVelo().plus(gravity));
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
			if (time < 0.05) {
				System.out.println("Collision");
				ball.setExactX( 492.5);
				ball.setExactY( 480.5);
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
			}

		}
		return new CollisionDetails1(shortestTime, newVelo);
	}

	public Absorber getAbsorber() {
		return absorber;
	}

	public Ball1 getBall() {
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