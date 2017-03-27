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
/** This is choosy girl class.It is child of girl class.
    */
public class choosy extends girl { 
    public choosy(String name1, int intel1, int attract1, int budget1){
        super(name1, intel1, attract1, budget1);
    }
    @Override
    public double happi(int x) {
        double ans = (Math.log(x));
        this.happ = ans;
        return ans;
    }
}
