package model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.StringTokenizer;

public class LoadFile{
	
	public LoadFile()
	{
		
	}
	
	ArrayList<String> gizmos = new ArrayList<String>();
	ArrayList<Circle1> circles = new ArrayList<Circle1>();
	ArrayList<Triangle> triangles = new ArrayList<Triangle>();
	ArrayList<Square> squares = new ArrayList<Square>();
	ArrayList<LeftFlipper> leftFlippers = new ArrayList<LeftFlipper>();
	ArrayList<RightFlipper> rightFlippers = new ArrayList<RightFlipper>();
	ArrayList<Absorber> absorbers = new ArrayList<Absorber>();
	ArrayList<Ball1> balls = new ArrayList<Ball1>();
	
	public void readFile(){
		
		Model1 m = new Model1();
		BufferedReader bufferRead = null;
		FileReader fileRead = null;
		
	
		try {
		
			fileRead = new FileReader("gizmos.txt");
			bufferRead = new BufferedReader(fileRead);
			String currentLine = bufferRead.readLine();
		
			while(currentLine != null)
			{
				gizmos.add(currentLine);
				currentLine = bufferRead.readLine();
			}	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		for(int i = 0; i<gizmos.size(); i++)
		{
			StringTokenizer st = new StringTokenizer(gizmos.get(i));
			if(st.hasMoreTokens())
			{
				String cGizmo = st.nextToken();
				String name = st.nextToken();
				String value1 = st.nextToken();
				String value2 = st.nextToken();
						
				if(cGizmo.equals("Triangle"))
				{
					double value1d = Double.parseDouble(value1);
					double value2d = Double.parseDouble(value2);
					m.addTriangle(name, value1d, value2d);
				}
				else if(cGizmo.equals("Square"))
				{
					double value1d = Double.parseDouble(value1);
					double value2d = Double.parseDouble(value2);
					m.addSquare(name, value1d, value2d);
				}
				else if(cGizmo.equals("Circle"))
				{
					double value1d = Double.parseDouble(value1);
					double value2d = Double.parseDouble(value2);
					m.addCircle(name, value1d, value2d);
				}
				else if(cGizmo.equals("LeftFlipper"))
				{
					double value1d = Double.parseDouble(value1);
					double value2d = Double.parseDouble(value2);
					m.addLeftFlipper(name, value1d, value2d);
				}
				else if(cGizmo.equals("RightFlipper"))
				{
					double value1d = Double.parseDouble(value1);
					double value2d = Double.parseDouble(value2);
					m.addRightFlipper(name, value1d, value2d);
				}
				else if(cGizmo.equals("Absorber"))
				{
					double value1d = Double.parseDouble(value1);
					double value2d = Double.parseDouble(value2);
					m.addAbsorber(name, value1d, value2d);
				}
				else if(cGizmo.equals("Ball"))
				{
					double value1d = Double.parseDouble(value1);
					double value2d = Double.parseDouble(value2);
					double value3 = Double.parseDouble(st.nextToken());
					double value4 = Double.parseDouble(st.nextToken());
					m.addBall(name, value1d, value2d, value3, value4);
				}
				else if(cGizmo.equals("Connect"))
				{
					
				}
				else if(cGizmo.equals("Key Connect"))
				{
					
				}
				else if(cGizmo.equals("Rotate"))
				{
					
				}

			}
		}
		triangles = m.getTriangle();
		squares = m.getSquare();
		circles = m.getCircle();
		leftFlippers = m.getLFlipper();
		rightFlippers = m.getRFlipper();
		absorbers = m.getAbsorber();
		balls = m.getBall();
	}
	
	public void print()
	{
		System.out.println(gizmos);
	}

	public ArrayList<Triangle> getTriangle()
	{
		return triangles;
	}
	
	public ArrayList<Square> getSquare() {
		return squares;
	}

	public ArrayList<Circle1> getCircle() {
		return circles;
	}


	public ArrayList<Absorber> getAbsorber() {
		return absorbers;
	}

	public ArrayList<LeftFlipper> getLFlipper() {
		return leftFlippers;
	}

	public ArrayList<RightFlipper> getRFlipper() {
		return rightFlippers;
	}

	public ArrayList<Ball1> getBall() {
		return balls;
	}
}
