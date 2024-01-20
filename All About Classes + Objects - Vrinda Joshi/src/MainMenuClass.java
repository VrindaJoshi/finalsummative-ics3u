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

// MAIN MENU CLASS: first screen that pops up
public class MainMenuClass extends JFrame implements ActionListener, MenuListener {

	// colors
	static final Color BEIGE = new Color(227, 228, 219);
	static final Color GRAY = new Color(205, 205, 205);

	// fonts
	static final Font italiana = loadFont("fonts/Italiana-Regular.ttf");
	static final Font inter = loadFont("fonts/Inter-VariableFont_slnt,wght.ttf");

	// panels
	static JPanel mainPanel = new JPanel();
	static JPanel sidePanel = new JPanel();
	private static JPanel topPanel = new JPanel();

	// header label
	static JLabel welcomeLabel = new JLabel("welcome");

	// text label that introduces content
	private JLabel textLabel = new JLabel(
			"<html>In this CAI (Computer-Assisted Instruction) application, you will learn all about classes and objects. In the past, we have learned about data types such as String, int, double, and boolean, but now you will be able to create and use your own data type (an object)! You will explore the concept of Object-Oriented Programming (OOP), and how using objects in your code will be very useful.</html>");

	// highlighted text at the bottom that tells user what to do
	static JLabel highlightedLabel = new JLabel("<html><b>before we get started, create your avatar!</b></html>");

	// blank icon before user creats avatar
	private static JLabel circle = new JLabel(new ImageIcon(
			new ImageIcon("images/blank.png").getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));

	// info in side panel that describes avatar
	static JLabel avatarInfo = new JLabel();

	// for avatar icon on the side --------
	static String hairPNG = "";
	static JLabel avatarFace = new JLabel(new ImageIcon((new ImageIcon("images/avatar/blankFace.png")).getImage()
			.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH)));
	static JLabel avatarHair = new JLabel(new ImageIcon(
			(new ImageIcon(hairPNG)).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
	static JLabel hairImg = new JLabel(
			new ImageIcon(new ImageIcon(hairPNG).getImage().getScaledInstance(195, 195, java.awt.Image.SCALE_SMOOTH)));
	static JLabel faceImg = new JLabel(new ImageIcon(new ImageIcon("images/avatar/blankFace.png").getImage()
			.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH)));
	// -------------------------------------

	// next button
	static JButton nextStep = new JButton("create avatar");

	// constructor
	public MainMenuClass() {

		// set size of frame
		setSize(1366, 766);
		setName("All About Objects + Classes");

		// set up main panel
		mainPanel.setBounds(0, 0, 1366, 766);
		mainPanel.setBackground(BEIGE);
		mainPanel.setLayout(null);
		add(mainPanel);

		// set menu bar at top
		setMenuBar();

		// set up panel w content
		setTopPanel();

		// set side panel
		setSidePanel();

		// called to check whether screen need to be changed; has user come from
		// menubar? --> set avatar info
		changeScreen();

		// set visible
		setVisible(true);
	}

	// this method loads the font, got from anahat and sajni
	private static Font loadFont(String address) {
		// initialize font
		Font newFont;

		try {
			// create the font from the address specified
			newFont = Font.createFont(Font.TRUETYPE_FONT, new java.io.File(address));
			GraphicsEnvironment font = GraphicsEnvironment.getLocalGraphicsEnvironment();
			// register the custom font with the graphics environment
			font.registerFont(newFont);
			// return the font
			return newFont;

		} catch (FontFormatException | IOException error) {
			System.out.println("File not found!");
			return null;
		}

	}

	// set menu bar at the top
	private void setMenuBar() {

		JMenuBar menuBar = new JMenuBar();

		// sections (buttons)
		JMenu mMenu = new JMenu("Home");
		JMenu mEdu = new JMenu("Learn");
		JMenu mActivity = new JMenu("Play");
		JMenu mQuiz = new JMenu("Quiz");

		// add menu listeners
		mEdu.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				// check if they can move forward
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
				// unused
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// unused
			}
		});

		mActivity.addMenuListener(new MenuListener() {
			public void menuSelected(MenuEvent e) {
				// check if they can move forward
				if (CAIApp.educationDone == true) {
					new ActivityClass();
					dispose();
				} else
					JOptionPane.showMessageDialog(topPanel, "Complete the lesson to play the game!",
							"Before you move on..", JOptionPane.WARNING_MESSAGE);
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// unused
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// unused
			}
		});
		mQuiz.addMenuListener(new MenuListener() {
			public void menuSelected(MenuEvent e) {
				// check if they can move forward
				if (CAIApp.activityDone == true) {
					new QuizClass();
					dispose();
				} else
					JOptionPane.showMessageDialog(topPanel, "Complete the activty to take the quiz!",
							"Before you move on..", JOptionPane.WARNING_MESSAGE);
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// unused
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				/// unused
			}
		});

		// add sections
		menuBar.add(mMenu);
		menuBar.add(mEdu);
		menuBar.add(mActivity);
		menuBar.add(mQuiz);

		// add menu bar
		setJMenuBar(menuBar);
	}

	// set panel on the side - first frame
	private void setSidePanel() {

		// set up blank panel
		sidePanel.setBounds(50, 50, 250, 616);
		sidePanel.setBackground(Color.WHITE);
		sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		sidePanel.setLayout(null);
		mainPanel.add(sidePanel);

		// next button
		nextStep.setBounds(40, 616 - 125, 160, 75);
		nextStep.setFont(inter.deriveFont(17f));
		nextStep.setBackground(GRAY);
		nextStep.addActionListener(this);
		sidePanel.add(nextStep);

		// set avatar info
		avatarInfo.setBounds(40, 210, 200, 200);
		avatarInfo.setFont(inter.deriveFont(17f));
		sidePanel.add(avatarInfo);

		// set circle
		circle.setBounds(25, 50, 200, 200);
		sidePanel.add(circle);

	}

	// set "main" panel
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

	// action listener
	@Override
	public void actionPerformed(ActionEvent e) {
		// check if first or second screen
		if (CAIApp.avatarCreated == false) {
			new AvatarBuilder();
		} else {
			new EducationClass();
			dispose();
		}

	}

	// method called to check whether user need to change the screen
	public static void changeScreen() {
		// check if first or second screen
		if (CAIApp.avatarCreated == true)
			changeScreenValues();

	}

	// change the screen values
	private static void changeScreenValues() {

		// choose the icon to display based on the avater created
		chooseHairImage();

		// change title to include name
		String titletext = "welcome, " + AvatarBuilder.userAvatar.getName().toLowerCase();
		welcomeLabel.setText(titletext);
		welcomeLabel.setBounds(50, 60, 1000, 100);
		welcomeLabel.setFont(italiana.deriveFont(100f));

		// change next instructions
		highlightedLabel.setText("<html><b>let’s start learning!<b></html>");
		nextStep.setText("start learning");

		// set info label
		avatarInfo.setText(
				"<html>Name: " + AvatarBuilder.userAvatar.getName() + "<br>Age: " + AvatarBuilder.userAvatar.getAge()
						+ "<br>Gender: " + AvatarBuilder.userAvatar.getGender().toLowerCase() + "<br>Hair Color: "
						+ AvatarBuilder.userAvatar.getHairColor().toLowerCase() + "</html>");

		// add icon images (stacked pngs)
		sidePanel.add(hairImg);
		faceImg.setBounds(20, 20, 200, 200);
		sidePanel.add(faceImg);

	}

	// choose personalize icon to display
	private static void chooseHairImage() {

		// if short hair
		if (AvatarBuilder.userAvatar.getGender() == "Male" || AvatarBuilder.userAvatar.getGender() == "Other") {

			// choose color
			if (AvatarBuilder.userAvatar.getHairColor() == "Brown") {
				hairPNG = "images/avatar/maleBrownHair.png";
			} else if (AvatarBuilder.userAvatar.getHairColor() == "Blonde") {
				hairPNG = "images/avatar/maleBlondeHair.png";
			}

			// configure
			hairImg = new JLabel(new ImageIcon(
					new ImageIcon(hairPNG).getImage().getScaledInstance(107, 107, java.awt.Image.SCALE_SMOOTH)));
			hairImg.setBounds(27, 00, 200, 200);

			// if long hair
		} else {

			// put slightly higher that short hair
			int height = 50;

			// choose color
			if (AvatarBuilder.userAvatar.getHairColor() == "Brown") {
				hairPNG = "images/avatar/femaleBrownHair.png";
			} else if (AvatarBuilder.userAvatar.getHairColor() == "Blonde") {
				hairPNG = "images/avatar/femaleBlondeHair.png";
				height = 60;

			}

			// configure
			hairImg = new JLabel(new ImageIcon(
					new ImageIcon(hairPNG).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
			hairImg.setBounds(25, height, 200, 200);

		}

		// repaint side panel
		sidePanel.remove(circle);
		sidePanel.revalidate();
		sidePanel.repaint();

	}

	@Override
	public void menuSelected(MenuEvent e) {
		// unused

	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// unused

	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// unused

	}
}
