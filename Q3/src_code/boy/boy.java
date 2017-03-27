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
import girl.*;
public class boy {
	public String name; 
	public int attract;	
	public int intel;
	public int budget;
        public int att_req;
	public String gf;
        public int gf_id;
	public double happ;
	public char status;
        public int gf_rec;
        public boy(String name1, int bud, int attr, int intel1, int att) {
            super();
            this.att_req = attr;
            this.attract = att;
            this.budget = bud;
            this.intel = intel1;
            this.name = name1;
            this.gf = " ";
            this.gf_id = -1;
            this.status = 's';
            this.happ = 0;
            this.gf_rec = 0;
        }
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
        public double happi(girl g){return 0;}
        public int cal_req(int [] gi, int ct, int req){return 0;}
        
}


