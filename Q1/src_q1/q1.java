/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author vishal
 */
import java.util.*;
import java.lang.*;
import java.io.*;
import girl.*;
import boy.*;
import testgen.*;
public class q1
{
	public static void main(String[] args) {
	int n = 10; //no. of test cases in input files
	int i=1,j,k;
	testgen t = new testgen();
	t.generate();
        boy[] b  = new boy[100];
        girl[] g = new girl[100];
        for(i=0;i<10;i++){
	b[i] = new boy();
	g[i] = new girl();}
	String file_name1 = "/home/vishal/Desktop/boy.txt";
	String file_name2 = "/home/vishal/Desktop/girl.txt";
	String seperator = " ";
        String newline;
        BufferedReader temp = null;i=0;
	try {   //for allcation of boys data from input file
		temp = new BufferedReader(new FileReader(file_name1));
			while((newline = temp.readLine() )!= null){
				String[] boys_entry = newline.split(seperator);
			//	System.out.println(boy[0] + boy[1] + boy[2] + boy [3]);
				String temp1_name = boys_entry[0];
				int temp1_intel = Integer.parseInt(boys_entry[1]);
				int temp1_attract = Integer.parseInt(boys_entry[2]);
				int temp1_attr_req = Integer.parseInt(boys_entry[3]);
				int temp1_budget = Integer.parseInt(boys_entry[4]);
                                b[i].name = temp1_name;
                                b[i].budget = temp1_budget;
                                b[i].att_req = temp1_attr_req;
                                b[i].intel = temp1_intel;
                                b[i].attract = temp1_attract;
				i++;
			}
        }
	catch ( IOException e ) {
		System.out.println( e.getMessage() );
	}
	try {   //for allcation of girl data from input file
            i=0;
		temp = new BufferedReader(new FileReader(file_name2));
			while((newline = temp.readLine() )!= null){
				String[] girl_entry = newline.split(seperator);
				System.out.println(girl_entry[0] +" "+ girl_entry[1] +" "+ girl_entry[2] +" " +girl_entry[3]);
				String temp2_name = girl_entry[0];
				int temp2_intel = Integer.parseInt(girl_entry[1]);
				int temp2_attract = Integer.parseInt(girl_entry[2]);
				int temp2_budget = Integer.parseInt(girl_entry[3]);
                                g[i].attract = temp2_attract;
                                g[i].budget = temp2_budget;
                                g[i].intel = temp2_intel;
                                g[i].name = temp2_name;
                                //System.out.println(g[i].name+g[i].budget );
				i++;
			}i=1;
                        //System.out.println(g[i].name+g[i].budget );
	}
	catch ( IOException e ) {
		System.out.println( e.getMessage() );
	}
	for(i=0;i<9;i++) {
		for(j=0;j<9;j++) {
                    //System.out.println(g[i].budget+" "+i+b[j].budget+" "+j);
			if(g[i].status=='s' && b[j].status=='s' && g[i].is_eligible(b[j].budget) && b[j].is_eligible(g[i].budget, g[i].attract)) {
                            g[i].status = 'c';
				b[j].status = 'c';
				g[i].bf = b[j].name;
				b[j].gf = g[i].name;
				System.out.println(g[i].name+" "+"is committed to"+" "+b[j].name);
                                
			}
		}
        }

}
}