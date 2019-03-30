package com.skilldistillery.jets.models;

public class Transport extends Jet{

	public Transport() {
		super();
	}
	
	public Transport(String type, String model, double speed, int range, long price) {
		super(type,model,speed,range,price);

	}
	
	public void fly() {
		System.out.print(this.getModel());
		System.out.println(": Airborne and bringing the boots, beans, and bullets!");
	}
}
