package view;

import java.awt.BorderLayout;
import java.awt.Button;
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
import controller.AddGizmoListener;
import controller.BuildListener;
import controller.GizmoBallListener;
import controller.MagicKeyListener;
import controller.RunListener1;
import model.Model1;
//import controller.RunListener;


public class BuildButtons1 extends JPanel {

	private Model1 model;
	private JFrame frame;
	private ActionListener listener;
	private Board1 board;
	//New stuff added
	private GizmoBallListener buildListener;
	private JPanel buildButtons;
	private JMenuBar buildBar;
	private GizmoBallGui view;
	private JTextArea messageBoard;
//	private JMenuBar menuBar;

	
	private static final long serialVersionUID = 1L;

	public BuildButtons1() {
	//	model = m;
	//	view = v;

		// RunListener catches all GUI events. In reality might have many listeners.
	//	 buildListener = new BuildListener(m);
	//}
	
//	public void createButtons() {
		
		
		this.setLayout(new BorderLayout());
		this.add(new Button("Absorber"));
		this.add(new Button("Ball"));
		
		
	/*	JButton absorberButton = new JButton("Add Absorber");
	
		MouseInputListener al =  new AddAbsorberListener(model, view, messageBoard);
		absorberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				messageBoard.setText("Click and drag to add absorber");
				buildListener.setMouseListener(al);
			}
		});
		
		JButton gizmoButton = new JButton("Add Gizmo");
		
		MouseInputListener gl =  new AddGizmoListener(model, view, messageBoard);
		gizmoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				messageBoard.setText("Click a box on the board you want to add a gizmo");
				buildListener.setMouseListener(gl);
			}
		});
		
JButton ballButton = new JButton("Add Ball");
		
		MouseInputListener bl =  new AddGizmoListener(model, view, messageBoard);
		ballButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				messageBoard.setText("Click a box on the board you want to add a gizmo");
				buildListener.setMouseListener(bl);
			}
		});
		
JButton rotateButton = new JButton("Rotate Gizmo");
		
		MouseInputListener rl =  new AddGizmoListener(model, view, messageBoard);
		rotateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				messageBoard.setText("Click a box on the board you want to add a gizmo");
				buildListener.setMouseListener(rl);
			}
		}); */
		
		
		
	
	}
	
/*	public JMenuBar createMenuBar(BuildListener buildListener) {
		
		final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
		
		JMenuBar buildBar = new JMenuBar();
		
		buildListener.setJMenuBar(buildBar);
		
		JMenu menu;
		JMenuItem item;
		
		menu = new JMenu("File");
		buildBar.add(menu);
		
		item = new JMenuItem("Save");
		
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,SHORTCUT_MASK));
		item.addActionListener(listener);
		menu.add(item);
		menu.addSeparator();
		
	item = new JMenuItem("Load");
		
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,SHORTCUT_MASK));
		item.addActionListener(listener);
		menu.add(item);
		menu.addSeparator();
		
	item = new JMenuItem("Quit");
		
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,SHORTCUT_MASK));
		item.addActionListener(listener);
		menu.add(item);
		menu.addSeparator();
		
		return buildBar; 
		
		
		
		
		
		
		
		
	}
	
	public void createMessageField() {
		
	} */

/*	public void createAndShowGUI() {

		frame = new JFrame("Gizmoball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenuBar(frame);

		// Board is passed the Model so it can act as Observer
		board = new Board1(400, 400, model);
		board.setBackground(Color.GRAY);

		Container cp = frame.getContentPane();

		Font gf = new Font("Rocket Script", Font.HANGING_BASELINE, 23);

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(2, 3));

		JButton button1 = new JButton("Add Gizmo");
		button1.setFont(gf);
		button1.addActionListener(listener);
		button1.setMaximumSize(new Dimension(25, 100));
		buttons.add(button1);

		JButton button2 = new JButton("Edit Gizmo");
		button2.setFont(gf);
		button2.addActionListener(listener);
		button2.setMaximumSize(new Dimension(25, 100));
		buttons.add(button2);

		JButton button4 = new JButton("Connections");
		button4.setFont(gf);
		button4.addActionListener(listener);
		button4.setMaximumSize(new Dimension(25, 100));
		buttons.add(button4);
		
		JButton button5 = new JButton("Edit Physics Values");
		button5.setFont(gf);
		button5.addActionListener(listener);
		button5.setMaximumSize(new Dimension(25, 100));
		buttons.add(button5);
		
		JButton button6 = new JButton("Add Ball");
		button6.setFont(gf);
		button6.addActionListener(listener);
		button6.setMaximumSize(new Dimension(25, 100));
		buttons.add(button6);
		
		

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
		
/*		JButton runModeButton = new JButton("Run Mode");
		runModeButton.addActionListener(listener);
		runModeButton.setFont(gf);
		buttons.add(runModeButton);

		cp.add(buttons, BorderLayout.SOUTH);
		cp.add(board, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	} */

}
