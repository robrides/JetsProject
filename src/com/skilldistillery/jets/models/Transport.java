package com.skilldistillery.jets.models;

public class Transport extends Jet{

	public Transport() {
		super();
	}
	
	public Transport(String type, String model, double speed, int range, long price) {
		super(type,model,speed,range,price);

	}
	
	public void fly() {
		super.fly();
	}
}
