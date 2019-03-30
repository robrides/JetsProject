package com.skilldistillery.jets.models;

public class CombatAircraft extends Jet implements CombatReady {
	boolean msnStatus;
	boolean dogFightStatus;

	public CombatAircraft() {
		super();
	}

	public CombatAircraft(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);

	}

	public void fly() {
		System.out.print("Type: " + getType() + ", Model: " + getModel() + ", Speed: " + getSpeed() + ", Range: "
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
		System.out.println("Combat aircraft " + getModel() + ", loading missiles.");
	}

	private void munitionsLoaded() {
		System.out.println("Combat aircraft " + getModel() + ", ready to fight!");
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
	
	private void startAttack() {
		System.out.println(getModel() + " reports, enemy in sights. Missles deployed.");
	}

	private void enemyEliminated() {
		System.out.println(getModel() + " reports, threat neutralized!");
	}

}
