package com.skilldistillery.jets.models;

import java.util.Collections;
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
			
			for (Jet jet : jets) {
				System.out.print("Aircraft Type: " + jet.getType());
				System.out.print(", Model: " + jet.getModel());
				System.out.print(", Speed: " + jet.getSpeed() + " MPH");
				System.out.print(", Range: " + jet.getRange() + " miles");
				System.out.println(", Price: $" + jet.getPrice());
			}			
		}
		
		public void fly() {
			for (Jet jet : jets) {
				jet.fly();
			}
		}
		
		public void fastestJet() {

			Optional<Jet> fastest = jets.stream()
                    .max((j1, j2) -> (int) j1.getSpeed() - (int) j2.getSpeed());
			// Collections.sort(jets, new SortBySpeed());
			System.out.println("The fastest jet is:\n" + fastest);
			
		}
		
		public void longestRangeJet() {

			Optional<Jet> longestRange = jets.stream()
                    .max((j1, j2) -> j1.getRange() - j2.getRange());
			// Collections.sort(jets, new SortByRange());
			System.out.println("The longest range jet is:\n" + longestRange);
			
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
					// if ((boolean) trnsptLoad.msnReady()){
					((TransportAircraft) trnsptLoad).loadingComplete();
					// }
				}
			}
		}
		
		public void fillTankerAircraft() {
			
			for (Jet tankerFill : jets) {
				
				if (tankerFill instanceof TankerAircraft) {
					
					((TankerAircraft) tankerFill).loading();;
				}
			}
		}

		public void finishFillingTankerAircraft() {
			for (Jet tankerFill : jets) {
				
				if (tankerFill instanceof TankerAircraft) {
					// if ((boolean) trnsptLoad.msnReady()){
					((TankerAircraft) tankerFill).loadingComplete();
					// }
				}
			}
		}	
		
		public void loadCombatAircraft() {
			
			for (Jet combatLoad : jets) {
				
				if (combatLoad instanceof CombatAircraft) {
					
					((CombatAircraft) combatLoad).munitionsLoading();
				}
			}
		}

		public void finishloadingCombatAircraft() {
			for (Jet combatLoad : jets) {
				
				if (combatLoad instanceof CombatAircraft) {
					// if ((boolean) trnsptLoad.msnReady()){
					((CombatAircraft) combatLoad).munitionsOnboard();
					// }
				}
			}
		}
		
		public void startDogFight() {
			
			for (Jet goToCombat : jets) {
				
				if (goToCombat instanceof CombatAircraft) {
				//	if ((boolean) goToCombat.msnReady()){
						((CombatAircraft) goToCombat).attack();
				//	}
					
				}
			}
		}
		
		public void endDogFight() {
			
			for (Jet goToCombat : jets) {
				
				if (goToCombat instanceof CombatAircraft) {
					
					((CombatAircraft) goToCombat).disengage();
				}
			}
		}
}
