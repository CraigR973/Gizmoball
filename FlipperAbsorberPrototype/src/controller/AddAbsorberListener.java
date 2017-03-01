package controller;

import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.event.MouseInputListener;
import javax.swing.text.Utilities;

import model.Model1;
import view.GizmoBallGui;

public class AddAbsorberListener implements MouseInputListener {
	
	private Model1 model;
	private GizmoBallGui view;
	private JTextArea messageBoard;
	
	public AddAbsorberListener(Model1 m, GizmoBallGui v, JTextArea mb){
		model = m;
		view = v;
		messageBoard = mb;
	}
	
	public void MousePressed(MouseEvent e) {
		messageBoard.setText("");
		x1 = (int)(e.getX() / Utilities.GizmoBallGlobals.DEFAULT_L);
		y1 = (int)(e.getY() / Utilities.GizmoBallGlobals.DEFAULT_L);
		rubberband(x1, y1, xtemp, ytemp);
	}
	
	public void MouseDragged(MouseEvent e) {
		int xtemp = (int) Math.ceil((e.getX() / (Utilities.GizmoBallGlobals.DEFAULT_L * 1.0)));
		int ytemp = (int) Math.ceil((e.getY() / (Utilities.GizmoBallGlobals.DEFAULT_L * 1.0)));
		eraseRubberband();
		rubberband(x1, y1, xtemp, ytemp);
	}

	private void eraseRubberband() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
