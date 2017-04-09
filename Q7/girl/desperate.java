/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girl;

/**
 *This is desperate girl class.It is child of girl class.
 * @author vishal kumar singh iit2015141
 */
public class desperate extends girl {
     public desperate(String name1, int intel1, int attract1, int budget1){
        super(name1, intel1, attract1, budget1);
    }
     /**  
    * It calculates Happiness.  
    * @param x It is total cost of gifts received.  
     * @return   Returns Happiness.
    */ 
     @Override  
    public double happi(int x) {
        double ans = (Math.pow((double)budget,(double)x));
        this.happ = ans;
        return ans;
    }
}

