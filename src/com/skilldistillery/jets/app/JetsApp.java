package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.models.Airfield;
import com.skilldistillery.jets.models.CombatAircraft;
import com.skilldistillery.jets.models.Jet;
import com.skilldistillery.jets.models.JetImpl;
import com.skilldistillery.jets.models.TankerAircraft;
import com.skilldistillery.jets.models.TransportAircraft;

public class JetsApp {

	// private String airfield;
	private Scanner kb;
	private Airfield airfield;
	private int menuChoice;

	public static void main(String[] args) {
		JetsApp jetsApp = new JetsApp();
		jetsApp.kb = new Scanner(System.in);
		jetsApp.run();
		jetsApp.kb.close();
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
		do {
			printMenuGetChoice();
			processMenu();
		} while (menuChoice != 10);

		// Print a list of the aircraft at the Airfield
	}

	private void processMenu() {

		switch (menuChoice) {
		case 1:
			airfield.listFleet();
			break;
		case 2:
			airfield.fly();
			break;
		case 3:
			airfield.fastestJet();
			break;
		case 4:
			airfield.longestRangeJet();
			break;
		case 5:
			airfield.loadTransportAircraft();
			airfield.finishLoadingTransportAircraft();
			airfield.fillTankerAircraft();
			airfield.finishFillingTankerAircraft();
			break;
		case 6:
			airfield.loadCombatAircraft();
			airfield.finishloadingCombatAircraft();
			airfield.startDogFight();
			airfield.endDogFight();
			break;
		case 7:
			addCustomJet();
			break;
		case 8:
			removeJet();
		case 9:
			flyChosenJet();
			break;
		case 10:
			break;
		default:
			break;

		}

	}

	private void flyChosenJet() {
		int jetToFly = 0;

		do {

			airfield.listFleet();
			System.out.println("Enter the number of the jet you would like to fly >>");

			try {
				jetToFly = kb.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please try again.");
			}
		} while (jetToFly == 0);

		airfield.chooseJetToFly(jetToFly);
	}

	private void printMenuGetChoice() {

		System.out.println("\nPlease select from the following menu by\nentering the number of your choice.");
		System.out.println("*********************************");
		System.out.println(
				"1) List fleet\n" + "2) Fly all jets\n" + "3) View fastest jet\n" + "4) View jet with longest range\n"
						+ "5) Load all Transport and Tanker Aircraft\n" + "6) Dogfight!\n" + "7) Add a jet to Fleet\n"
						+ "8) Remove a jet from Fleet\n" + "9) Fly a jet of your choice\n" + "10) Quit\n");
		System.out.println("*********************************\n");

		System.out.print("Enter choice >> ");

		try {
			menuChoice = kb.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Try again.");
			kb.nextLine();
		}
		System.out.println();
	}

	private void printWelcome() {
		System.out.println("********************************");
		System.out.println("* Welcome to USAF Jets Program *");
		System.out.println("********************************");
		System.out.println();
	}

	private void removeJet() {
		int jetToRemove;

		airfield.listFleet();

		System.out.println("Please select the number of the jet you would like to remove >> ");

		jetToRemove = kb.nextInt();

		Jet removedJet = new JetImpl();

		removedJet = airfield.removeJet(jetToRemove);

		System.out.println("Removed this jet:\n" + removedJet + "\n");
	}

	public void addCustomJet() {
		String type = "";
		String model = "";
		double speed = 0.0;
		int range = 0;
		long price = 0;
		int choice = 0;

		do {
			System.out.println("What type of jet would you like to add? Select the number of your choice below.");
			System.out.println("*******************");
			System.out.println("1. Transport");
			System.out.println("2. Tanker");
			System.out.println("3. Combat");
			System.out.println("*******************");

			try {
				choice = kb.nextInt();
			} catch (Exception e1) {
				System.out.println("\nInvalid input. Please try again\n");
				kb.nextLine();
			}
		} while (choice != 1 && choice != 2 && choice != 3);

		switch (choice) {
		case 1:
			type = "Transport";
			break;
		case 2:
			type = "Tanker";
			break;
		case 3:
			type = "Combat";
			break;
		}

		do {
			System.out.println("Enter the jet model >> ");
			try {
				model = kb.next();
				System.out.println("Enter the jet's speed >> ");
				speed = kb.nextDouble();
				System.out.println("Enter the jet's range >> ");
				range = kb.nextInt();
				System.out.println("Enter the jet's price >> ");
				range = kb.nextInt();

			} catch (Exception e) {
				System.out.println("\nInvalid input. Please try again.\n");
				kb.nextLine();
				type = "";
				model = "";
				speed = 0.0;
				range = 0;
			}
		} while (model.equals("") && speed == 0.0 && range == 0 && price == 0.0);

		System.out.println("The following jet was added.");
		System.out.println(airfield.addCustomJet(type, model, speed, range, price));

	}

	public List<Jet> populateAirfieldFromFile(String fileName) {

		System.out.println("Populating airfield from file.");

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
					Jet newCombatJet = new CombatAircraft(type, model, speed, range, price);
					jetsList.add(newCombatJet);
				} else if (type.equals("Tanker")) {
					Jet newTankerJet = new TankerAircraft(type, model, speed, range, price);
					jetsList.add(newTankerJet);
				} else if (type.equals("Transport")) {
					Jet newTransportJet = new TransportAircraft(type, model, speed, range, price);
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
