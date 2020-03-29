package com.techelevator;

public class KataStringCalculator {
	public int add(String numbers) {
		if (numbers.length() != 0) {
			String[] numberArray = numbers.split(",|\n");
			int[] intNumberArray = new int[numberArray.length];
			int total = 0;
			for (int x = 0; x < intNumberArray.length; x++) {
				intNumberArray[x] = Integer.parseInt(numberArray[x]);
				total = total + intNumberArray[x];
			}
			return total;
		}
		return 0;
	}
}
