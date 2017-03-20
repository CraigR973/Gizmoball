package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Model;
import view.Board;

public class RotateGizmoMouseListener implements MouseListener{
	Model model;
	Board board;
	public RotateGizmoMouseListener(Model m, Board b) {
		// TODO Auto-generated constructor stub
		model = m;
		board = b;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = Math.round(e.getX() / 20);
		int y = Math.round(e.getY() / 20);
		model.rotate(x, y);
		board.repaint();
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

		board.removeMouseListener(this);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
