/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boy;
import girl.*;
/**
 *
 * @author vishal kumar singh iit2015141
 */
/** This is geek boy class.It is child of boy class.
    */
public class geeks extends boy {
    public geeks(String name1, int bud, int attr, int intel1, int att) {
        super(name1,bud,attr,intel1,att);
    }
    @Override
    public double happi(girl g) {
        this.happ = g.intel;
        return g.intel;
    }
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
                    if(bal-gi[ct]>=0) {
                        bal = bal-gi[ct];
                        ct++;
                    }
                    this.gf_rec = budget - bal;
                    return ct;
    }
}

