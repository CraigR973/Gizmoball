package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import model.Model1;
import view.Gui;


/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class RunListener2 implements ActionListener {

	private Timer timer;
	private Model1 model;
	private Gui gui;
	private boolean buildMode;

	public RunListener2(Model1 m) {
		model = m;
		timer = new Timer(50, this);
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {

		if (e.getSource() == timer) {
			model.moveBall();
		} else
			switch (e.getActionCommand()) {
			case "Start":
				timer.start();
				break;
			case "Stop":
				timer.stop();
				break;
			case "Tick":
				model.moveBall();
				break;
			case "Quit":
				System.exit(0);
				break;
			case "Save":
				System.out.println("Save Button");
				break;
			case "Load":
				System.out.println("Load Button");
				break;
			case "Build Mode":
				buildMode = true;
			    break;
				
			}
	}
}
