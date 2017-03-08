package model;

import javax.swing.text.Utilities;

public class addGizmo {

	String currentGizmo;
	static double x;
	static double y;
	private static Model1 model;
	
	public addGizmo()
	{
		
		
	}
	
	public static void add(String gizmo, double x1, double y1)
	{
		String currentGizmo = gizmo;
		x = x1;
		y = y1;
		if(currentGizmo.equals("Triangle"))
		{
			String name = "T"+x+y;
			model.addTriangle(name, x, y);
		}
		else if(currentGizmo.equals("Square"))
		{
			String name = "S"+x+y;
			model.addSquare(name, x, y);
		}
		else if(currentGizmo.equals("Circle"))
		{
			String name = "C"+x+y;
			model.addCircle(name, x, y);
		}
	}
}
