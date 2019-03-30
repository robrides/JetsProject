package com.skilldistillery.jets.models;

import java.util.List;

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

			System.out.println("The fleet: \n");
			
			for (Jet jet : jets) {
				System.out.print("Aircraft Type: " + jet.getType());
				System.out.print(", Model: " + jet.getModel());
				System.out.print(", Speed: " + jet.getSpeed() + " MPH");
				System.out.print(", Range: " + jet.getRange() + " miles");
				System.out.println(", Price: $" + jet.getPrice());
			}			
		}
		
		public void fly() {
			System.out.println();
			for (Jet jet : jets) {
				jet.fly();
			}
		}

		@Override
		public String toString() {
			return "Airfield [jets=" + jets + "]";
		}
		
		
}
