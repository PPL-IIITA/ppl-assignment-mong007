/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girl;

/**
 *This class contains and manages attributes of Girls.
 * @author vishal kumar singh iit2015141
 */
import boy.boy;
import java.lang.*;
import java.util.*;
import java.io.*;

public abstract class girl {
	public String name; 
	public int budget;	
	public int intel;
	public int attract;
        public int bf_id;
        public int rec;
	public String bf = " ";
	public double happ;
	public char status = 's';
	public girl(String name1, int intel1, int attract1, int budget1){
            super();
            this.name = name1;
            this.intel = intel1;
            this.attract = attract1;
            this.budget = budget1;
            this.bf_id = -1;
            this.rec = 0;
            this.bf = " ";
            this.happ = 0;
            this.status = 's';
            }
        /**  
    * It check whether a boy is eligible to be BF or not.  
    * @param b_budget It is budget of the enquired Boy.  
     * @return   Returns 1 for Yes and 0 for no.
    */ 
	public boolean is_eligible (int b_budget) {
		if(b_budget >= this.budget) 
			return true;
		else 
			return false;
	}
	/**  
    * It returns relationship status of girl.   
     * @return   Returns relationship status of girl.
    */ 
	public char view_status() {
		return this.status;
	}
        /**  
         * It changes relationship status of girl . 
         @param status1 It is new relationship status of girl . 
    */
	public void change_status(char status1) {
			  if(status1 == 'c') this.status = 'c';
			   else this.status = 's';
	} 
        public abstract double happi(int x);
        /**
 * This class is comparator to sort girls in order of their budget(maintenance cost).
 */
          public static class g_ord implements Comparator<girl> {
        @Override
        public int compare(girl o1, girl o2) {
            return o1.budget > o2.budget ? 1 : (o1.budget < o2.budget ? -1 : 0);
        }
    }
}
