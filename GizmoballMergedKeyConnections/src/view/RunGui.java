package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import controller.GizKeyListener;
import controller.RunListener;
import model.Model;

public class RunGui {

	private Model model;
	private JFrame frame;
	private ActionListener listener;
	private Board board;
	private KeyListener keyListener;

	public RunGui(Model m) {
		model = m;

		// RunListener catches all GUI events. In reality might have many
		// listeners.
		listener = new RunListener(m);
		//keyListener = new GizKeyListener();
	}

	public void createAndShowGUI() {

		frame = new JFrame("Absorber Prototype");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Board is passed the Model so it can act as Observer
		board = new Board(400, 400, model);
		board.setBackground(Color.GRAY);

		Container cp = frame.getContentPane();

		Font gf = new Font("Papyrus", Font.HANGING_BASELINE, 23);

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4, 1));

		JButton button1 = new JButton("Start");
		button1.setFont(gf);
		button1.addActionListener(listener);
		button1.setMaximumSize(new Dimension(50, 50));
		buttons.add(button1);

		JButton button2 = new JButton("Stop");
		button2.setFont(gf);
		button2.addActionListener(listener);
		button2.setMaximumSize(new Dimension(50, 50));
		buttons.add(button2);

		JButton button4 = new JButton("Tick");
		button4.setFont(gf);
		button4.addActionListener(listener);
		button4.setMaximumSize(new Dimension(50, 50));
		buttons.add(button4);

		JButton button3 = new JButton("Quit");
		button3.setFont(gf);
		button3.addActionListener(listener);
		button3.setMaximumSize(new Dimension(50, 50));
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

//		JLabel info = new JLabel("Press the Start button then press the space key to release the ball in the absorber");

		cp.add(buttons, BorderLayout.SOUTH);
		//cp.add(info, BorderLayout.NORTH);
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
		button3.setFocusable(false);
		button4.setFocusable(false);
		saveButton.setFocusable(false);
		loadButton.setFocusable(false);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		board.requestFocus();
	}

	public void changeFocus() {
		frame.requestFocus();
		frame.requestFocusInWindow();
	}
	
	public JFrame getFrame(){
		return frame;
	}
}
