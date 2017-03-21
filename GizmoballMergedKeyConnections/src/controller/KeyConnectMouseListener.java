package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import model.Model;
import view.Board;

public class KeyConnectMouseListener implements MouseListener{
	Model model;
	Board board;
	String gizmo;
	
	public KeyConnectMouseListener(Model m, Board b) {
		// TODO Auto-generated constructor stub
		model = m;
		board = b;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = Math.round(e.getX() / 20);
		int y = Math.round(e.getY() / 20);
		gizmo = model.getGizmo(x, y);
		model.storeGizConnection(gizmo);
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
	

}