package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier {
	private String model;
	private double speed;
	private int range;
	private long price;

	public CargoPlane() {
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;

	}
	
	@Override
	public void loadCargo() {
		System.out.println("Loading cargo plane.");
		System.out.println("Loading complete!");
	}
	
	@Override
	public void fly() {
		System.out.println("Jet Details: Model: " + model + ", Speed: " + speed + "mph, Range: " + range + "mi., Price: $" + price);
		double timeToFly = range / speed;
		System.out.println("Based on speed and range, this jet can fly for " + timeToFly + " more hours.");
	}
	
	

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CargoPlane [model=");
		builder.append(model);
		builder.append(", speed=");
		builder.append(speed);
		builder.append(", range=");
		builder.append(range);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
