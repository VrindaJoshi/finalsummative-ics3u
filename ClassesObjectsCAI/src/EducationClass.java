
// SEE IF YOU CAN CHANGE THE SLIDE USING THE KEYBOARD

// imports
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

// class
public class EducationClass extends JFrame implements ActionListener {

	// fonts
	//

	// colors
	static final Color BEIGE = new Color(227, 228, 219);
	static final Color GRAY = new Color(205, 205, 205);

	// static variables
	static JPanel[] panelArray = new JPanel[17]; // array of jpanels
	static JInternalFrame  [] checkpointArray = new JInternalFrame [3]; // array of internal frames
	static int currentSlide = 0; // changing value of the current slide

	private JPanel mainPanel = new JPanel();

	private JPanel topPanel = new JPanel();

	// panel for buttons at the bottom
	private JPanel buttonPanel = new JPanel();
	private JProgressBar progressBar = new JProgressBar(0, panelArray.length);

	// contents of button panel
	private JButton nextButton = new JButton(">"); // next button to go to next slide
	private JButton backButton = new JButton("<"); // back button to go to previous slide
	private JButton finishButton = new JButton("finish"); // finish button to end slideshow

	// constructor
	public EducationClass() {

		// set size of frame
		setSize(1366, 766);
		setTitle("Education Class");

		// set up main panel
		mainPanel.setBounds(0, 0, 1366, 766);
		mainPanel.setBackground(BEIGE);
		mainPanel.setLayout(null);
		add(mainPanel);

		// set up panel with JProgressBar
		setTopPanel();

		// initials panelArray method
		initializePanels();
		
		//show first panel
		mainPanel.add(panelArray[currentSlide]);

		// initialize buttonPanel and contents
		initializeButtons();

		// remove layout manager
		setLayout(null);

		// set frame to visible
		setVisible(true);
	}

	
	// this method sets ups and adds the JProgressBar and the panel above it
	private void setTopPanel() {

		// set up blank panel
		topPanel.setBounds(50, 50, 1166, 70);
		topPanel.setBackground(Color.WHITE);
		topPanel.setLayout(null);
		mainPanel.add(topPanel);

		// set up progress bar
		progressBar.setValue(currentSlide);
		progressBar.setForeground(BEIGE);
		progressBar.setBounds(50, 120, 1166, 20);
		progressBar.setStringPainted(true); // show percent on progress bar
		mainPanel.add(progressBar);

	}

	// initialize buttonPanel and contents
	private void initializeButtons() {

		// button to go back (is not added at first as you cannot go back from first
		// panel)
		backButton.setBounds(50, 0, 50, 50);
		backButton.addActionListener(this);
		backButton.setBackground(GRAY);
		backButton.setLayout(null);

		// button to go next
		nextButton.setBounds(1066, 0, 50, 50);
		nextButton.addActionListener(this);
		nextButton.setBackground(GRAY);
		nextButton.setLayout(null);
		buttonPanel.add(nextButton);

		// button to finish (is not added at first as you cannot go finish until you
		// have gone through all slides)
		finishButton.setBounds(1016, 0, 100, 50);
		finishButton.addActionListener(this);
		finishButton.setBackground(GRAY);
		finishButton.setLayout(null);

		// set up button panel
		buttonPanel.setBounds(50, 576, 1166, 90);
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(Color.WHITE);
		mainPanel.add(buttonPanel);

	}

	// initials panelArray method
	private void initializePanels() {

		// for loop for all panels, as they all have the same dimensions and locations
		for (int index = 0; index < panelArray.length; index++) {
			panelArray[index] = new JPanel();
			panelArray[index].setBounds(50, 140, 1166, 566 - 130);
			panelArray[index].setBackground(Color.WHITE);
			panelArray[index].setLayout(null);
		}

		firstSlide();

		secondSlide();

		thirdSlide();

		fourthSlide();

		fifthSlide();

		sixthSlide();

		seventhSlide();

		eighthSlide();

		ninthSlide();

		tenthSlide();

		eleventhSlide();

		twelthSlide();

		thirteenthSlide();

		fourteenthSlide();

		fifteenthSlide();

		sixteenthSlide();

		seventeenthSlide();

	}

	private void seventeenthSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel(
				"Congrats, that is how you create a template class! From here, you can add in methods, like the dyeBirthdayHair() method. ");

		// set up text labels
		textLabelOne.setBounds(50, 50, 1000, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[16].add(textLabelOne);

	}

	private void sixteenthSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel("A new method will auto-generate!\r\n" + "");

		// set up text labels
		textLabelOne.setBounds(50, 50, 1000, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[15].add(textLabelOne);

		// create + setup picture label
		ImageIcon instanceIcon = new ImageIcon("images/slideshow/slide15.png");
		JLabel instanceImg = new JLabel(new ImageIcon(instanceIcon.getImage().getScaledInstance(1347/2, 122/2, java.awt.Image.SCALE_SMOOTH)));

		instanceImg.setBounds(100, 100, 1347/2, 122/2);
		instanceImg.setLayout(null);
		panelArray[15].add(instanceImg);

	}

	private void fifteenthSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel(
				"<html>Lastly, we will create a method that outputs a summary message for a specific instance. \r\n"
						+ "\r\n"
						+ "<br>Go to the menu bar at the top again, and press on \'Source > Generate toString()...\'</html>");
		JLabel textLabelTwo = new JLabel("Press on Generate!\r\n" + "");

		// set up text labels
		textLabelOne.setBounds(50, 50, 600, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[14].add(textLabelOne);

		// create + setup picture label
		ImageIcon methodIcon = new ImageIcon("images/slideshow/slide14.png");
		JLabel methodImg = new JLabel(
				new ImageIcon(methodIcon.getImage().getScaledInstance(834 / 3, 1065 / 3, java.awt.Image.SCALE_SMOOTH)));

		methodImg.setBounds(650, 50, 834 / 3, 1065 / 3);
		methodImg.setLayout(null);
		panelArray[14].add(methodImg);

		textLabelTwo.setBounds(50, 200, 500, 50);
		textLabelTwo.setLayout(null);
		textLabelTwo.setFont(Fonts.interRegularEDU);
		panelArray[14].add(textLabelTwo);

	}

	private void fourteenthSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel(
				"Get methods and set methods will auto-generate for each of the fields.\r\n" + "");

		// set up text labels
		textLabelOne.setBounds(50, 50, 1000, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[13].add(textLabelOne);

		// create + setup picture label
		ImageIcon instanceIcon = new ImageIcon("images/slideshow/slide13.png");
		JLabel instanceImg = new JLabel(new ImageIcon(instanceIcon.getImage()));

		instanceImg.setBounds(100, 100, 600, 224);
		instanceImg.setLayout(null);
		panelArray[13].add(instanceImg);

	}

	private void thirteenthSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel(
				"Next, go to the menu bar at the top again, and press on \'Source > Generate Getters and Setters…\'");
		JLabel textLabelTwo = new JLabel("Select all the fields, and press on Generate!\r\n" + "");

		// set up text labels
		textLabelOne.setBounds(50, 50, 600, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[12].add(textLabelOne);

		// create + setup picture label
		ImageIcon methodIcon = new ImageIcon("images/slideshow/slide12.png");
		JLabel methodImg = new JLabel(
				new ImageIcon(methodIcon.getImage().getScaledInstance(834 / 3, 1065 / 3, java.awt.Image.SCALE_SMOOTH)));

		methodImg.setBounds(650, 50, 834 / 3, 1065 / 3);
		methodImg.setLayout(null);
		panelArray[12].add(methodImg);

		textLabelTwo.setBounds(50, 200, 500, 50);
		textLabelTwo.setLayout(null);
		textLabelTwo.setFont(Fonts.interRegularEDU);
		panelArray[12].add(textLabelTwo);

	}

	private void twelthSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel("The constructor method will auto generate!");
		JLabel textLabelTwo = new JLabel(
				"This is the method that is called when you create a new instance of City.\r\n" + "");

		// set up text labels
		textLabelOne.setBounds(50, 50, 1000, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[11].add(textLabelOne);

		// create + setup picture label
		ImageIcon instanceIcon = new ImageIcon("images/slideshow/slide11.png");
		JLabel instanceImg = new JLabel(new ImageIcon(
				instanceIcon.getImage().getScaledInstance(1168 / 2, 218 / 2, java.awt.Image.SCALE_SMOOTH)));

		instanceImg.setBounds(100, 100, 1168 / 2, 218 / 2);
		instanceImg.setLayout(null);
		panelArray[11].add(instanceImg);

		textLabelTwo.setBounds(50, 250, 1000, 50);
		textLabelTwo.setLayout(null);
		textLabelTwo.setFont(Fonts.interRegularEDU);
		panelArray[11].add(textLabelTwo);

	}

	private void eleventhSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel(
				"There isn’t much coding after this! Next, go to the menu bar at the top, and press on \'Source > Generate Constructor using Fields…\'");
		JLabel textLabelTwo = new JLabel(
				"This screen will pop up. Make sure all the fields are selected, and press Generate.");

		// set up text labels
		textLabelOne.setBounds(50, 50, 800, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[10].add(textLabelOne);

		// create + setup picture label
		ImageIcon methodIcon = new ImageIcon("images/slideshow/slide10-2.png");
		JLabel methodImg = new JLabel(
				new ImageIcon(methodIcon.getImage().getScaledInstance(834 / 3, 1065 / 3, java.awt.Image.SCALE_SMOOTH)));

		methodImg.setBounds(825, 50, 834 / 3, 1065 / 3);
		methodImg.setLayout(null);
		panelArray[10].add(methodImg);

		textLabelTwo.setBounds(50, 200, 500, 50);
		textLabelTwo.setLayout(null);
		textLabelTwo.setFont(Fonts.interRegularEDU);
		panelArray[10].add(textLabelTwo);

	}

	private void tenthSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel(
				"Let's initialize these attributes. The initialized variables in the template class are called fields.");
		JLabel textLabelTwo = new JLabel("Feel free to add in any other attributes of a city that you can think of!");

		// set up text labels
		textLabelOne.setBounds(50, 50, 600, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[9].add(textLabelOne);

		// create + setup picture label
		ImageIcon methodIcon = new ImageIcon("images/slideshow/slide9.png");
		JLabel methodImg = new JLabel(new ImageIcon(methodIcon.getImage()));

		methodImg.setBounds(50, 125, 600, 250);
		methodImg.setLayout(null);
		panelArray[9].add(methodImg);

		textLabelTwo.setBounds(600, 400, 500, 50);
		textLabelTwo.setLayout(null);
		textLabelTwo.setFont(Fonts.interRegularEDU);
		panelArray[9].add(textLabelTwo);
	}

	private void ninthSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel(
				"<html>Now that we know all about objects, " + "let's learn how to make a template class! "
						+ "Open up your code editors, and create a new " + "class. Let’s make a class called City.\r\n"
						+ "<br><br><br>What are some attributes of a city? You can "
						+ "brainstorm your own, but some attributes " + "include: planet, continent, country, name, "
						+ "and population.</html>");

		// set up text labels
		textLabelOne.setBounds(50, 0, 400, 260);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[8].add(textLabelOne);

		// create + setup picture label
		ImageIcon methodIcon = new ImageIcon("images/slideshow/slide8.png");
		JLabel methodImg = new JLabel(
				new ImageIcon(methodIcon.getImage().getScaledInstance(426, 453, java.awt.Image.SCALE_SMOOTH)));

		methodImg.setBounds(500, 10, 500, 500);
		methodImg.setLayout(null);
		panelArray[8].add(methodImg);

	}

	private void eighthSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel(
				"<html>We have learned that objects are useful, as we can use get and set methods to access an instance’s attributes. But we can also make our object do other things! Let’s say I love to dye my hair on my birthday. I could type up code everytime I want to dye my hair a different color, but I could also create a method in the template class that automatically dyes my avatar’s hair everytime I call it, and also increases my age by 1.</html>");

		JLabel textLabelTwo = new JLabel("<html>To call this method, you would write:<html>");

		// set up text labels
		textLabelOne.setBounds(50, 0, 250, 260);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[7].add(textLabelOne);

		// create + setup picture label
		ImageIcon methodIcon = new ImageIcon("images/slideshow/slide7-1.png");
		JLabel methodImg = new JLabel(new ImageIcon(methodIcon.getImage()));

		methodImg.setBounds(315, 10, 800, 290);
		methodImg.setLayout(null);
		panelArray[7].add(methodImg);

		textLabelTwo.setBounds(350, 320, 1000, 50);
		textLabelTwo.setLayout(null);
		textLabelTwo.setFont(Fonts.interRegularEDU);
		panelArray[7].add(textLabelTwo);

		ImageIcon callMethodIcon = new ImageIcon("images/slideshow/slide7-2.png");
		JLabel callMethodImg = new JLabel(new ImageIcon(callMethodIcon.getImage()));

		callMethodImg.setBounds(400, 200, 800, 290);
		callMethodImg.setLayout(null);
		panelArray[7].add(callMethodImg);

	}

	private void seventhSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel(
				"<html>Back on slide X, we learned that every instance of an object is familiar with its own instance variables. We are able to get and set the values of the instance variables, through the instance. To do so, we can use get methods, or set methods.\r\n"
						+ "</html>");

		JLabel textLabelTwo = new JLabel(
				"<html>Look at the table below to learn more about get and set methods.<html>");

		// set up text labels
		textLabelOne.setBounds(50, 50, 1000, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[6].add(textLabelOne);

		// create + setup picture label
		ImageIcon tableIcon = new ImageIcon("images/slideshow/slide6.png");
		JLabel tableImg = new JLabel(new ImageIcon(tableIcon.getImage()));

		tableImg.setBounds(150, 125, 800, 290);
		tableImg.setLayout(null);
		panelArray[6].add(tableImg);

		textLabelTwo.setBounds(50, 100, 1000, 50);
		textLabelTwo.setLayout(null);
		textLabelTwo.setFont(Fonts.interRegularEDU);
		panelArray[6].add(textLabelTwo);

	}

	private void sixthSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel("Let's look at the code that created your instance of Avatar!");
		JLabel textLabelTwo = new JLabel("<html>If we break down the syntax of this line of code..\r\n<br>"
				+ "&bull we are declaring the data type of the variable as Avatar\r\n<br>"
				+ "&bull the variable is called myAvatar\r\n<br>"
				+ "&bull myAvatar is equal to an instance of the avatar class \r\n<br>"
				+ "&bull the keyword new creates a new object of the class to the right (in this case, Avatar), by calling the object's constructor method.\r\n<br>"
				+ "&bull inside the brackets are the attributes of the object, called instance variables. These values are passed into the constructor method\r\n<br>"
				+ "<html>");

		// set up text labels
		textLabelOne.setBounds(50, 50, 1000, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[5].add(textLabelOne);

		// create + setup picture label
		JLabel instanceImg = new JLabel(new ImageIcon("images/slideshow/slide5.png"));

		instanceImg.setBounds(100, 100, 800, 125);
		instanceImg.setLayout(null);
		panelArray[5].add(instanceImg);

		textLabelTwo.setBounds(50, 150, 1000, 300);
		textLabelTwo.setLayout(null);
		textLabelTwo.setFont(Fonts.interRegularEDU);
		panelArray[5].add(textLabelTwo);

	}

	private void fifthSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel(
				"<html>Let's take a look at the code for the Avatar template class:\r<br><br><br>"
						+ "&bull the first line creates the class\r\n<br>"
						+ "&bull initialize all the instance variables\r\n<br>"
						+ "&bull constructor method: constructs every instance of the Avatar class\r\n<br>"
						+ "&bull get and set methods\r\n<br>"
						+ "&bull to string method: method that summarizes every instance\r\n<br>" + "</html>");

		// set up text labels
		textLabelOne.setBounds(50, 50, 1000, 170);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[4].add(textLabelOne);

	}

	private void fourthSlide() {

		// create text labels
		JLabel textLabelOne = new JLabel(
				"What is the Avatar class? The Avatar class is the template, or blueprint for all instances of Avatar.");
		JLabel textLabelTwo = new JLabel(
				"<html>The coder of the Avatar class engineered all Avatars to have a name, an age, a gender, and a hairColor. These attributes are called instance variables. Every instance of Avatar is familiar with its own instance variables. Your avatar has its own unique values for its instance variables: its name is x, its age is x, its gender is x, and its hair color is x. </html>");

		// set up text labels
		textLabelOne.setBounds(50, 50, 1000, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[3].add(textLabelOne);

		textLabelTwo.setBounds(50, 150, 1000, 50);
		textLabelTwo.setLayout(null);
		textLabelTwo.setFont(Fonts.interRegularEDU);
		panelArray[3].add(textLabelTwo);

		// code is from
		// https://docs.oracle.com/javase/tutorial/uiswing/components/editorpane.html
		/*
		 * // editor pane!! JEditorPane editorPane = new JEditorPane();
		 * editorPane.setEditable(false); java.net.URL helpURL =
		 * EducationClass.class.getResource( "AvatarClass.html"); if (helpURL != null) {
		 * try { editorPane.setPage(helpURL); } catch (IOException e) {
		 * System.err.println("Attempted to read a bad URL: " + helpURL); } } else {
		 * System.err.println("Couldn't find file: AvatarClass.html"); }
		 * 
		 * //Put the editor pane in a scroll pane. JScrollPane editorScrollPane = new
		 * JScrollPane(editorPane); editorScrollPane.setVerticalScrollBarPolicy(
		 * JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); editorScrollPane.setPreferredSize(new
		 * Dimension(250, 145)); editorScrollPane.setMinimumSize(new Dimension(10, 10));
		 * 
		 * panelArray[3].add(editorPane);
		 */
	}

	private void thirdSlide() {

		// create text labels
		JLabel textLabelOne = new JLabel(
				"<html>Before we got started, you customized your own avatar. What if I told you that you just used your first object! By pressing the done button, you created an instance of the Avatar class.</html>");

		// set up text labels
		textLabelOne.setBounds(50, 50, 1000, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[2].add(textLabelOne);

		// create + setup picture label
		ImageIcon miiIcon = new ImageIcon("images/slideshow/slide3.png");
		JLabel miiImg = new JLabel(
				new ImageIcon(miiIcon.getImage().getScaledInstance(300, 290, java.awt.Image.SCALE_SMOOTH)));

		miiImg.setBounds(500, 100, 300, 290);
		miiImg.setLayout(null);
		panelArray[2].add(miiImg);

	}

	private void secondSlide() {

		// create text labels
		JLabel textLabelOne = new JLabel(
				"<html>Let’s go back to the car example. A car must be designed and engineered by someone. When you press the brakes of a car, the speed of the car will decrease, and when you accelerate, <br>the car will speed up. These messages are sent to the car, the object.</html>");
		JLabel textLabelTwo = new JLabel(
				"<html>Object-Oriented Programming takes real-life objects, and creates a template to represent these objects in code, a class. Once you have a template, you can make copies, each with <br>their own unique attributes. These copies are called instances. You can send messages to each copy, by calling methods.</html>");

		// set up text labels
		textLabelOne.setBounds(50, 50, 1000, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[1].add(textLabelOne);

		textLabelTwo.setBounds(50, 150, 1000, 50);
		textLabelTwo.setLayout(null);
		textLabelTwo.setFont(Fonts.interRegularEDU);
		panelArray[1].add(textLabelTwo);

	}

	private void firstSlide() {

		// create text labels
		JLabel textLabelOne = new JLabel(
				"Let’s start by thinking, what " + "is an object? Well, we can consider an object any "
						+ "person, place, or thing. All 3 of these have specific"
						+ " characteristics, and tasks that they can do.");
		JLabel textLabelTwo = new JLabel(
				"<html>Let’s say our object is a car." + " A car will have characteristics such as its color, "
						+ "speed,<br> and fuel capacity. A car can drive forwards, "
						+ "backwards, and change directions.</html>");
		JLabel textLabelThree = new JLabel("<html>Let’s say our object is a beach. A beach "
				+ "will have characteristics such as weather,<br> water salinity, and "
				+ "tourist rating. At the beach it can rain, or a beach may get "
				+ "crowded<br> with tourists.</html>");

		// set up text labels
		textLabelOne.setBounds(50, 50, 1000, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[0].add(textLabelOne);

		textLabelTwo.setBounds(50, 150, 1000, 50);
		textLabelTwo.setLayout(null);
		textLabelTwo.setFont(Fonts.interRegularEDU);
		panelArray[0].add(textLabelTwo);

		textLabelThree.setBounds(50, 300, 1000, 50);
		textLabelThree.setLayout(null);
		textLabelThree.setFont(Fonts.interRegularEDU);
		panelArray[0].add(textLabelThree);

		// create + setup picture label
		ImageIcon carImgIcon = new ImageIcon("images/slideshow/slide1.png");
		JLabel carImg = new JLabel(
				new ImageIcon(carImgIcon.getImage().getScaledInstance(300, 130, java.awt.Image.SCALE_SMOOTH)));

		carImg.setBounds(700, 175, 300, 130);
		carImg.setLayout(null);
		panelArray[0].add(carImg);

	}

	// action listener for buttons
	@Override
	public void actionPerformed(ActionEvent e) {

		// check if button is finish button
		if (e.getSource() == finishButton) {
			dispose(); // close frame
		}

		// remove the current panel
		mainPanel.remove(panelArray[currentSlide]);

		// decide whether to go back or next
		if (e.getSource() == nextButton)
			currentSlide++;
		else if (e.getSource() == backButton)
			currentSlide--;

		// add/remove back button based on if current slide is the first slide
		if (currentSlide != 0) {
			buttonPanel.add(backButton);
		} else
			buttonPanel.remove(backButton);

		// add/remove next button based on if current slide is the last slide
		if (currentSlide == panelArray.length-1) {
			buttonPanel.remove(nextButton);
			buttonPanel.add(finishButton); // add finish button
		} else {
			buttonPanel.add(nextButton);
			buttonPanel.remove(finishButton); // add finish button
		}

		progressBar.setValue(currentSlide);// change progress bar value
		mainPanel.add(panelArray[currentSlide]); // add the next or previous slide

		// make changes to frame
		revalidate();
		repaint();

	}

}
