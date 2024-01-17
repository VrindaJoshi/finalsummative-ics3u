/* PROJECT HEADER
*
* DATE: December 15th 2023
* COURSE: ICS3U1-01, Mr. Fernandes
* TITLE: PAC-MAN
*
* DESCRIPTION: A game that allows users to play as pac man, to try and eat all the food.
* 			They can play with different themes as well.
*
* MAJOR SKILLS:
*  Arrays, Swing GUI Components(button, label, combobox etc.), File Scanner, KeyListener, Images, if-else statements, objects,
* Try-catch, Images, awt GUI components(color, gridlayout, actionlistener etc.), javax.sound.sampled.*

* 
* ADDED FEATURES:
*  - Score Panel
*  - Lives
*  - Levels
*  - Sounds/ Music
*  - Player Name
*  - Themes
*  - Ghost AI ( ghost will chase you if it is on the same row/ column)
*  - Bonus point cherries
*  - Read in high score data from csv file
*  - Path for ghosts to leave box
*  - gate for ghosts and pacman
*  - High score
* 
* AREAS OF CONCERN:
*  - I could not figure out how to update my csv file from the game
*  - CSV file contents can be used, but must be changed directly in the file
*  - currently only 4 users can be stored
*  - there is no image for the gate
*/

// this class is the application that runs the game
public class PacManGame {
	
	// static arrays
	
	// mazes for different levels
	
	// mazes for different users, 4 stored into csv file
	
	// this method allows for code to be processed
	public static void main(String[] args) {
		
		// initialize array

		// get input form past games (csv file)

		// this calls the frame of the game
		new PacManGUI();

		//new PacManIntro();

	}

}