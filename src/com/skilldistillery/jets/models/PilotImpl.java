package com.skilldistillery.jets.models;

public class PilotImpl extends Pilot {
	
	public PilotImpl() {
		super();
	}

	public PilotImpl(String name, String isHired) {
		super(name, isHired);
	}

	@Override
	public String toString() {
		return "Name: " + getName() + ", Hired Already: " + getIsHired();
	}
	
}
