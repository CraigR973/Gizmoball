package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

public class PhysicsLoop {
	private Absorber absorber;
	private Ball ball;
	private Walls gws;
	private boolean keyPressed = false;
	private ArrayList<CircleGizmo> circs = new ArrayList<CircleGizmo>();
	private ArrayList<TriangleGizmo> tris = new ArrayList<TriangleGizmo>();
	private ArrayList<SquareGizmo> squares = new ArrayList<SquareGizmo>();
	private Vect physics;
	private double friction;
	private double grav;

	public PhysicsLoop(Ball b, Walls walls, Absorber abs, boolean keyPress, ArrayList<SquareGizmo> sqs,
			ArrayList<CircleGizmo> cirs, ArrayList<TriangleGizmo> triangles) {
		ball = b;
		absorber = abs;
		keyPressed = keyPress;
		squares = sqs;
		circs = cirs;
		tris = triangles;
		gws = walls;
		friction = 0;
		grav = 25 * 20 / 31.622776601683793;
	}

	public void moveBall() {
		double moveTime = 0.02; // 0.02 = 50 times per second as per Gizmoball
		double xVel = ball.getVelo().x();
		double yVel = ball.getVelo().y();

		System.out.println("garav?: " + grav);
		System.out.println("Fritciot: " + friction);

		if (xVel > 0) {
			// friction = ball.getVelo().x() * (1 - 0.025 * 0.02 -
			// (ball.getVelo().x() / 20) * Math.abs(ball.getVelo().x()) * 0.02);
			xVel -= friction;
		} else if (xVel < 0) {
			// friction = ball.getVelo().x() * (1 - 0.025 * 0.02 -
			// (ball.getVelo().x() / 20) * Math.abs(ball.getVelo().x()) * 0.02);
			xVel += friction;
		}
		// friction = ball.getVelo().y() * (1 - 0.025 * 0.02 -
		// (ball.getVelo().y() / 20) * Math.abs(ball.getVelo().y()) * 0.02);
		yVel += grav + friction;

		// if (xVel > 0) {
		// xVel -= friction;
		// } else if (xVel < 0) {
		// xVel += friction;
		// }
		// yVel += grav + friction;

		physics = new Vect(xVel, yVel);
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

		if (ball.getExactX() > 400 || ball.getExactY() > 380) {
			ball.setExactX(385);
			ball.setExactY(385);
		}
	}

	public CollisionDetails timeUntilCollision() {
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
					ball.setVelo(new Vect(0, 0));
					System.out.println("Ball stopped in absorber");
					ball.stop();
					System.out.println("Ball stopped: " + ball.stopped());
					System.out.println("Current velo: " + ball.getVelo());
					System.out.println("X: " + ball.getExactX() + " Y: " + ball.getExactY());
					break;
				}
				System.out.println("Ball left absorber");
				Vect velo = new Vect(0, 1000);
				newVelo = Geometry.reflectWall(ls, velo, 1.0);
				ball.setVelo(velo);
				System.out.println(ball.getVelo().x());
				System.out.println(ball.getVelo().y());
			}

		}

		// Time to collide with squares
		if (!squares.isEmpty()) {
			for (int i = 0; i < squares.size(); i++) {
				for (int j = 0; j < 4; j++) {
					time = Geometry.timeUntilWallCollision(squares.get(i).getLineSegs(j), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectWall(squares.get(i).getLineSegs(j), ball.getVelo(), 1.0);
					}

					time = Geometry.timeUntilCircleCollision(squares.get(i).getCorners(j), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectCircle(squares.get(i).getCornerCentres(j), ball.getCentreOfBall(),
								ball.getVelo(), 1.0);
					}
				}
			}
		}

		// Time to collide with triangles
		if (!tris.isEmpty()) {
			for (int i = 0; i < tris.size(); i++) {
				for (int j = 0; j < 3; j++) {
					// Surface collisions for triangles
					time = Geometry.timeUntilWallCollision(tris.get(i).getLinSegs(j), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectWall(tris.get(i).getLinSegs(j), ball.getVelo(), 1.0);

						if (time < 0.02) {
							tris.get(i).setColour(Color.BLUE);
							double xVel = 0;
							double yVel = 0;

							if (ball.getVelo().x() > 0) {
								xVel = ball.getVelo().x() + 100;
							} else {
								xVel = ball.getVelo().x() - 100;
							}
							if (ball.getVelo().y() > 0) {
								yVel = ball.getVelo().y() + 100;
							} else {
								yVel = ball.getVelo().y() - 100;
							}

							Vect nVel = new Vect(xVel, yVel);
							ball.setVelo(nVel);
						}
					}

					// Corner collisions for triangles
					time = Geometry.timeUntilCircleCollision(tris.get(i).getCorners(j), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectCircle(tris.get(i).getCornerCentres(j), ball.getCentreOfBall(),
								ball.getVelo(), 1.0);
					}
				}
			}
		}

		// Time to collide with circles
		if (!circs.isEmpty()) {
			for (int i = 0; i < circs.size(); i++) {
				time = Geometry.timeUntilCircleCollision(circs.get(i).getCircle(), ballCircle, ballVelocity);
				if (time < shortestTime) {
					shortestTime = time;
					newVelo = Geometry.reflectCircle(circs.get(i).getCircleCentre(), ball.getCentreOfBall(),
							ball.getVelo(), 1.0);
				}

				time = Geometry.timeUntilCircleCollision(circs.get(i).getCircle(), ballCircle, ballVelocity);
				if (time < shortestTime) {
					shortestTime = time;
					newVelo = Geometry.reflectCircle(circs.get(i).getCircleCentre(), ball.getCentreOfBall(),
							ball.getVelo(), 1.0);
				}
			}
		}
		return new CollisionDetails(shortestTime, newVelo);
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
}
