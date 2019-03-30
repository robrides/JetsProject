package com.skilldistillery.jets.models;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

			Collections.sort(jets, new SortBySpeed());
			System.out.println("The fastest jet is:\n" + jets.get(0));
			
			//			Set<String> fastest = new TreeSet<>();
//			
//			for (Jet jet : jets) {
//				fastest.add(Double.toString(jet.getSpeed()));
//			}
//			System.out.println(fastest);
			
		}
		
		public void sortAirfieldByInput() {
			
			Collections.sort(jets, new SortBySpeed());
			
			for (int i = 0; i <  jets.size(); i++) {
				System.out.println(jets.get(i));
			}
			
		}

		@Override
		public String toString() {
			return "Airfield [jets=" + jets + "]";
		}
		
		
}
