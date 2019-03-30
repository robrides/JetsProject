package com.skilldistillery.jets.models;

public class Combat extends Jet implements CombatReady {

	public Combat() {
		super();
	}

	public Combat(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);

	}

	public void fly() {
		System.out.print("Type: " + getType() + ", Model: " + getModel() + ", Speed: " + getSpeed() + ", Range: "
				+ getRange() + ", Flight Time: ");
		System.out.printf("%.2f", ((getRange() / getSpeed())));
		System.out.print(" hours.");
		System.out.println("\nAirborne and ready to engage!\n");
	}

	@Override
	public boolean readyToFight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void munitionsLoading() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void msnCapable() {
		// TODO Auto-generated method stub
		
	}

}
