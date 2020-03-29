package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCount {
	

	public static void main(String[] args) throws FileNotFoundException {
		
		int wordCount = 0;
		int sentenceCount = 0;
		
		File inputFile = getInputFileFromUser();
		try(Scanner fileScanner = new Scanner(inputFile)) {
			while(fileScanner.hasNextLine()) {
				String fullLine = fileScanner.nextLine();
				if (fullLine.length() != 0) {
					String [] wordArray = fullLine.split(" ");
					for (int x = 0; x < wordArray.length; x++) {
						if(wordArray[x].length() != 0) {
							wordCount = wordCount + 1;	
						}
					}
				}
			}
		}
		
		System.out.println("WordCount =  " + wordCount);
		
		try(Scanner fileScanner = new Scanner(inputFile)) {
			while(fileScanner.hasNextLine()) {
				String fullLine = fileScanner.nextLine();
				if (fullLine.length() != 0) {
					String [] sentenceArray = fileScanner.nextLine().split(".!\\?");	
					for (int x = 0; x < sentenceArray.length; x++) {
						if (sentenceArray[x].length() != 0) {
							sentenceCount = sentenceCount + 1;	
						}
					}
				}
			}
		}
		
		System.out.println("SentenceCount =  " + sentenceCount);
		
	}
	
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		if(inputFile.exists() == false) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}
	
		
		
	
	

}
