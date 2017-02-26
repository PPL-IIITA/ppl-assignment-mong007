/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2;

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
public class Q2
{
	public static void main(String[] args) {
	int n = 10; //no. of test cases in input files
	int i=1,j,k,u1=0,l1=0;
	testgen t = new testgen();
	t.generate();
        int[] giftv = new int[100];
        boy[] b  = new boy[100];
        girl[] g = new girl[100];
        essential[] e = new essential[200];
        luxury[] l = new luxury[200];
        utility[] u = new utility[200];
        for(i=0;i<10;i++){
	b[i] = new boy();
	g[i] = new girl();}
        for(i=0;i<100;i++){
            e[i] = new essential();
            l[i] = new luxury();
            u[i] = new utility();
        }
	String file_name1 = "/home/vishal/Desktop/boy.txt";
	String file_name2 = "/home/vishal/Desktop/girl.txt";
        String file_name3 = "/home/vishal/Desktop/gift.txt";
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
                                b[i].name = temp1_name;
                                b[i].budget = temp1_budget;
                                b[i].att_req = temp1_attr_req;
                                b[i].intel = temp1_intel;
                                b[i].attract = temp1_attract;
                                b[i].type = temp1_type;
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
                                g[i].attract = temp2_attract;
                                g[i].budget = temp2_budget;
                                g[i].intel = temp2_intel;
                                g[i].name = temp2_name;
                                g[i].type = temp2_type;
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
                                e[i].price = temp2_price;
                                giftv[i] = temp2_price;
                                if(temp2_name == "luxury"){
                                    l[l1].pri = temp2_price;
                                    l1++;
                                }
                                else if(temp2_name == "utility"){
                                    u[u1].pri = temp2_price;
                                    u1++;
                                }
                                i++;
			}i=1;
	}
        
	catch ( IOException e1 ) {
		System.out.println( e1.getMessage() );
	}
	for(i=0;i<9;i++) {
		for(j=0;j<9;j++) {
			if(g[i].status=='s' && b[j].status=='s' && g[i].is_eligible(b[j].budget) && b[j].is_eligible(g[i].budget, g[i].attract)) {
                            g[i].status = 'c';
				b[j].status = 'c';
				g[i].bf = b[j].name;
				b[j].gf = g[i].name;
                                b[j].gf_id = i;
                                g[i].bf_id = j;                                
			}
		}
        }
        Arrays.sort(giftv);
        int ct = 0;
        long[][] hap = new long[10][3];
        long[][] com = new long[10][3];
        int hapc=0;
        int comc=0;
        for(i=0;i<10;i++) {
                if(b[i].type.equals("miser") && b[i].status == 'c') {
                    int bal = b[i].budget;
                    int id = b[i].gf_id;
                    int req = g[id].budget;
                    while(req>0 && ct<100) {
                        req = req - giftv[ct];
                        ct++;
                    } 
                    g[id].rec = g[id].budget - req;
                    b[i].happ = b[i].budget - g[id].rec;
                    if(g[id].type.equals("choosy")){
                        g[id].happ = (int)(Math.log(g[id].rec));
                    }
                    else if(g[id].type.equals("normal")) {
                        g[id].happ = g[id].rec;
                    }
                    else {
                        g[id].happ = (int)(Math.pow((double)g[id].budget,(double)g[id].rec));
                    }
                    hap[hapc][0] = g[id].happ+b[i].happ;
                    hap[hapc][1] = i;
                    hap[hapc][2] = id;
                    hapc++;
                    com[comc][0] = Math.abs((g[id].rec - b[i].budget))+ Math.abs((g[id].intel - b[i].intel))+Math.abs((g[id].attract - b[i].attract));
                    com[comc][1] = i;
                    com[comc][2] = id;
                    comc++;
         }
                else if(b[i].type.equals("generous") && b[i].status == 'c') {
                    int bal = b[i].budget;
                    int id = b[i].gf_id;
                    int req = g[id].budget;
                    while(bal>0 && ct<100) {
                        bal = bal - giftv[ct];
                        ct++;
                    } 
                    if(bal<0){
                        bal = bal + giftv[ct-1];
                        ct--;
                    }
                    g[id].rec = g[id].budget - req;
                    b[i].happ = b[i].budget - g[id].rec;
                    if(g[id].type.equals("choosy")){
                        g[id].happ = (int)(Math.log(g[id].rec));
                    }
                    else if(g[id].type.equals("normal")) {
                        g[id].happ = g[id].rec;
                    }
                    else {
                        g[id].happ = (int)(Math.pow((double)g[id].budget,(double)g[id].rec));
                    }
                    hap[hapc][0] = g[id].happ+b[i].happ;
                    hap[hapc][1] = i;
                    hap[hapc][2] = id;
                    hapc++;
                    com[comc][0] = Math.abs((g[id].rec - b[i].budget))+ Math.abs((g[id].intel - b[i].intel))+Math.abs((g[id].attract - b[i].attract));
                    com[comc][1] = i;
                    com[comc][2] = id;
                    comc++;
         }
                 else if(b[i].type.equals("geeks") && b[i].status == 'c') {
                    int bal = b[i].budget;
                    int id = b[i].gf_id;
                    int req = g[id].budget;
                    while(bal>0 && ct<100) {
                        bal = bal - giftv[ct];
                        ct++;
                    } 
                    if(bal<0){
                        bal = bal + giftv[ct-1];
                        ct--;
                    }
                    g[id].rec = g[id].budget - req;
                    b[i].happ = b[i].budget - g[id].rec;
                    if(g[id].type.equals("choosy")){
                        g[id].happ = (int)(Math.log(g[id].rec));
                    }
                    else if(g[id].type.equals("normal")) {
                        g[id].happ = g[id].rec;
                    }
                    else {
                        g[id].happ = (int)(Math.pow((double)g[id].budget,(double)g[id].rec));
                    }
                    hap[hapc][0] = g[id].happ+b[i].happ;
                    hap[hapc][1] = i;
                    hap[hapc][2] = id;
                    hapc++;
                    com[comc][0] = Math.abs((g[id].rec - b[i].budget))+ Math.abs((g[id].intel - b[i].intel))+Math.abs((g[id].attract - b[i].attract));
                    com[comc][1] = i;
                    com[comc][2] = id;
                    comc++;
         }
		}
Arrays.sort(hap, Comparator.comparingLong(arr -> arr[0]));
Arrays.sort(com, Comparator.comparingLong(arr -> arr[0]));
int ipk = 3; // input value of k
System.out.println(ipk+" "+"most happy couples are");
int ct1 = ipk;
int ct2 = ct1;
i=9;
while(ct1>0){
    System.out.println("b"+hap[i][1]+" "+"g"+hap[i][2]);
    i--;
    ct1--;
    
}
System.out.println(ipk+" "+"most compatible couples are");
i=9;
while(ct2>0) {
    System.out.println("b"+com[i][1]+" "+"g"+com[i][2]);
    i--;
    ct2--;
}

}
/**this is utility function to print array.
 * @param hap 
 */
    private static void dump(long[][] hap) {
        for(int p = 0;p<10;p++)
    {
        System.out.println(hap[p][0] + " " + hap[p][1]+" "+hap[p][2]);
    }
    }  //utility method to print array
}
