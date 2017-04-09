/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;
import couple.*;
import java.util.*;
import java.io.*;
/**
 * this is hash table implementation of the problem.It extends search class.
 * @author vishal
 */
public class hash_table extends search {
    public hash_table(couple [] couple1, String [] input1) {
        super(couple1, input1);
    }
    /**
     * This function find GF for given set of inputs. 
     * @param c It list of couples formed.
     * @param input It list of input provided.
     * @param c1 It is no. of couples formed.
     * @param b1 It is size of input array.
     */
    @Override
    public void find(couple [] c, String [] input, int c1, int b1){
        try{
            FileWriter file1 = new FileWriter("sol.txt");
            Hashtable<String,couple> coup = new Hashtable<String,couple>();
            Enumeration n;
            for(int i=0;i<c1;i++) {
                coup.put(c[i].b.name, c[i]);
            }
            file1.write("Answer using hash table implementation (selected by random function in  main class)"+"\n"+"input"+" "+"output"+"\n");
            n = coup.keys();
            /*while(n.hasMoreElements()){
                String str = (String) n.nextElement();
                System.out.println(str+coup.get(str).g.name);
            }*/
        for(int i=0;i<b1;i++) {
            String str = (String) input[i];
            if(coup.containsKey(str))
            file1.write(input[i]+"   "+coup.get(str).g.name+"\n");
            }
        file1.close();
        }
        catch (IOException e1 ) {
		System.out.println( e1.getMessage() );
	}
    }
}
