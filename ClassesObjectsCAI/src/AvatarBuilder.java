// this class pops up when user creates their avatar

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AvatarBuilder extends JFrame implements ActionListener {

	// colors
	static final Color BEIGE = new Color(227, 228, 219);
	static final Color GRAY = new Color(205, 205, 205);
	
	//static values
	static Avatar userAvatar;

	private JPanel mainPanel = new JPanel();

	private JLabel welcomeLabel = new JLabel("create your avatar");

	private JPanel topPanel = new JPanel();

	private JButton nextStep = new JButton("finish");

	private JLabel fieldsLabels = new JLabel("<html>name:<br><br>age:<br><br>gender:<br><br>hair color:</html>");

	// input points
	private JTextField nameEntry = new JTextField();
		
	private JSpinner ageEntry = new JSpinner(new SpinnerNumberModel(0, 0, 122, 1));
	
	private ButtonGroup group = new ButtonGroup();
	
	
	private String[] genders = {"Select","Male","Female","Other"};
	private String[] colors = {"Select","Brown","Blonde","Red","Black"};
	
	@SuppressWarnings("unchecked")
	private JComboBox genderEntry = new JComboBox(genders);
	@SuppressWarnings("unchecked")
	private JComboBox hairEntry = new JComboBox(colors);
	
	private ImageIcon circleIcon = new ImageIcon("images/blank.png");
	private JLabel circle = new JLabel(new ImageIcon(circleIcon.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));

	
	public AvatarBuilder() {

		setSize(783, 533);

		// set up main panel
		mainPanel.setBounds(0, 0, 783, 533);
		mainPanel.setBackground(BEIGE);
		mainPanel.setLayout(null);
		add(mainPanel);
		

		setTopPanel();

		setLocationRelativeTo(null); // sets pop-up in center of screen
		setVisible(true);
	}

	private void setTopPanel() {

		// set up blank panel
		topPanel.setBounds(50, 40, 683, 403);
		topPanel.setBackground(Color.WHITE);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.setLayout(null);
		mainPanel.add(topPanel);

		// set title
		welcomeLabel.setBounds(40, 40, 683, 70);
		welcomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		topPanel.add(welcomeLabel);

		// button
		nextStep.setBounds(683 - 30 - 100, 403 - 30 - 50, 100, 50);
		nextStep.setFont(new Font("Times New Roman", Font.BOLD, 17));
		nextStep.setBackground(GRAY);
		nextStep.addActionListener(this);
		topPanel.add(nextStep);

		// set field labels
		fieldsLabels.setBounds(50, 130, 90, 200);
		fieldsLabels.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		topPanel.add(fieldsLabels);
		
		nameEntry.setBounds(160, 145, 150, 25);
		nameEntry.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		nameEntry.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.add(nameEntry);
		
		ageEntry.setBounds(160, 195, 70, 25);
		ageEntry.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ageEntry.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.add(ageEntry);
		
		genderEntry.setBounds(160, 245, 70, 25);
		genderEntry.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		genderEntry.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.add(genderEntry);
		
		hairEntry.setBounds(160, 290, 70, 25);
		hairEntry.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		hairEntry.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.add(hairEntry);
		
		circle.setBounds(450, 125, 150, 150);
		topPanel.add(circle);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		
		//if ((genderEntry.getSelectedItem() == "Select")|| (hairEntry.getSelectedItem() == "Select"))
			//JOptionPane.showMessageDialog(topPanel, "Finish personalizing your avatar first!",  "Before we move on..", JOptionPane.WARNING_MESSAGE);
		//else {
			userAvatar = new Avatar(nameEntry.getText(), (int)ageEntry.getValue(), (String)genderEntry.getSelectedItem(),(String)hairEntry.getSelectedItem());
			MainMenuClass.avatarCreated = true;
			setVisible(false);
			MainMenuClass.changeScreen();
		//}

	}

}
