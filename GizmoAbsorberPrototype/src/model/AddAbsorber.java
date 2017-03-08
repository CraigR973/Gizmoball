package model;

public class AddAbsorber {

	static double x;
	static double y;
	private Model1 model;
	
	public void add(double x1, double y1)
	{
		x = x1;
		y = y1;
		String name = "A"+x+y;
		model.addAbsorber(name, x, y);
	}
}
