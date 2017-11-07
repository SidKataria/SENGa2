package ca.ucalgary.seng300.a1;

import org.lsmr.vending.Coin;
import org.lsmr.vending.hardware.AbstractHardware;
import org.lsmr.vending.hardware.AbstractHardwareListener;
import org.lsmr.vending.hardware.CapacityExceededException;
import org.lsmr.vending.hardware.CoinSlot;
import org.lsmr.vending.hardware.CoinSlotListener;
import org.lsmr.vending.hardware.DisabledException;

public class MyCoinSlotListener implements CoinSlotListener {
	public int enabledCount = 0;
	public int disabledCount = 0;
	public int validCoinInsertedCount = 0;
	public int coinRejectedCount = 0;
	private MyVendingMachineManager myManager;
	
	public MyCoinSlotListener(MyVendingMachineManager myManager){
		this.myManager= myManager;
	}
	@Override
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		enabledCount++;
		
	}

	@Override
	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		disabledCount++;
		
	}

	@Override
	public void validCoinInserted(CoinSlot slot, Coin coin) {
		if(!slot.isDisabled()){
			validCoinInsertedCount++;
			try {
				myManager.GetVendingMachine().getCoinReceptacle().acceptCoin(coin);
			} catch (CapacityExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DisabledException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void coinRejected(CoinSlot slot, Coin coin) {
		System.out.println("Coin invalid");
		coinRejectedCount++;
		
	}

}
