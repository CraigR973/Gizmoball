package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class saveFile {

	public void SaveFile(){
		
}
	public void save(ArrayList<TriangleGizmo> triangles1, ArrayList<SquareGizmo> squares1, ArrayList<CircleGizmo> circles1, ArrayList<LeftFlipper> leftFlippers1, ArrayList<RightFlipper> rightFlippers1, ArrayList<Absorber> absorbers1, ArrayList<Ball> balls1){

		System.out.println("Saving");
		BufferedWriter bufferWrite = null;
		FileWriter fileWrite = null;
		Model m1 = new Model();
		String value = JOptionPane.showInputDialog("Enter name of file");
	
		try {
			File filename = new File(value + ".txt");
			if(filename.createNewFile())
			{
				System.out.println("New file created");
			}
			fileWrite = new FileWriter(filename);
			bufferWrite = new BufferedWriter(fileWrite);
			ArrayList<TriangleGizmo> triangles = triangles1;
			ArrayList<SquareGizmo> squares = squares1;
			ArrayList<CircleGizmo> circles = circles1;
			ArrayList<LeftFlipper> leftFlippers = leftFlippers1;
			ArrayList<RightFlipper> rightFlippers = rightFlippers1;
			ArrayList<Absorber> absorbers = absorbers1;
			ArrayList<Ball> balls = balls1;
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
					if(triangles.get(i).getRotation() > 0)
					{
						int no = triangles.get(i).getNoRotations();
						for(int in = 0; in < no;in++)
						{
							bufferWrite.write("Rotate ");
							bufferWrite.write(name);
							bufferWrite.newLine();
						}
					}
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
				bufferWrite.newLine();
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
				bufferWrite.newLine();
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
					if(circles.get(i).isConnect == true)
					{
						ArrayList<String> connect = circles.get(i).getConnections();
						for(int index = 0; index <connect.size();index++)
						{
							String t = "Connect";
							String n = circles.get(i).getName();
							String c = connect.get(index);
							bufferWrite.write(t +" ");
							bufferWrite.write(n +" ");
							bufferWrite.write(c +" ");
							bufferWrite.newLine();
						}
					}
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
				bufferWrite.newLine();
				for (int i =0; i<leftFlippers.size();i++)
				{
					String type = "LeftFlipper";
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
					if(leftFlippers.get(i).isKeyConnect == true)
					{
						ArrayList<String> keyconnect = leftFlippers.get(i).getKeyConnections();
						for(int index = 0; index <keyconnect.size();index++)
						{
							String t = "KeyConnect";
							String n = leftFlippers.get(i).getName();
							String c = keyconnect.get(index);
							bufferWrite.write(t +" ");
							bufferWrite.write(c +" ");
							bufferWrite.write(n +" ");
							bufferWrite.newLine();
						}
					}
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
				bufferWrite.newLine();
				for (int i =0; i<rightFlippers.size();i++)
				{
					String type = "RightFlipper";
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
					if(rightFlippers.get(i).isKeyConnect == true)
					{
						ArrayList<String> keyconnect = rightFlippers.get(i).getKeyConnections();
						for(int index = 0; index <keyconnect.size();index++)
						{
							String t = "KeyConnect";
							String n = rightFlippers.get(i).getName();
							String c = keyconnect.get(index);
							bufferWrite.write(t +" ");
							bufferWrite.write(c +" ");
							bufferWrite.write(n +" ");
							bufferWrite.newLine();
						}
					}
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
				bufferWrite.newLine();
				for (int i =0; i<absorbers.size();i++)
				{
					System.out.println("adding absorber");
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
					//Connections
					if(absorbers.get(i).isConnect == true)
					{
						ArrayList<String> connect = absorbers.get(i).getConnections();
						for(int index = 0; index <connect.size();index++)
						{
							String t = "Connect";
							String n = absorbers.get(i).getName();
							String c = connect.get(index);
							bufferWrite.write(t +" ");
							bufferWrite.write(n +" ");
							bufferWrite.write(c +" ");
							bufferWrite.newLine();
						}
					}
					//Key Connections
					if(absorbers.get(i).isKeyConnect == true)
					{
						ArrayList<String> keyconnect = absorbers.get(i).getKeyConnections();
						for(int index = 0; index <absorbers.size();index++)
						{
							String t = "KeyConnect";
							String n = absorbers.get(i).getName();
							String c = keyconnect.get(index);
							bufferWrite.write(t +" ");
							bufferWrite.write(c +" ");
							bufferWrite.write(n +" ");
							bufferWrite.newLine();
						}
					}
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
				bufferWrite.newLine();
				for (int i =0; i<balls.size();i++)
				{
					System.out.println("adding ball");
					String type = "Ball";
					String name = balls.get(i).getName();
					int x1 = (int) (balls.get(i).getExactX()/20);
					int y1 = (int) (balls.get(i).getExactY()/20);
					int vx1 = (int) (balls.get(i).getVelo().x());
					int vy1 = (int) (balls.get(i).getVelo().y());
					String x = Integer.toString(x1);
					String y = Integer.toString(y1);
					String vx = Integer.toString(vx1);
					String vy = Integer.toString(vy1);
					bufferWrite.write(type +" ");
					bufferWrite.write(name +" ");
					bufferWrite.write(x +" ");
					bufferWrite.write(y +" ");
					bufferWrite.write(vx +" ");
					bufferWrite.write(vy +" ");
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
