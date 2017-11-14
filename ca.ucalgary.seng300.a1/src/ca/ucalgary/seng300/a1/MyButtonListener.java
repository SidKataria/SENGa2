package ca.ucalgary.seng300.a1;

import java.util.Observable;
import java.util.Observer;

import org.lsmr.vending.PopCan;
import org.lsmr.vending.hardware.AbstractHardware;
import org.lsmr.vending.hardware.AbstractHardwareListener;
import org.lsmr.vending.hardware.CapacityExceededException;
import org.lsmr.vending.hardware.DisabledException;
import org.lsmr.vending.hardware.EmptyException;
import org.lsmr.vending.hardware.PushButton;
import org.lsmr.vending.hardware.PushButtonListener;
import org.lsmr.vending.hardware.VendingMachine;
/**
 * An implementation of the SelectionButtonListener
 * @param myManager
 * The Manager class for all listeners used to keep track and interact
 */
public class MyButtonListener implements PushButtonListener {
	public int enabledCount = 0;
	public int disabledCount = 0;
	public int pressedCount = 0;
	private MyVendingMachineManager myManager;
	
	public MyButtonListener(MyVendingMachineManager myManager){
		this.myManager=myManager;
	}

	@Override
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		enabledCount++;
		
	}

	@Override
	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		disabledCount++;	
	}

	/**
	 * Implementation for event pressed
	 * Checks if enough coins are inserted, if enough pops are in the rack
	 * Delivers the can through the chute
	 */
	@Override
	public void pressed(PushButton button) {
		pressedCount++;
		int n = myManager.GetVendingMachine().getNumberOfSelectionButtons();
		int index;
		for(int i = 0;i<n;i++){
			if(myManager.GetVendingMachine().getSelectionButton(i).equals(button)){
				index=i;
				try {
					if(myManager.GetCurrentCoins()>=myManager.GetVendingMachine().getPopKindCost(index)){
							if(myManager.GetVendingMachine().getPopCanRack(index).size()>0){
								try {
									myManager.GetVendingMachine().getPopCanRack(index).dispensePopCan();
								} catch (EmptyException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								myManager.GetVendingMachine().getDeliveryChute().acceptPopCan(new PopCan(myManager.GetVendingMachine().getPopKindName(index)));
								int amount=myManager.GetCurrentCoins()-myManager.GetVendingMachine().getPopKindCost(index);
								myManager.SetCurrentCoins(amount);
							}
							else{
								System.out.println("That pop can is empty");
							}
					}
					else{
						System.out.println("You need more coins to buy that pop can");
					}
				} catch (CapacityExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DisabledException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
	}
