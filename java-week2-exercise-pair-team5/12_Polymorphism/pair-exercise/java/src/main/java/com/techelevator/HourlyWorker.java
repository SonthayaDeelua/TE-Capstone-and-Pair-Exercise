package com.techelevator;

public class HourlyWorker implements Worker {
	
	private String firstName;
	private String lastName;
	private double hourlyRate;
	
	public HourlyWorker(String firstName, String lastName, double hourlyRate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.hourlyRate = hourlyRate;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}


	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public double getCalculateWeeklyPay(int hoursWorked) {
		double weeklyPay = 0;
		if (hoursWorked <= 40) {
		weeklyPay = (hourlyRate*hoursWorked);
		}
		else if (hoursWorked > 40) {
		int overtime = hoursWorked - 40;
		weeklyPay = (hourlyRate*hoursWorked) + (hourlyRate*overtime*0.5);
		}
		return weeklyPay;
	}

}
