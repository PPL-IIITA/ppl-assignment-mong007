/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boy;
import girl.*;
/**
 *This is miser boy class.It is child of boy class.
 * @author vishal kumar singh iit2015141
 */
public class miser extends boy {
    public miser(String name1, int bud, int attr, int intel1, int att) {
        super(name1,bud,attr,intel1,att);
    }
    /**  
    * It calculates Happiness.  
    * @param g It is java object of class girl.  
     * @return   Returns Happiness.
    */ 
    @Override
    public double happi(girl g) {
        double ans = budget - g.rec;
        return ans;
    }
    /**  
    * It calculates cost of gift to be given to GirlFriend.  
    * @param gi It array of gifts available for selection. 
    * @param ct It represents index after which gifts are available for selection. 
    * @param req It represent budget of the girl.
     * @return   Returns total cost of gift received.
    */
    @Override
    public int cal_req(int [] gi, int ct, int req) {
        int bal = budget;
                    int req1 = req;
                    while(req1>0 && ct<100) {
                        req1 = req1 - gi[ct];
                        bal = bal - gi[ct];
                        ct++;
                    }
                    if(bal<0){
                        bal = bal + gi[ct-1];
                        ct--;
                    }
                    this.gf_rec = budget - bal;
                    return ct;
    }
}