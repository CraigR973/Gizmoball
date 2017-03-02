package view;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import controller.GizmoBallListener;

public interface GizmoBallGui {
	
	public JPanel createButtons(GizmoBallListener l); 
	public JMenuBar createMenuBar(GizmoBallListener l);
	public JPanel createMessageField();
		
	

	public void RunGui1();

	public Object getMessageBoard();
	
	public void BuildGui1();

}
