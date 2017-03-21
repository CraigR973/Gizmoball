package controller;

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
	private int keyEvent;
	
	public ConnectKeyListener(Model m, Board b) {
		model = m;
		board = b;
		
	}
	
	public void getKeyEvent()
	{
		String connect = null;
		ArrayList<String> absorberConnection = model.getAbs().get(0).getKeyConnections();
		for(int i = 0; i<absorberConnection.size(); i++)
		{
			connect = absorberConnection.get(i);
		}
		StringTokenizer st = new StringTokenizer(connect);
		if (st.hasMoreTokens()) {
			String k = st.nextToken();
			keyEvent = Integer.parseInt(st.nextToken());
			String k1 = st.nextToken();
			String k2 = st.nextToken();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		getKeyEvent();
		if (e.getKeyCode() == keyEvent) {
			System.out.println("Space pressed");
			model.releaseBall();
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == keyEvent) {
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
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
