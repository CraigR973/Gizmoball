package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import controller.BuildListener;
import controller.RunListener1;
import model.Model1;
//import controller.RunListener;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Gui2 {

	private Model1 model;
	private JFrame frame;
	private ActionListener listener;
	private Board1 board;
	private boolean switchMode;
	private JPanel buttons1;
	

	public Gui2(Model1 m) {
		model = m;
		this.buttons1 = null;
	//	this.switchMode = true;

		// RunListener catches all GUI events. In reality might have many listeners.
	//	listener = new RunListener1(m);
	}

	public void createAndShowGUI() {

		frame = new JFrame("Absorber Prototype <3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Board is passed the Model so it can act as Observer
		board = new Board1(500, 500, model);
		board.setBackground(Color.GRAY);

		Container cp = frame.getContentPane();

		Font gf = new Font("Papyrus", Font.HANGING_BASELINE, 23);

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4, 1));

		JButton button1 = new JButton("Start");
		button1.setFont(gf);
		button1.addActionListener(listener);
		button1.setMaximumSize(new Dimension(100, 100));
		buttons.add(button1);

		JButton button2 = new JButton("Stop");
		button2.setFont(gf);
		button2.addActionListener(listener);
		button2.setMaximumSize(new Dimension(100, 100));
		buttons.add(button2);

		JButton button4 = new JButton("Tick");
		button4.setFont(gf);
		button4.addActionListener(listener);
		button4.setMaximumSize(new Dimension(100, 100));
		buttons.add(button4);

		JButton button3 = new JButton("Quit");
		button3.setFont(gf);
		button3.addActionListener(listener);
		button3.setMaximumSize(new Dimension(100, 100));
		buttons.add(button3);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(listener);
		saveButton.setFont(gf);
		saveButton.setBackground(Color.decode("#D4FAFF"));
		buttons.add(saveButton);
		
		JButton loadButton = new JButton("Load");
		loadButton.addActionListener(listener);
		loadButton.setFont(gf);
		buttons.add(loadButton);
		
		JPanel buildButtons = new JPanel();
		buildButtons.setLayout(new GridLayout(4, 1));
		
		JButton ballButton = new JButton("Ball");
		ballButton.addActionListener(listener);
		ballButton.setFont(gf);
		buildButtons.add(ballButton);
		
		
		
		
			
			JMenuBar bar = new JMenuBar();
			
			
			
			JMenu menu;
			JMenuItem item;
			
			menu = new JMenu("File");
			bar.add(menu);
			
			item = new JMenuItem("Change");
			
			
			item.addActionListener((new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					if(switchMode == false) {
						buttons1 =  buttons;
						switchMode = true;
						
					/*	if(buildButtons.getComponentCount() != 0) {
							buildButtons.removeAll();
						}  */
						
						buildButtons.setVisible(false);
						buttons.setVisible(true);
						
			
					} else {
						
						switchMode = false;
						buttons1 =  buildButtons;
						
				/*		if(buildButtons.getComponentCount() != 0) {
							buildButtons.removeAll(); 
							
						}  */
						buildButtons.setVisible(true);
						buttons.setVisible(false);
						
					} 
					
					buildButtons.add(buttons1);
					buildButtons.repaint();
					buildButtons.revalidate();
				}
			}));
	

	
	
		
			menu.add(item);
		
	//	JButton switchScreen1 = new JButton("Change Mode");
	//	buildButtons.add(switchScreen1);
		
	//	JButton switchScreen2 = new JButton("Change Mode");
	//	buttons.add(switchScreen2);
		

	
		
		

		cp.add(buttons, BorderLayout.LINE_START);
		cp.add(buildButtons, BorderLayout.LINE_START);
		cp.add(bar, BorderLayout.NORTH);
		cp.add(board, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
/*switchScreen1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(switchMode == false) {
					buttons1 =  buttons;
					switchMode = true;
					
					if(buildButtons.getComponentCount() != 0) {
						buildButtons.removeAll();
					}
					
		
				} else {
					
					switchMode = false;
					buttons1 =  buildButtons;
					buttons.add(switchScreen1);
					if(buildButtons.getComponentCount() != 0) {
						buildButtons.removeAll();
						
					}
				}
				
				buildButtons.add(buttons1);
				buildButtons.repaint();
				buildButtons.revalidate();
			}
		}); */
	
	
/*	switchScreen2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(switchMode == false) {
				buttons1 =  buildButtons;
				switchMode = true;
				
				if(buttons.getComponentCount() != 0) {
					buttons.removeAll();
				}
				
	
			} else {
				
				switchMode = false;
				buttons1 = buttons;
				
				if(buttons.getComponentCount() != 0) {
					buttons.removeAll();
				}
			}
			
			buttons.add(buttons1);
			buttons.repaint();
			buttons.revalidate();
		}
	}); */
} 

	
	

}
