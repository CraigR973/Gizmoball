package view;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JPanel;


public class RunButtons1 extends  JPanel{



     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RunButtons1() {
        // TODO Auto-generated constructor stub

        this.setLayout(new BorderLayout());

        this.add(new Button("Button1"));
        this.add(new Button("Button2"));

    }




}
