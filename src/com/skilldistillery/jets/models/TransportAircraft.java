package com.skilldistillery.jets.models;

public class TransportAircraft extends Jet implements TransportAndTankerLoad {

	boolean loaded;

	public TransportAircraft() {
		super();
	}

	public TransportAircraft(String type, String model, double speed, int range, long price, String pilot) {
		super(type, model, speed, range, price, pilot);

	}

	public void fly() {
		System.out.print(this.getClass().getSimpleName() + ": " +  ", Model: " + getModel() + "\nSpeed: " + getSpeed() + ", Range: "
				+ getRange() + ", Flight Time: ");
		System.out.printf("%.2f", ((getRange() / getSpeed())));
		System.out.print(" hours.");
		System.out.println("\nAirborne and bringing the boots, beans, and bullets!\n");
	}

	@Override
	public boolean loaded() {
		return loaded;
	}

	@Override
	public void loading() {
		loaded = false;
		this.startLoading();
	}

	@Override
	public void loadingComplete() {
		loaded = true;
		this.finishedLoading();
	}

	private void startLoading() {
		System.out.println(this.getClass().getSimpleName() + ": " + getModel() + ", loading boots, bullets, and beans.");
	}

	private void finishedLoading() {
		System.out.println(this.getClass().getSimpleName() + ": " + getModel() + ", ready to deliver boots, bullets, and beans.");
	}

}