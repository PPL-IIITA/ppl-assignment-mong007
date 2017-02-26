/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgen;

/**
 *
 * @author vishal
 */
import java.io.*;
import java.util.*;
public class testgen {
	    public void generate(){
		try{
			FileWriter file1 = new FileWriter("/home/vishal/Desktop/boy.txt");
			FileWriter file2 = new FileWriter("/home/vishal/Desktop/girl.txt");
			Random b = new Random();
			Random g = new Random();
			int j;
		for(j=0;j<10;j++){
				file1.write("B"+j+" "+b.nextInt(100)+" "+b.nextInt(100)+" "+b.nextInt(100)+" "+b.nextInt(10000)+"\n");
			}
			for(j=0;j<10;j++){
				file2.write("G"+j+" "+g.nextInt(100)+" "+g.nextInt(1000)+" "+g.nextInt(100)+"\n");
			}
			file1.close();
			file2.close();
		}catch(IOException e){		
			System.out.println( e.getMessage() );
		}
	
		
	}
	    
}
