package com.skilldistillery.jets.models;

public class JetImpl extends Jet {

	public JetImpl() {
		super();
	}

	public JetImpl(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.print("Type: " + getType() + ", Model: " + getModel() + "\nSpeed: " + getSpeed() + ", Range: "
				+ getRange() + ", Flight Time: ");
		System.out.printf("%.2f", ((getRange() / getSpeed())));
		System.out.print(" hours.");
		System.out.println("\nCustom bird airborne.\n");
	}

}