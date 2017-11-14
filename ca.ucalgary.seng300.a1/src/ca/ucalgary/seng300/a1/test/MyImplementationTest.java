package ca.ucalgary.seng300.a1.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.lsmr.vending.Coin;
import org.lsmr.vending.hardware.DisabledException;

import ca.ucalgary.seng300.a1.MyButtonListener;
import ca.ucalgary.seng300.a1.MyVendingMachineManager;
@SuppressWarnings("javadoc")
public class MyImplementationTest {
	private MyVendingMachineManager myManager;
	private List<String> popCanNames = new ArrayList<String>();
	private List<Integer> popCanCosts = new ArrayList<Integer>();
	
	@Before
	public void setup() {
	myManager = new MyVendingMachineManager();
	}
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testInvalidButtonPress() {
		myManager.GetVendingMachine().getSelectionButton(7).press();
	}
	@Test
	public void testInsertedWrongCoin() {
		try {
			myManager.GetVendingMachine().getCoinSlot().addCoin(new Coin(3));
		} catch (DisabledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1,myManager.GetCoinSlotListener().coinRejectedCount);
	}
	@Test
	public void testButtonPressed(){
		MyButtonListener listener = new MyButtonListener(myManager);
		myManager.GetVendingMachine().getSelectionButton(0).deregisterAll();
		myManager.GetVendingMachine().getSelectionButton(0).register(listener);
		myManager.GetVendingMachine().getSelectionButton(0).press();
		assertEquals(1,listener.pressedCount);
	}
	
	@Test
	public void testPopBought(){
		MyButtonListener listener = new MyButtonListener(myManager);
		myManager.GetVendingMachine().getSelectionButton(0).deregisterAll();
		myManager.GetVendingMachine().getSelectionButton(0).register(listener);
		Coin testcoin = new Coin(2);
		try {
			myManager.GetVendingMachine().getCoinSlot().addCoin(testcoin);
		} catch (DisabledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myManager.GetVendingMachine().getSelectionButton(0).press();
		assertEquals(1,myManager.GetCurrentCoins().intValue());
	}
	@Test
	public void testPopCanNotEmpty(){
		assertEquals(10,myManager.GetVendingMachine().getPopCanRack(0));
	}

}
