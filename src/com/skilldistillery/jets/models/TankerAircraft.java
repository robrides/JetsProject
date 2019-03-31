package com.skilldistillery.jets.models;

public class TankerAircraft extends Jet implements TransportAndTankerLoad {

	private boolean loaded;

	public TankerAircraft() {
		super();
	}

	public TankerAircraft(String type, String model, double speed, int range, long price, String pilot) {
		super(type, model, speed, range, price, pilot);

	}
	
	public void fly() {
		System.out.print(this.getClass().getSimpleName() + ": " + ", Model: " + getModel() + "\nSpeed: " + getSpeed() + ", Range: "
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
		System.out.println(this.getClass().getSimpleName() + ": " + getModel() + ", loading gas.");
	}

	private void fullOfFuel() {
		System.out.println(this.getClass().getSimpleName() + ": " + getModel() + ", ready to pump gas.");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (loaded ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TankerAircraft other = (TankerAircraft) obj;
		if (loaded != other.loaded)
			return false;
		return true;
	}
	
}