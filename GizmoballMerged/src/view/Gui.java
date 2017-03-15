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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


import controller.BuildListener3;

import controller.RunListener2;
import model.Model;

//import controller.RunListener;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Gui {

	private Model model;
	private JFrame frame;
	private ActionListener listener;
	private ActionListener listener2;
	private Board board;
	private boolean switchMode;
	private JPanel buttons1;

	public Gui(Model m) {
		model = m;
	//	this.buttons1 = runButtons;
	    this.switchMode = false;

		// RunListener catches all GUI events. In reality might have many
		// listeners.
		listener = new RunListener2(m);
		listener2 = new BuildListener3(m);
	}

	public void createAndShowGUI() {

		frame = new JFrame("Gizmoball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	frame.setSize(700,700);
		

		// Board is passed the Model so it can act as Observer
		board = new Board(500, 500, model);
		board.setBackground(Color.GRAY);

		Container cp = frame.getContentPane();

		Font gf = new Font("Rocket Script", Font.HANGING_BASELINE, 15);

		JPanel runButtons = new JPanel();
	//	buttons.setLayout(new GridLayout(2, 4));
		 runButtons.setLayout(new GridLayout(4,1));
		 runButtons.setPreferredSize(new Dimension(300, 500));
		 

		// JButton switchScreen = new JButton("Change Mode");

		// buttons.add(switchScreen);

		JButton button1 = new JButton("Start");
		button1.setFont(gf);
		button1.addActionListener(listener);
		button1.setMaximumSize(new Dimension(75, 75));
		runButtons.add(button1);

		JButton button2 = new JButton("Stop");
		button2.setFont(gf);
		button2.addActionListener(listener);
		button2.setMaximumSize(new Dimension(75, 75));
		runButtons.add(button2);

		JButton button4 = new JButton("Tick");
		button4.setFont(gf);
		button4.addActionListener(listener);
		button4.setMaximumSize(new Dimension(75, 75));
		runButtons.add(button4);

	/*	JButton button3 = new JButton("Quit");
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
		buttons.add(loadButton); */

		JPanel buildButtons = new JPanel();
		buildButtons.setLayout(new GridLayout(4,1));
		buildButtons.setPreferredSize(new Dimension(300, 500));

		JButton addGizmoButton = new JButton("Add Gizmo");
		addGizmoButton.addActionListener(listener2);
		addGizmoButton.setFont(gf);
		addGizmoButton.setMaximumSize(new Dimension(75, 75));
		buildButtons.add(addGizmoButton);
		
		JButton addBallButton = new JButton("Add Ball");
		addBallButton.addActionListener(listener2);
		addBallButton.setFont(gf);
		addBallButton.setMaximumSize(new Dimension(75, 75));
		buildButtons.add(addBallButton);
		
		JButton addAbsorberButton = new JButton("Add Absorber");
		addAbsorberButton.addActionListener(listener2);
		addAbsorberButton.setFont(gf);
		addAbsorberButton.setMaximumSize(new Dimension(75, 75));
		buildButtons.add(addAbsorberButton);
		
		JButton addFlipperButton = new JButton("Add Flipper");
		addFlipperButton.addActionListener(listener2);
		addFlipperButton.setFont(gf);
		addFlipperButton.setMaximumSize(new Dimension(75, 75));
		buildButtons.add(addFlipperButton);
		
		JButton editGizmoButton = new JButton("Edit Gizmo");
		editGizmoButton.addActionListener(listener2);
		editGizmoButton.setFont(gf);
		editGizmoButton.setMaximumSize(new Dimension(75, 75));
		buildButtons.add(editGizmoButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(listener2);
		clearButton.setFont(gf);
		clearButton.setMaximumSize(new Dimension(75, 75));
		buildButtons.add(clearButton);
		
		JButton editPhysicsButton = new JButton("Edit physics");
		editPhysicsButton.addActionListener(listener2);
		editPhysicsButton.setFont(gf);
		editPhysicsButton.setMaximumSize(new Dimension(75, 75));
		buildButtons.add(editPhysicsButton);
		
		JButton connectionsButton = new JButton("Connections");
		connectionsButton.addActionListener(listener2);
		connectionsButton.setFont(gf);
		connectionsButton.setMaximumSize(new Dimension(75, 75));
		buildButtons.add(connectionsButton);
		
		
		
		
		

		JPanel build = new JPanel();
	//	build.setLayout(new GridLayout(4, 1));
	//	JPanel run = new JPanel();
	//	run.setLayout(new GridLayout(4, 1));

		buttons1 = new JPanel();
	//	buttons1.setSize(500, 500);
	//	buttons1.setLayout(new GridLayout(4,1));
	//	buttons1.add(run);
		buttons1.add(build);
		buttons1.setPreferredSize(new Dimension(300, 700));
	//	this.buttons1 = null;

		JMenuBar bar = new JMenuBar();
		bar.setLayout(new GridLayout(1,4));

	//	JMenu menu;
	//	JMenuItem item;
		
		
		
		
		JButton save = new JButton("Save");
		save.addActionListener(listener);
		save.setFont(gf);
		save.setBackground(Color.decode("#D4FAFF"));
		
		JButton load = new JButton("Load");
		load.addActionListener(listener);
		load.setFont(gf);
		
		JButton quit = new JButton("Quit");
		quit.setFont(gf);
		quit.addActionListener(listener);
		quit.setMaximumSize(new Dimension(100, 100));
		
		JButton change = new JButton("Change Mode");
		change.setFont(gf);
		quit.setMaximumSize(new Dimension(100, 100));
		
	
		
		
		
		
	
		
		
		
		
		
		

	//	menu = new JMenu("File");
	//	bar.add(menu);
		
		bar.add(save);
		bar.add(load);
		bar.add(quit);
		bar.add(change);

	//	item = new JMenuItem("Change");

	//	menu.add(item);

	//	 cp.setLayout(new GridLayout(1,3));
		cp.add(buttons1, BorderLayout.LINE_START);
		// cp.add(buildButtons, BorderLayout.LINE_START);
		// cp.add(buttons, BorderLayout.LINE_START);
		// cp.add(buildButtons, BorderLayout.LINE_START);
		cp.add(bar, BorderLayout.NORTH);
		cp.add(board, BorderLayout.CENTER);
		
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					System.out.println("Space pressed");
					model.releaseBall();
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("Up pressed");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					System.out.println("Space released");
					model.captureBall();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		board.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Key press detected on board");
				model.releaseBall();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				model.captureBall();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		button1.setFocusable(false);
		button2.setFocusable(false);
		quit.setFocusable(false);
		button4.setFocusable(false);
		save.setFocusable(false);
		load.setFocusable(false);
		change.setFocusable(false);

		
		frame.setPreferredSize(new Dimension(800, 565));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		board.requestFocus();

		change.addActionListener((new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (switchMode == false) {
					buttons1 = runButtons;
					switchMode = true;

					if (build.getComponentCount() != 0) {
						build.removeAll();
					}

					

				} else {

					switchMode = false;
					buttons1 = buildButtons;

					if (build.getComponentCount() != 0) {
						build.removeAll();

					}
					
				}

				build.add(buttons1);
				build.repaint();
				build.revalidate();
			}
		}));

	}
	
	public void changeFocus() {
		frame.requestFocus();
		frame.requestFocusInWindow();
	}
	
	public JFrame getFrame(){
		return frame;
	}

}
