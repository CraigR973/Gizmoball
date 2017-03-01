package view;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import controller.BuildListener;
import controller.RunListener1;
import model.Model1;

public class GizmoBallView {
	
	private GizmoBallGui runModeGui;
	private GizmoBallGui buildModeGui;
	JPanel buildButtons;
	JPanel runButtons;
	JPanel buttons;
	JMenuBar buildBar;
	JMenuBar runBar;
	JMenuBar bar;
	Model1 model;
	private BuildGui1 buildMode;
	private BuildListener buildListener;
	private RunGui1 runMode;
	private RunListener1 runListener;
	
	public void createBuildGui() {
		buildMode = new BuildGui1(model);
		buildListener = new BuildListener(model, this);
		buildButtons = buildMode.createButtons(buildListener);
		buildBar = buildMode.createMenuBar(buildListener);
	}
	
	public void createRunGui() {
		runMode = new RunGui1(model);
		runListener = new RunListener1(model, this);
		runButtons = runMode.createButtons(runListener);
		runBar = runMode.createMenuBar(runListener);
	}
	
	public void buildMode(){
		buttons = buildButtons;
		bar = buildBar;
	}
	
	public void runMode(){
		buttons = runButtons;
		bar = runBar;
	}
	
	
	

}
