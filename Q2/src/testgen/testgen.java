/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgen;

/**
 *
 * @author vishal kumar singh iit2015141
 * This Class generates random inputs.
 */
import java.io.*;
import java.util.*;
public class testgen {
	    public void generate(){
		try{
                        String[] type_b = {"miser", "generous", "geeks"};
                        String[] type_g = {"choosy", "normal", "desperate"};
                        String[] type_gi = {"essential", "luxury", "utility"};
			FileWriter file1 = new FileWriter("/home/vishal/Desktop/boy.txt");
			FileWriter file2 = new FileWriter("/home/vishal/Desktop/girl.txt");
                        FileWriter file3 = new FileWriter("/home/vishal/Desktop/gift.txt");
			Random b = new Random();
			Random g = new Random();
                        Random gi = new Random();
			int j;
		for(j=0;j<10;j++){
				file1.write("B"+j+" "+b.nextInt(100)+" "+b.nextInt(100)+" "+b.nextInt(100)+" "+b.nextInt(10000)+" "+type_b[b.nextInt(type_b.length)]+"\n");
			}
			for(j=0;j<10;j++){
				file2.write("G"+j+" "+g.nextInt(100)+" "+g.nextInt(1000)+" "+g.nextInt(100)+" "+type_g[g.nextInt(type_g.length)]+"\n");
			}
                        for(j=0;j<100;j++){
				file3.write(type_gi[gi.nextInt(type_gi.length)]+" "+gi.nextInt(100)+"\n");
			}
			file1.close();
			file2.close();
                        file3.close();
		}catch(IOException e){		
			System.out.println( e.getMessage() );
		}
	
		
	}
	    
}
