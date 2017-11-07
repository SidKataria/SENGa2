package ca.ucalgary.seng300.a1;

import org.lsmr.vending.Coin;
import org.lsmr.vending.hardware.AbstractHardware;
import org.lsmr.vending.hardware.AbstractHardwareListener;
import org.lsmr.vending.hardware.CapacityExceededException;
import org.lsmr.vending.hardware.CoinReceptacle;
import org.lsmr.vending.hardware.CoinReceptacleListener;
import org.lsmr.vending.hardware.DisabledException;

public class MyCoinReceptacleListener implements CoinReceptacleListener {
	
	/**
	 * Implementation of the CoinReceptacleListener
	 * @param myManager 
	 * object for managing the cending machine
	 */
	
	MyVendingMachineManager myManager;
	public MyCoinReceptacleListener(MyVendingMachineManager myManager){
		this.myManager = myManager;
	}

	@Override
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Updates the current amount of coins
	 */
	@Override
	public void coinAdded(CoinReceptacle receptacle, Coin coin) {
		int amount = myManager.GetCurrentCoins() + coin.getValue();
		myManager.SetCurrentCoins(amount);
	}

	@Override
	public void coinsRemoved(CoinReceptacle receptacle) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * CoinsFull event routes coins fromthe receptacle to the coin rack
	 */
	@Override
	public void coinsFull(CoinReceptacle receptacle) {
		try {
			receptacle.storeCoins();
		} catch (CapacityExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DisabledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void coinsLoaded(CoinReceptacle receptacle, Coin... coins) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coinsUnloaded(CoinReceptacle receptacle, Coin... coins) {
		// TODO Auto-generated method stub
		
	}

}
