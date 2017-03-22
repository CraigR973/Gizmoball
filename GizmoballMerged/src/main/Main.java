package main;

import javax.swing.UIManager;

import model.Model;
import view.Gui;





public class Main {

	public static void main(String[] args) {
		try {
			// Use the platform look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Look and Feel error in Main");
		}

		Model model = new Model();

		model.setBallSpeed(200, 200);


		

		Gui gui = new Gui(model);
		gui.createAndShowGUI();
	}
}
