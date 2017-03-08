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
	public void save(ArrayList<Triangle> triangles1, ArrayList<Square> squares1, ArrayList<Circle1> circles1, ArrayList<LeftFlipper> leftFlippers1, ArrayList<RightFlipper> rightFlippers1, ArrayList<Absorber> absorbers1, ArrayList<Ball1> balls1){

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
			System.out.println("Before loop");
			ArrayList<Triangle> triangles = triangles1;
			ArrayList<Square> squares = squares1;
			ArrayList<Circle1> circles = circles1;
			ArrayList<LeftFlipper> leftFlippers = leftFlippers1;
			ArrayList<RightFlipper> rightFlippers = rightFlippers1;
			ArrayList<Absorber> absorbers = absorbers1;
			ArrayList<Ball1> balls = m1.getBall();
				for (int i =0; i<triangles.size();i++)
				{
					String type = "Triangle";
					String name = triangles.get(i).getName();
					int x1 = (int) (triangles.get(i).getXpos1()/20);
					int y1 = (int) (triangles.get(i).getYpos1()/20);
					String x = Integer.toString(x1);
					String y = Integer.toString(y1);
					bufferWrite.write(type +" ");
					bufferWrite.write(name +" ");
					bufferWrite.write(x +" ");
					bufferWrite.write(y +" ");
					bufferWrite.newLine();
//					for(int i1 = 0; i1<= triangles.get(i).getConnectons().size(); i1++)
//					{
//						String s = "Connect";
//						String connect = Integer.toString(triangles.get(i).getConnectons().get(i1));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
//					for(int i2 = 0; i<= triangles.get(i).getKeyConnectons().size(); i2++)
//					{
//						String s = "Key Connect";
//						String connect = Integer.toString(triangles.get(i).getKeyConnectons().get(i2));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
				}
				for (int i =0; i<squares.size();i++)
				{
					String type = "Square";
					String name = squares.get(i).getName();
					int x1 = (int) (squares.get(i).getXPos()/20);
					int y1 = (int) (squares.get(i).getYPos()/20);
					String x = Integer.toString(x1);
					String y = Integer.toString(y1);
					bufferWrite.write(type +" ");
					bufferWrite.write(name +" ");
					bufferWrite.write(x +" ");
					bufferWrite.write(y +" ");
					bufferWrite.newLine();
//					for(int i1 = 0; i<= squares.get(i).getConnectons().size(); i1++)
//					{
//						String s = "Connect";
//						String connect = Integer.toString(squares.get(i).getConnectons().get(i1));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
//					for(int i2 = 0; i<= squares.get(i).getKeyConnectons().size(); i2++)
//					{
//						String s = "Key Connect";
//						String connect = Integer.toString(squares.get(i).getKeyConnectons().get(i2));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
				}
				for (int i =0; i<circles.size();i++)
				{
					String type = "Circle";
					String name = circles.get(i).getName();
					int x1 = (int) (circles.get(i).getExactX()/20);
					int y1 = (int) (circles.get(i).getExactY()/20);
					String x = Integer.toString(x1);
					String y = Integer.toString(y1);
					bufferWrite.write(type +" ");
					bufferWrite.write(name +" ");
					bufferWrite.write(x +" ");
					bufferWrite.write(y +" ");
					bufferWrite.newLine();
//					for(int i1 = 0; i<= circles.get(i).getConnectons().size(); i1++)
//					{
//						String s = "Connect";
//						String connect = Integer.toString(circles.get(i).getConnectons().get(i1));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
//					for(int i2 = 0; i<= circles.get(i).getKeyConnectons().size(); i2++)
//					{
//						String s = "Key Connect";
//						String connect = Integer.toString(circles.get(i).getKeyConnectons().get(i2));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
				}
				for (int i =0; i<leftFlippers.size();i++)
				{
					String type = "Left Flipper";
					String name = leftFlippers.get(i).getName();
					int x1 = (int) (leftFlippers.get(i).getXPos()/20);
					int y1 = (int) (leftFlippers.get(i).getYPos()/20);
					String x = Integer.toString(x1);
					String y = Integer.toString(y1);
					bufferWrite.write(type +" ");
					bufferWrite.write(name +" ");
					bufferWrite.write(x +" ");
					bufferWrite.write(y +" ");
					bufferWrite.newLine();
//					for(int i1 = 0; i<= leftFlippers.get(i).getConnectons().size(); i1++)
//					{
//						String s = "Connect";
//						String connect = Integer.toString(leftFlippers.get(i).getConnectons().get(i1));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
//					for(int i2 = 0; i<= leftFlippers.get(i).getKeyConnectons().size(); i2++)
//					{
//						String s = "Key Connect";
//						String connect = Integer.toString(leftFlippers.get(i).getKeyConnectons().get(i2));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
				}
				for (int i =0; i<rightFlippers.size();i++)
				{
					String type = "Right Flipper";
					String name = rightFlippers.get(i).getName();
					int x1 = (int) (rightFlippers.get(i).getXPos()/20);
					int y1 = (int) (rightFlippers.get(i).getYPos()/20);
					String x = Integer.toString(x1);
					String y = Integer.toString(y1);
					bufferWrite.write(type +" ");
					bufferWrite.write(name +" ");
					bufferWrite.write(x +" ");
					bufferWrite.write(y +" ");
					bufferWrite.newLine();
//					for(int i1 = 0; i<= rightFlippers.get(i).getConnectons().size(); i1++)
//					{
//						String s = "Connect";
//						String connect = Integer.toString(rightFlippers.get(i).getConnectons().get(i1));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
//					for(int i2 = 0; i<= rightFlippers.get(i).getKeyConnectons().size(); i2++)
//					{
//						String s = "Key Connect";
//						String connect = Integer.toString(rightFlippers.get(i).getKeyConnectons().get(i2));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
				}
				for (int i =0; i<absorbers.size();i++)
				{
					String type = "Absorber";
					String name = absorbers.get(i).getName();
					int x1 = (int) (absorbers.get(i).getXPos()/20);
					int y1 = (int) (absorbers.get(i).getYPos()/20);
					String x = Integer.toString(x1);
					String y = Integer.toString(y1);
					bufferWrite.write(type +" ");
					bufferWrite.write(name +" ");
					bufferWrite.write(x +" ");
					bufferWrite.write(y +" ");
					bufferWrite.newLine();
//					for(int i1 = 0; i<= absorbers.get(i).getConnectons().size(); i1++)
//					{
//						String s = "Connect";
//						String connect = Integer.toString(absorbers.get(i).getConnectons().get(i1));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
//					for(int i2 = 0; i<= absorbers.get(i).getKeyConnectons().size(); i2++)
//					{
//						String s = "Key Connect";
//						String connect = Integer.toString(absorbers.get(i).getKeyConnectons().get(i2));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
				}
				for (int i =0; i<balls.size();i++)
				{
					String type = "Ball";
					String name = balls.get(i).getName();
					int x1 = (int) (balls.get(i).getExactX()/20);
					int y1 = (int) (balls.get(i).getExactY()/20);
					String x = Integer.toString(x1);
					String y = Integer.toString(y1);
					bufferWrite.write(type +" ");
					bufferWrite.write(name +" ");
					bufferWrite.write(x +" ");
					bufferWrite.write(y +" ");
					bufferWrite.newLine();
//					for(int i1 = 0; i<= balls.get(i).getConnectons().size(); i1++)
//					{
//						String s = "Connect";
//						String connect = Integer.toString(balls.get(i).getConnectons().get(i1));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
//					for(int i2 = 0; i<= balls.get(i).getKeyConnectons().size(); i2++)
//					{
//						String s = "Key Connect";
//						String connect = Integer.toString(balls.get(i).getKeyConnectons().get(i2));
//						bufferWrite.write(s);
//						bufferWrite.write(name);
//						bufferWrite.write(connect);
//					}
				}
				bufferWrite.close();
			}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
