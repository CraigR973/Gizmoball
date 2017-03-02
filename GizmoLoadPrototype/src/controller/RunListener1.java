package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import model.Model1;
import model.saveFile;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class RunListener1 implements ActionListener {

	private Timer timer;
	private Model1 model;

	public RunListener1(Model1 m) {
		model = m;
		timer = new Timer(50, this);
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {

//		if (e.getSource() == timer) {
//			model.moveBall();
//		} else
			switch (e.getActionCommand()) {
//			case "Start":
//				timer.start();
//				break;
//			case "Stop":
//				timer.stop();
//				break;
//			case "Tick":
//				model.moveBall();
//				break;
//			case "Quit":
//				System.exit(0);
//				break;
			case "Save":
				model.save();
				System.out.println("Save Button");
				break;
			case "Load":
				model.load();
				System.out.println("Load Button");
				break;
			}
			
	}
}
