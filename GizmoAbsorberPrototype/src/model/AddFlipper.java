package model;

public class AddFlipper {

	String currentGizmo;
	static double x;
	static double y;
	private Model1 model;
	
	public void add(String gizmo, double x1, double y1)
	{
		String currentGizmo = gizmo;
		x = x1;
		y = y1;
		if(currentGizmo.equals("LeftFlipper"))
		{
			String name = "LF"+x+y;
			model.addLeftFlipper(name, x, y);
		}
		else if(currentGizmo.equals("RightFlipper"))
		{
			String name = "RF"+x+y;
			model.addRightFlipper(name, x, y);
		}
	}
}
