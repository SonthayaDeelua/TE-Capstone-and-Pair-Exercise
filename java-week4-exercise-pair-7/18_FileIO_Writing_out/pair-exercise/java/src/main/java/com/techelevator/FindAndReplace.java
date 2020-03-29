package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);// command to get the data from user
		// alices_adventures_in_wonderland.txt
		System.out.println("Please enter the word you want to replaced: "); //ask user
		String searchWord = input.nextLine(); // convert data from user into String
		System.out.println("Please enter the word you want it to be replaced by: "); //ask user more
		String replaceWord = input.nextLine(); // convert data from user into String
		System.out.println("Please enter the name or path of the file you want to replace words from: ");//ask for the source file
		String path = input.nextLine();
		File inputFile = new File (path);
		if (inputFile.exists() && inputFile.isFile()) {
			System.out.println("File exists.");	
			System.out.println(inputFile);
		}else {
			System.out.println(path + " does not exist or is not a file. Exiting Program.");
			System.exit(0);
		}
		Scanner inputFileScanner = new Scanner(inputFile);
		File copyFile = new File ("CopyFile");
		String oldContent = "";
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String line = reader.readLine();

		while (line != null){
			oldContent = oldContent + line + System.lineSeparator();
			line = reader.readLine();
		}
		String newContent = oldContent.replaceAll(searchWord, replaceWord);
		PrintWriter writer = new PrintWriter(copyFile);
		writer.println(newContent);
		writer.close();
		reader.close();
		inputFileScanner.close();
		
	}	
}
