package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class HourlyWorkerTest {
	
	HourlyWorker johnDoe = new HourlyWorker("John", "Doe", 20);


	@Test
	public void test_if_35_hours_result_750_weekly_pay() {
		double expected = 700;
		
		double actual = johnDoe.getCalculateWeeklyPay(35);
		assertEquals(expected, actual, 0.0001);
	}
	
	@Test
	public void test_if_50_hours_result_1100_weekly_pay() {
		double expected = 1100;
		
		double actual = johnDoe.getCalculateWeeklyPay(50);
		assertEquals(expected, actual, 0.0001);
	}
	
	@Test
	public void test_for_return_first_name() {
		assertEquals("John", johnDoe.getFirstName());
	}
	
	@Test
	public void test_for_return_last_name() {
		assertEquals("Doe", johnDoe.getLastName());
	}
	
	@Test
	public void test_for_return_hourly_rate() {
		assertEquals(20, johnDoe.getHourlyRate(), 0.0001);
	}
 
}
