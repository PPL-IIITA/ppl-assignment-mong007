/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girl;

/**
 *
 * @author vishal
 */
import java.lang.*;
import java.util.*;
import java.io.*;

public class girl {
	public String name; 
	public int budget;	
	public int intel;
	public int attract;
	public String bf = " ";
	public int happ;
	public char status = 's';
	
	/*public girl(String name1, int attract1, int intel1, int budget1) {
		name = name1;
		budget = budget1;
		intel = intel1;
		attract = attract1;
	}*/
	
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
