package com.techelevator.ssg.model;

public class AgeCalculator {

	private String name;
	private int age;
	private double planetEarthDays;
	private double planetAge;
	
	
	public AgeCalculator(String name, int age) {
		this.name = name;
		this.age = age;
		this.planetAge = (365.26* this.age) / this.planetEarthDays;
	}
	
	public double getPlanetAge() {
		return planetAge;
	}

	public void setPlanetAge(double planetAge) {
		this.planetAge = planetAge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPlanetEarthDays() {
		return planetEarthDays;
	}

	public void setPlanetEarthDays(double planetEarthDays) {
		this.planetEarthDays = planetEarthDays;
	}

	
	
	public double findPlanetEarthDays(String name, int age) {
		
		if(this.name.equals("mercury")){
			this.planetEarthDays = 87.96;
		}
		else if(this.name.equals("venus")){
			this.planetEarthDays = 224.68;
		}
		else if(this.name.equals("earth")){
			this.planetEarthDays = 365.26;
		}
		else if(this.name.equals("mars")){
			this.planetEarthDays = 686.98;
		}
		else if(this.name.equals("jupiter")){
			this.planetEarthDays = 11.862;
		}
		else if(this.name.equals("saturn")){
			this.planetEarthDays = 29.456;
		}
		else if(this.name.equals("uranus")){
			this.planetEarthDays = 84.07;
		}
		else if(this.name.equals("neptune")){
			this.planetEarthDays = 164.81;
		}
		else if(this.name.equals("pluto")){
			this.planetEarthDays = 247.70;
		}
		
		return this.planetEarthDays;
	}
	

	
}
