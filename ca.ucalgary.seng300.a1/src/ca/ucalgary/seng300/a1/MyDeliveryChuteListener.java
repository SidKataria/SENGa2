package ca.ucalgary.seng300.a1;

import org.lsmr.vending.hardware.AbstractHardware;
import org.lsmr.vending.hardware.AbstractHardwareListener;
import org.lsmr.vending.hardware.DeliveryChute;
import org.lsmr.vending.hardware.DeliveryChuteListener;

public class MyDeliveryChuteListener implements DeliveryChuteListener {

	
	/**
	 * Implementation of the DeliveryChuteListener
	 * @param myManager
	 * object for managing the vendingmachine
	 */
	MyVendingMachineManager myManager;
	public MyDeliveryChuteListener(MyVendingMachineManager myManager){
		this.myManager=myManager;
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
	 * Event itemDelivered, it´s expected that the person removes the items from the chute
	 */
	@Override
	public void itemDelivered(DeliveryChute chute) {
		System.out.print("Item delivered");
		chute.removeItems();
		
	}

	@Override
	public void doorOpened(DeliveryChute chute) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doorClosed(DeliveryChute chute) {
		
		
	}

	@Override
	public void chuteFull(DeliveryChute chute) {
		// TODO Auto-generated method stub
		
	}

}
