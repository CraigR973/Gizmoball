package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

public class PhysicsLoop {
	private ArrayList<Absorber> abs;
	private ArrayList<Ball> ball;
	private Walls gws;
	private boolean keyPressed = false;
	private ArrayList<CircleGizmo> circs = new ArrayList<CircleGizmo>();
	private ArrayList<TriangleGizmo> tris = new ArrayList<TriangleGizmo>();
	private ArrayList<SquareGizmo> squares = new ArrayList<SquareGizmo>();
	private ArrayList<LeftFlipper> leftFlippers = new ArrayList<LeftFlipper>();
	private ArrayList<RightFlipper> rightFlippers = new ArrayList<RightFlipper>();
	private Vect physics;
	private double friction;
	private double grav;

	public PhysicsLoop(ArrayList<Ball> b, Walls walls, ArrayList<Absorber> absorber, boolean keyPress,
			ArrayList<SquareGizmo> sqs, ArrayList<CircleGizmo> cirs, ArrayList<TriangleGizmo> triangles, ArrayList<LeftFlipper> leftFlipper,
			 ArrayList<RightFlipper> rightFlipper) {
		ball = b;
		abs = absorber;
		keyPressed = keyPress;
		squares = sqs;
		circs = cirs;
		tris = triangles;
		leftFlippers = leftFlipper;
		rightFlippers = rightFlipper;
		gws = walls;
		friction = 2;
		grav = 10;
	}
	
	public double getGrav() {
		return grav;
	} 
	
	public void setGrav(double g) {
		grav = g;
	}
	
	public double getFriction() {
		return friction;
	} 
	
	public void setFriction(double f) {
		friction = f;
	}
	

	public void moveBall() {
		if (!ball.isEmpty()) {
			for(int n = 0; n < ball.size(); n++){
			double moveTime = 0.02; // 0.02 = 50 times per second as per
									// Gizmoball
			double xVel = ball.get(n).getVelo().x();
			double yVel = ball.get(n).getVelo().y();

			Ball ba = ball.get(n);

		//	v new = v old + grav * time;
			

//			if (xVel > 0) {
//				 friction = ba.getVelo().x() * (1 - 0.025 * 0.02 -
//				 (ba.getVelo().x() / 20) * Math.abs(ba.getVelo().x()) *
//				 0.02);
//				xVel -= friction;
//			} else if (xVel < 0) {
//				 friction = ba.getVelo().x() * (1 - 0.025 * 0.02 -
//				 (ba.getVelo().x() / 20) * Math.abs(ba.getVelo().x()) *
//				 0.02);
//				xVel += friction;
//			}
//			 friction = ba.getVelo().y() * (1 - 0.025 * 0.02 -
//			 (ba.getVelo().y() / 20) * Math.abs(ba.getVelo().y()) * 0.02);
//			yVel += grav + friction;
//
//			 if (xVel > 0) {
//			 xVel -= friction;
//			 } else if (xVel < 0) {
//			 xVel += friction;
//			 }
//			 grav = 20;
	//		 friction = 5;
			 yVel += grav + friction;

			physics = new Vect(xVel, yVel);
			ba.setVelo(physics);

			CollisionDetails cd = timeUntilCollision(n);

			double tuc = cd.getTuc();
			if (tuc > moveTime) {
				// No collision ...
				ba = movelBallForTime(ball.get(n), moveTime);
			} else {
				// We've got a collision in tuc
				ba = movelBallForTime(ball.get(n), tuc);
				// Post collision velocity ...
				ba.setVelo(cd.getVelo());
			}

			if (ba.getExactX() > 400 || ball.get(n).getExactY() > 400) {
				ba.setExactX(390);
				ba.setExactY(385);
			}
		}}
	}

	public CollisionDetails timeUntilCollision(int n) {
		// Find Time Until Collision and also, if there is a collision, the new
		// speed vector.
		// Create a physics.Circle from Ball
		Circle ballCircle = ball.get(n).getCircle();
		Vect ballVelocity = ball.get(n).getVelo();
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
				newVelo = Geometry.reflectWall(line, ball.get(n).getVelo(), 1.0);
			}

		}

		// Time to collide with absorber
		if (!abs.isEmpty()) {
			for (int i = 0; i < abs.size(); i++) {
				LineSegment ls = abs.get(i).getAbsLineSeg();
				time = Geometry.timeUntilWallCollision(ls, ballCircle, ballVelocity);
				if (time < shortestTime) {
					shortestTime = time;
					// newVelo = Geometry.reflectWall(ls, ball.getVelo(), 1.0);
					if (time < 0.02) {
//						ball.get(n).setExactX(395);
//						ball.get(n).setExactY(385);
						ball.get(n).setExactX(abs.get(i).setXPos());
						ball.get(n).setExactY(abs.get(i).setYPos());
						while (keyPressed == false) {
							if(ball.get(n).getExactY() > (abs.get(i).getYPos()+abs.get(i).getHeight()-15)){
								ball.get(n).setExactX(abs.get(i).setYPos());
							}
							ball.get(n).setVelo(new Vect(0, 0));
							ball.get(n).stop();
							break;
						}
						Vect velo = new Vect(0, 1000);
						newVelo = Geometry.reflectWall(ls, velo, 1.0);
						ball.get(n).setVelo(velo);
					}

				}
			}
		}

		// Time to collide with squares
		if (!squares.isEmpty()) {
			for (int i = 0; i < squares.size(); i++) {
				for (int j = 0; j < 4; j++) {
					time = Geometry.timeUntilWallCollision(squares.get(i).getLineSegs(j), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectWall(squares.get(i).getLineSegs(j), ball.get(n).getVelo(), 1.0);
						if (time < 0.02){
							squares.get(i).setColour(randColour());
						}
					}

					time = Geometry.timeUntilCircleCollision(squares.get(i).getCorners(j), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectCircle(squares.get(i).getCornerCentres(j),
								ball.get(n).getCentreOfBall(), ball.get(n).getVelo(), 1.0);
						if (time < 0.02){
							squares.get(i).setColour(randColour());
						}
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
						newVelo = Geometry.reflectWall(tris.get(i).getLinSegs(j), ball.get(n).getVelo(), 1.0);
						
						if (time < 0.02) {
							tris.get(i).setColour(randColour());
						}
						
					}

					// Corner collisions for triangles
					time = Geometry.timeUntilCircleCollision(tris.get(i).getCorners(j), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectCircle(tris.get(i).getCornerCentres(j), ball.get(n).getCentreOfBall(),
								ball.get(n).getVelo(), 1.0);
					}
					if(time < 0.02){
						tris.get(i).setColour(randColour());
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
					newVelo = Geometry.reflectCircle(circs.get(i).getCircleCentre(), ball.get(n).getCentreOfBall(),
							ball.get(n).getVelo(), 1.0);

					if(time < 0.02){
						circs.get(i).setColour(randColour());
					}
				}

				time = Geometry.timeUntilCircleCollision(circs.get(i).getCircle(), ballCircle, ballVelocity);
				if (time < shortestTime) {
					shortestTime = time;
					newVelo = Geometry.reflectCircle(circs.get(i).getCircleCentre(), ball.get(n).getCentreOfBall(),
							ball.get(n).getVelo(), 1.0);

					if(time < 0.02){
						circs.get(i).setColour(randColour());
					}
				}
			}
		}
		//Time to collide to left flippers
		if (!leftFlippers.isEmpty()) {
			for (int i = 0; i < leftFlippers.size(); i++) {
				for (int j = 0; j < 2; j++) {
					time = Geometry.timeUntilWallCollision(leftFlippers.get(i).getLineSegs(j), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectWall(leftFlippers.get(i).getLineSegs(j), ball.get(n).getVelo(), 1.0);
					}

					time = Geometry.timeUntilCircleCollision(leftFlippers.get(i).getCorners(j), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectCircle(leftFlippers.get(i).getCornerCentres(j),
								ball.get(n).getCentreOfBall(), ball.get(n).getVelo(), 1.0);
					}
				}
			}
		}
		
		//Time to collide with right flippers
		if (!rightFlippers.isEmpty()) {
			for (int i = 0; i < rightFlippers.size(); i++) {
				for (int j = 0; j < 2; j++) {
					time = Geometry.timeUntilWallCollision(rightFlippers.get(i).getLineSegs(j), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectWall(rightFlippers.get(i).getLineSegs(j), ball.get(n).getVelo(), 1.0);
					}

					time = Geometry.timeUntilCircleCollision(rightFlippers.get(i).getCorners(j), ballCircle, ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectCircle(rightFlippers.get(i).getCornerCentres(j),
								ball.get(n).getCentreOfBall(), ball.get(n).getVelo(), 1.0);
					}
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
	
	private Color randColour(){
		Random rnd = new Random();
		int red = rnd.nextInt();
		int blue = rnd.nextInt();
		int green = rnd.nextInt();
		
		Color randomColour = new Color(rnd.nextInt(0xFFFFFF));
		return randomColour;
	}
}
