package com.techelevator.ssg.model;

public class TravelAgeCalculator {
	
	private String name;
	private String travelMode;
	private int  age;
	private Long  distance;
	private Long distancePerYear;
	private Long yearsOfTravel;
	private Long ageAtReached;
	
	
	public TravelAgeCalculator (String name, String TravelMode , int age) {
		this.name = name;
		this.travelMode = TravelMode;
		this.age  = age;
		this.yearsOfTravel = findDistance(this.name)/findDistancePerYear(this.name);
		this.ageAtReached = this.age + this.yearsOfTravel;
		
	

	
		
	}


	public Long getAgeAtReached() {
		return ageAtReached;
	}


	public void setAgeAtReached(Long ageAtReached) {
		this.ageAtReached = ageAtReached;
	}

	public Long getDistancePerYear() {
		return distancePerYear;
	}


	public void setDistancePerYear(Long distancePerYear) {
		this.distancePerYear = distancePerYear;
	}


	public Long getYearsOfTravel() {
		return yearsOfTravel;
	}


	public void setYearsOfTravel(Long yearsOfTravel) {
		this.yearsOfTravel = yearsOfTravel;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTravelMode() {
		return travelMode;
	}

	public void setTravelMode(String travelMode) {
		this.travelMode = travelMode;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Long getDistance() {
		return  distance;
	}


	public void setDistance(Long distance) {
		this.distance = distance;
	}


	
	public Long findDistance (String name) {
		
		if(this.name.equals("mercury")){
			this.distance = 56974146L;
		}
		else if(this.name.equals("venus")){
			this.distance = 25724767L;
		}
		else if(this.name.equals("earth")){
			this.distance = 0L;
		}
		else if(this.name.equals("mars")){
			this.distance = 48678219L;
		}
		else if(this.name.equals("jupiter")){
			this.distance = 390674710L;
		}
		else if(this.name.equals("saturn")){
			this.distance = 792248270L;
		}
		else if(this.name.equals("uranus")){
			this.distance = 1692662530L ;
		}
		else if(this.name.equals("neptune")){
			this.distance = 2703959960L;
					
		}
				
		return this.distance;
	}
	
	
	public Long findDistancePerYear (String travelMode) {
		
		
		if(this.travelMode.equals("walking")) {
			this.distancePerYear =  26280L; //(3*24*365)
						
		}
		if(this.travelMode.equals("car")) {
			this.distancePerYear =  876000L; 
			
		}
		if(this.travelMode.equals("bulletTrain")) {
			this.distancePerYear = 1752000L; 
			
		}
		if(this.travelMode.equals("boeing")) {
			this.distancePerYear =  4993200L; 
			
		}
		if(this.travelMode.equals("concorde")) {
			this.distancePerYear =  11826000L; 
			
		}
		
		return this.distancePerYear;
		
	}
			
}

