package controller;

import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.event.MouseInputListener;
import javax.swing.text.Utilities;

import model.Model1;

public class DeleteGizmoListener implements MouseInputListener {
	
	Model1 model = new Model1();
	double x;
	double y;
	String gizmo;
	
	public DeleteGizmoListener(Model1 model, Object messageBoard, JTextArea messageBoard2) {
		
		// TODO Auto-generated constructor stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		x = (double)(e.getX() / Utilities.GizmoBallGlobals.DEFAULT_L);
		y = (double)(e.getY() / Utilities.GizmoBallGlobals.DEFAULT_L);
		model.addGizmo(gizmo, x, y);
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
