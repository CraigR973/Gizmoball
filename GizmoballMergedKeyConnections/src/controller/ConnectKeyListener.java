package controller;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import model.Model;
import view.Board;

public class ConnectKeyListener implements KeyListener {
	private Model model;
	private Board board;
	private String gizmo;
	private int akeyEvent;
	private int skeyEvent;
	ArrayList<String> absorberConnection = new ArrayList<String>();
	ArrayList<String> squareConnection = new ArrayList<String>();
	
	public ConnectKeyListener(Model m, Board b) {
		model = m;
		board = b;
		
	}
	
	public void getAbsoberKey()
	{
		String connect = "";
		if(model.getAbs().size() > 0)
		{
			absorberConnection = model.getAbs().get(0).getKeyConnections();
	//	ArrayList<String> circleConnection = model.getCircles().get(0).getKeyConnections();
	//	ArrayList<String> triangleConnection = model.getTriangles().get(0).getKeyConnections();
			//squareConnection = model.getSquares().get(0).getKeyConnections();
		for(int i = 0; i<absorberConnection.size(); i++)
		{
			connect = absorberConnection.get(i);
		}
	/*	for(int i = 0; i<circleConnection.size(); i++)
		{
			connect = circleConnection.get(i);
		}
		for(int i = 0; i<triangleConnection.size(); i++)
		{
			connect = triangleConnection.get(i);
		}
		for(int i = 0; i<squaresConnection.size(); i++)
		{
			connect = squaresConnection.get(i);
		} */
		
		StringTokenizer st = new StringTokenizer(connect);
		if (st.hasMoreTokens()) {
			String k = st.nextToken();
			akeyEvent = Integer.parseInt(st.nextToken());
			String k1 = st.nextToken();
			String k2 = st.nextToken();
		
		}
		}
	}
	
	public void getSquareKey()
	{
		String connect = "";
		if(model.getSquares().size() > 0)
		{
			//absorberConnection = model.getSquares().get(0).getKeyConnections();
	//	ArrayList<String> circleConnection = model.getCircles().get(0).getKeyConnections();
	//	ArrayList<String> triangleConnection = model.getTriangles().get(0).getKeyConnections();
			squareConnection = model.getSquares().get(0).getKeyConnections();
		for(int i = 0; i<squareConnection.size(); i++)
		{
			if(model.getSquares().get(i).isConnect() == true) {
				ArrayList<String> connections = new ArrayList<String>();
				connections = model.getSquares().get(i).getKeyConnections();
				connect = connections.get(0);
			}
		}
	/*	for(int i = 0; i<circleConnection.size(); i++)
		{
			connect = circleConnection.get(i);
		}
		for(int i = 0; i<triangleConnection.size(); i++)
		{
			connect = triangleConnection.get(i);
		}
		for(int i = 0; i<squaresConnection.size(); i++)
		{
			connect = squaresConnection.get(i);
		} */
		
		StringTokenizer st = new StringTokenizer(connect);
		if (st.hasMoreTokens()) {
			String k = st.nextToken();
			skeyEvent = Integer.parseInt(st.nextToken());
			String k1 = st.nextToken();
			String k2 = st.nextToken();
		
		}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(model.getAbs().size() > 0)
		{
			System.out.println("Receiveddddddd");
			getAbsoberKey();
		    if (e.getKeyCode() == akeyEvent) {
			System.out.println("Space pressed");
			model.releaseBall();
			//model.getSquares().get(0).setColour(Color.GREEN);
		}
		  if(model.getSquares().size() > 0)
		{
			getSquareKey();
			System.out.println("Receive");
			for(int i = 0; i < model.getSquares().size(); i++) {
			if (e.getKeyCode() == skeyEvent) {
				
			
			model.getSquares().get(i).setColour(Color.GREEN);
		}
			}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		System.out.println("Space pressed");
		model.releaseBall();
		}
		
		for(int i = 0; i< model.getLFlipper().size(); i++)
		{
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				model.getLFlipper().get(i).setColour();
			}
		}
		
		for(int i = 0; i< model.getRFlipper().size(); i++)
		{
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				model.getRFlipper().get(i).setColour();
			}
		}
	
		
		for (int i = 0; i< model.getAbs().size(); i++)
		{
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				model.getAbs().get(i).setColour();
			}
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
		for(int i = 0; i< model.getLFlipper().size(); i++)
		{
			
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				model.getLFlipper().get(i).setColour1();
			}
		}
		
		for(int i = 0; i< model.getRFlipper().size(); i++)
		{
			
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				model.getRFlipper().get(i).setColour1();
			}
		}
		
		for (int i = 0; i< model.getAbs().size(); i++)
		{
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				model.getAbs().get(i).setColour1();
			}
		} 
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
