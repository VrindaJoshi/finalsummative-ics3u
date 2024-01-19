import java.awt.Color;
import java.awt.FontFormatException;
import java.io.IOException;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MainMenuClass extends JFrame implements ActionListener, MenuListener {

	// colors
	static final Color BEIGE = new Color(227, 228, 219);
	static final Color GRAY = new Color(205, 205, 205);

	static JPanel mainPanel = new JPanel();
	static JPanel sidePanel = new JPanel();

	static JLabel welcomeLabel = new JLabel("welcome");
	private JLabel textLabel = new JLabel(
			"<html>In this CAI (Computer-Assisted Instruction) application, you will learn all about classes and objects. In the past, we have learned about data types such as String, int, double, and boolean, but now you will be able to create and use your own data type (an object)! You will explore the concept of Object-Oriented Programming (OOP), and how using objects in your code will be very useful.</html>");
	static JLabel highlightedLabel = new JLabel("<html><b>before we get started, create your avatar!</b></html>");

	private static ImageIcon circleIcon = new ImageIcon("images/blank.png");
	private static JLabel circle = new JLabel(
			new ImageIcon(circleIcon.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
	private static JPanel topPanel = new JPanel();

	static JButton nextStep = new JButton("create avatar");

	static JLabel avatarInfo = new JLabel("");

	static String hairPNG = "";

	static JLabel avatarFace = new JLabel(new ImageIcon((new ImageIcon("images/avatar/blankFace.png")).getImage()
			.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH)));

	static JLabel avatarHair = new JLabel(new ImageIcon(
			(new ImageIcon(hairPNG)).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));

	static JLabel hairImg = new JLabel(
			new ImageIcon(new ImageIcon(hairPNG).getImage().getScaledInstance(195, 195, java.awt.Image.SCALE_SMOOTH)));
	static JLabel faceImg = new JLabel(new ImageIcon(new ImageIcon("images/avatar/blankFace.png").getImage()
			.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH)));
	
	static final Font italiana = loadFont("fonts/Italiana-Regular.ttf");
	static final Font inter = loadFont("fonts/Inter-VariableFont_slnt,wght.ttf");


	public MainMenuClass() {

		// set size of frame
		setSize(1366, 766);
		setName("All About Objects + Classes");

		// set up main panel
		mainPanel.setBounds(0, 0, 1366, 766);
		mainPanel.setBackground(BEIGE);
		mainPanel.setLayout(null);
		add(mainPanel);

		setMenuBar();
		

		// set up panel w content
		setTopPanel();

		setSidePanel();

		changeScreen();

		setVisible(true);
	}

	// this method loads the font
	private static Font loadFont(String address) {
		// Initialize Font object
		Font font1;
		// Try to load the custom font
		try {
			// Create a Font object from the specified font file
			font1 = Font.createFont(Font.TRUETYPE_FONT, new java.io.File(address));
			// Get the local graphics environment
			GraphicsEnvironment font = GraphicsEnvironment.getLocalGraphicsEnvironment();
			// Register the custom font with the graphics environment
			font.registerFont(font1);
			// Return the loaded font
			return font1;
			// Catch FontFormatException & IOException; print an error message if the file
			// is not found & return null
		} catch (FontFormatException | IOException error) {
			System.out.println("File not found!");
			return null;
		}
	} // end of priv method

	private void setMenuBar() {

		JMenuBar menuBar = new JMenuBar();

		JMenu mMenu = new JMenu("Home");
		JMenu mEdu = new JMenu("Learn");
		JMenu mActivity = new JMenu("Play");
		JMenu mQuiz = new JMenu("Quiz");

		// menu bar - used like buttons

		mEdu.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				System.out.println(CAIApp.avatarCreated);
				if (CAIApp.avatarCreated == true) {
					new EducationClass();
					dispose();
				} else
					JOptionPane.showMessageDialog(topPanel, "Create your avatar to start learning!",
							"Before you move on..", JOptionPane.WARNING_MESSAGE);
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
			}
		});

		mActivity.addMenuListener(new MenuListener() {
			public void menuSelected(MenuEvent e) {
				if (CAIApp.educationDone == true) {
					new ActivityClass();
					dispose();
				} else
					JOptionPane.showMessageDialog(topPanel, "Complete the lesson to play the game!",
							"Before you move on..", JOptionPane.WARNING_MESSAGE);
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mQuiz.addMenuListener(new MenuListener() {
			public void menuSelected(MenuEvent e) {
				if (CAIApp.activityDone == true) {
					new QuizClass();
					dispose();
				} else
					JOptionPane.showMessageDialog(topPanel, "Complete the activty to take the quiz!",
							"Before you move on..", JOptionPane.WARNING_MESSAGE);
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
			}
		});

		menuBar.add(mMenu);
		menuBar.add(mEdu);
		menuBar.add(mActivity);
		menuBar.add(mQuiz);

		setJMenuBar(menuBar);
	}

	private void setSidePanel() {

		// set up blank panel
		sidePanel.setBounds(50, 50, 250, 616);
		sidePanel.setBackground(Color.WHITE);
		sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		sidePanel.setLayout(null);
		mainPanel.add(sidePanel);

		nextStep.setBounds(40, 616 - 125, 160, 75);
		nextStep.setFont(inter.deriveFont(17f));
		nextStep.setBackground(GRAY);
		nextStep.addActionListener(this);
		sidePanel.add(nextStep);

		avatarInfo.setBounds(40, 210, 200, 200);
		avatarInfo.setFont(inter.deriveFont(17f));
		sidePanel.add(avatarInfo);

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
		welcomeLabel.setBounds(50, 60, 1000, 100);
		welcomeLabel.setFont(italiana.deriveFont(130f));

		topPanel.add(welcomeLabel);

		// set text
		textLabel.setBounds(50, 100, 700, 400);
		textLabel.setFont(inter.deriveFont(17f));
		topPanel.add(textLabel);

		// set bottom text
		highlightedLabel.setBounds(50, 450, 700, 50);
		highlightedLabel.setFont(italiana.deriveFont(30f));
		topPanel.add(highlightedLabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (CAIApp.avatarCreated == false) {
			new AvatarBuilder();
		} else {
			new EducationClass();
			dispose();
		}

	}

	public static void changeScreen() {

		if (CAIApp.avatarCreated == true)
			changeScreenValues();

	}

	private static void changeScreenValues() {

		chooseHairImage();

		String titletext = "welcome, " + AvatarBuilder.userAvatar.getName().toLowerCase();

		welcomeLabel.setText(titletext);

		highlightedLabel.setText("<html><b>let’s start learning!<b></html>");
		nextStep.setText("start learning");

		avatarInfo.setText(
				"<html>Name: " + AvatarBuilder.userAvatar.getName() + "<br>Age: " + AvatarBuilder.userAvatar.getAge()
						+ "<br>Gender: " + AvatarBuilder.userAvatar.getGender().toLowerCase() + "<br>Hair Color: "
						+ AvatarBuilder.userAvatar.getHairColor().toLowerCase() + "</html>");

		sidePanel.add(hairImg);

		faceImg.setBounds(20, 20, 200, 200);
		sidePanel.add(faceImg);

		welcomeLabel.setBounds(50, 60, 1000, 100);
		welcomeLabel.setFont(italiana.deriveFont(100f));

		topPanel.add(welcomeLabel);

	}

	private static void chooseHairImage() {

		if (AvatarBuilder.userAvatar.getGender() == "Male" || AvatarBuilder.userAvatar.getGender() == "Other") {

			if (AvatarBuilder.userAvatar.getHairColor() == "Brown") {
				hairPNG = "images/avatar/maleBrownHair.png";
			} else if (AvatarBuilder.userAvatar.getHairColor() == "Blonde") {
				hairPNG = "images/avatar/maleBlondeHair.png";
			}

			hairImg = new JLabel(new ImageIcon(
					new ImageIcon(hairPNG).getImage().getScaledInstance(107, 107, java.awt.Image.SCALE_SMOOTH)));

			hairImg.setBounds(27, 00, 200, 200);

		} else {

			int height = 50;

			if (AvatarBuilder.userAvatar.getHairColor() == "Brown") {
				hairPNG = "images/avatar/femaleBrownHair.png";
			} else if (AvatarBuilder.userAvatar.getHairColor() == "Blonde") {
				hairPNG = "images/avatar/femaleBlondeHair.png";
				height = 60;

			}

			hairImg = new JLabel(new ImageIcon(
					new ImageIcon(hairPNG).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));

			hairImg.setBounds(25, height, 200, 200);

		}

		sidePanel.remove(circle);

		sidePanel.revalidate();
		sidePanel.repaint();

	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub

	}
}
