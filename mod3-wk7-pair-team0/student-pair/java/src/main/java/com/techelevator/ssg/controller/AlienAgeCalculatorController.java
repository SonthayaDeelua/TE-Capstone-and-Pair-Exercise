package com.techelevator.ssg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.AgeCalculator;

@Controller
public class AlienAgeCalculatorController {
	
	
	
	@RequestMapping("/alienAge")
	public String alienAgeCalulatorDisplay() {
		return "alienAge";
	}
	
	@RequestMapping("/alienAgeResults")
	public String AlienAgeCalculatorResultsDisplay(@RequestParam String name, 
													@RequestParam int age,
													ModelMap map) {
		
		AgeCalculator ageCalc = new AgeCalculator(name, age);
		ageCalc.findPlanetEarthDays(name, age);
		map.put("ageCalculator", ageCalc);
		
		return "alienAgeResults";
	}
	
	

}
