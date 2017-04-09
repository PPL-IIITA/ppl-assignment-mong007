/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *This is Main function.
 * @author vishal kumar singh iit2015141
 */
import boy.generous;
import boy.miser;
import boy.geeks;
import boy.boy;
import java.util.*;
import java.lang.*;
import java.io.*;
import girl.*;
import gift.*;
import testgen.*;
import couple.*;
public class Q5
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
        Collections.sort(b, new boy.b_ord());
        Collections.sort(g, new girl.g_ord());
        for(i=0;i<100;i++) {
            g.add(g1[i]);
            b.add(b1[i]);
        }
        int ct2 = 0;
        ct2 = algo(b,g,c,ct2);
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
file1.write(ipk+" "+"most happiest couples are"+"\n");
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
/**
 * This function performs breakup.
 * @param b list of boys.
 * @param g list of girls.
 * @param c list of couples.
 * @param ct2 count of number of couples.
     * @return ct2 count of number of couples.
        */
 public static int algo(List<boy> b, List<girl> g, couple c[], int ct2) {
     for(int i=1;i<100;i++) {
            for(int j=1;j<100;j++) {
			if(b.get(i).status=='s' && g.get(j).status=='s' && b.get(i).is_eligible(g.get(j).budget, g.get(j).attract ) && g.get(j).is_eligible(b.get(i).budget)) {
                            b.get(i).status = 'c';
				g.get(j).status = 'c';
				b.get(i).gf = g.get(j).name;
				g.get(j).bf = b.get(i).name;
                                g.get(j).bf_id = i;
                                b.get(i).gf_id = j;   
                                c[ct2] = new couple(g.get(j),b.get(i));
                                ct2++;
			}
		}
		for(int j=1;j<100;j++) {
                    int max = 0,maxi=0;
                    for(int k1=1;k1<100;k1++) {
                        if(g.get(k1).attract>max) {
                            max = g.get(k1).attract;
                            maxi = k1;
                        }
                    }
			if(g.get(maxi).status=='s' && b.get(j).status=='s' && g.get(maxi).is_eligible(b.get(j).budget) && b.get(j).is_eligible(g.get(maxi).budget, g.get(maxi).attract)) {
                            g.get(maxi).status = 'c';
				b.get(j).status = 'c';
				g.get(maxi).bf = b.get(j).name;
				b.get(j).gf = g.get(maxi).name;
                                b.get(j).gf_id = maxi;
                                g.get(maxi).bf_id = j;   
                                c[ct2] = new couple(g.get(maxi),b.get(j));
                                ct2++;
			}
		}
        }
     return ct2;
 }

}

