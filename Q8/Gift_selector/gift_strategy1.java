/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gift_selector;
import java.io.*;
import gift.*;
/**
 * This is first gifting strategy(as mentioned in the question).
 * @author vishal kumar singh iit2015141
 */
public class gift_strategy1 extends Gift_selector{
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
        int ans[] = new int[1000];
        gift[] gi1 = new gift[1000];
        try {  
           int i=0;
           FileWriter file1 = new FileWriter("sol.txt");
            file1.write("Gifts available for selection under gift strategy 1:\ntype    price\n");
		temp = new BufferedReader(new FileReader(file_name3));
			while((newline = temp.readLine() )!= null){
				String[] gift_entry = newline.split(seperator);
				String temp2_name = gift_entry[0];
				int temp2_price = Integer.parseInt(gift_entry[1]);
                                giftv[i] = temp2_price;
                                if(temp2_name.equals("luxury")){
                                    gi1[i] = new luxury(temp2_price);
                                    file1.write("luxury  : "+gi1[i].price+"\n");
                                }
                                else if(temp2_name.equals("utility")){
                                    gi1[i] = new utility(temp2_price);
                                    file1.write("utility  : "+gi1[i].price+"\n");
                                }
                                else {
                                     gi1[i] = new essential(temp2_price);
                                     file1.write("essential : "+gi1[i].price+"\n");
                                }
                                i++;
			}i=1;
                        file1.close();
	}
        
	catch ( IOException e1 ) {
		System.out.println( e1.getMessage() );
	}
        for(int i=0;i<100;i++) {
            ans[i] = giftv[i];
        }
         System.out.println("Random Function generated Gift Strategy 1\n");
        return ans;
    }
}
