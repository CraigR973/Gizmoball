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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.plaf.ButtonUI;

import controller.BuildListener3;

import controller.RunListener2;
import model.Model;
import model.PhysicsLoop;

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
		// this.buttons1 = runButtons;
		this.switchMode = false;

		// RunListener catches all GUI events. In reality might have many
		// listeners.
		listener = new RunListener2(m);
		listener2 = new BuildListener3(m);
	}

	public void createAndShowGUI() {

		frame = new JFrame("Gizmoball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// frame.setSize(700,700);

		// Board is passed the Model so it can act as Observer
		board = new Board(400, 400, model);
		board.setBackground(Color.GRAY);
		board.setMaximumSize(new Dimension(400, 400));

		Container cp = frame.getContentPane();

		Font gf = new Font("Rocket Script", Font.HANGING_BASELINE, 15);

		JPanel runButtons = new JPanel();
		// buttons.setLayout(new GridLayout(2, 4));
		runButtons.setLayout(new GridLayout(4, 1));
		runButtons.setPreferredSize(new Dimension(250, 400));

		// JButton switchScreen = new JButton("Change Mode");

		// buttons.add(switchScreen);

		JButton startButton = new JButton("Start");
		startButton.setFont(gf);
		startButton.addActionListener(listener);
		startButton.setMaximumSize(new Dimension(200, 125));
		runButtons.add(startButton);

		JButton stopButton = new JButton("Stop");
		stopButton.setFont(gf);
		stopButton.addActionListener(listener);
		stopButton.setMaximumSize(new Dimension(200, 125));
		runButtons.add(stopButton);

		JButton tickButton = new JButton("Tick");
		tickButton.setFont(gf);
		tickButton.addActionListener(listener);
		tickButton.setMaximumSize(new Dimension(200, 125));
		runButtons.add(tickButton);

		/*
		 * JButton button3 = new JButton("Quit"); button3.setFont(gf);
		 * button3.addActionListener(listener); button3.setMaximumSize(new
		 * Dimension(100, 100)); buttons.add(button3);
		 * 
		 * JButton saveButton = new JButton("Save");
		 * saveButton.addActionListener(listener); saveButton.setFont(gf);
		 * saveButton.setBackground(Color.decode("#D4FAFF"));
		 * buttons.add(saveButton);
		 * 
		 * JButton loadButton = new JButton("Load");
		 * loadButton.addActionListener(listener); loadButton.setFont(gf);
		 * buttons.add(loadButton);
		 */

		JPanel buildButtons = new JPanel();
		buildButtons.setLayout(new GridLayout(9, 2));
		buildButtons.setPreferredSize(new Dimension(250, 390));

		/*
		 * JComboBox<String> comboGizmo = new JComboBox<String>();
		 * comboGizmo.addItem("Square"); comboGizmo.addItem("Circle");
		 * comboGizmo.addItem("Triangle"); buildButtons.add(comboGizmo);
		 */

		JButton addCircleButton = new JButton("Add Circle");
		addCircleButton.addActionListener(listener2);
		addCircleButton.setFont(gf);
		addCircleButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addCircleButton);

		JButton addSquareButton = new JButton("Add Square");
		addSquareButton.addActionListener(listener2);
		addSquareButton.setFont(gf);
		addSquareButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addSquareButton);

		JButton addTriangleButton = new JButton("Add Triangle");
		addTriangleButton.addActionListener(listener2);
		addTriangleButton.setFont(gf);
		addTriangleButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addTriangleButton);

		JButton addBallButton = new JButton("Add Ball");
		addBallButton.addActionListener(listener2);
		addBallButton.setFont(gf);
		addBallButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addBallButton);

		JButton addAbsorberButton = new JButton("Add Absorber");
		addAbsorberButton.addActionListener(listener2);
		addAbsorberButton.setFont(gf);
		addAbsorberButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addAbsorberButton);

		JButton addLeftFlipperButton = new JButton("Add Left Flipper");
		addLeftFlipperButton.addActionListener(listener2);
		addLeftFlipperButton.setFont(gf);
		addLeftFlipperButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addLeftFlipperButton);

		JButton addRightFlipperButton = new JButton("Add Right Flipper");
		addRightFlipperButton.addActionListener(listener2);
		addRightFlipperButton.setFont(gf);
		addRightFlipperButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addRightFlipperButton);

		JButton rotateGizmoButton = new JButton("Rotate Gizmo");
		rotateGizmoButton.addActionListener(listener2);
		rotateGizmoButton.setFont(gf);
		rotateGizmoButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(rotateGizmoButton);

		JButton deleteGizmoButton = new JButton("Delete Gizmo");
		deleteGizmoButton.addActionListener(listener2);
		deleteGizmoButton.setFont(gf);
		deleteGizmoButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(deleteGizmoButton);

		JButton moveGizmoButton = new JButton("Move Gizmo");
		moveGizmoButton.addActionListener(listener2);
		moveGizmoButton.setFont(gf);
		moveGizmoButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(moveGizmoButton);

		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(listener2);
		clearButton.setFont(gf);
		clearButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(clearButton);

		JButton editFrictionButton = new JButton("Edit Friction");
		editFrictionButton.addActionListener(listener2);
		editFrictionButton.setFont(gf);
		editFrictionButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(editFrictionButton);

		JButton editGravityButton = new JButton("Edit Gravity");
		editGravityButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			//	JOptionPane optionPane = new JOptionPane(); 
				JOptionPane.showInputDialog(frame, "Please enter your new gravity value");
				
			}
		});
		editGravityButton.setFont(gf);
		editGravityButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(editGravityButton);

		JButton connectButton = new JButton("Connect");
		connectButton.addActionListener(listener2);
		connectButton.setFont(gf);
		connectButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(connectButton);

		JButton disconnectButton = new JButton("Disconnect");
		disconnectButton.addActionListener(listener2);
		disconnectButton.setFont(gf);
		disconnectButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(disconnectButton);

		JButton keyConnectButton = new JButton("Key Connect");
		keyConnectButton.addActionListener(listener2);
		keyConnectButton.setFont(gf);
		keyConnectButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(keyConnectButton);

		JButton keyDisconnectButton = new JButton("Key Connect");
		keyDisconnectButton.addActionListener(listener2);
		keyDisconnectButton.setFont(gf);
		keyDisconnectButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(keyDisconnectButton);

		JPanel build = new JPanel();
		

		// build.setLayout(new GridLayout(4, 1));
		// JPanel run = new JPanel();
		// run.setLayout(new GridLayout(4, 1));

		buttons1 = new JPanel();
		// buttons1.setSize(500, 500);
		// buttons1.setLayout(new GridLayout(4,1));
		// buttons1.add(run);
		buttons1.add(build);
		buttons1.setPreferredSize(new Dimension(250, 390));
		// this.buttons1 = null;

		JMenuBar bar = new JMenuBar();
		bar.setLayout(new GridLayout(1, 4));
		// bar.setPreferredSize(new Dimension(400,100));

		// JMenu menu;
		// JMenuItem item;

		JButton save = new JButton("Save");
		save.addActionListener(listener);
		save.setFont(gf);
		save.setMaximumSize(new Dimension(75, 75));

		JButton load = new JButton("Load");
		load.addActionListener(listener);
		load.setFont(gf);
		load.setMaximumSize(new Dimension(75, 75));

		JButton quit = new JButton("Quit");
		quit.setFont(gf);
		quit.addActionListener(listener);
		quit.setMaximumSize(new Dimension(75, 75));

		JButton change = new JButton("Change Mode");
		change.setFont(gf);
		quit.setMaximumSize(new Dimension(75, 75));

		// menu = new JMenu("File");
		// bar.add(menu);

		bar.add(save);
		bar.add(load);
		bar.add(quit);
		bar.add(change);

		// item = new JMenuItem("Change");

		// menu.add(item);

		// cp.setLayout(new GridLayout(1,3));
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

		startButton.setFocusable(false);
		stopButton.setFocusable(false);
		quit.setFocusable(false);
		tickButton.setFocusable(false);
		save.setFocusable(false);
		load.setFocusable(false);
		change.setFocusable(false);
		addCircleButton.setFocusable(false);
		addTriangleButton.setFocusable(false);
		addSquareButton.setFocusable(false);
		addLeftFlipperButton.setFocusable(false);
		addRightFlipperButton.setFocusable(false);
		addAbsorberButton.setFocusable(false);
		addBallButton.setFocusable(false);
		deleteGizmoButton.setFocusable(false);
		moveGizmoButton.setFocusable(false);
	    rotateGizmoButton.setFocusable(false);
		addBallButton.setFocusable(false);
		connectButton.setFocusable(false);
		disconnectButton.setFocusable(false);
		keyConnectButton.setFocusable(false);
		keyDisconnectButton.setFocusable(false);
		clearButton.setFocusable(false);
		editFrictionButton.setFocusable(false);
		editGravityButton.setFocusable(false);
		
		
		

		frame.setPreferredSize(new Dimension(659, 462));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
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

	public JFrame getFrame() {
		return frame;
	}

}
