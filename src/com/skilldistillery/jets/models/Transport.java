package com.skilldistillery.jets.models;

public class Transport extends Jet{

	public Transport() {
		super();
	}
	
	public Transport(String type, String model, double speed, int range, long price) {
		super(type,model,speed,range,price);

	}
	
	public void fly() {
		System.out.print("Type: " + getType() + ", Model: " + getModel() + ", Speed: " + getSpeed() + ", Range: "
				+ getRange() + ", Flight Time: ");
		System.out.printf("%.2f", ((getRange() / getSpeed())));
		System.out.print(" hours.");
		System.out.println("\nAirborne and bringing the boots, beans, and bullets!\n");
	}
}
