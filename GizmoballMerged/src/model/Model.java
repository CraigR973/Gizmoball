package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.StringTokenizer;
import java.util.Timer;

import physics.Vect;

public class Model extends Observable {
	private Absorber absorber;
	private Ball ball;
	private Walls gws;
	private boolean keyPressed = false;
	PhysicsLoop physicsLoop;
	private ArrayList<CircleGizmo> circs = new ArrayList<CircleGizmo>();
	private ArrayList<TriangleGizmo> tris = new ArrayList<TriangleGizmo>();
	private ArrayList<SquareGizmo> squares = new ArrayList<SquareGizmo>();
	private ArrayList<LeftFlipper> leftFlippers = new ArrayList<LeftFlipper>();
	private ArrayList<RightFlipper> rightFlippers = new ArrayList<RightFlipper>();
	private ArrayList<Absorber> abs = new ArrayList<Absorber>();
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	private LoadReader file = new LoadReader();
	private saveFile savefile = new saveFile();
	private String currentGizmo;
	private String currentKey;

	int counter = 0;

	public Model() {
		gws = new Walls(0, 0, 400, 400);
		physicsLoop = new PhysicsLoop(balls, gws, abs, keyPressed, squares, circs, tris, leftFlippers, rightFlippers);

	}

	public void start() {
		// System.out.println(balls);
		// System.out.println(abs);
		if (balls.get(0) != null && !balls.get(0).stopped()) {
			// System.out.println(balls.get(0).getVelo());
			physicsLoop.moveBall();
			this.setChanged();
			this.notifyObservers();
		}
	}

	public Absorber getAbsorber() {
		return absorber;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBallSpeed(int x, int y) {
		if (!balls.isEmpty()) {
			ball.setVelo(new Vect(x, y));
		}
	}

	public void releaseBall() {
		for (int i = 0; i < balls.size(); i++) {

			keyPressed = true;
			balls.get(i).start();
		}
	}

	public void captureBall() {
		keyPressed = false;
	}

	public ArrayList<CircleGizmo> getCircles() {
		return circs;
	}

	public ArrayList<TriangleGizmo> getTriangles() {
		return tris;
	}

	public ArrayList<SquareGizmo> getSquares() {
		return squares;
	}

	public ArrayList<Absorber> getAbs() {
		return abs;
	}

	public ArrayList<Ball> getBalls() {
		return balls;
	}

	public ArrayList<LeftFlipper> getLFlipper() {
		return leftFlippers;
	}

	public ArrayList<RightFlipper> getRFlipper() {
		return rightFlippers;
	}

	public void addSquare(SquareGizmo sq) {
		squares.add(sq);
	}

	public void addCircle(CircleGizmo c) {
		circs.add(c);
	}

	public void addTriangle(TriangleGizmo t) {
		tris.add(t);
	}

	public void addAbsorber(Absorber a) {
		absorber = a;
	}

	public void addLeftFlipper(LeftFlipper leftFlipper) {
		leftFlippers.add(leftFlipper);
	}

	public void addRightFlipper(RightFlipper rightFlipper) {
		rightFlippers.add(rightFlipper);
	}

	public void save() {
		savefile.save(tris, squares, circs, leftFlippers, rightFlippers, abs, balls);
	}

	public void loadBoard() {
		ArrayList<String> gizmos = new ArrayList<String>();
		file.readFile();
		gizmos = file.getGizmos();
		for (int i = 0; i < gizmos.size(); i++) {
			StringTokenizer st = new StringTokenizer(gizmos.get(i));
			if (st.hasMoreTokens()) {
				String cGizmo = st.nextToken();
				String name = st.nextToken();

				if (cGizmo.equals("Triangle")) {
					String value1 = st.nextToken();
					String value2 = st.nextToken();
					double nvalue1 = Double.parseDouble(value1);
					double nvalue2 = Double.parseDouble(value2);
					TriangleGizmo t = new TriangleGizmo(name, nvalue1, nvalue2);
					tris.add(t);

				} else if (cGizmo.equals("Square")) {
					String value1 = st.nextToken();
					String value2 = st.nextToken();
					double nvalue1 = Double.parseDouble(value1);
					double nvalue2 = Double.parseDouble(value2);
					SquareGizmo sq = new SquareGizmo(name, nvalue1, nvalue2);
					squares.add(sq);

				} else if (cGizmo.equals("Circle")) {
					String value1 = st.nextToken();
					String value2 = st.nextToken();
					double nvalue1 = Double.parseDouble(value1);
					double nvalue2 = Double.parseDouble(value2);
					CircleGizmo c = new CircleGizmo(name, nvalue1, nvalue2);
					circs.add(c);

				} else if (cGizmo.equals("LeftFlipper")) {
					String value1 = st.nextToken();
					String value2 = st.nextToken();
					double nvalue1 = Double.parseDouble(value1);
					double nvalue2 = Double.parseDouble(value2);
					LeftFlipper lf = new LeftFlipper(name, nvalue1, nvalue2);
					leftFlippers.add(lf);

				} else if (cGizmo.equals("RightFlipper")) {
					String value1 = st.nextToken();
					String value2 = st.nextToken();
					double nvalue1 = Double.parseDouble(value1);
					double nvalue2 = Double.parseDouble(value2);
					RightFlipper rf = new RightFlipper(name, nvalue1, nvalue2);
					rightFlippers.add(rf);

				} else if (cGizmo.equals("Absorber")) {
					String value1 = st.nextToken();
					String value2 = st.nextToken();
					double nvalue1 = Double.parseDouble(value1);
					double nvalue2 = Double.parseDouble(value2);
					Absorber a = new Absorber(name, nvalue1, nvalue2);
					abs.add(a);
				} else if (cGizmo.equals("Ball")) {
					String value1 = st.nextToken();
					String value2 = st.nextToken();
					double nvalue1 = Double.parseDouble(value1);
					double nvalue2 = Double.parseDouble(value2);
					double value3 = Double.parseDouble(st.nextToken());
					double value4 = Double.parseDouble(st.nextToken());
					Ball b = new Ball(name, nvalue1, nvalue2, value3, value4);
					balls.add(b);
				} else if (cGizmo.equals("Rotate")) {
					char giz = name.charAt(0);
					if (giz == 'T') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < tris.size(); index++) {
								TriangleGizmo t = tris.get(index);
								String triName = t.getName();
								if (triName.equals(name)) {
									t.addRotation();
									found = true;
								}

							}
						}
					}
					if (giz == 'L') {
						boolean found = false;
						while (found != true) {
							found = true;
						}
					}
					if (giz == 'R') {
						boolean found = false;
						while (found != true) {
							found = true;
						}
					}
				} else if (cGizmo.equals("Connect")) {
					String value1 = st.nextToken();
					char giz = name.charAt(0);
					if (giz == 'C') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < circs.size(); index++) {
								CircleGizmo c = circs.get(index);
								String circName = c.getName();
								if (circName.equals(name)) {
									c.addConnections(value1);
									found = true;
								}

							}
						}
					}
					if (giz == 'A') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < abs.size(); index++) {
								Absorber a = abs.get(index);
								String aName = a.getName();
								if (aName.equals(name)) {
									a.addConnections(value1);
									found = true;
								}

							}
						}
					}
					if (giz == 'B') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < balls.size(); index++) {
								Ball b = balls.get(index);
								String ballName = b.getName();
								if (ballName.equals(name)) {
									b.addConnections(value1);
									found = true;
								}

							}
						}
					}
					if (giz == 'L') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < leftFlippers.size(); index++) {
								LeftFlipper lf = leftFlippers.get(index);
								String lfName = lf.getName();
								if (lfName.equals(name)) {
									lf.addConnections(value1);
									found = true;
								}

							}
						}
					}
					if (giz == 'R') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < rightFlippers.size(); index++) {
								RightFlipper rf = rightFlippers.get(index);
								String circName = rf.getName();
								if (circName.equals(name)) {
									rf.addConnections(value1);
									found = true;
								}

							}
						}
					}
					if (giz == 'S') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < squares.size(); index++) {
								SquareGizmo s = squares.get(index);
								String sName = s.getName();
								if (sName.equals(name)) {
									s.addConnections(value1);
									found = true;
								}

							}
						}
					}
					if (giz == 'T') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < tris.size(); index++) {
								TriangleGizmo t = tris.get(index);
								String tName = t.getName();
								if (tName.equals(name)) {
									t.addConnections(value1);
									found = true;
								}

							}
						}
					}
				} else if (cGizmo.equals("KeyConnect")) {
					String value1 = st.nextToken();
					String value2 = st.nextToken();
					String value3 = st.nextToken();
					char giz = value3.charAt(0);
					String connection = name + " " + value1 + " " + value2 + " " + value3;
					if (giz == 'L') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < leftFlippers.size(); index++) {
								LeftFlipper lf = leftFlippers.get(index);
								String LFName = lf.getName();
								if (LFName.equals(value3)) {
									lf.addKeyConnections(connection);
									found = true;
								}

							}
						}
					}
					if (giz == 'R') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < rightFlippers.size(); index++) {
								RightFlipper rf = rightFlippers.get(index);
								String RFName = rf.getName();
								if (RFName.equals(value3)) {
									rf.addKeyConnections(connection);
									found = true;
								}

							}
						}
					}
					if (giz == 'A') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < abs.size(); index++) {
								Absorber a = abs.get(index);
								String aName = a.getName();
								if (aName.equals(value3)) {
									a.addKeyConnections(connection);
									found = true;
								}

							}
						}
					}
					if (giz == 'T') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < tris.size(); index++) {
								TriangleGizmo t = tris.get(index);
								String tName = t.getName();
								if (tName.equals(value3)) {
									t.addKeyConnections(connection);
									found = true;
								}
							}
						}
					}
					if (giz == 'B') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < balls.size(); index++) {
								Ball b = balls.get(index);
								String tName = b.getName();
								if (tName.equals(value3)) {
									b.addKeyConnections(connection);
									found = true;
								}

							}
						}
					}
					if (giz == 'S') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < squares.size(); index++) {
								SquareGizmo s = squares.get(index);
								String sName = s.getName();
								if (sName.equals(value3)) {
									s.addKeyConnections(connection);
									found = true;
								}

							}
						}
					}
					if (giz == 'C') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < circs.size(); index++) {
								CircleGizmo c = circs.get(index);
								String tName = c.getName();
								if (tName.equals(value3)) {
									c.addKeyConnections(connection);
									found = true;
								}

							}
						}
					}
				} else if (cGizmo.equals("Delete")) {
					char giz = name.charAt(0);
					if (giz == 'S') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < squares.size(); index++) {
								SquareGizmo s = squares.get(index);
								String sName = s.getName();
								if (sName.equals(name)) {
									deleteGizmo(name, "square");
									found = true;
								}
							}
						}
					}
					if (giz == 'A') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < abs.size(); index++) {
								Absorber a = abs.get(index);
								String aName = a.getName();
								if (aName.equals(name)) {
									deleteGizmo(name, "absorber");
									found = true;
								}
							}
						}
					}
					if (giz == 'C') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < balls.size(); index++) {
								CircleGizmo c = circs.get(index);
								String cName = c.getName();
								if (cName.equals(name)) {
									deleteGizmo(name, "circle");
									found = true;
								}
							}
						}
					}
					if (giz == 'L') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < leftFlippers.size(); index++) {
								LeftFlipper lf = leftFlippers.get(index);
								String lfName = lf.getName();
								if (lfName.equals(name)) {
									deleteGizmo(name, "leftflipper");
									found = true;
								}
							}
						}
					}
					if (giz == 'R') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < rightFlippers.size(); index++) {
								RightFlipper rf = rightFlippers.get(index);
								String sName = rf.getName();
								if (sName.equals(name)) {
									deleteGizmo(name, "rightflippers");
									found = true;
								}
							}
						}
					}
					if (giz == 'T') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < tris.size(); index++) {
								TriangleGizmo t = tris.get(index);
								String tName = t.getName();
								if (tName.equals(name)) {
									deleteGizmo(name, "triangle");
									found = true;
								}
							}
						}
					}
				} else if (cGizmo.equals("Move")) {
					int value1 = Integer.parseInt(st.nextToken());
					int value2 = Integer.parseInt(st.nextToken());
					char giz = name.charAt(0);
					if (giz == 'S') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < squares.size(); index++) {
								SquareGizmo s = squares.get(index);
								String sName = s.getName();
								if (sName.equals(name)) {
									deleteGizmo(name, "square");
									moveGizmoAdd(value1, value2, "Square");
									found = true;
								}
							}
						}
					}
					if (giz == 'T') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < tris.size(); index++) {
								TriangleGizmo t = tris.get(index);
								String tName = t.getName();
								if (tName.equals(name)) {
									deleteGizmo(name, "triangle");
									moveGizmoAdd(value1, value2, "Triangle");
									found = true;
								}
							}
						}
					}
					if (giz == 'C') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < circs.size(); index++) {
								CircleGizmo c = circs.get(index);
								String sName = c.getName();
								if (sName.equals(name)) {
									deleteGizmo(name, "circle");
									moveGizmoAdd(value1, value2, "Circle");
									found = true;
								}
							}
						}
					}
					if (giz == 'B') {
						boolean found = false;
						while (found != true) {
							for (int index = 0; index < balls.size(); index++) {
								Ball b = balls.get(index);
								String sName = b.getName();
								if (sName.equals(name)) {
									deleteGizmo(name, "ball");
									moveGizmoAdd(value1, value2, "Ball");
									found = true;
								}
							}
						}
					}
				}
			}
		}
	}

	// For use with loading in deletes
	public void deleteGizmo(String name, String gizmo) {
		if (gizmo.equals("square")) {
			for (int i = 0; i < squares.size(); i++) {
				if (squares.get(i).getName().equals(name)) {
					squares.remove(i);
				}
			}
		}
		if (gizmo.equals("absorber")) {
			for (int i = 0; i < abs.size(); i++) {
				if (abs.get(i).getName().equals(name)) {
					abs.remove(i);
				}
			}
		}
		if (gizmo.equals("circle")) {
			for (int i = 0; i < circs.size(); i++) {
				if (circs.get(i).getName().equals(name)) {
					circs.remove(i);
				}
			}
		}
		if (gizmo.equals("leftflipper")) {
			for (int i = 0; i < leftFlippers.size(); i++) {
				if (leftFlippers.get(i).getName().equals(name)) {
					leftFlippers.remove(i);
				}
			}
		}
		if (gizmo.equals("rightflippers")) {
			for (int i = 0; i < rightFlippers.size(); i++) {
				if (rightFlippers.get(i).getName().equals(name)) {
					rightFlippers.remove(i);
				}
			}
		}
		if (gizmo.equals("triangle")) {
			for (int i = 0; i < tris.size(); i++) {
				if (tris.get(i).getName().equals(name)) {
					tris.remove(i);
				}
			}
		}
	}

	public void load() {
		loadBoard();
		// System.out.println("starting ball");
		Vect v = new Vect(500, 500);
		balls.get(0).setVelo(v);
		// System.out.println(abs);
		this.setChanged();
		this.notifyObservers();
	}

	public void addSquareGizmo(int x, int y) {
		String name = "S" + x + y;
		SquareGizmo sqg = new SquareGizmo(name, x, y);
		if (!checkGizmos(x, y)) {
			squares.add(sqg);
		}
		this.notifyObservers();
		this.setChanged();
	}

	public void addCircleGizmo(int x, int y) {
		String name = "C" + x + y;
		CircleGizmo cg = new CircleGizmo(name, x, y);
		if (!checkGizmos(x, y)) {
			circs.add(cg);
		}
		this.notifyObservers();
		this.setChanged();
	}

	public void addTriangleGizmo(int x, int y) {
		String name = "T" + x + y;
		TriangleGizmo tg = new TriangleGizmo(name, x, y);
		if (!checkGizmos(x, y)) {
			tris.add(tg);
		}
		this.notifyObservers();
		this.setChanged();
	}

	public String deleteGizmo(int x, int y) {
		for (int i = 0; i < tris.size(); i++) {
			if (tris.get(i).getXpos1() == x * 20 && tris.get(i).getYpos1() == y * 20) {
				tris.remove(i);
				this.notifyObservers();
				this.setChanged();
				return "Triangle";
			}
		}
		for (int i = 0; i < circs.size(); i++) {
			if (circs.get(i).getExactX() == x * 20 + 10 && circs.get(i).getExactY() == y * 20 + 10) {
				circs.remove(i);
				this.notifyObservers();
				this.setChanged();
				return "Circle";
			}
		}
		for (int i = 0; i < squares.size(); i++) {
			if (squares.get(i).getXPos() == x * 20 && squares.get(i).getYPos() == y * 20) {
				squares.remove(i);
				this.notifyObservers();
				this.setChanged();
				return "Square";
			}
		}
		for (int i = 0; i < abs.size(); i++) {
			if (abs.get(i).getYPos() == y * 20) {
				abs.remove(i);
				this.notifyObservers();
				this.setChanged();
				return "Absorber";
			}
		}
		for (int i = 0; i < leftFlippers.size(); i++) {
			if ((leftFlippers.get(i).getXPos() == x * 20 && leftFlippers.get(i).getYPos() == y * 20) || (leftFlippers.get(i).getXPos() == x * 20 && leftFlippers.get(i).getYPos()+20 == y * 20)) {
				leftFlippers.remove(i);
				this.notifyObservers();
				this.setChanged();
				return "LF";
			}
		}
		for (int i = 0; i < rightFlippers.size(); i++) {
			if ((rightFlippers.get(i).getXPos()-10 == x * 20 && rightFlippers.get(i).getYPos() == y * 20) || (rightFlippers.get(i).getXPos()-10 == x * 20 && rightFlippers.get(i).getYPos()+20 == y * 20)) {
				rightFlippers.remove(i);
				this.notifyObservers();
				this.setChanged();
				return "RF";
			}
		}
		for (int i = 0; i < balls.size(); i++) {
			if (balls.get(i).getExactX() == x * 20 && balls.get(i).getExactY() == y * 20) {
				balls.remove(i);

				this.notifyObservers();
				this.setChanged();
				return "Balls";
			}
		}
		this.notifyObservers();
		this.setChanged();

		return null;
	}

	public String getGizmo(int x, int y) {
		for (int i = 0; i < tris.size(); i++) {
			if (tris.get(i).getXpos1() == x * 20 && tris.get(i).getYpos1() == y * 20) {
				return tris.get(i).getName();
			}
		}
		for (int i = 0; i < circs.size(); i++) {
			if (circs.get(i).getExactX() == x * 20 + 10 && circs.get(i).getExactY() == y * 20 + 10) {
				return circs.get(i).getName();
			}
		}
		for (int i = 0; i < squares.size(); i++) {
			if (squares.get(i).getXPos() == x * 20 && squares.get(i).getYPos() == y * 20) {
				return squares.get(i).getName();
			}
		}
		for (int i = 0; i < abs.size(); i++) {
			if (abs.get(i).getYPos() == y * 20) {
				return abs.get(i).getName();
			}
		}
		for (int i = 0; i < leftFlippers.size(); i++) {
			if ((leftFlippers.get(i).getXPos() == x * 20 && leftFlippers.get(i).getYPos() == y * 20) || (leftFlippers.get(i).getXPos() == x * 20 && leftFlippers.get(i).getYPos()+20 == y * 20)) {
				return leftFlippers.get(i).getName();
			}
		}
		for (int i = 0; i < rightFlippers.size(); i++) {
			if ((rightFlippers.get(i).getXPos()-10 == x * 20 && rightFlippers.get(i).getYPos() == y * 20) || (rightFlippers.get(i).getXPos()-10 == x * 20 && rightFlippers.get(i).getYPos()+20 == y * 20)) {
				return rightFlippers.get(i).getName();
			}
		}
		for (int i = 0; i < balls.size(); i++) {
			if (balls.get(i).getExactX() == x * 20 && balls.get(i).getExactY() == y * 20) {
				return balls.get(i).getName();
			}
		}
		this.notifyObservers();
		this.setChanged();

		return null;
	}

	public void addAbsorberGizmo(int y) {
		String name = "A";
		Absorber a = new Absorber(name, 0, y);
		if (!checkGizmos(0, y)) {
			abs.add(a);
		}
		this.notifyObservers();
		this.setChanged();
	}

	public void addBallGizmo(int x, int y, double xv, double yv) {
		String name = "B";
		if (balls.size() < 1) {
			Ball b = new Ball(name, x, y, xv, yv);
			if (!checkGizmos(x, y)) {
				balls.add(b);
			}
		} else {
			System.out.println("too many balls");
		}
		this.notifyObservers();
		this.setChanged();
	}

	public void addRFlipperGizmo(int x, int y) {
		String name = "RF" + x + y;
		RightFlipper rf = new RightFlipper(name, x, y);
		if (!checkGizmos(x, y)) {
			rightFlippers.add(rf);
		}
		this.notifyObservers();
		this.setChanged();
	}

	public void addLFlipperGizmo(int x, int y) {
		String name = "LF" + x + y;
		LeftFlipper lf = new LeftFlipper(name, x, y);
		if (!checkGizmos(x, y)) {
			leftFlippers.add(lf);
		}
		this.notifyObservers();
		this.setChanged();
	}

	public boolean checkGizmos(int x, int y) {
		for (int i = 0; i < tris.size(); i++) {
			if (tris.get(i).getXpos1() == x * 20 && tris.get(i).getYpos1() == y * 20) {
				return true;
			}
		}
		for (int i = 0; i < circs.size(); i++) {
			if (circs.get(i).getExactX() == x * 20 + 10 && circs.get(i).getExactY() == y * 20 + 10) {
				return true;
			}
		}
		for (int i = 0; i < squares.size(); i++) {
			if (squares.get(i).getXPos() == x * 20 && squares.get(i).getYPos() == y * 20) {
				return true;
			}
		}
		for (int i = 0; i < balls.size(); i++) {
			if (balls.get(i).getExactX() == x * 20 && balls.get(i).getExactY() == y * 20) {
				return true;
			}
		}
		for (int i = 0; i < rightFlippers.size(); i++) {
			if ((rightFlippers.get(i).getXPos()-10 == x * 20 && rightFlippers.get(i).getYPos() == y * 20) || (rightFlippers.get(i).getXPos()-10 == x * 20 && rightFlippers.get(i).getYPos()+20 == y * 20)) {
				return true;
			}
		}
		for (int i = 0; i < leftFlippers.size(); i++) {
			if ((leftFlippers.get(i).getXPos() == x * 20 && leftFlippers.get(i).getYPos() == y * 20) || (leftFlippers.get(i).getXPos() == x * 20 && leftFlippers.get(i).getYPos()+20 == y * 20)) {
				return true;
			}
		}
		for (int i = 0; i < abs.size(); i++) {
			if (abs.get(i).getYPos() == y * 20) {
				return true;
			}
		}
		return false;
	}

	public void storeGizConnection(String gizmo) {
		currentGizmo = gizmo;
		System.out.println(currentGizmo);
	}

	public String getGizConnection() {
		return currentGizmo;
	}

	public void storeKeyConnection(String key) {
		currentKey = key;
		System.out.println(currentKey);
	}

	public String getKeyConnection() {
		return currentKey;
	}

	public void addKeyConnection(String gizmo) {
		if (gizmo.equals("Square")) {
			String cgizmo = getGizConnection();
			String cKey = getKeyConnection();
			for (int i = 0; i < squares.size(); i++) {
				if (squares.get(i).getName().equals(cgizmo)) {
					squares.get(i).addKeyConnections(cKey);
				}
				System.out.println(squares.get(i).getKeyConnections());
			}
		}
		if (gizmo.equals("Triangle")) {
			String cgizmo = getGizConnection();
			String cKey = getKeyConnection();
			for (int i = 0; i < tris.size(); i++) {
				if (tris.get(i).getName().equals(cgizmo)) {
					tris.get(i).addKeyConnections(cKey);
				}
				System.out.println(tris.get(i).getKeyConnections());
			}
		}
		if (gizmo.equals("Circle")) {
			String cgizmo = getGizConnection();
			String cKey = getKeyConnection();
			for (int i = 0; i < circs.size(); i++) {
				if (circs.get(i).getName().equals(cgizmo)) {
					circs.get(i).addKeyConnections(cKey);
				}
				System.out.println(circs.get(i).getKeyConnections());
			}
		}
	}

	public void clearBoard() {
		if (!balls.isEmpty()) {
			balls.clear();
		}
		if (!rightFlippers.isEmpty()) {
			rightFlippers.clear();
		}
		if (!leftFlippers.isEmpty()) {
			leftFlippers.clear();
		}
		if (!squares.isEmpty()) {
			squares.clear();
		}
		if (!circs.isEmpty()) {
			circs.clear();
		}
		if (!tris.isEmpty()) {
			tris.clear();
		}
		if (!abs.isEmpty()) {
			abs.clear();
		}
		this.setChanged();
		this.notifyObservers();
	}

	public void moveGizmoAdd(int x, int y, String giz) {
		switch (giz) {
		case "Square":
			addSquareGizmo(x, y);
			break;
		case "Triangle":
			addTriangleGizmo(x, y);
			break;
		case "Circle":
			addCircleGizmo(x, y);
			break;
		case "Ball":
			addBallGizmo(x, y, 50, 50);
			break;
		}
	}

	public SquareGizmo checkSquares(int x, int y) {
		for (int i = 0; i < squares.size(); i++) {
			if (squares.get(i).getXPos() == x * 20 && squares.get(i).getYPos() == y * 20) {
				return squares.get(i);
			}
		}
		return null;
	}

	public TriangleGizmo checkTriangles(int x, int y) {
		for (int i = 0; i < tris.size(); i++) {
			if (tris.get(i).getXpos1() == x * 20 && tris.get(i).getYpos1() == y * 20) {
				return tris.get(i);
			}
		}
		return null;
	}

	public CircleGizmo checkCircs(int x, int y) {
		for (int i = 0; i < circs.size(); i++) {
			if (circs.get(i).getExactX() == x * 20 + 10 && circs.get(i).getExactY() == y * 20 + 10) {
				return circs.get(i);
			}
		}
		return null;
	}

	public Ball checkBalls(int x, int y) {
		for (int i = 0; i < balls.size(); i++) {
			if (balls.get(i).getExactX() == x * 20 && balls.get(i).getExactY() == y * 20) {
				return balls.get(i);
			}
		}
		return ball;
	}

	public RightFlipper checkRFs(int x, int y) {
		for (int i = 0; i < rightFlippers.size(); i++) {
			if ((rightFlippers.get(i).getXPos()-10 == x * 20 && rightFlippers.get(i).getYPos() == y * 20) || (rightFlippers.get(i).getXPos()-10 == x * 20 && rightFlippers.get(i).getYPos()+20 == y * 20)) {
				return rightFlippers.get(i);
			}
		}
		return null;
	}

	public LeftFlipper checkLFs(int x, int y) {
		for (int i = 0; i < leftFlippers.size(); i++) {
			if ((leftFlippers.get(i).getXPos() == x * 20 && leftFlippers.get(i).getYPos() == y * 20) || (leftFlippers.get(i).getXPos() == x * 20 && leftFlippers.get(i).getYPos()+20 == y * 20)) {
				return leftFlippers.get(i);
			}
		}
		return null;
	}

	public Absorber checkAbs(int x, int y) {
		for (int i = 0; i < abs.size(); i++) {
			if (abs.get(i).getYPos() == y * 20) {
				return abs.get(i);
			}
		}
		return null;
	}

	public void rotate(int x, int y) {
		if (checkTriangles(x, y) != null) {
			checkTriangles(x, y).rotate();
		}
		this.setChanged();
		this.notifyObservers();
	}

	public void flipFlippers() {
		if (!leftFlippers.isEmpty()) {
			for (int i = 0; i < leftFlippers.size(); i++) {
				leftFlippers.get(i).rotateLines();
			}
		}
		if(!rightFlippers.isEmpty()){
			for (int i = 0; i < rightFlippers.size(); i++) {
				rightFlippers.get(i).rotateLines();
			}
		}
		this.setChanged();
		this.notifyObservers();
	}

	public void unflipFlippers() {
		if (!leftFlippers.isEmpty()) {
			for (int i = 0; i < leftFlippers.size(); i++) {
				leftFlippers.get(i).unrotateLines();
			}
		}
		if (!rightFlippers.isEmpty()) {
			for (int i = 0; i < rightFlippers.size(); i++) {
				rightFlippers.get(i).unrotateLines();
			}
		}
		this.setChanged();
		this.notifyObservers();
	}

	public void setGrav(double g) {
		physicsLoop.setGrav(g);
	}

	public void setFriction(double f) {
		physicsLoop.setFriction(f);
	}
}