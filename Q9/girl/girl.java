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
import couple.couple;
import java.lang.*;
import java.util.*;
import java.io.*;

public abstract class girl implements Comparable<girl>{
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
         * This function makes couple by checking eligibility of every girl for a boy.
         * @param b list of object of boy class.
         * @param giv It is value of k(k best options as given in question).
         * @return returns bf_id in case of successful coupling otherwise return -1.
         */
        public int mk_pair(boy[] b, int giv) {
            int ct = giv;
          for(boy j : b) {
              if(ct>0){
			if(j.status=='s' && this.status=='s' && j.is_eligible(this.budget, this.attract ) && this.is_eligible(j.budget)) {
                            j.status = 'c';
				this.status = 'c';
				j.gf = this.name;
				this.bf = j.name;
                                this.bf_id = Integer.parseInt(j.name.substring(j.name.length() - 1));
                                j.gf_id = Integer.parseInt(this.name.substring(this.name.length() - 1));   
                                return bf_id;
                                //System.out.println(c[i].g.bf_id);
			}
                        ct--;
		}
          }
          
          return -1;
          
        }
        /**  
         * It changes relationship status of girl . 
         @param status1 It is new relationship status of girl . 
    */
	public void change_status(char status1) {
			  if(status1 == 'c') this.status = 'c';
			   else this.status = 's';
	} 
        /**  
    * It calculates Happiness.  
    * @param x It is total cost of gifts received.  
     * @return   Returns Happiness.
    */
        public abstract double happi(int x);
        /**
         * This comparator function to sort list of object of class girl in order of their budget.
         * @param o an object of class boy.
         */
        @Override
          public int compareTo(girl o) {
        return this.budget > o.budget ? 1 : (this.budget < o.budget ? -1 : 0);

    }
}
