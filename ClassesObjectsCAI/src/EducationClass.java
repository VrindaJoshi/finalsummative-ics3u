
// SEE IF YOU CAN CHANGE THE SLIDE USING THE KEYBOARD

// imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	static JPanel[] panelArray = new JPanel[16]; // array of jpanels
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

		// show first panel
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
		progressBar.setForeground(GRAY);
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

	}

	private void fifthSlide() {
		// create text labels
		JLabel textLabelOne = new JLabel("Let's look at the code that created your instance of Avatar!");
		JLabel textLabelTwo = new JLabel(
				"<html>If we break down the syntax of this line of code..\r\n<br>"
				+ "\twe are declaring the data type of the variable as Avatar\r\n<br>"
				+ "\tthe variable is called myAvatar\r\n<br>"
				+ "\tmyAvatar is equal to an instance of the avatar class \r\n<br>"
				+ "\tthe keyword new creates a new object of the class to the right (in this case, Avatar), by calling the object's constructor method.\r\n<br>"
				+ "\tinside the brackets are the attributes of the object, called instance variables. These values are passed into the constructor method\r\n<br>"
				+ "<html>");

		// set up text labels
		textLabelOne.setBounds(50, 50, 1000, 50);
		textLabelOne.setLayout(null);
		textLabelOne.setFont(Fonts.interRegularEDU);
		panelArray[4].add(textLabelOne);

		// create + setup picture label
		JLabel instanceImg = new JLabel(
				new ImageIcon("images/slideshow/slide5.png"));

		instanceImg.setBounds(100, 125, 800, 125);
		instanceImg.setLayout(null);
		panelArray[4].add(instanceImg);

		textLabelTwo.setBounds(50, 100, 1000, 300);
		textLabelTwo.setLayout(null);
		textLabelTwo.setFont(Fonts.interRegularEDU);
		panelArray[4].add(textLabelTwo);


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

	// set up first slide of education class
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
		if (currentSlide == panelArray.length - 1) {
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
