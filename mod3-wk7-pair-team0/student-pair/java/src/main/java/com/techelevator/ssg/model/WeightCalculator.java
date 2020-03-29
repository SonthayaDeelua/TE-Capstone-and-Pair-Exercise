package com.techelevator.ssg.model;

public class WeightCalculator {
	
	private String name;
	private int earthWeight;
	private double gCompare;
	private double planetWeight;

	
	
	public WeightCalculator (String name , int earthWeight) {
		
		this.name = name;
		this.earthWeight = earthWeight;				
		this.planetWeight = this.earthWeight * findGCompare(this.name) ;
	}



	public double getPlanetWeight() {
		return planetWeight;
	}



	public void setPlanetWeight(double planetWeight) {
		this.planetWeight = planetWeight;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getEarthWeight() {
		return earthWeight;
	}



	public void setEarthWeight(int earthWeight) {
		this.earthWeight = earthWeight;
	}


	public double getgCompare() {
		return gCompare;
	}



	public void setgCompare(double gCompare) {
		this.gCompare = gCompare;
	}


	public double findGCompare (String name) {
		
		if(this.name.equals("mercury")){
			this.gCompare = 0.37;
		}
		else if(this.name.equals("venus")){
			this.gCompare = 0.90;
		}
		else if(this.name.equals("earth")){
			this.gCompare = 1.00;
		}
		else if(this.name.equals("mars")){
			this.gCompare = 0.38;
		}
		else if(this.name.equals("jupiter")){
			this.gCompare = 2.65;
		}
		else if(this.name.equals("saturn")){
			this.gCompare = 1.13;
		}
		else if(this.name.equals("uranus")){
			this.gCompare = 1.09;
		}
		else if(this.name.equals("neptune")){
			this.gCompare = 1.43;
		}
		else if(this.name.equals("pluto")){
			this.gCompare = 0.04;
		}
		
		return this.gCompare;
	}
			
	
	
}

