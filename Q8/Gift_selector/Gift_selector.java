/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gift_selector;

/**
 * This is gift selector class. It contains both Gifting strategy mentioned in  the question.
 * @author vishal kumar singh iit2015141
 */
public abstract class Gift_selector {
    /**
     * This function defines how gifts are to be arranged(as given in the question. 
     * @return List of gifts available for selection.
     */
    public abstract int[] gift_tech();
}
