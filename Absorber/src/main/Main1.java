package main;

import javax.swing.UIManager;

import model.Model1;
//import model.VerticalLine1;
import view.RunGui1;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Main1 {

	public static void main(String[] args) {
		try {
			// Use the platform look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Look and Feel error in Main");
		}

		Model1 model = new Model1();

		model.setBallSpeed(200, 200);

		// Vertical line at (100,100), width 300
//		model.addLine(new VerticalLine(100, 100, 300));
//		model.addLine(new VerticalLine(100, 200, 300));
//		model.addLine(new VerticalLine(100, 300, 300));
//		model.addLine(new VerticalLine(100, 400, 300));
		
		

		RunGui1 gui = new RunGui1(model);
		gui.createAndShowGUI();
	}
}
