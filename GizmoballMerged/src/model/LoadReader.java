package model;
import java.awt.Component;
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

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
public class LoadReader {
	
	ArrayList<String> gizmos = new ArrayList<String>();
	public void readFile(){
		
		BufferedReader bufferRead = null;
		FileReader fileRead = null;
		String value = JOptionPane.showInputDialog("Enter name of file you want to load");
		String filename = value + ".txt";
	
		try {
			fileRead = new FileReader(filename);
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
			JOptionPane.showMessageDialog( null, "File not found");
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