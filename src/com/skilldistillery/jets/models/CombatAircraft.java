package com.skilldistillery.jets.models;

public class CombatAircraft extends Jet implements CombatReady {
	private boolean msnStatus;
	private boolean dogFightStatus;

	public CombatAircraft() {
		super();
	}

	public CombatAircraft(String type, String model, double speed, int range, long price, String pilot) {
		super(type, model, speed, range, price, pilot);

	}

	public void fly() {
		System.out.print(this.getClass().getSimpleName() + ": " +  ", Model: " + getModel() + "\nSpeed: " + getSpeed() + ", Range: "
				+ getRange() + ", Flight Time: ");
		System.out.printf("%.2f", ((getRange() / getSpeed())));
		System.out.print(" hours.");
		System.out.println("\nAirborne and ready to engage!\n");
	}

	@Override
	public boolean readyForCombat() {
		return msnStatus;
	}

	@Override
	public void munitionsLoading() {
		msnStatus = false;
		loadingMunitions();
	}

	@Override
	public void munitionsOnboard() {
		munitionsLoaded();
	}

	private void loadingMunitions() {
		System.out.println(this.getClass().getSimpleName() + ": " + getModel() + ", loading missiles.");

	}

	private void munitionsLoaded() {
		System.out.println(this.getClass().getSimpleName() + ": " + getModel() + " Missiles loaded.");
	}
	
	private void startAttack() {
		System.out.println(this.getClass().getSimpleName() + ": " + getModel() + " reports, enemy in sights. Missles deployed.");
	}
	
	private void enemyEliminated() {
		System.out.println(this.getClass().getSimpleName() + ": " + getModel() + " reports, threat neutralized!");
	}

	@Override
	public boolean engagedInDogfight() {
		return dogFightStatus;
	}

	@Override
	public void attack() {
		dogFightStatus = true;
		startAttack();
	}

	@Override
	public void disengage() {
		dogFightStatus = false;
		enemyEliminated();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (dogFightStatus ? 1231 : 1237);
		result = prime * result + (msnStatus ? 1231 : 1237);
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
		CombatAircraft other = (CombatAircraft) obj;
		if (dogFightStatus != other.dogFightStatus)
			return false;
		if (msnStatus != other.msnStatus)
			return false;
		return true;
	}
	
}