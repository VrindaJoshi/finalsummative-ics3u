
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

// AVATAR BUILDER CLASS: this class pops up when user creates their avatar

public class AvatarBuilder extends JFrame implements ActionListener, ItemListener {

	// colors
	static final Color BEIGE = new Color(227, 228, 219);
	static final Color GRAY = new Color(205, 205, 205);

	// static values
	static Avatar userAvatar;

	// panels
	private JPanel mainPanel = new JPanel();
	private JPanel topPanel = new JPanel();

	// header label
	private JLabel welcomeLabel = new JLabel("create your avatar");

	// next button
	private JButton nextStep = new JButton("finish");

	// labels for the inputs
	private JLabel fieldsLabels = new JLabel("<html>name:<br><br>age:<br><br>gender:<br><br>hair color:</html>");

	// input points
	private JTextField nameEntry = new JTextField();
	private JSpinner ageEntry = new JSpinner(new SpinnerNumberModel(0, 0, 122, 1));
	private String[] genders = { "Select", "Male", "Female", "Other" };
	private String[] colors = { "Select", "Brown", "Blonde" };
	@SuppressWarnings("unchecked")
	private JComboBox genderEntry = new JComboBox(genders);
	@SuppressWarnings("unchecked")
	private JComboBox hairEntry = new JComboBox(colors);

	// circle placeholder
	private ImageIcon circleIcon = new ImageIcon("images/blank.png");
	private JLabel circle = new JLabel(
			new ImageIcon(circleIcon.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));

	// avatar icon
	static String hairPNG = "";
	static JLabel avatarFace = new JLabel(new ImageIcon((new ImageIcon("images/avatar/blankFace.png")).getImage()
			.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH)));
	static JLabel avatarHair = new JLabel(new ImageIcon(
			(new ImageIcon(hairPNG)).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
	static JLabel hairImg = new JLabel(
			new ImageIcon(new ImageIcon(hairPNG).getImage().getScaledInstance(195, 195, java.awt.Image.SCALE_SMOOTH)));
	static JLabel faceImg = new JLabel(new ImageIcon(new ImageIcon("images/avatar/blankFace.png").getImage()
			.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH)));

	// constructor
	public AvatarBuilder() {

		// frame details
		setSize(783, 533);
		setName("All About Objects+ + Classes");

		// set up main panel
		mainPanel.setBounds(0, 0, 783, 533);
		mainPanel.setBackground(BEIGE);
		mainPanel.setLayout(null);
		add(mainPanel);

		// "main" panel
		setTopPanel();

		setLocationRelativeTo(null); // sets pop-up in center of screen
		setVisible(true);
	}

	// "main" panel
	private void setTopPanel() {

		// set up blank panel
		topPanel.setBounds(50, 40, 683, 403);
		topPanel.setBackground(Color.WHITE);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.setLayout(null);
		mainPanel.add(topPanel);

		// set title
		welcomeLabel.setBounds(40, 40, 683, 70);
		welcomeLabel.setFont(MainMenuClass.italiana.deriveFont(60f));
		topPanel.add(welcomeLabel);

		// button
		nextStep.setBounds(683 - 30 - 100, 403 - 30 - 50, 100, 50);
		nextStep.setFont(MainMenuClass.inter.deriveFont(17f));
		nextStep.setBackground(GRAY);
		nextStep.addActionListener(this);
		topPanel.add(nextStep);

		// set field labels
		fieldsLabels.setBounds(50, 130, 140, 200);
		fieldsLabels.setFont(MainMenuClass.inter.deriveFont(20f));
		topPanel.add(fieldsLabels);

		// name entry
		nameEntry.setBounds(160, 145, 150, 25);
		nameEntry.setFont(MainMenuClass.inter.deriveFont(15f));
		nameEntry.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.add(nameEntry);

		// age entry
		ageEntry.setBounds(160, 195, 70, 25);
		ageEntry.setFont(MainMenuClass.inter.deriveFont(15f));
		ageEntry.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.add(ageEntry);

		// ITEM LISTENER: check if state changed -----------------------------
		// https://stackoverflow.com/questions/58939/jcombobox-selection-change-listener
		genderEntry.setBounds(160, 245, 70, 25);
		genderEntry.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getID() == ItemEvent.ITEM_STATE_CHANGED) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						chooseHairImage();
					}
				}
			}
		});
		genderEntry.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		genderEntry.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.add(genderEntry);

		hairEntry.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getID() == ItemEvent.ITEM_STATE_CHANGED) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						chooseHairImage();
					}
				}
			}
		});
		hairEntry.setBounds(160, 290, 70, 25);
		hairEntry.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		hairEntry.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.add(hairEntry);
		//--------------------------------------------------------------------

		// set up placeholder
		circle.setBounds(450, 125, 150, 150);
		topPanel.add(circle);
	}

	// choose icon
	private void chooseHairImage() {

		topPanel.remove(hairImg);

		if (genderEntry.getSelectedItem() == "Male" || genderEntry.getSelectedItem() == "Other") {

			if (hairEntry.getSelectedItem() == "Brown") {
				hairPNG = "images/avatar/maleBrownHair.png";
			} else if (hairEntry.getSelectedItem() == "Blonde") {
				hairPNG = "images/avatar/maleBlondeHair.png";
			}

			hairImg = new JLabel(new ImageIcon(
					new ImageIcon(hairPNG).getImage().getScaledInstance(107, 107, java.awt.Image.SCALE_SMOOTH)));

			hairImg.setBounds(457, 105 - 30, 150, 150);

		} else {

			if (hairEntry.getSelectedItem() == "Brown") {
				hairPNG = "images/avatar/femaleBrownHair.png";
			} else if (hairEntry.getSelectedItem() == "Blonde") {
				hairPNG = "images/avatar/femaleBlondeHair.png";

			}

			hairImg = new JLabel(new ImageIcon(
					new ImageIcon(hairPNG).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));

			hairImg.setBounds(430, 135 - 30, 200, 200);

		}

		topPanel.remove(circle);

		topPanel.add(hairImg);

		faceImg.setBounds(450, 125 - 30, 150, 150);
		topPanel.add(faceImg);

		topPanel.revalidate();
		topPanel.repaint();

	}

	// action listener
	@Override
	public void actionPerformed(ActionEvent e) {

		// if user has not fully personalized avatar
		if ((genderEntry.getSelectedItem() == "Select") || (hairEntry.getSelectedItem() == "Select"))
			JOptionPane.showMessageDialog(topPanel, "Finish personalizing your avatar first!", "Before we move on..",
					JOptionPane.WARNING_MESSAGE);
		else { //if all is complete, next
			userAvatar = new Avatar(nameEntry.getText(), (int) ageEntry.getValue(),
					(String) genderEntry.getSelectedItem(), (String) hairEntry.getSelectedItem());
			CAIApp.avatarCreated = true;
			setVisible(false); // disposing would destroy avatar
			MainMenuClass.changeScreen(); // call change screen method
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// unused
	}

}
