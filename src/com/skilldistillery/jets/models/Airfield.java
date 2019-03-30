package com.skilldistillery.jets.models;

import java.util.List;
import java.util.Optional;

public class Airfield {

	private List<Jet> jets;

	public Airfield() {
		super();
	}

	public Airfield(List<Jet> jets) {
		super();
		this.jets = jets;
	}

	public void listFleet() {

		System.out.println("The fleet: ");

		// for (Jet jet : jets) {
		for (int i = 0; i < jets.size(); i++) {
			System.out.print(i + 1 + ". " + jets.get(i) + "\n");

		}
		System.out.println();
	}

	public void fly() {
		for (Jet jet : jets) {
			jet.fly();
		}
	}

	public void fastestJet() {

		Optional<Jet> fastest = jets.stream().max((j1, j2) -> (int) j1.getSpeed() - (int) j2.getSpeed());
		System.out.println("The fastest jet is:\n" + fastest.get() + "\n");

	}

	public void longestRangeJet() {

		Optional<Jet> longestRange = jets.stream().max((j1, j2) -> j1.getRange() - j2.getRange());
		System.out.println("The longest range jet is:\n" + longestRange.get() + "\n");

	}

	@Override
	public String toString() {
		return "Airfield [jets=" + jets + "]";
	}

	public void loadTransportAircraft() {

		for (Jet trnsptLoad : jets) {
			if (trnsptLoad instanceof TransportAircraft) {
				((TransportAircraft) trnsptLoad).loading();
			}
		}
	}

	public void finishLoadingTransportAircraft() {

		for (Jet trnsptLoad : jets) {
			if (trnsptLoad instanceof TransportAircraft) {
				((TransportAircraft) trnsptLoad).loadingComplete();
			}
		}
	}

	public void fillTankerAircraft() {

		for (Jet tankerFill : jets) {
			if (tankerFill instanceof TankerAircraft) {
				((TankerAircraft) tankerFill).loading();
				;
			}
		}
	}

	public void finishFillingTankerAircraft() {

		for (Jet tankerFill : jets) {
			if (tankerFill instanceof TankerAircraft) {
				((TankerAircraft) tankerFill).loadingComplete();
			}
		}
	}

	public void loadCombatAircraft() {

		for (Jet combatLoad : jets) {
			if (combatLoad instanceof CombatReady) {
				((CombatReady) combatLoad).munitionsLoading();
			}
		}
	}

	public void finishloadingCombatAircraft() {
		for (Jet combatLoad : jets) {

			if (combatLoad instanceof CombatReady) {
				((CombatReady) combatLoad).munitionsOnboard();
			}
		}
	}

	public void startDogFight() {

		for (Jet goToCombat : jets) {
			if (goToCombat instanceof CombatReady) {
				((CombatReady) goToCombat).attack();
			}
		}
	}

	public void endDogFight() {

		for (Jet goToCombat : jets) {
			if (goToCombat instanceof CombatReady) {
				((CombatReady) goToCombat).disengage();
			}
		}
	}

	public Jet addCustomJet(String type, String model, double speed, int range, long price) {

		Jet newJet = new JetImpl(type, model, speed, range, price);
		jets.add(newJet);
		return newJet;

	}

	public Jet removeJet(int jetToRemove) {
		Jet jetRemoved;
		jetRemoved = jets.remove(jetToRemove - 1);
		return jetRemoved;
	}

	public void chooseJetToFly(int jetToFly) {
		
		for (Jet jet : jets) {
			if (jet.equals(jets.get(jetToFly - 1))) {
				jet.fly();
			}
		}
	}
}