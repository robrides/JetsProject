package com.skilldistillery.jets.models;

public class TankerAircraft extends Jet implements TransportAndTankerLoad {

	private boolean loaded;

	public TankerAircraft() {
		super();
	}

	public TankerAircraft(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);

	}

	public void fly() {
		System.out.print("Type: " + getType() + ", Model: " + getModel() + "\nSpeed: " + getSpeed() + ", Range: "
				+ getRange() + ", Flight Time: ");
		System.out.printf("%.2f", ((getRange() / getSpeed())));
		System.out.print(" hours.");
		System.out.println("\nAirborne and ready to pump gas!\n");
	}

	@Override
	public boolean loaded() {
		return loaded;
	}

	@Override
	public void loading() {
		loaded = false;
		startFilling();
	}

	@Override
	public void loadingComplete() {
		loaded = true;
		fullOfFuel();
	}

	private void startFilling() {
		System.out.println("Tanker " + getModel() + ", loading gas.");
	}

	private void fullOfFuel() {
		System.out.println("Tanker " + getModel() + ", ready to pump gas.");
	}
}