/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gift_selector;
import java.io.*;
import gift.*;
/**
 * This is second gifting strategy(as mentioned in the question).
 * @author vishal kumar singh iit2015141
 */
public class gift_strategy2 extends Gift_selector{
    /**
     * This function defines how gifts are to be arranged(as given in the question. 
     * @return List of gifts available for selection.
     */
    @Override
    public int [] gift_tech() {
        BufferedReader temp = null;
        String file_name3 = "gift.txt";
	String seperator = " ";
        String newline;
        int giftv[] = new int[1000];
        int ans[] = new int[100];
        gift[] gi1 = new gift[1000];
        gift[] l1 = new luxury[1000];
        gift[] u1 = new utility[1000];
        gift[] e1 = new essential[1000];
        int l3 = 0,e3 = 0,u3 = 0;
        try {  
           int i=0;
		temp = new BufferedReader(new FileReader(file_name3));
			while((newline = temp.readLine() )!= null){
				String[] gift_entry = newline.split(seperator);
				String temp2_name = gift_entry[0];
				int temp2_price = Integer.parseInt(gift_entry[1]);
                                giftv[i] = temp2_price;
                                if(temp2_name.equals("luxury")){
                                    gi1[i] = new luxury(temp2_price);
                                    l1[l3] = gi1[i];
                                    l3++;
                                }
                                else if(temp2_name.equals("utility")){
                                    gi1[i] = new utility(temp2_price);
                                    u1[u3] = gi1[i];
                                    u3++;
                                }
                                else {
                                     gi1[i] = new essential(temp2_price);
                                     e1[e3] =gi1[i];
                                    e3++;
                                }
                                i++;
			}i=1;
	
        int ct= Math.min(l3,Math.min(u3, e3));
        if(ct>99) ct=100;
        FileWriter file1 = new FileWriter("sol.txt");
        file1.write("Gifts available for selection under gift strategy 2:\n");
        for(int j=0;j<ct;j++) {
            ans[j] = l1[j].price+u1[j].price+e1[j].price;
           file1.write("luxury price : "+l1[j].price+" "+"utility price : "+u1[j].price+" essential price : "+e1[j].price+"\n");
        }
        file1.close();
        System.out.println("Random Function generated Gift Strategy 2\n");
        for( i=ct;i<100;i++) ans[i] = 9999;
        }
        catch ( IOException e7 ) {
		System.out.println( e7.getMessage() );
	}
        return ans;
    }
}
