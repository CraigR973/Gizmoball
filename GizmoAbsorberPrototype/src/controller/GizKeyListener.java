package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Model;

public class GizKeyListener implements KeyListener{
	
	private Model model;

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			System.out.println("Space pressed");
			model.releaseBall();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			System.out.println("Space released");
			model.captureBall();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			System.out.println("Left key pressed");
		}
	}

}
