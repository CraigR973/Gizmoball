package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Model;
import view.Board;

public class AddBallMouseListener implements MouseListener {
	private Model model;
	private Board board;
	private double xv;
	private double yv;

	public AddBallMouseListener(Model m, Board b, double xVel, double yVel) {
		model = m;
		board = b;
		xv=xVel;
		yv=yVel;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {

			int x = Math.round(e.getX() / 20);
			int y = Math.round(e.getY() / 20);
			model.addBallGizmo(x, y, xv, yv);
			board.repaint();
		}
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