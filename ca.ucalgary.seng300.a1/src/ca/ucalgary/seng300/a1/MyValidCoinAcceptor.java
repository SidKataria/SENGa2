package ca.ucalgary.seng300.a1;

import org.lsmr.vending.Coin;
import org.lsmr.vending.hardware.CapacityExceededException;
import org.lsmr.vending.hardware.CoinAcceptor;
import org.lsmr.vending.hardware.DisabledException;

public class MyValidCoinAcceptor implements CoinAcceptor {
	public int acceptCoinCount = 0;
	@Override
	public void acceptCoin(Coin coin) throws CapacityExceededException, DisabledException {
		acceptCoinCount++;
		
	}

	@Override
	public boolean hasSpace() {
		// TODO Auto-generated method stub
		return true;
	}

}
