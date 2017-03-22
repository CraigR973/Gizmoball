package controller;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import model.Model;
import view.Board;
import view.Gui;

public class ConnectKeyListener implements KeyListener {
	private Model model;
	private Board board;
	private String gizmo;
	private int akeyEvent;
	private int skeyEvent;
	private int tkeyEvent;
	private int ckeyEvent;
	ArrayList<String> absorberConnection = new ArrayList<String>();
	ArrayList<String> squareConnection = new ArrayList<String>();
	ArrayList<String> triangleConnection = new ArrayList<String>();
	ArrayList<String> circleConnection = new ArrayList<String>();

	public ConnectKeyListener(Model m, Board b) {
		model = m;
		board = b;

	}

	public void getAbsoberKey() {
		String connect = "";
		if (model.getAbs().size() > 0) {
			absorberConnection = model.getAbs().get(0).getKeyConnections();
		
			for (int i = 0; i < absorberConnection.size(); i++) {
				connect = absorberConnection.get(i);
			}
		

			StringTokenizer st = new StringTokenizer(connect);
			if (st.hasMoreTokens()) {
				String k = st.nextToken();
				akeyEvent = Integer.parseInt(st.nextToken());
				String k1 = st.nextToken();
				String k2 = st.nextToken();

			}
		}
	}

	public void getSquareKey() {
		String connect = "";
		if (model.getSquares().size() > 0) {
			squareConnection = model.getSquares().get(0).getKeyConnections();
			for (int i = 0; i < squareConnection.size(); i++) {
				connect = squareConnection.get(i);
			}
			// absorberConnection =
			// model.getSquares().get(0).getKeyConnections();
			// ArrayList<String> circleConnection =
			// model.getCircles().get(0).getKeyConnections();
			// ArrayList<String> triangleConnection =
			// model.getTriangles().get(0).getKeyConnections();
			
			/*
			 * for(int i = 0; i<model.getSquares().size(); i++) {
			 * if(model.getSquares().get(i).isConnect() == true) {
			 * 
			 * } }
			 */
			/*
			 * for(int i = 0; i<circleConnection.size(); i++) { connect =
			 * circleConnection.get(i); } for(int i = 0;
			 * i<triangleConnection.size(); i++) { connect =
			 * triangleConnection.get(i); } for(int i = 0;
			 * i<squaresConnection.size(); i++) { connect =
			 * squaresConnection.get(i); }
			 */

			StringTokenizer st = new StringTokenizer(connect);
			if (st.hasMoreTokens()) {
				String k = st.nextToken();
				skeyEvent = Integer.parseInt(st.nextToken());
				String k1 = st.nextToken();
				String k2 = st.nextToken();

			}
		}
	}
	
	public void getTriangleKey() {
		String connect = "";
		if (model.getTriangles().size() > 0) {
			triangleConnection = model.getTriangles().get(0).getKeyConnections();
			for (int i = 0; i < triangleConnection.size(); i++) {
				connect = triangleConnection.get(i);
			}
			// absorberConnection =
			// model.getSquares().get(0).getKeyConnections();
			// ArrayList<String> circleConnection =
			// model.getCircles().get(0).getKeyConnections();
			// ArrayList<String> triangleConnection =
			// model.getTriangles().get(0).getKeyConnections();
			
			/*
			 * for(int i = 0; i<model.getSquares().size(); i++) {
			 * if(model.getSquares().get(i).isConnect() == true) {
			 * 
			 * } }
			 */
			/*
			 * for(int i = 0; i<circleConnection.size(); i++) { connect =
			 * circleConnection.get(i); } for(int i = 0;
			 * i<triangleConnection.size(); i++) { connect =
			 * triangleConnection.get(i); } for(int i = 0;
			 * i<squaresConnection.size(); i++) { connect =
			 * squaresConnection.get(i); }
			 */

			StringTokenizer st = new StringTokenizer(connect);
			if (st.hasMoreTokens()) {
				String k = st.nextToken();
				tkeyEvent = Integer.parseInt(st.nextToken());
				String k1 = st.nextToken();
				String k2 = st.nextToken();

			}
		}
	}
	
	public void getCircleKey() {
		String connect = "";
		if (model.getCircles().size() > 0) {
			circleConnection = model.getCircles().get(0).getKeyConnections();
			for (int i = 0; i < circleConnection.size(); i++) {
				connect = circleConnection.get(i);
			}
		

			StringTokenizer st = new StringTokenizer(connect);
			if (st.hasMoreTokens()) {
				String k = st.nextToken();
				ckeyEvent = Integer.parseInt(st.nextToken());
				String k1 = st.nextToken();
				String k2 = st.nextToken();

			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (model.getAbs().size() > 0) {
			System.out.println("Receiveddddddd");
			getAbsoberKey();
			if (e.getKeyCode() == akeyEvent) {
				System.out.println("Space pressed");
				model.releaseBall();
				
			}
			if (model.getSquares().size() > 0) {
				getSquareKey();

				for (int i = 0; i < model.getSquares().size(); i++) {
					System.out.println(model.getSquares().get(i).isConnect());
					System.out.println("Button  "  + skeyEvent);
					if (e.getKeyCode() == KeyEvent.VK_ENTER && model.getSquares().get(i).isConnect() == true) {

						System.out.println("Match");
						
						model.getSquares().get(i).setColour(Color.GREEN);
					} else {
						System.out.println("Doesn't match");
						
					}

					
				}
			}
			if (model.getTriangles().size() > 0) {
				getTriangleKey();

				for (int i = 0; i < model.getTriangles().size(); i++) {
					System.out.println(model.getTriangles().get(i).isConnect());
					System.out.println("Button  "  + skeyEvent);
					if (e.getKeyCode() == KeyEvent.VK_UP && model.getTriangles().get(i).isConnect() == true) {

						System.out.println("Match");
						
						model.getTriangles().get(i).setColour(Color.YELLOW);
					} else {
						System.out.println("Doesn't match");
						
					}

					
				}
			}
			if (model.getCircles().size() > 0) {
				getSquareKey();

				for (int i = 0; i < model.getCircles().size(); i++) {
					System.out.println(model.getCircles().get(i).isConnect());
					System.out.println("Button  "  + skeyEvent);
					if (e.getKeyCode() == KeyEvent.VK_DOWN && model.getCircles().get(i).isConnect() == true) {

						System.out.println("Match");
						
						model.getCircles().get(i).setColour(Color.CYAN);
					} else {
						System.out.println("Doesn't match");
						
					}

					
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				System.out.println("Space pressed");
				model.releaseBall();
			}

			for (int i = 0; i < model.getLFlipper().size(); i++) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					model.getLFlipper().get(i).setColour();
				}
			}

			for (int i = 0; i < model.getRFlipper().size(); i++) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					model.getRFlipper().get(i).setColour();
				}
			}

			for (int i = 0; i < model.getAbs().size(); i++) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					model.getAbs().get(i).setColour();
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == skeyEvent) {
			System.out.println("Space released");
			model.captureBall();
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("Space released");
			model.captureBall();
		}


		for (int i = 0; i < model.getAbs().size(); i++) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				model.getAbs().get(i).setColour1();
			}
		}
		
		if (model.getSquares().size() > 0) {
			getSquareKey();

			for (int i = 0; i < model.getSquares().size(); i++) {
				System.out.println(model.getSquares().get(i).isConnect());
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					System.out.println("Match");
					model.getSquares().get(i).setColour(Color.RED);
				} else {
					System.out.println("Doesn't match");
				}

				
			}
		}
		
		if (model.getTriangles().size() > 0) {
			getSquareKey();

			for (int i = 0; i < model.getTriangles().size(); i++) {
				System.out.println(model.getTriangles().get(i).isConnect());
				if (e.getKeyCode() == KeyEvent.VK_UP) {

					System.out.println("Match");
					model.getTriangles().get(i).setColour(Color.BLUE);
				} else {
					System.out.println("Doesn't match");
				}

				
			}
		}
		
		if (model.getCircles().size() > 0) {
			getSquareKey();

			for (int i = 0; i < model.getCircles().size(); i++) {
				System.out.println(model.getCircles().get(i).isConnect());
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {

					System.out.println("Match");
					model.getCircles().get(i).setColour(Color.GREEN);
				} else {
					System.out.println("Doesn't match");
				}

				
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
