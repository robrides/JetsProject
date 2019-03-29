package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.models.Airfield;
import com.skilldistillery.jets.models.Combat;
import com.skilldistillery.jets.models.Jet;
import com.skilldistillery.jets.models.Tanker;

public class JetsApp {

	//private String airfield;
	private Scanner kb;
	Airfield airfield; 
	
	public static void main(String[] args) {
		JetsApp jetsApp = new JetsApp();
		jetsApp.kb = new Scanner(System.in);
		jetsApp.run();
	}

	private void run() {

		List<Jet> jetsList = populateAirfieldFromFile("initialData.txt");
		System.out.println("********************************");
		System.out.println("* Welcome to USAF Jets Program *");
		System.out.println("********************************");
		System.out.println();
		// this.airfield = this.kb.nextLine();
		airfield = new Airfield(jetsList);
		airfield.listFleet();
	}

	public List<Jet> populateAirfieldFromFile(String fileName) {

		List<Jet> jetsList = new ArrayList<>();
		

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;
			int lineNum = 0;
			while ((line = br.readLine()) != null) {
				lineNum++;
				String[] jetField = line.split(";");
				String type = jetField[0];
				String model = jetField[1];
				// String payloadType = jetField[2];
				double speed = Double.parseDouble(jetField[2]);
				int range = Integer.parseInt(jetField[3]);
				long price = Long.parseLong(jetField[4]);
				// boolean msnReady = Boolean.parseBoolean(jetField[6]);

				if (type.equals("Combat")) {
					Jet newCombatJet = new Combat(type, model, speed, range, price);
					jetsList.add(newCombatJet);
				} else if (type.equals("Tanker")) {

					Jet newTankerJet = new Tanker(type, model, speed, range, price);
					jetsList.add(newTankerJet);
				} else if (type.equals("Transport")) {

					Jet newTransportJet = new Tanker(type, model, speed, range, price);
					jetsList.add(newTransportJet);
				}

			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
			// return;
		} catch (IOException e) {
			System.err.println("Problem while reading " + fileName + ": " + e.getMessage());
			// return;
		}
		return jetsList;
	}

}
