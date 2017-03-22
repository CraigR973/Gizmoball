package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Model;
import view.Board;

public class AddAbsorberMouseListener implements MouseListener {
	int initX;
	int initY;
	int finalX;
	int finalY;

	Model model;
	Board board;

	public AddAbsorberMouseListener(Model m, Board b) {
		// TODO Auto-generated constructor stub
		model = m;
		board = b;
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
		board.removeMouseListener(this);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		initX = arg0.getX() / 20;
		initY = arg0.getY() / 20;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		finalX = arg0.getX() / 20;
		finalY = arg0.getY() / 20;

		int width = finalX - initX;
		int height = finalY - initY;
		
		System.out.println("width " + width);
		
		if (width < 0 && height < 0) {
			width = -width;
			height = -height;
			model.addAbsorberGizmo(finalX, finalY, width+1, height+1);
		} else if (width > 0 && height > 0) {
			model.addAbsorberGizmo(initX, initY, width+1, height+1);
		} else if(width == 0 && height == 0){
			model.addAbsorberGizmo(initX,initY,width+1, height+1);
		} else if(width < 0 && height > 0){
			width = -width;
			model.addAbsorberGizmo(finalX, initY, width+1, height+1);
		} else if(width > 0 && height < 0){
			height = -height;
			model.addAbsorberGizmo(initX, finalY, width+1, height+1);
		} else if(width > 0 && height == 0){
			model.addAbsorberGizmo(initX, initY, width+1, height+1);
		} else if(width < 0 && height == 0){
			width = -width;
			model.addAbsorberGizmo(finalX, initY, width+1, height+1);
		} else if(width == 0 && height < 0){
			height = -height;
			model.addAbsorberGizmo(initX, finalY, width+1, height+1);
		} else if(width == 0 && height > 0){
			model.addAbsorberGizmo(initX, initY, width+1, height+1);
		}
		board.repaint();
	}

}
