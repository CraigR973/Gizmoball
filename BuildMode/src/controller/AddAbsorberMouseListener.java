package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Model;

public class AddAbsorberMouseListener implements MouseListener{
	
	private Model model;

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			//if(switchMode == false){
				int x = Math.round(e.getX() / 20);
				int y = Math.round(e.getY() / 20);
				model.deleteGizmo(x, y);
			//}
		}
		// TODO Auto-generated method stub
		if (e.getButton() == MouseEvent.BUTTON1) {
			//if(switchMode == false){
//				int x = Math.round(e.getX() / 20);
				int y = Math.round(e.getY() / 20);
			
				model.addAbsorberGizmo(y);
			//}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
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
