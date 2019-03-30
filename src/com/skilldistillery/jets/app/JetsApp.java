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
import com.skilldistillery.jets.models.Transport;

public class JetsApp {

	//private String airfield;
	private Scanner kb;
	private Airfield airfield; 
	private int menuChoice;
	
	
	public static void main(String[] args) {
		JetsApp jetsApp = new JetsApp();
		jetsApp.kb = new Scanner(System.in);
		jetsApp.run();
	}

	// Main application functionality execution
	private void run() {

		printWelcome();
		// this.airfield = this.kb.nextLine();
		
		// Read in aircraft from file and populate List
		List<Jet> jetsList = populateAirfieldFromFile("initialData.txt");
		
		// Instantiate a new Airfield instance and fill with fleet of jets
		airfield = new Airfield(jetsList);
		
		// Display menu to the user
		printMenuGetChoice();
		
		processMenu();
		
		// Print a list of the aircraft at the Airfield
	}
	
	private void processMenu() {

		switch(menuChoice) {
		case 1:
			airfield.listFleet();
			break;
		case 2:
			airfield.fly();
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			default:
				break;		
			
		}
		
	}

	private void printMenuGetChoice() {
		
		System.out.println("Please select from the following menu by entering the number of your choice.\n");
		System.out.println("*********************************");
		System.out.println("1) List fleet\n" + 
				"2) Fly all jets\n" + 
				"3) View fastest jet\n" + 
				"4) View jet with longest range\n" + 
				"5) Load all Cargo Jets\n" + 
				"6) Dogfight!\n" + 
				"7) Add a jet to Fleet\n" + 
				"8) Remove a jet from Fleet\n" + 
				"9) Quit");
		System.out.println("*********************************\n");
		System.out.print("Enter choice >> ");
		menuChoice = kb.nextInt();
		
	}
	
	private void printWelcome() {
		System.out.println("********************************");
		System.out.println("* Welcome to USAF Jets Program *");
		System.out.println("********************************");
		System.out.println();
	}

	public List<Jet> populateAirfieldFromFile(String fileName) {

		System.out.println("Populating airfield from file.\n");
		
		// Create list of jets
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
					Jet newTransportJet = new Transport(type, model, speed, range, price);
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
