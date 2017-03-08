package model;

import java.util.ArrayList;

public class deleteGizmo {
	
	static Model1 model = new Model1();
	static ArrayList<Circle1> circles = new ArrayList<Circle1>();
	static ArrayList<Triangle> triangles = new ArrayList<Triangle>();
	static ArrayList<Square> squares = new ArrayList<Square>();
	
	public static void delete(String gizmo, String name)
	{
		String currentGizmo = gizmo;
		String gizmoName = name;
		int gizmoIndex = 0;
		if(currentGizmo.equals("Triangle"))
		{
			triangles.addAll(model.getTriangle());
			for(int i = 0; i < triangles.size(); i++)
			{
				if(triangles.get(i).getName().equals(gizmoName))
				{
					gizmoIndex = i;
				}
			}
			model.deleteTriangle(gizmoIndex);
		}
		else if(currentGizmo.equalsIgnoreCase("Square"))
		{
			squares.addAll(model.getSquare());
			for(int i = 0; i < squares.size(); i++)
			{
				if(squares.get(i).getName().equals(gizmoName))
				{
					gizmoIndex = i;
				}
			}
			model.deleteSquare(gizmoIndex);
		}
		else if(currentGizmo.equalsIgnoreCase("Circle"))
		{
			circles.addAll(model.getCircle());
			for(int i = 0; i < circles.size(); i++)
			{
				if(circles.get(i).getName().equals(gizmoName))
				{
					gizmoIndex = i;
				}
			}
			model.deleteCircle(gizmoIndex);
		}
	}

}
