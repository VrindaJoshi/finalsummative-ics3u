/*
NAME: Vrinda Joshi
DATE: January 19th 2024
COURSE CODE: ICS3U1-01, Mr.Fernandes
TITLE: All About Classes + Objects

DESCRIPTION: I am creating a Computer-Assisted Instruction software that teaches users about objects and classes. The 
	user gets to play a game where they become a baker, and create cakes for customers based on their order. The user concludes
	their lesson with a short quiz. If they are successful, they receive a certificate!

FEATURES: User can create their own customized Avatar, timer countdown in quiz, JTabbedPane in activity allows user to be organized,
	HTML link in Concepts Class, JProgressBar.

MAJOR SKILLS: Arrays, Objects (Avatar, Cake), JSwing, booleans, for loops, revalidate/repaint method, JMenuBar for switching between 
	screens, Images, Listeners (Item, Action, Key).
	
AREAS OF CONCERN:
 - Some Frames pop up twice; but close the entire program when closed.


*/
public class CAIApp {

	// booleans that restrict the use of the main menu bar, checks if the user has
	// completed a prereq
	static boolean avatarCreated = false;
	static boolean educationDone = false;
	static boolean activityDone = false;

	// main method
	public static void main(String[] args) {

		new MainMenuClass();

	}

}
