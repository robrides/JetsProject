package com.skilldistillery.jets.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class Airfield {

	private List<Jet> jets;
	private List<Pilot> pilots;

	public Airfield() {
		super();
	}

	public Airfield(List<Jet> jets, List<Pilot> pilots) {
		super();
		this.jets = jets;
		this.pilots = pilots;
	}

	public void listFleet() {
		// List all jets in the Airfield
		System.out.println("The fleet: ");

		for (int i = 0; i < jets.size(); i++) {
			System.out.print(i + 1 + ". " + jets.get(i) + "\n");
		}
		System.out.println();
	}

	public void listPilots() {

		// List all the pilots at the Airfield
		System.out.println("The pilots: ");

		for (int i = 0; i < pilots.size(); i++) {
			System.out.print(i + 1 + ". " + pilots.get(i) + "\n");
		}
		System.out.println();
	}

	public void assignPilotsToAircraft() {

		int rand = 0;
		Set<Integer> randPilotsSet = new TreeSet<>();

		// Place random int in a TreeSet the same size as the jets list. TreeSet ensures
		// no duplicates.
		while (randPilotsSet.size() < jets.size()) {
			rand = (int) (Math.random() * pilots.size());
			randPilotsSet.add(rand);
		}
		// Place the TreeSet into a List so that the get() method may be used in
		// populating the pilot in the jets list
		List<Integer> randPilotsIndexes = new ArrayList<>(randPilotsSet.size());
		randPilotsIndexes.addAll(randPilotsSet);

		for (int i = 0; i < jets.size(); i++) {
			jets.get(i).setPilot(pilots.get(randPilotsIndexes.get(i)).getName());
		}
	}

	public void fly() {
		for (Jet jet : jets) {
			jet.fly();
		}
	}

	public void fastestJet() {

		// Used Optional to determine the highest number in the ArrayList
		Optional<Jet> fastest = jets.stream().max((j1, j2) -> (int) j1.getSpeed() - (int) j2.getSpeed());
		System.out.println("The fastest jet is:\n" + fastest.get() + "\n");

	}

	public void longestRangeJet() {

		// Used Optional to determine the highest number in the ArrayList
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

	public String addCustomJet(int choice, String type, String model, double speed, int range, long price, String pilot) {
		
		switch (choice) {
		case 1:
			Jet newJet = new TransportAircraft(type, model, speed, range, price, pilot);
			jets.add(newJet);
			return newJet.toString();
		case 2:
			Jet newJet2 = new TankerAircraft(type, model, speed, range, price, pilot);
			jets.add(newJet2);
			return newJet2.toString();
		case 3:
			Jet newJet3 = new CombatAircraft(type, model, speed, range, price, pilot);
			jets.add(newJet3);
			return newJet3.toString();
		}

		return "Error while adding jet.";
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

	public void choosePilotToHire(int pilotToHire) {

		for (Pilot pilot : pilots) {
			if (pilot.equals(pilots.get(pilotToHire - 1))) {
				if (pilot.getIsHired().equals("No")) {
					setPilotForJet(pilots.get(pilotToHire - 1));
				} else {
					System.out.println(pilots.get(pilotToHire - 1) + " is hired already.");
				}
			}
		}
	}

	private void setPilotForJet(Pilot pilotToHire) {

		pilotToHire.setIsHired("Yes");
		System.out.println("You have hired " + pilotToHire);
		System.out.println("Pilot status: ");
		listPilots();
		System.out.println();
	}

	public List<Jet> getListOfJets() {
		return jets;
	}

	public String addPilot(String pilotName) {
		
		Pilot p = new PilotImpl(pilotName, "No");
		pilots.add(p);
		return p.toString();
	}
}