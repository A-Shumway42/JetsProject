package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;
	
	
	public Jet() {
		this.model = "jet";
		this.speed = 0.0;
		this.range = 0;
		this.price = 0;
	}


	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	public void fly() {
		System.out.println("Let's fly boys!");
	}
	
	public double getSpeedInMach() {
		return speed;
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
		builder.append("Jet [model=");
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



