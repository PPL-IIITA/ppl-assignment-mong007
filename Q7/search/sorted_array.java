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
 * This is sorted array implementation of the problem.It extends search class.
 * @author vishal
 */
public class sorted_array extends search {
    public sorted_array(couple [] couple1, String [] input1) {
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
            Arrays.sort(c,new couple.OrderByBoy());
            FileWriter file1 = new FileWriter("sol.txt");
            file1.write("Answer using array implementation (selected by random function in  main class)"+"\n"+"input"+" "+"output"+"\n");
        for(int i=0;i<b1;i++) {
            couple c3 = coup(c,input[i]);
            if(c3.equals(c[99]) == false) {
            int a = Arrays.binarySearch(c, c3);
            file1.write(input[i]+"   "+c[a].g.name+"\n");
            }
        }
        
        file1.close();
        }
        catch (IOException e1 ) {
		System.out.println( e1.getMessage() );
	}
    }
    /**
     * This function returns couple object corresponding to given boy object.
     * @param c It list of couples formed.
     * @param i1 Name of Boy.
     * @return An object of class couple. 
     */
    public couple coup(couple [] c, String i1) {
        for(int i=0;i<99;i++) {
            if(c[i].b.name.equals(i1)) return c[i];
        }
        return c[99];
    }
}
