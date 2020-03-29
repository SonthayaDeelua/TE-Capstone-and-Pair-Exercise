package com.techelevator;

public class SalaryWorker implements Worker {
	
	private String firstName;
	private String lastName;
	private double annualSalary;
	
	public SalaryWorker(String firstName, String lastName, double annualSalary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = annualSalary;
	}
	
	

	public double getAnnualSalary() {
		return annualSalary;
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
		return (annualSalary / 52);
	}

}
