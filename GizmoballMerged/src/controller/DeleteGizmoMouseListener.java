package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Model;
import view.Board;

public class DeleteGizmoMouseListener implements MouseListener {

	Model model;
	Board board;
	static boolean active;

	public DeleteGizmoMouseListener(Model m, Board b) {
		model = m;
		board = b;
		active = true;
	}

	public static void setActive(boolean b) {
		active = b;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (active == false) {
			if (e.getButton() == MouseEvent.BUTTON3) {
				int x = Math.round(e.getX() / 20);
				int y = Math.round(e.getY() / 20);
				model.deleteGizmo(x, y);
				board.repaint();
			}
		}
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
