package ca.ucalgary.seng300.a1;

import org.lsmr.vending.PopCan;
import org.lsmr.vending.hardware.AbstractHardware;
import org.lsmr.vending.hardware.AbstractHardwareListener;
import org.lsmr.vending.hardware.PopCanRack;
import org.lsmr.vending.hardware.PopCanRackListener;

public class MyPopCanRackListener implements PopCanRackListener {
	
	MyVendingMachineManager myManager;
	
	public MyPopCanRackListener(MyVendingMachineManager myManager){
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

	@Override
	public void popCanAdded(PopCanRack popCanRack, PopCan popCan) {
		popCanRack.load(popCan);
		
	}

	@Override
	public void popCanRemoved(PopCanRack popCanRack, PopCan popCan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popCansFull(PopCanRack popCanRack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popCansEmpty(PopCanRack popCanRack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popCansLoaded(PopCanRack rack, PopCan... popCans) {
		
	
	}

	@Override
	public void popCansUnloaded(PopCanRack rack, PopCan... popCans) {
		// TODO Auto-generated method stub
		
	}

}
