package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class saveFile {

	public void SaveFile(){
		
}
	public void save(){

		BufferedWriter bufferWrite = null;
		FileWriter fileWrite = null;
		Model1 m1 = new Model1();
	
		try {
			File filename = new File("gizmoball.txt");
			if(filename.createNewFile())
			{
				System.out.println("New file created");
			}
			fileWrite = new FileWriter(filename);
			bufferWrite = new BufferedWriter(fileWrite);
				for (Triangle t : m1.getTriangle())
				{
					String type = "Triangle";
					String name = t.getName();
					String x = Double.toString((t.getXpos1())/20);
					String y = Double.toString((t.getYpos1())/20);
					bufferWrite.write(type);
					bufferWrite.write(name);
					bufferWrite.write(x);
					bufferWrite.write(y);
					bufferWrite.newLine();
					for(int i = 0; i<= t.getConnectons().size(); i++)
					{
						String s = "Connect";
						String connect = Integer.toString(t.getConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
					for(int i = 0; i<= t.getKeyConnectons().size(); i++)
					{
						String s = "Key Connect";
						String connect = Integer.toString(t.getKeyConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
				}
				for (Square sq : m1.getSquare())
				{
					String type = "Square";
					String name = sq.getName();
					String x = Double.toString((sq.getXPos())/20);
					String y = Double.toString((sq.getYPos())/20);
					bufferWrite.write(type);
					bufferWrite.write(name);
					bufferWrite.write(x);
					bufferWrite.write(y);
					bufferWrite.newLine();
					for(int i = 0; i<= sq.getConnectons().size(); i++)
					{
						String s = "Connect";
						String connect = Integer.toString(sq.getConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
					for(int i = 0; i<= sq.getKeyConnectons().size(); i++)
					{
						String s = "Key Connect";
						String connect = Integer.toString(sq.getKeyConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
				}
				for (Circle1 c : m1.getCircle())
				{
					String type = "Circle";
					String name = c.getName();
					String x = Double.toString((c.getExactX())/20);
					String y = Double.toString((c.getExactY())/20);
					bufferWrite.write(type);
					bufferWrite.write(name);
					bufferWrite.write(x);
					bufferWrite.write(y);
					bufferWrite.newLine();
					for(int i = 0; i<= c.getConnectons().size(); i++)
					{
						String s = "Connect";
						String connect = Integer.toString(c.getConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
					for(int i = 0; i<= c.getKeyConnectons().size(); i++)
					{
						String s = "Key Connect";
						String connect = Integer.toString(c.getKeyConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
				}
				for (LeftFlipper lf : m1.getLFlipper())
				{
					String type = "Left Flipper";
					String name = lf.getName();
					String x = Double.toString((lf.getXPos())/20);
					String y = Double.toString((lf.getYPos())/20);
					bufferWrite.write(type);
					bufferWrite.write(name);
					bufferWrite.write(x);
					bufferWrite.write(y);
					bufferWrite.newLine();
					for(int i = 0; i<= lf.getConnectons().size(); i++)
					{
						String s = "Connect";
						String connect = Integer.toString(lf.getConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
					for(int i = 0; i<= lf.getKeyConnectons().size(); i++)
					{
						String s = "Key Connect";
						String connect = Integer.toString(lf.getKeyConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
				}
				for (RightFlipper rf : m1.getRFlipper())
				{
					String type = "Right Flipper";
					String name = rf.getName();
					String x = Double.toString((rf.getXPos())/20);
					String y = Double.toString((rf.getYPos())/20);
					bufferWrite.write(type);
					bufferWrite.write(name);
					bufferWrite.write(x);
					bufferWrite.write(y);
					bufferWrite.newLine();
					for(int i = 0; i<= rf.getConnectons().size(); i++)
					{
						String s = "Connect";
						String connect = Integer.toString(rf.getConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
					for(int i = 0; i<= rf.getKeyConnectons().size(); i++)
					{
						String s = "Key Connect";
						String connect = Integer.toString(rf.getKeyConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
				}
				for (Absorber a : m1.getAbsorber())
				{
					String type = "Absorber";
					String name = a.getName();
					String x = Double.toString((a.getXPos())/20);
					String y = Double.toString((a.getYPos())/20);
					bufferWrite.write(type);
					bufferWrite.write(name);
					bufferWrite.write(x);
					bufferWrite.write(y);
					bufferWrite.newLine();
					for(int i = 0; i<= a.getConnectons().size(); i++)
					{
						String s = "Connect";
						String connect = Integer.toString(a.getConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
					for(int i = 0; i<= a.getKeyConnectons().size(); i++)
					{
						String s = "Key Connect";
						String connect = Integer.toString(a.getKeyConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
				}
				for (Ball1 b : m1.getBall())
				{
					String type = "Ball";
					String name = b.getName();
					String x = Double.toString((b.getExactX())/20);
					String y = Double.toString((b.getExactY())/20);
					bufferWrite.write(type);
					bufferWrite.write(name);
					bufferWrite.write(x);
					bufferWrite.write(y);
					bufferWrite.newLine();
					for(int i = 0; i<= b.getConnectons().size(); i++)
					{
						String s = "Connect";
						String connect = Integer.toString(b.getConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
					for(int i = 0; i<= b.getKeyConnectons().size(); i++)
					{
						String s = "Key Connect";
						String connect = Integer.toString(b.getKeyConnectons().get(i));
						bufferWrite.write(s);
						bufferWrite.write(name);
						bufferWrite.write(connect);
					}
				}
			}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
