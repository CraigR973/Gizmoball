package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.event.MouseInputListener;

import model.Model1;

public  class BuildListener implements GizmoBallListener {
	
	private Model1 model;
	private GizmoBallGui view;
	private MouseInputListener mouseListener;
	private KeyListener keyboardListener;
	
	public BuildListener(Model1 m, GizmoBallGui v) {
		model = m;
		view = v;
		mouseListener = new AddGizmoListener(model, view.getMessageBoard());
		keyboardListener = new DoNothingKeyListener(m);
	}
	
	public final void actionPerformed(final ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Quit":
			System.exit(0);
			break;
		case "Run Mode":
			view.RunGui1();
			
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void windowClosing(final WindowEvent arg0) {
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyboardListener.keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	public void mousePressed(MouseEvent arg0) {
		mouseListener.mousePressed(arg0);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		mouseListener.mouseReleased(arg0);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMouseListener(MouseInputListener ml) {
		mouseListener = ml;
		
	}

	@Override
	public void setKeyBoardListener(KeyListener kl) {
		keyboardListener = kl;
		
	}
}


