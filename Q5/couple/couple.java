/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package couple;
import boy.boy;
import java.lang.*;
import java.util.*;
import java.io.*;
import girl.*;
/**
 *This class contains and manages attributes of various couples.
 * @author vishal kumar singh iit2015141
 */


public class couple 
{
public girl g;
public boy b;
public int [] gifts = new int[100];
public double happ = 0;
public int comp = 0;
public int[] gi = new int[100];
public couple(girl g1, boy b1) {
    this.g = g1;
    this.b = b1;
}
/**  
    * It calculates Happiness of couple.  
    * @param gi1 It array of gifts available for selection.
    * @param ct It represents index after which gifts are available for selection. 
     * @return   Returns Happiness of couples.
    */
public int cal_hap(int [] gi1, int ct) {
    int ct1 = ct;
    this.gi = gi1;
    int req = g.budget;
    int j=0,i;
    int ctl = b.cal_req(gi, ct,req);
    for(i=ct1;i<ctl;i++) {
        gifts[j] = gi[i];
        j++;
    }
    g.rec = b.gf_rec;
    this.happ = b.happi(g) + g.happi(b.gf_rec);
    return ctl;
}
/**  
    * It calculates Compatibility of couple.  
    */ 
public void cal_com() {
    this.comp = Math.abs((g.rec - b.budget))+ Math.abs((g.intel - b.intel))+Math.abs((g.attract - b.attract));
}
/**
 * This class is comparator to sort Couples in order of Happiness.
 */
public static class OrderByHapp implements Comparator<couple> {

        @Override
        public int compare(couple o1, couple o2) {
            return o1.happ < o2.happ ? 1 : (o1.happ > o2.happ ? -1 : 0);
        }
    }
/**
 * This class is comparator to sort Couples in order of Compatibility.
 */
public static class OrderByComp implements Comparator<couple> {

        @Override
        public int compare(couple o1, couple o2) {
            return o1.comp < o2.comp ? 1 : (o1.comp > o2.comp ? -1 : 0);
        }
    }


    }


