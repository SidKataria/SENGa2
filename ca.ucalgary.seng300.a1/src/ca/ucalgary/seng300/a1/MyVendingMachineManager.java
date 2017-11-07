package ca.ucalgary.seng300.a1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.lsmr.vending.PopCan;
import org.lsmr.vending.hardware.CoinChannel;
import org.lsmr.vending.hardware.PopCanRack;
import org.lsmr.vending.hardware.VendingMachine;

public class MyVendingMachineManager {
	
	private List<String> popCanNames = new ArrayList<String>();
	private List<Integer> popCanCosts = new ArrayList<Integer>();
	private MyCoinSlotListener coinSlotListener;
	private MyValidCoinAcceptor validAcceptor;
	private MyInvalidCoinAcceptor invalidAcceptor;

	
	private int[] acceptedCoins = new int[]{1,2};
	private int selectionButtons= 6;
	private int coinRackCapacity = 200;
	private int popCanRackCapacity = 10;
	private int receptacleCapacity = 2;
	
	private int currentCoins = 0;
	
	
	private VendingMachine machine;
	 
	public MyVendingMachineManager(){
		coinSlotListener = new MyCoinSlotListener(this);
		validAcceptor = new MyValidCoinAcceptor();
		invalidAcceptor = new MyInvalidCoinAcceptor();
		
		machine = new VendingMachine(acceptedCoins,selectionButtons,coinRackCapacity,popCanRackCapacity,receptacleCapacity, coinRackCapacity, coinRackCapacity);
		
		for(int i = 0; i < machine.getNumberOfSelectionButtons();i++){
			machine.getSelectionButton(i).register(new MyButtonListener(this));
		}
		
		machine.getDeliveryChute().register(new MyDeliveryChuteListener(this));
		
		machine.getCoinSlot().register(coinSlotListener);
		machine.getCoinSlot().connect(new CoinChannel(validAcceptor), new CoinChannel(invalidAcceptor));
		int racks = machine.getNumberOfPopCanRacks();
		for(int i =0;i<racks;i++){
			machine.getPopCanRack(i).register(new MyPopCanRackListener(this));
		}
		
		popCanNames.add("Pepsi");
		popCanCosts.add(1);
		popCanNames.add("Sprite");
		popCanCosts.add(2);
		popCanNames.add("Uludag");
		popCanCosts.add(2);
		popCanNames.add("Mountain Dew");
		popCanCosts.add(3);
		popCanNames.add("Coca Cola");
		popCanCosts.add(3);
		popCanNames.add("Fanta");
		popCanCosts.add(2);
		machine.configure(popCanNames, popCanCosts);
		machine.loadPopCans(10,10,10,10,10,0);
		
		machine.getCoinReceptacle().register(new MyCoinReceptacleListener(this));

	}

	public VendingMachine GetVendingMachine(){
		return this.machine;
	}
	
	public Integer GetCurrentCoins(){
		return this.currentCoins;
	}
	public void SetCurrentCoins(int amount){
		this.currentCoins = amount;
	}
	public MyCoinSlotListener GetCoinSlotListener(){
		return this.coinSlotListener;
	}
}
