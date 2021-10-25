package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> fleet;

	public AirField() {
		this.fleet = new ArrayList<>();
	}

	public void addJetToFleet(Jet jet) {
		this.fleet.add(jet);

	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}
	

}
