package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.Timer;
import model.Model;
import view.RunGui;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class RunListener2 implements ActionListener {

	private Timer timer;
	private Model model;
	private RunGui gui;

	public RunListener2(Model m) {
		model = m;
		timer = new Timer(50, this);
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {

		if (e.getSource() == timer) {
			model.start();
		} else
			switch (e.getActionCommand()) {
			case "Start":
				if(!model.getBalls().isEmpty()){
				timer.start();
				}
				System.out.println(timer);
				break;
			case "Stop":
				timer.stop();
				break;
			case "Tick":
				model.start();
				break;
			case "Quit":
				System.exit(0);
				break;
			case "Save":
				System.out.println("Save Button");
				model.save();
				break;
			case "Load":
				System.out.println("Load Button");
//				JFileChooser fileChooser = new JFileChooser();
//				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//				int result = fileChooser.showOpenDialog(null);
//				if (result == JFileChooser.APPROVE_OPTION) {
//				    File selectedFile = fileChooser.getSelectedFile();
//				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
//				}
				model.load();
				break;
			}
	}
}