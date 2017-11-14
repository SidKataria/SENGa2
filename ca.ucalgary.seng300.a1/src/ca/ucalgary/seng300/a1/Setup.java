package ca.ucalgary.seng300.a1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.lsmr.vending.Coin;
import org.lsmr.vending.hardware.CoinChannel;
import org.lsmr.vending.hardware.CoinSlot;
import org.lsmr.vending.hardware.DisabledException;
import org.lsmr.vending.hardware.VendingMachine;

public class Setup {

	public static void main(String [] args) throws IOException{
		MyVendingMachineManager myManager = new MyVendingMachineManager();

		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    //Just a simple loop for running the machine
	    while(true){
	    	System.out.print("Add Coins: ");
		    String input = br.readLine();
		    if(Integer.parseInt(input)<=2){
		    	Coin testCoin = new Coin(Integer.parseInt(input));
				try {
					myManager.GetVendingMachine().getCoinSlot().addCoin(testCoin);
				} catch (DisabledException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    System.out.println("You added " + input + " coin/s.");
			    System.out.print("Choose Pop Can: Pepsi is button 0 and Sprite is button 1 ");
			    input = br.readLine();
			    myManager.GetVendingMachine().getSelectionButton(Integer.parseInt(input)).press();
		    }
		    else{
		    	System.out.println("We dont accept those coins");
		    }
	    }
	}
}
