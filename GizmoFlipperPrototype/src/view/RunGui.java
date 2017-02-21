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

import controller.RunListener;
import model.Model;
//import controller.RunListener;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class RunGui {

	private Model model;
	private JFrame frame;
	private ActionListener listener;
	private Board board;

	public RunGui(Model m) {
		model = m;

		// RunListener catches all GUI events. In reality might have many listeners.
		listener = new RunListener(m);
	}

	public void createAndShowGUI() {

		frame = new JFrame("Flipper Prototype");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Board is passed the Model so it can act as Observer
		board = new Board(500, 500, model);
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

		JLabel info = new JLabel("Use the left arrow key to move the flipper");
		
		cp.add(buttons, BorderLayout.SOUTH);
		cp.add(info, BorderLayout.NORTH);
		cp.add(board, BorderLayout.CENTER);
		
		button1.addKeyListener( new KeyListener() {

			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					System.out.println("Flipper moved");
					model.rotateLeftFLip();
					board.keyPressDetect();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					System.out.println("Flipper moved");
					model.rotateLeftFLip();
					board.keyPressDetectNon();
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			//new GizKeyListener());
		});

		frame.requestFocus();
		frame.requestFocusInWindow(); 
		
		
	

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
