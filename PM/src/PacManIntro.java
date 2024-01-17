import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// this class is the intro panel at the statr
public class PacManIntro extends JFrame implements ActionListener{
	
	// theme
	static int selectedTheme;
	
	// theme array
	private String[] themes = {"DEFAULT", "PINK", "INVISIBLE"};
	
	// back portion panel
	private JPanel mainPanel = new JPanel();
	
	// content panel
	private JPanel main2Panel = new JPanel();
	
	// picture for title
	private ImageIcon titlePic = new ImageIcon("images/pacManTitle.png");
	
	// objective
	private JLabel objectiveLabel = new JLabel("<html>OBJECTIVE: Try to eat all the pellets on the board. Be careful! There are three ghosts"
			+ " out to eat YOU. Run away from them as you feast.</html>");

	// how to play
	private JLabel howToPlayLabel = new JLabel("<html>HOW TO PLAY: Use the arrow keys on your keyboard to move PacMan.</html>");
	
	// button
	private JButton startButton = new JButton("START");
	
	// text field
	static JTextField nameEntry = new JTextField();
	private JLabel nameEntryLabel = new JLabel("ENTER NAME");
	
	// choose theme
	private JLabel themePickerLabel = new JLabel("CHOOSE THEME");
	private JComboBox themePicker = new JComboBox(themes);
	
	// constructor method
	public PacManIntro() {
		
		// set up size
		setSize(600, 600);
		setTitle("PacMan");
		setLayout(null);
		
		bkgdPanel();
		
		contentsPanel();
		
		startButton();
		
		setVisible(true);		
		
	}

	// this method sets up start button
	private void startButton() {
		
		startButton.setBounds(330, 400, 100, 40);
		startButton.setFont(new Font("Garamond", Font.BOLD, 20));
		startButton.setBackground(Color.LIGHT_GRAY);
		startButton.setLayout(null);
		startButton.addActionListener(this);
		main2Panel.add(startButton);
		
	}

	// this method sets up the contents of the panel
	private void contentsPanel() {

		main2Panel.setBounds(40, 40, 480, 480);
		main2Panel.setLayout(null);

		mainPanel.add(main2Panel);

		JLabel titleLabel = new JLabel(new ImageIcon(titlePic.getImage().getScaledInstance(425, 400, java.awt.Image.SCALE_SMOOTH)));
		
		titleLabel.setBounds(40, 0, 400, 170);
		titleLabel.setLayout(null);
		main2Panel.add(titleLabel);
		
		
		objectiveLabel.setBounds(40, 150, 400, 100);
		objectiveLabel.setFont(new Font("Garamond", Font.PLAIN, 18));
		objectiveLabel.setLayout(null);
		main2Panel.add(objectiveLabel);
		
		howToPlayLabel.setBounds(40, 250, 400, 90);
		howToPlayLabel.setFont(new Font("Garamond", Font.PLAIN, 18));
		howToPlayLabel.setLayout(null);
		main2Panel.add(howToPlayLabel);
		
		nameEntryLabel.setBounds(40, 400, 125, 30);
		nameEntryLabel.setFont(new Font("Garamond", Font.BOLD, 15));
		nameEntryLabel.setLayout(null);
		main2Panel.add(nameEntryLabel);
		
		nameEntry.setBounds(165, 400, 125, 30);
		nameEntry.setFont(new Font("Garamond", Font.BOLD, 18));
		nameEntry.setBorder(null);
		nameEntry.setLayout(null);
		main2Panel.add(nameEntry);
		
		themePickerLabel.setBounds(40, 350, 150, 30);
		themePickerLabel.setFont(new Font("Garamond", Font.BOLD, 15));
		themePickerLabel.setLayout(null);
		main2Panel.add(themePickerLabel);
		
		themePicker.setSelectedIndex(0);
		themePicker.setBounds(180, 350, 125, 30);
		main2Panel.add(themePicker);
		
	}

	// black part
	private void bkgdPanel() {

		mainPanel.setBounds(0, 0, 600, 600);
		mainPanel.setBackground(Color.BLACK);
		mainPanel.setLayout(null);
		add(mainPanel);
				
	}

	// action listener
	@Override
	public void actionPerformed(ActionEvent e) {
		// gets theme
		selectedTheme = themePicker.getSelectedIndex();
		
		// call gui (board)
		new PacManGUI();
		
		// sets user name
		ScorePanel.userNameLabel.setText(nameEntry.getText().toUpperCase());
		
		// hides screen
		setVisible(false);
	}
		
}
	
	