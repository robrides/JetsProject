package com.skilldistillery.jets.models;

public class Combat extends Jet{

	public Combat() {
		super();
	}
	
	public Combat(String type, String model, double speed, int range, long price) {
		super(type,model,speed,range,price);

	}
	
	public void fly() {
		super.fly();
	}
	
}
