package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.BuildListener;
import controller.BuildListener2;
import controller.RunListener1;
import controller.RunListener2;
import model.Model1;
//import controller.RunListener;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Gui {

	private Model1 model;
	private JFrame frame;
	private ActionListener listener;
	private BuildListener2 buildListener;
	private Board1 board;
    private JPanel buttons;
    final static String CHANGEBUTTON = "Switch Game";
	private JPanel runButtons;
	private JPanel buildButtons;
	public boolean changeMode;

	public Gui(Model1 m) {
		model = m;
		this.changeMode = false;
		this.buttons = null;

		// RunListener catches all GUI events. In reality might have many
		// listeners.
		listener = new RunListener2(m);
	//	buildListener = new BuildListener2(m);
		
	}
	
	/*public void addComponentToPane(Container pane) {
		
		JButton buttonChanger = new JButton();
		String buttonItems[] = {CHANGEBUTTON};
		
	} */
	
	
	


	public void createAndShowGUI() {

		frame = new JFrame("Absorber Prototype <3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Board is passed the Model so it can act as Observer
		board = new Board1(500, 500, model);
		board.setBackground(Color.GRAY);

		Container cp = frame.getContentPane();

		Font gf = new Font("Papyrus", Font.HANGING_BASELINE, 23);
		
	//	JPanel buttons = new JPanel();
		
		
		
	/*	JPanel runButtons = new JPanel();
		
		JButton button1 = new JButton("Start");
		button1.setFont(gf);
		button1.addActionListener(listener);
		button1.setMaximumSize(new Dimension(100, 100));
		runButtons.add(button1);

		JButton button2 = new JButton("Stop");
		button2.setFont(gf);
		button2.addActionListener(listener);
		button2.setMaximumSize(new Dimension(100, 100));
		runButtons.add(button2);
		
		JPanel buildButtons = new JPanel();
		
		JButton button3 = new JButton("Absorber");
		button3.setFont(gf);
		button3.addActionListener(listener);
		button3.setMaximumSize(new Dimension(100, 100));
		buildButtons.add(button3);

		JButton button4 = new JButton("Ball");
		button4.setFont(gf);
		button4.addActionListener(listener);
		button4.setMaximumSize(new Dimension(100, 100));
		buildButtons.add(button4);  */
		
		JPanel runButtons = new JPanel();
		
		JButton switchScreen = new JButton("Change Mode");

		runButtons.add(switchScreen);
		
//		runButtons.add(new JButton("Start"));
//		runButtons.add(new JButton("Stop"));
		
		JPanel buildButtons = new JPanel();
		
//		buildButtons.add(new JButton("Ball"));
//		buildButtons.add(new JButton("Absorber"));
		
		
		cp.setLayout(new GridLayout(2,2));
		cp.add(runButtons);
		cp.add(buildButtons);
	//	cp.add(board, BorderLayout.CENTER);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 
		
		
		
		
		

	//	runButtons = new JPanel();

		

	//	buildButtons = new JPanel();
		
	//	buildButtons.add(switchScreen);

	//	JPanel buttons = new JPanel();
	//	cp.setLayout(new GridLayout(4,4));
	//	cp.add(runButtons);
	//	cp.add(buildButtons);

	//	cp.add(buttons, BorderLayout.LINE_START);
	//	cp.add(board, BorderLayout.CENTER);

		
		switchScreen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(changeMode == false) {
					buttons =  new RunButtons1();
					changeMode = true;
					
					if(buildButtons.getComponentCount() != 0) {
						buildButtons.removeAll();
					}
					
		
				} else {
					
					changeMode = false;
					buttons =  new BuildButtons1();
					
					if(buildButtons.getComponentCount() != 0) {
						buildButtons.removeAll();
					}
				}
				
				buildButtons.add(buttons);
				buildButtons.repaint();
				buildButtons.revalidate();
			}
		});
	}
}
	

	

	/*	if (changeMode == false) {
			runMode();
		}
	} */

/*	public void runButtons() {

		// JPanel buttons = new JPanel();
		// runButtons.setLayout(new GridLayout(4, 1));

		// Container cp = frame.getContentPane();

		Font gf = new Font("Papyrus", Font.HANGING_BASELINE, 23);

		JButton button1 = new JButton("Start");
		button1.setFont(gf);
		button1.addActionListener(listener);
		button1.setMaximumSize(new Dimension(100, 100));
		runButtons.add(button1);

		JButton button2 = new JButton("Stop");
		button2.setFont(gf);
		button2.addActionListener(listener);
		button2.setMaximumSize(new Dimension(100, 100));
		runButtons.add(button2);

		JButton button4 = new JButton("Tick");
		button4.setFont(gf);
		button4.addActionListener(listener);
		button4.setMaximumSize(new Dimension(100, 100));
		runButtons.add(button4);

		JButton button3 = new JButton("Quit");
		button3.setFont(gf);
		button3.addActionListener(listener);
		button3.setMaximumSize(new Dimension(100, 100));
		runButtons.add(button3);

		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(listener);
		saveButton.setFont(gf);
		saveButton.setBackground(Color.decode("#D4FAFF"));
		runButtons.add(saveButton);

		JButton loadButton = new JButton("Load");
		loadButton.addActionListener(listener);
		loadButton.setFont(gf);
		runButtons.add(loadButton);

		JButton buildButton = new JButton("Build Mode");
		buildButton.addActionListener(listener);
		buildButton.setFont(gf);
		runButtons.add(buildButton);

		buttons = runButtons;

	}

	public void buildButtons() {

		// JPanel buildButtons = new JPanel();
		buildButtons.setLayout(new GridLayout(4, 1));

		Container cp = frame.getContentPane();

		Font gf = new Font("Papyrus", Font.HANGING_BASELINE, 23);

		JButton addButton = new JButton("Add Gizmo");
		addButton.addActionListener(buildListener);
		addButton.setFont(gf);
		buildButtons.add(addButton);

		buttons = buildButtons;

	} 

} */
