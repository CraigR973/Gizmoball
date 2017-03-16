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

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
public class LoadReader {
	
	ArrayList<String> gizmos = new ArrayList<String>();
	public void readFile(){
		
		BufferedReader bufferRead = null;
		FileReader fileRead = null;
		
	
		try {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt files only", "txt");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
						fileRead = new FileReader(chooser.getSelectedFile().getName());
			    }
			
			 
			//fileRead = new FileReader(file);
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