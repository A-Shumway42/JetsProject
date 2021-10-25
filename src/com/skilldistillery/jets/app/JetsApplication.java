package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoCarrier;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.CombatReady;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;
import com.skilldistillery.jets.entities.PassengerJet;

public class JetsApplication {

	private AirField airfield;

	public static void main(String[] args) {
		JetsApplication jetApp = new JetsApplication();
		jetApp.run();
	}

	public void run() {
		Scanner input = new Scanner(System.in);
		createAirField();
		chooseMenu(input);
	}

	public void createAirField() {
		this.airfield = new AirField();
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetLines = line.split(",");
				Jet jet = jetCreator(jetLines);
				if (jet != null) {
					this.airfield.addJetToFleet(jet);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	private Jet jetCreator(String[] jetData) {
		String jetType = jetData[0];
		String model = jetData[1];
		double speed = Double.parseDouble(jetData[2]);
		int range = Integer.parseInt(jetData[3]);
		long price = Long.parseLong(jetData[4]);
		if (jetType.equals("Fighter Jet")) {
			FighterJet jet = new FighterJet(model, speed, range, price);
			return jet;
		} else if (jetType.equals("Cargo Plane")) {
			CargoPlane jet = new CargoPlane(model, speed, range, price);
			return jet;
		} else if (jetType.equals("Passenger Jet")) {
			PassengerJet jet = new PassengerJet(model, speed, range, price);
			return jet;
		} else if (jetType.equals("JetImpl")) {
			JetImpl jet = new JetImpl(model, speed, range, price);
			return jet;
		} else {
			Jet jet = null;
			return jet;
		}
	}

	public void createMenu() {
		System.out.println("*****************************");
		System.out.println("1. List Fleet");
		System.out.println("2. Fly All Jets");
		System.out.println("3. View Fastest Jet");
		System.out.println("4. View Jet With Longest Range");
		System.out.println("5. Load All Cargo Jets");
		System.out.println("6. Dogfight!");
		System.out.println("7. Add A Jet To Fleet.");
		System.out.println("8. Remove A Jet From Fleet.");
		System.out.println("9. Quit");
		System.out.println("****************************");
	}

	public void chooseMenu(Scanner input) {
		boolean keepGoing = true;
		while (keepGoing) {
			createMenu();
			int choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				listFleet();
				break;
			case 2:
				flyAllJets();
				break;
			case 3:
				viewFastestJet();
				break;
			case 4:
				viewJetWithLongestRange();
				break;
			case 5:
				loadAllCargoJets();
				break;
			case 6:
				dogFight();
				break;
			case 7:
				addJetToFleet(input);
				break;
			case 8:
				removeJetFromFleet(input);
				break;
			case 9:
				System.out.println("Closing app. Thank You!");
				keepGoing = false;
				break;
			default:
				System.out.println("Invalid selection. Please choose available options.");
				break;
			}
		}
	}

	public void listFleet() {
		for (Jet jet : this.airfield.getFleet()) {
			System.out.println(jet.toString());
		}
	}

	public void flyAllJets() {
		for (Jet jet : this.airfield.getFleet()) {
			jet.fly();

		}

	}

	public void viewFastestJet() {
		double maxSpeed = 0.0;
		Jet fastestJet = null;
		for (Jet jet : this.airfield.getFleet()) {
			if (jet.getSpeed() > maxSpeed) {
				maxSpeed = jet.getSpeed();
				fastestJet = jet;
			}

		}
		if (fastestJet != null) {
			System.out.println("Fastest Jet: " + fastestJet.toString());
		} else {
			System.out.println("Error: Finding fastest Jet");
		}

	}

	public void viewJetWithLongestRange() {
		int maxRange = 0;
		Jet longestRangeJet = null;
		for (Jet jet : this.airfield.getFleet()) {
			if (jet.getRange() > maxRange) {
				maxRange = jet.getRange();
				longestRangeJet = jet;
			}

		}
		if (longestRangeJet != null) {
			System.out.println("Jet With Longest Range: " + longestRangeJet.toString());
		} else {
			System.out.println("Error: Finding Longest Ranged Jet");
		}

	}

	public void loadAllCargoJets() {
		int jetNumber = 1;
		for (Jet jet : this.airfield.getFleet()) {
			if (jet instanceof CargoCarrier) {
				System.out.println("Permission to load cargo plane #" + jetNumber++);
				System.out.println(jet.toString());
				((CargoCarrier) jet).loadCargo();
			}

		}

	}

	public void dogFight() {
		int jetNumber = 1;
		for (Jet jet : this.airfield.getFleet()) {
			if (jet instanceof CombatReady) {
				System.out.println("Permission to deploy fighter jet #" + jetNumber++);
				System.out.println(jet.toString());
				((CombatReady) jet).fight();
			}

		}

	}

	public void addJetToFleet(Scanner input) {
		System.out.println("Please create a cargo plane.");
		System.out.println("What is the model of the plane?");
		String model = input.nextLine();
		System.out.println("What is the speed of the plane?");
		double speed = input.nextDouble();
		System.out.println("What is the range of the plane?");
		int range = input.nextInt();
		System.out.println("What is the price of the plane?");
		long price = input.nextLong();
		airfield.addJetToFleet(new CargoPlane(model, speed, range, price));
		System.out.println("Cargo Plane successfully added to fleet!");

	}

	public void removeJetFromFleet(Scanner input) {
		System.out.println("Which Jet would you like to remove from fleet?");
		int index = 1;
		for (Jet jet : this.airfield.getFleet()) {
			System.out.println(index++ + ": " + jet.toString());
		}
		System.out.println("Input jet number to remove from fleet.");
		index = input.nextInt();
		airfield.getFleet().remove(index - 1);
		System.out.println("Jet successfully removed from fleet!");

	}

}
