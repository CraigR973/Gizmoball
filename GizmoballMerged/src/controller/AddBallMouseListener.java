package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

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
		xv = xVel;
		yv = yVel;
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
			if (model.getBalls().size() > 0) {
				JOptionPane.showMessageDialog(board, "There is already a ball on the board!", "Cannot Place Gimzo", 0);
			} else {
				if (x == 0 || y == 0) {
					JOptionPane.showMessageDialog(board, "Cannot place a ball off the board!", "Cannot Place Gimzo", 0);
				} else {
					if (model.checkGizmos(x, y)) {
						JOptionPane.showMessageDialog(board, "There is already a gizmo in this location!",
								"Cannot Place Gimzo", 0);
					} else {
						model.addBallGizmo(x, y, xv, yv);
					}
				}
				board.repaint();
			}
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