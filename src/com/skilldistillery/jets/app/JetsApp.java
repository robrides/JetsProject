package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.models.Airfield;
import com.skilldistillery.jets.models.CombatAircraft;
import com.skilldistillery.jets.models.Jet;
import com.skilldistillery.jets.models.JetImpl;
import com.skilldistillery.jets.models.Pilot;
import com.skilldistillery.jets.models.PilotImpl;
import com.skilldistillery.jets.models.TankerAircraft;
import com.skilldistillery.jets.models.TransportAircraft;

public class JetsApp {

	// private String airfield;
	private Scanner kb;
	private Airfield airfield;
	private int menuChoice;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		JetsApp jetsApp = new JetsApp();
		jetsApp.kb = new Scanner(System.in);
		jetsApp.run();
		jetsApp.kb.close();
	}

	// Main application functionality execution
	private void run() throws FileNotFoundException, IOException {

		printWelcome();
		// this.airfield = this.kb.nextLine();
		initiateApplication();

		do {
			// Display menu to the user and get choice
			printMenuGetChoice();
			processMenu();
		} while (menuChoice != 16);
	}

	private void initiateApplication() throws FileNotFoundException, IOException {

		System.out.println(
				"Note: Filenames requested below are:\nAirfield: initialData.txt\nPilots: pilotData.txt\nThese must be entered accurately for the application to contine.\n\n");

		// Instantiate, read in, and populate aircraft into the Airfield List from file
		List<Jet> jetsList = populateJetsFromFile();

		// Instantiate, read in, and populate pilots into the Pilot List from file
		List<Pilot> pilotsList = populatePilotsFromFile();

		// Instantiate a new Airfield instance and fill with fleet of jets
		airfield = new Airfield(jetsList, pilotsList);

		// Randomly assign pilots to aircraft
		airfield.assignPilotsToAircraft();
	}

	private void processMenu() {

		switch (menuChoice) {
		case 1:
			// Print a list of the aircraft at the Airfield
			airfield.listFleet();
			break;
		case 2:
			// Fly all aircraft in the airfield
			airfield.fly();
			break;
		case 3:
			// Search for the fastest aircraft
			airfield.fastestJet();
			break;
		case 4:
			airfield.longestRangeJet();
			// Search for the aircraft with the longest range
			break;
		case 5:
			airfield.loadTransportAircraft();
			airfield.finishLoadingTransportAircraft();
			break;
		case 6:
			airfield.fillTankerAircraft();
			airfield.finishFillingTankerAircraft();
			break;
		case 7:
			airfield.loadCombatAircraft();
			airfield.finishloadingCombatAircraft();
			break;
		case 8:
			airfield.startDogFight();
			airfield.endDogFight();
			break;
		case 9:
			addCustomJet();
			break;
		case 10:
			removeJet();
			break;
		case 11:
			flyChosenJet();
			break;
		case 12:
			airfield.listPilots();
			break;
		case 13:
			addPilot();
			break;
		case 14:
			hirePilot();
			break;
		case 15:
			writeJetsToFile();
			break;
		case 16:
			break;
		default:
			break;

		}

	}

	private void writeJetsToFile() {
		boolean successfulFileIO = true;
		String fileName;

		do {
			System.out.println("Please enter the desired filename for the output >> ");
			fileName = kb.next();

			try {
				if (!fileName.equals("initialData.txt")) {
					FileWriter fw = new FileWriter(fileName);
					PrintWriter pw = new PrintWriter(fw);
					for (Jet jet : airfield.getListOfJets()) {
						pw.println(jet);
					}
					System.out.println("\nFile written successfully.\n");
					pw.close();

				} else {
					System.out.println("Filename already in use. Please try again.");
					break;
				}
			} catch (FileAlreadyExistsException e) {
				System.err.println("File name already in use. Please try again.");
				successfulFileIO = false;
			} catch (IOException e) {
				System.err.println("File name not available. Please try again.");
				successfulFileIO = false;
			}
		} while (successfulFileIO == false);
	}

	private void hirePilot() {
		int pilotToHire = 0;

		do {
			airfield.listPilots();

			System.out.println("Which pilot would you like to hire?");
			System.out.println("Enter the number of your choice >> ");

			try {
				pilotToHire = kb.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid input. Please try again.");
			}
		} while (pilotToHire == 0);

		airfield.choosePilotToHire(pilotToHire);
	}

	private void flyChosenJet() {
		int jetToFly = 0;

		do {

			airfield.listFleet();
			System.out.println("Enter the number of the jet you would like to fly >>");

			try {
				jetToFly = kb.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid input. Please try again.");
			}
		} while (jetToFly == 0);

		airfield.chooseJetToFly(jetToFly);
	}

	private void printMenuGetChoice() {

		System.out.println("\nPlease select from the following menu by\nentering the number of your choice.");
		System.out.println("*********************************");
		System.out.println(
				"1) List fleet and assigned pilots\n" + "2) Fly all jets\n" + "3) View fastest jet\n" + "4) View jet with longest range\n"
						+ "5) Load all Transport Aircraft\n" + "6) Fill all Tanker Aircraft\n"
						+ "7) Load all Combat Aircraft\n" + "8) Dogfight!\n" + "9) Add a jet to Fleet\n"
						+ "10) Remove a jet from Fleet\n" + "11) Fly a jet of your choice\n" + "12) List Pilots\n"
						+ "13) Add Pilot\n" + "14) Hire Pilot\n" + "15) Output Jets to file\n" + "16) Quit\n");
		System.out.println("*********************************\n");

		System.out.print("Enter choice >> ");

		try {
			menuChoice = kb.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Invalid input. Try again.");
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

	private void addCustomJet() {
		String type = "";
		String model = "";
		String pilot = "no pilot";
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
				System.err.println("\nInvalid input. Please try again\n");
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
				price = kb.nextLong();

			} catch (Exception e) {
				System.err.println("\nInvalid input. Please try again.\n");
				kb.nextLine();
				type = "";
				model = "";
				speed = 0.0;
				range = 0;
			}
		} while (model.equals("") && speed == 0.0 && range == 0 && price == 0.0);

		System.out.println("The following jet was added.");
		System.out.println(airfield.addCustomJet(choice, type, model, speed, range, price, pilot));

	}

	private void addPilot() {

		String pilotName = "";

			System.out.println("Enter the pilot's name >> ");
				pilotName = kb.next();
				kb.nextLine();

		System.out.println("The following pilot was added.");
		System.out.println(airfield.addPilot(pilotName));
	}

	private List<Pilot> populatePilotsFromFile() throws FileNotFoundException, IOException {
		boolean successfulFileIO = true;
		String fileName = "";

		// Create list of pilots
		List<Pilot> pilotsList = new ArrayList<>();

		do {
			System.out.println("What file will be used to populate the Pilots?");
			System.out.print("File name >> ");
			fileName = kb.nextLine();

			try {
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					String[] pilotField = line.split(";");
					String name = pilotField[0];
					String isHired = pilotField[1];

					Pilot newPilot = new PilotImpl(name, isHired);
					pilotsList.add(newPilot);
				}

				br.close();
			} catch (FileNotFoundException e) {
				successfulFileIO = false;
				System.err.print("Invalid filename. Please try again.\n");
				kb.nextLine();
			} catch (IOException e) {
				successfulFileIO = false;
				System.err.print("Invalid filename. Please try again.\n");
				kb.nextLine();
			}
		} while (successfulFileIO = false);

		return pilotsList;
	}

	private List<Jet> populateJetsFromFile() throws FileNotFoundException, IOException {

		boolean successfulFileIO = true;
		String fileName = "";

		// Create list of jets
		List<Jet> jetsList = new ArrayList<>();

		do {

			System.out.println("What file will be used to populate the Airfield?");
			System.out.print("File name >> ");
			fileName = kb.nextLine();

			try {
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					String[] jetField = line.split(";");
					String type = jetField[0];
					String model = jetField[1];
					double speed = Double.parseDouble(jetField[2]);
					int range = Integer.parseInt(jetField[3]);
					long price = Long.parseLong(jetField[4]);
					String pilot = jetField[5];

					if (type.equals("Combat")) {
						Jet newCombatJet = new CombatAircraft(type, model, speed, range, price, pilot);
						jetsList.add(newCombatJet);
					} else if (type.equals("Tanker")) {
						Jet newTankerJet = new TankerAircraft(type, model, speed, range, price, pilot);
						jetsList.add(newTankerJet);
					} else if (type.equals("Transport")) {
						Jet newTransportJet = new TransportAircraft(type, model, speed, range, price, pilot);
						jetsList.add(newTransportJet);
					}

				}
				br.close();
			} catch (FileNotFoundException e) {
				successfulFileIO = false;
				System.err.print("Invalid filename. Please try again.\n");
				kb.nextLine();
			} catch (IOException e) {
				successfulFileIO = false;
				System.err.print("Invalid filename. Please try again.\n");
				kb.nextLine();
			}
		} while (successfulFileIO = false);

		return jetsList;
	}

}
