package com.techelevator.ssg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.TravelAgeCalculator;

@Controller
public class TravelAgeCalculatorController {
	
	@RequestMapping("/driveTime")
	public String alienTravelCalulatorDisplay() {
		return "driveTime";
	}
	
	@RequestMapping("/driveTimeResults")
	public String AlienAgeCalculatorResultsDisplay(@RequestParam String name, 
													@RequestParam String travelMode,
													@RequestParam int age,
													ModelMap map) {
			
		
		TravelAgeCalculator travelCal = new TravelAgeCalculator(name, travelMode, age);
		
		map.put("travelAgeCalculator", travelCal);
		
		return "driveTimeResults";
	}
	

}


