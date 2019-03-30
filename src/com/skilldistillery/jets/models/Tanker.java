package com.skilldistillery.jets.models;

public class Tanker extends Jet {

	public Tanker() {
		super();
	}
	
	public Tanker(String type, String model, double speed, int range, long price) {
		super(type,model,speed,range,price);

	}
	
	public void fly() {
		super.fly();
	}
	
}
