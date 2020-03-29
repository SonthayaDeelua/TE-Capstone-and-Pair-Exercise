package com.techelevator.ssg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.techelevator.ssg.model.WeightCalculator;

@Controller
public class AlienWeightCalculatorController {
	
	@RequestMapping("/alienWeight")
	public String earthWeightInput() {
		return "alienWeight";
	}
	
	@RequestMapping("/alienWeightResults")
	public String showResult	(@RequestParam String name,
								@RequestParam int earthWeight,
								ModelMap map) {
		
		
		WeightCalculator weightCalc = new WeightCalculator( name , earthWeight);
		
		System.out.println(weightCalc.getName());
		
		map.put("weightCalculator", weightCalc);
		
		return "alienWeightResults";
		
	}
	

}	




