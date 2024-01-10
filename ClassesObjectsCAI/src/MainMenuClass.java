import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class MainMenuClass extends JFrame {

	// colors
	static final Color BEIGE = new Color(227, 228, 219);
	static final Color GRAY = new Color(205, 205, 205);

	private JPanel mainPanel = new JPanel();
	private JPanel sidePanel = new JPanel();

	private JLabel welcomeLabel = new JLabel("welcome");
	private JLabel textLabel = new JLabel(
			"<html>In this CAI (Computer-Assisted Instruction) application, you will learn all about classes and objects. In the past, we have learned about data types such as String, int, double, and boolean, but now you will be able to create and use your own data type (an object)! You will explore the concept of Object-Oriented Programming (OOP), and how using objects in your code will be very useful. You will be learning many new terms, and you can access a glossary through the menu bar at the top.</html>");
	private JLabel highlightedLabel = new JLabel("before we get started, create your avatar!");

	private ImageIcon circleIcon = new ImageIcon("images/browncircle.png");
	private JLabel circle = new JLabel(new ImageIcon(circleIcon.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
	private JPanel topPanel = new JPanel();
	
	private JButton nextStep = new JButton("create avatar");

	public MainMenuClass() {

		// set size of frame
		setSize(1366, 766);
		setTitle("Education Class");

		// set up main panel
		mainPanel.setBounds(0, 0, 1366, 766);
		mainPanel.setBackground(BEIGE);
		mainPanel.setLayout(null);
		add(mainPanel);

		// set up panel w content
		setTopPanel();

		setSidePanel();

		setVisible(true);
	}

	private void setSidePanel() {

		// set up blank panel
		sidePanel.setBounds(50, 50, 250, 616);
		sidePanel.setBackground(Color.WHITE);
		sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		sidePanel.setLayout(null);
		mainPanel.add(sidePanel);
		
		nextStep.setBounds(40, 616-125, 160, 75);
		nextStep.setFont(new Font("Times New Roman", Font.BOLD, 17));
		nextStep.setBackground(BEIGE);
		sidePanel.add(nextStep);
		
		circle.setBounds(25, 50, 200, 200);
		sidePanel.add(circle);

	}

	private void setTopPanel() {

		// set up blank panel
		topPanel.setBounds(300, 50, 916, 616);
		topPanel.setBackground(Color.WHITE);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.setLayout(null);
		mainPanel.add(topPanel);

		// set title
		welcomeLabel.setBounds(50, 60, 500, 100);
		welcomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 100));
		topPanel.add(welcomeLabel);

		// set text
		textLabel.setBounds(50, 100, 700, 400);
		textLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		topPanel.add(textLabel);

		// set bottom text
		highlightedLabel.setBounds(50, 450, 700, 50);
		highlightedLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		topPanel.add(highlightedLabel);

	}
}
