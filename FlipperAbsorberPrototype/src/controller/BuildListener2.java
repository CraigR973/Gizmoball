package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JMenuBar;
import javax.swing.event.MouseInputListener;

import model.Model1;
import view.GizmoBallGui;
import view.GizmoBallView;

public  class BuildListener2 implements GizmoBallListener {
	
	private Model1 model;
	private GizmoBallGui view;
	private MouseInputListener mouseListener;
	private KeyListener keyboardListener;
	
	public BuildListener2(Model1 m) {
		model = m;
//		view = v;
	//	mouseListener = new AddGizmoListener(model, view, view.getMessageBoard());
		keyboardListener = new DoNothingKeyListener(m);
	}
	
	public final void actionPerformed(final ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Quit":
			System.exit(0);
			break;
		case "Run Mode":
			view.RunGui1();
			break;
	
			
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
		keyboardListener.keyReleased(e);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyboardListener.keyTyped(e);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		mouseListener.mouseClicked(arg0);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		mouseListener.mouseEntered(arg0);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		mouseListener.mouseExited(arg0);
		
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
	public void mouseDragged(MouseEvent arg0) {
		mouseListener.mouseDragged(arg0);
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		mouseListener.mouseMoved(arg0);
		
	}

	@Override
	public void setMouseListener(MouseInputListener ml) {
		mouseListener = ml;
		
	}

	@Override
	public void setKeyBoardListener(KeyListener kl) {
		keyboardListener = kl;
		
	}

	public void setJMenuBar(JMenuBar menubar) {
		// TODO Auto-generated method stub
		
	} 
}


