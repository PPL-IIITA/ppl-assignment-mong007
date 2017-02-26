/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boy;

/**
 *
 * @author vishal kumar singh iit2015141  
 */
/** This class contains and manages attributes of Boys.
*/
import java.lang.*;
import java.util.*;
import java.io.*;

public class boy {
	public String name; 
        public String type;
	public int attract;	
	public int intel;
	public int budget;
        public int att_req;
	public String gf = " ";
        public int gf_id;
	public long happ;
	public char status = 's';
	public boolean is_eligible (int g_budget, int g_att) {
                boolean flag = true;
		if(g_budget > this.budget) 
			flag = false;
		if(g_att < this.att_req)
			flag =  false;
                if(this.status == 'c' )
                    flag = false;
                return flag;
	}
	
	public char view_status() {
		return this.status;
	}
	public void change_status(char status1) {
			  if(status1 == 'c') this.status = 'c';
			   else this.status = 's';
	}
        
}


