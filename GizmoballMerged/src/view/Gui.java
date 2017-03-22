package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.AddAbsorberMouseListener;
import controller.AddBallMouseListener;
import controller.AddGizmoMouseListener;
import controller.BuildListener3;
import controller.DeleteGizmoMouseListener;
import controller.KeyConnectMouseListener;
import controller.MoveMouseListener;
import controller.RotateGizmoMouseListener;
import controller.RunListener2;
import controller.ConnectKeyListener;
import model.Model;
import model.PhysicsLoop;

//import controller.RunListener;

public class Gui {

	private Model model;
	private JFrame frame;
	private ActionListener listener;
	private ActionListener listener2;
	private Board board;
	private boolean switchMode;
	private JPanel buttons1;
	private PhysicsLoop pl;

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
		board.addMouseListener(new DeleteGizmoMouseListener(model, board));
		
	/*	if(switchMode==true) {
			board.setBackground(Color.WHITE);
		} */

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
		addCircleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddGizmoMouseListener sml = new AddGizmoMouseListener(model, "Circle", board);
				board.addMouseListener(sml);
			}
		});
		addCircleButton.setFont(gf);
		addCircleButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addCircleButton);

		JButton addSquareButton = new JButton("Add Square");
		addSquareButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddGizmoMouseListener sml = new AddGizmoMouseListener(model, "Square", board);
				board.addMouseListener(sml);
			}
		});
		addSquareButton.setFont(gf);
		addSquareButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addSquareButton);

		JButton addTriangleButton = new JButton("Add Triangle");
		addTriangleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddGizmoMouseListener sml = new AddGizmoMouseListener(model, "Triangle", board);
				board.addMouseListener(sml);
			}
		});
		addTriangleButton.setFont(gf);
		addTriangleButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addTriangleButton);

		JButton addBallButton = new JButton("Add Ball");
		addBallButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

		//		int optionPaneXv = Integer.parseInt(JOptionPane.showInputDialog("Enter X Vel"));
		//		int optionPaneYv = Integer.parseInt(JOptionPane.showInputDialog("Enter Y Vel"));

				double xVel = Double.parseDouble(JOptionPane.showInputDialog("Enter X Vel"));
				double yVel = Double.parseDouble(JOptionPane.showInputDialog("Enter Y Vel"));

				
	//			optionPane.showInputDialog(frame, "Hello");
		//		Double.parseDouble(JOptionPane.showInputDialog(frame, "Please enter your x value for ball velocity"));
			//	Double.parseDouble(JOptionPane.showInputDialog(frame, "Please enter your y value for ball velocity"));

			//	AddGizmoMouseListener sml = new AddGizmoMouseListener(model, "Ball", board, optionPaneXv, optionPaneYv);
			//	board.addMouseListener(sml);
			//	model.setBallSpeed(optionPaneXv, optionPaneYv);

//				AddGizmoMouseListener sml = new AddGizmoMouseListener(model, "Ball", board, optionPaneXv, optionPaneYv);
//				board.addMouseListener(sml);
				AddBallMouseListener abml = new AddBallMouseListener(model, board, xVel, yVel);
				board.addMouseListener(abml);

			}
		});
		addBallButton.setFont(gf);
		addBallButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addBallButton);

		JButton addAbsorberButton = new JButton("Add Absorber");
		addAbsorberButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				AddGizmoMouseListener sml = new AddGizmoMouseListener(model, "Absorber", board);
//				board.addMouseListener(sml);
				AddAbsorberMouseListener aml = new AddAbsorberMouseListener(model, board);
				board.addMouseListener(aml);
			}
		});
		addAbsorberButton.setFont(gf);
		addAbsorberButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addAbsorberButton);

		JButton addLeftFlipperButton = new JButton("Add Left Flipper");
		addLeftFlipperButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddGizmoMouseListener sml = new AddGizmoMouseListener(model, "LF", board);
				board.addMouseListener(sml);
			}
		});
		addLeftFlipperButton.setFont(gf);
		addLeftFlipperButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addLeftFlipperButton);

		JButton addRightFlipperButton = new JButton("Add Right Flipper");
		addRightFlipperButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddGizmoMouseListener sml = new AddGizmoMouseListener(model, "RF", board);
				board.addMouseListener(sml);
			}
		});
		addRightFlipperButton.setFont(gf);
		addRightFlipperButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(addRightFlipperButton);

		JButton rotateGizmoButton = new JButton("Rotate Gizmo");
		rotateGizmoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MouseListener rml = new RotateGizmoMouseListener(model, board);
				board.addMouseListener(rml);
			}
		});
		rotateGizmoButton.setFont(gf);
		rotateGizmoButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(rotateGizmoButton);

		JButton deleteGizmoButton = new JButton("Delete Gizmo");
		deleteGizmoButton.addActionListener(listener2);
		deleteGizmoButton.setFont(gf);
		deleteGizmoButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(deleteGizmoButton);

		JButton moveGizmoButton = new JButton("Move Gizmo");
		moveGizmoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MoveMouseListener mml = new MoveMouseListener(model,board);
				board.addMouseListener(mml);
			}
		});
		moveGizmoButton.setFont(gf);
		moveGizmoButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(moveGizmoButton);

		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.clearBoard();
			}
		});
		clearButton.setFont(gf);
		clearButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(clearButton);

		JButton editFrictionButton = new JButton("Edit Friction");
		editFrictionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			//	JOptionPane optionPane = new JOptionPane(); 
				double friction;
				
		//		friction = PhysicsLoop.getGrav();
				
				
//				friction = Double.parseDouble(JOptionPane.showInputDialog(frame, "Please enter your new friction value"));
				double mu = Double.parseDouble(JOptionPane.showInputDialog(frame, "Please enter a value for mu"));
				double mu2 = Double.parseDouble(JOptionPane.showInputDialog(frame, "Please enter a value for mu2"));
				friction = mu + mu2;
				System.out.println(friction);
				model.setFriction(friction);
				
			}
		});
		editFrictionButton.setFont(gf);
		editFrictionButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(editFrictionButton);

		JButton editGravityButton = new JButton("Edit Gravity");
		editGravityButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			//	JOptionPane optionPane = new JOptionPane(); 
				double gravity;
				
		//		gravity = PhysicsLoop.getGrav();
				
				
				gravity = Double.parseDouble(JOptionPane.showInputDialog(frame, "Please enter your new gravity value"));
				System.out.println(gravity);
					model.setGrav(gravity);
				
				
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
		keyConnectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//gets gizmos user wants to add connection to
				MouseListener kcml = new KeyConnectMouseListener(model, board);
				board.addMouseListener(kcml);
				
				//gets button user wants to connect to gizmo
//				frame.addKeyListener(new KeyListener() {
//
//					@Override
//					public void keyPressed(KeyEvent e) {
//						// TODO Auto-generated method stub
//						int keycode = e.getKeyCode();
//						String connection = "key " + keycode + " down";
//						//model.storeKeyConnection(connection);
//						System.out.println(connection);
//					}
//
//					@Override
//					public void keyReleased(KeyEvent e) {
//					}
//
//					@Override
//					public void keyTyped(KeyEvent e) {
//						// TODO Auto-generated method stub
//
//					}
//				});
			}
		});
		keyConnectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//gets gizmos user wants to add connection to
//				MouseListener kcml = new KeyConnectMouseListener(model, board);
//				board.addMouseListener(kcml);
				
			
				
				//gets button user wants to connect to gizmo
				frame.addKeyListener(new KeyListener() {

					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						int keycode = e.getKeyCode();
						String connection = "key " + keycode + " down";
						model.storeKeyConnection(connection);
						model.addKeyConnection("Square");
						model.addKeyConnection("Triangle");
						model.addKeyConnection("Circle");
						//System.out.println(connection);
					}

					@Override
					public void keyReleased(KeyEvent e) {
						frame.removeKeyListener(this);
					}

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub

					}
				});
				
			}
		});
		
		keyConnectButton.addActionListener(listener2);
		keyConnectButton.setFont(gf);

		keyConnectButton.setMaximumSize(new Dimension(75, 15));
		buildButtons.add(keyConnectButton);
		
	

		JButton keyDisconnectButton = new JButton("Key Disconnect");
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
		
		KeyListener ckl = new ConnectKeyListener(model, board); 
		frame.addKeyListener(ckl);


		board.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					//System.out.println("Space pressed");
					model.releaseBall();
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("left pressed");
					model.flipFlippers();
					board.repaint();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					//System.out.println("Space released");
					model.captureBall();
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					model.unflipFlippers();
					board.repaint();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		
		
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


//		board.addKeyListener(new KeyListener() {
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("Key press detected on board");
//				model.releaseBall();
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				model.captureBall();
//			}
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//		});

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
				board.flipMode(switchMode);
				
				if (switchMode == false) {
					buttons1 = runButtons;
					switchMode = true;
					board.setBackground(Color.BLACK);
					DeleteGizmoMouseListener.setActive(true);
					if (build.getComponentCount() != 0) {
						build.removeAll();
					}

				} else {

					switchMode = false;
					buttons1 = buildButtons;
					board.setBackground(Color.WHITE);
				    ((RunListener2) listener).getTimer().stop();
				    DeleteGizmoMouseListener.setActive(false);
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
