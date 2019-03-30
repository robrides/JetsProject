package com.skilldistillery.jets.models;

public class Combat extends Jet{

	public Combat() {
		super();
	}
	
	public Combat(String type, String model, double speed, int range, long price) {
		super(type,model,speed,range,price);

	}
	
	public void fly() {
		System.out.print(this.getModel());
		System.out.println(": Airborne and ready to engage!");
	}
	
}
