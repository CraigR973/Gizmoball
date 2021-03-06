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
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.MouseInputListener;

import controller.AddAbsorberListener;
import controller.RunListener1;
import model.Model1;
//import controller.RunListener;


public class RunGui1 {

	private Model1 model;
	private JFrame frame;
	private ActionListener listener;
	private Board1 board;
	
	private JTextArea messageBoard;
	private GizmoBallGui view;

	public RunGui1(Model1 m, GizmoBallGui v) {
		model = m;
		view = v;

		// RunListener catches all GUI events. In reality might have many listeners.
		listener = new RunListener1(m, v);
	}
	
/* public JPanel createButtons(RunListener1 runListener) {
		
		
		JButton absorberButton = new JButton("Add Absorber");
	
	
		MouseInputListener al =  new AddAbsorberListener(model, view, messageBoard);
		absorberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				messageBoard.setText("Click and drag to add absorber");
				listener.setMouseListener(al);
			}
		});
		return board;
		
	} */

public JMenuBar createMenuBar(JFrame frame) {
	
	final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
	
	JMenuBar menubar = new JMenuBar();
	
	frame.setJMenuBar(menubar);
	
	JMenu menu;
	JMenuItem item;
	
	menu = new JMenu("File");
	menubar.add(menu);
	
	item = new JMenuItem("Save");
	
	item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,SHORTCUT_MASK));
	menu.add(item);
	return menubar;
	
	
	
	
	
	
	
	
}
	

	public void createAndShowGUI() {

		frame = new JFrame("Gizmoball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenuBar(frame);

		// Board is passed the Model so it can act as Observer
		board = new Board1(400, 400, model);
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

		cp.add(buttons, BorderLayout.SOUTH);
		cp.add(board, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	

}
