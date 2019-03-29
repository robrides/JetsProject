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
			
			System.out.println(jets);
			
		}
}
