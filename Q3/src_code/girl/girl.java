/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girl;

/**
 *
 * @author vishal kumar singh iit2015141
 */
/** This class contains and manages attributes of Girls.
*/
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
	public boolean is_eligible (int b_budget) {
		if(b_budget >= this.budget) 
			return true;
		else 
			return false;
	}
	
	public char view_status() {
		return this.status;
	}
	public void change_status(char status1) {
			  if(status1 == 'c') this.status = 'c';
			   else this.status = 's';
	} 
        public abstract double happi(int x);
}
