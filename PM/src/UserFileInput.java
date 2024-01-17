/*
* Name: Vrinda Joshi
* Date: 11/04/2023 (December 4, 2023)
* Title: AboutFrame
* Description: Processes the data from the csv file to fill the laptop array
* 
*/ 

//import classes
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// class
public class UserFileInput {
	
	static Scanner inputFile;
	
	public UserFileInput() {
		
		fillLibrary();
		
	}
	
private static void fillLibrary() {
	
	try {
		
		// the file used
		Scanner inputFile = new Scanner(new File("userHighScoresFile.csv"));
		
		// skip over commas
		inputFile.useDelimiter(",|\r\n");
		
		// for every instance in the array
		for(int index = 0; index < PacManGame.userScoreArray.length; index++) {
			
			// add instance variables (fields)
			String name = inputFile.next();
			int highScore = inputFile.nextInt();
			
			// create instance
			PacManGame.userScoreArray[index] = new UserScore(name, highScore);
					
		}
		
		// close file
		inputFile.close();
	
	// if error occurs
	} catch (FileNotFoundException e) {
	
		System.out.println("File Error");
		
	}
	
}

}
