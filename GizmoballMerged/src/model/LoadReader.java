package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
public class LoadReader {
	
	ArrayList<String> gizmos = new ArrayList<String>();
	public void readFile(){
		
		BufferedReader bufferRead = null;
		FileReader fileRead = null;
		
	
		try {
			
			fileRead = new FileReader("gizmos.txt");
			bufferRead = new BufferedReader(fileRead);
			String currentLine = bufferRead.readLine();
//			InputStream readIn = getClass().getResourceAsStream("/gizmos.txt"); 
//			BufferedReader reader = new BufferedReader(new InputStreamReader(readIn));
//			String currentLine = reader.readLine();
			
			while(currentLine != null)
			{
				gizmos.add(currentLine);
//				currentLine = reader.readLine();
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
		
	}
	
	public void print()
	{
		System.out.println(gizmos);
	}
	
	public ArrayList<String> getGizmos()
	{
		return gizmos;
	}
}