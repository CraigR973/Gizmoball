package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Model;

public class MoveMouseListener implements MouseListener{

	Model model;
	String giz;
	
	public MoveMouseListener(Model m) {
		// TODO Auto-generated constructor stub
		model = m;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = Math.round(e.getX() / 20);
		int y = Math.round(e.getY() / 20);
		
		giz = model.deleteGizmo(x, y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = Math.round(e.getX() / 20);
		int y = Math.round(e.getY() / 20);
		
		if(giz != null){
			model.moveGizmoAdd(x, y, giz);
		}
	}

}