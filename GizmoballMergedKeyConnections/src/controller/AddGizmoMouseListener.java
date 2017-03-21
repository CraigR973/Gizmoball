package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Model;
import view.Board;

public class AddGizmoMouseListener implements MouseListener {
	private Model model;
	private Board board;
	private String gizmo;

	public AddGizmoMouseListener(Model m, String g, Board b) {
		model = m;
		gizmo = g;
		board = b;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
//		if (e.getButton() == MouseEvent.BUTTON3) {
//			int x = Math.round(e.getX() / 20);
//			int y = Math.round(e.getY() / 20);
//			model.deleteGizmo(x, y);
//		}
		// TODO Auto-generated method stub
		if (e.getButton() == MouseEvent.BUTTON1) {

			int x = Math.round(e.getX() / 20);
			int y = Math.round(e.getY() / 20);
			switch (gizmo) {
			case "Square":
				System.out.println("adding square");
				model.addSquareGizmo(x, y);
				break;
			case "Circle":
				System.out.println("adding circ");
				model.addCircleGizmo(x, y);
				break;
			case "Triangle":
				System.out.println("adding tri");
				model.addTriangleGizmo(x, y);
				break;
			case "RF":
				System.out.println("adding rf");
				model.addRFlipperGizmo(x,y);
				break;
			case "LF":
				System.out.println("adding lf");
				model.addLFlipperGizmo(x, y);
				break;
			case "Absorber":
				System.out.println("adding abs");
				model.addAbsorberGizmo(y);
				break;
			}
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