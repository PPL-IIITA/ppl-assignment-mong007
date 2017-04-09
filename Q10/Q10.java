/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vishal kumar singh iit2015141
 */
/** this is Main function.
 */
import java.util.*;
import java.lang.*;
import java.io.*;
import girl.*;
import boy.*;
import gift.*;
import testgen.*;
import couple.*;
public class Q10
{
	public static void main(String[] args) {
	int n = 10; //no. of test cases in input files
	int i=1,j,k,u1=0,l1=0;
	testgen t = new testgen();
	t.generate();
        int[] giftv = new int[100];
        List<couple> cs = new ArrayList<couple>();
        List<boy> b = new ArrayList<boy>();
        List<girl> g = new ArrayList<girl>();
        boy[] b1  = new boy[100];
        girl[] g1 = new girl[100];
        couple[] c = new couple[100];
        gift[] gi1 = new gift[100];
	String file_name1 = "boy.txt";
	String file_name2 = "girl.txt";
        String file_name3 = "gift.txt";
	String seperator = " ";
        String newline;
        
        BufferedReader temp = null;i=0;
	try {   //for allcation of boys and girls data from input file
		temp = new BufferedReader(new FileReader(file_name1));
			while((newline = temp.readLine() )!= null){
				String[] boys_entry = newline.split(seperator);
				String temp1_name = boys_entry[0];
				int temp1_intel = Integer.parseInt(boys_entry[1]);
				int temp1_attract = Integer.parseInt(boys_entry[2]);
				int temp1_attr_req = Integer.parseInt(boys_entry[3]);
				int temp1_budget = Integer.parseInt(boys_entry[4]);
                                String temp1_type = boys_entry[5];
                                if(temp1_type.equals("geeks")) {
                                    b1[i] = new geeks(temp1_name,temp1_intel ,temp1_attract,temp1_attr_req,temp1_budget);
                                }
                                else if(temp1_type.equals("miser")) {
                                    b1[i] = new miser(temp1_name,temp1_intel ,temp1_attract,temp1_attr_req,temp1_budget);
                                }
                                else if(temp1_type.equals("generous")) {
                                    b1[i] = new generous(temp1_name,temp1_intel ,temp1_attract,temp1_attr_req,temp1_budget);
                                }
                              
				i++;
			}
        }
	catch ( IOException e1 ) {
		System.out.println( e1.getMessage() );
	}
	try {   
            i=0;
		temp = new BufferedReader(new FileReader(file_name2));
			while((newline = temp.readLine() )!= null){
				String[] girl_entry = newline.split(seperator);
				String temp2_name = girl_entry[0];
				int temp2_intel = Integer.parseInt(girl_entry[1]);
				int temp2_attract = Integer.parseInt(girl_entry[2]);
				int temp2_budget = Integer.parseInt(girl_entry[3]);
                                String temp2_type = girl_entry[4];
                                if(temp2_type.equals("normal")){
                                g1[i] = new normal(temp2_name,temp2_intel,temp2_attract,temp2_budget);
                                }
                                else if(temp2_type.equals("choosy")){
                                g1[i] = new choosy(temp2_name,temp2_intel,temp2_attract,temp2_budget);
                                }
                                else if(temp2_type.equals("desperate")){
                                g1[i] = new desperate(temp2_name,temp2_intel,temp2_attract,temp2_budget);
                                }
       
				i++;
			}i=1;
	}
        
	catch ( IOException e1 ) {
		System.out.println( e1.getMessage() );
	}
        try {  
            i=0;
		temp = new BufferedReader(new FileReader(file_name3));
			while((newline = temp.readLine() )!= null){
				String[] gift_entry = newline.split(seperator);
				String temp2_name = gift_entry[0];
				int temp2_price = Integer.parseInt(gift_entry[1]);
                                giftv[i] = temp2_price;
                                if(temp2_name.equals("luxury")){
                                    gi1[i] = new luxury(temp2_price);
                                }
                                else if(temp2_name.equals("utility")){
                                    gi1[i] = new utility(temp2_price);
                                }
                                else {
                                     gi1[i] = new essential(temp2_price);
                                }
                                i++;
			}i=1;
	}
        
	catch ( IOException e1 ) {
		System.out.println( e1.getMessage() );
	}
        Collections.sort(b);
        Collections.sort(g);
        for(i=0;i<100;i++) {
            g.add(g1[i]);
            b.add(b1[i]);
        }
        Random r = new Random();
        int giv = r.nextInt(50);
        int ct2 = 0;
        try {
        FileWriter file1 = new FileWriter("sol.txt");
        file1.write("couples formed using new data structure:"+"\n");
	for(i=1;i<100;i++) {
            boy a20 = Random(b1, giv);
            int a15 = g.get(i).mk_pair(a20);
            if(a15!=-1){
            file1.write(b.get(a15).name+" "+g.get(i).name+"\n");
            c[ct2] = new couple(g.get(i),b.get(a15));
            ct2++;
            }
            girl g20 = Random(g1, giv);
            a15 = b.get(i).mk_pair(g20);
            if(a15!=-1){
                file1.write(b.get(i).name+" "+g.get(a15).name+"\n");
            c[ct2] = new couple(g.get(a15),b.get(i));
            ct2++;
            }
           
        }
        Arrays.sort(giftv);
        int ct = 0;
        for(i=0;i<ct2;i++) {
                ct = c[i].cal_hap(giftv, ct);
                c[i].cal_com();
                cs.add(c[i]);
         }
        file1.close();
        }
        catch(IOException e3){		
			System.out.println( e3.getMessage() );
		}

        }
        /**
         * This swap function.This is a utility function for new data structure.
         * @param <E> This is generic object.
         * @param a This is list of generic objects.
         * @param i Index of object to be swapped.
         * @param j Index of object to be swapped.
         */
private static <E>  void swap(E[] a, int i, int j) {
        if (i != j) {
            E temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
/**
 * It implements new data structure mentioned in question.It uses Templates. 
 * @param <E> This is generic object.
 * @param a This is list of generic objects.
 * @param s This value of k(no. of best options to be provided).
     * @return It returns a random object over k best objects.
 */
    public static <E extends Comparable<E>> E Random(E[] a, int s) {
        for (int i = 0; i < s; i++) {
            int small = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[small])<=0) {
                    small = j;
                }
            }

            swap(a, i, small);  // swap smallest to front
        }
        Random b = new Random();
        return a[b.nextInt(100)];
    }


}

