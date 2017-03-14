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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import controller.BuildListener;
import controller.BuildListener3;
import controller.RunListener1;
import controller.RunListener2;
import model.Model1;
//import controller.RunListener;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Gui2 {

	private Model1 model;
	private JFrame frame;
	private ActionListener listener;
	private ActionListener listener2;
	private Board1 board;
	private boolean switchMode;
	private JPanel buttons1;

	public Gui2(Model1 m) {
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
	//	frame.setSize(600,600);

		// Board is passed the Model so it can act as Observer
		board = new Board1(500, 500, model);
		board.setBackground(Color.BLACK);

		Container cp = frame.getContentPane();

		Font gf = new Font("Rocket Script", Font.HANGING_BASELINE, 15);

		JPanel runButtons = new JPanel();
	//	buttons.setLayout(new GridLayout(2, 4));
		 runButtons.setLayout(new GridLayout(4,1));

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
	//	this.buttons1 = null;

		JMenuBar bar = new JMenuBar();

	//	JMenu menu;
	//	JMenuItem item;
		JButton change;
		JButton save;
		JButton load;
		JButton quit;
		
		change = new JButton("Change Mode");
		save = new JButton("Save");
		load = new JButton("Load");
		quit = new JButton("Quit");

	//	menu = new JMenu("File");
	//	bar.add(menu);
		bar.add(change);
		bar.add(save);
		bar.add(load);
		bar.add(quit);

	//	item = new JMenuItem("Change");

	//	menu.add(item);

	//	 cp.setLayout(new GridLayout(1,3));
		cp.add(buttons1, BorderLayout.LINE_START);
		// cp.add(buildButtons, BorderLayout.LINE_START);
		// cp.add(buttons, BorderLayout.LINE_START);
		// cp.add(buildButtons, BorderLayout.LINE_START);
		cp.add(bar, BorderLayout.NORTH);
		cp.add(board, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

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

}
