/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;
import couple.*;
/**
 *This is Search class.It implements all three variants of search.
 * @author vishal
 */
public abstract class search {
    couple [] c = new couple[1000];
    String [] input = new String[1000];
    public search(couple [] couple1, String [] input1) {
        super();
        this.c  = couple1;
        this.input  = input1;
    }
    /**
     * This function find GF for given set of inputs. 
     * @param c It list of couples formed.
     * @param input It list of input provided.
     * @param c1 It is no. of couples formed.
     * @param b1 It is size of input array.
     */
    public abstract void find(couple [] c, String [] input, int c1, int b1); 
}
