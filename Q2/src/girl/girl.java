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

public class girl {
	public String name; 
        public String type;
	public int budget;	
	public int intel;
	public int attract;
        public int bf_id;
        public int rec = 0;
	public String bf = " ";
	public long happ;
	public char status = 's';
	
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
}
