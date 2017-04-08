/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package q3;

/**
 *
 * @author vishal kumar singh iit2015141
 */
/** This is Main function.
 */
import boy.generous;
import boy.boy;
import boy.miser;
import boy.geeks;
import java.util.*;
import java.lang.*;
import java.io.*;
import girl.*;
import gift.*;
import testgen.*;
import couple.*;
public class Q3
{
    /** 
     * this is Main function.
    */
	public static void main(String[] args) {
	int n = 100; //no. of test cases in input files
	int i=1,j,k,u1=0,l1=0;
	testgen t = new testgen();
	t.generate();
        int[] giftv = new int[100];
        List<couple> cs = new ArrayList<couple>();
        boy[] b  = new boy[100];
        girl[] g = new girl[100];
        couple[] c = new couple[100];
        gift[] gi1 = new gift[100];
	String file_name1 = "boy.txt";
	String file_name2 = "girl.txt";
        String file_name3 = "gift.txt";
	String seperator = " ";
        String newline;
        
        BufferedReader temp = null;i=0;
	try {   //for alloation of boys and girls data from input file
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
                                    b[i] = new geeks(temp1_name,temp1_intel ,temp1_attract,temp1_attr_req,temp1_budget);
                                }
                                else if(temp1_type.equals("miser")) {
                                    b[i] = new miser(temp1_name,temp1_intel ,temp1_attract,temp1_attr_req,temp1_budget);
                                }
                                else if(temp1_type.equals("generous")) {
                                    b[i] = new generous(temp1_name,temp1_intel ,temp1_attract,temp1_attr_req,temp1_budget);
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
                                g[i] = new normal(temp2_name,temp2_intel,temp2_attract,temp2_budget);
                                }
                                else if(temp2_type.equals("choosy")){
                                g[i] = new choosy(temp2_name,temp2_intel,temp2_attract,temp2_budget);
                                }
                                else if(temp2_type.equals("desperate")){
                                g[i] = new desperate(temp2_name,temp2_intel,temp2_attract,temp2_budget);
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
                                if(temp2_name == "luxury"){
                                    gi1[i] = new luxury(temp2_price);
                                }
                                else if(temp2_name == "utility"){
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
        int ct2 = 0;
	for(i=0;i<100;i++) {
		for(j=0;j<100;j++) {
			if(g[i].status=='s' && b[j].status=='s' && g[i].is_eligible(b[j].budget) && b[j].is_eligible(g[i].budget, g[i].attract)) {
                            g[i].status = 'c';
				b[j].status = 'c';
				g[i].bf = b[j].name;
				b[j].gf = g[i].name;
                                b[j].gf_id = i;
                                g[i].bf_id = j;   
                                c[ct2] = new couple(g[i],b[j]);
                                ct2++;
			}
		}
        }
        Arrays.sort(giftv);
        int ct = 0;
        for(i=0;i<ct2;i++) {
                ct = c[i].cal_hap(giftv, ct);
                c[i].cal_com();
                cs.add(c[i]);
         }
        
Collections.sort(cs, new couple.OrderByHapp());
Random r = new Random();
int ipk = r.nextInt(10);
try {
int ct1 = ipk;
FileWriter file1 = new FileWriter("sol.txt");
file1.write(ipk+" "+"most happy couples are"+"\n");
for (couple i1 : cs) {
                        ct1--;
                        if(ct1>=0)
			file1.write(i1.b.name+" "+i1.g.name+"\n");
                        else break;
		}
    
Collections.sort(cs, new couple.OrderByComp());
file1.write(ipk+" "+"most compatible couples are"+"\n");
ct1 = ipk;
for (couple i1 : cs) {
                        ct1--;
                        if(ct1>=0)
			file1.write(i1.b.name+" "+i1.g.name+"\n");
                        else break;
		}
file1.close();
}
catch(IOException e3){		
			System.out.println( e3.getMessage() );
		}
        }

}

