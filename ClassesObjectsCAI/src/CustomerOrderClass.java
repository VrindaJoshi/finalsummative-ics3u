
//this class pops up when user creates their avatar

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class CustomerOrderClass extends JFrame implements ActionListener{

	// colors
	static final Color PINK = Color.decode("#FFE1E1");
	static final Color GRAY = new Color(205, 205, 205);

	// static values
	static Avatar userAvatar;
	static int customerNumber;

	private JPanel mainPanel = new JPanel();
	private JPanel topPanel = new JPanel();

	//first screen elements
	private JLabel welcomeLabel;
	private JButton nextStep = new JButton("to the kitchen!");
	private JLabel lady = new JLabel(new ImageIcon(new ImageIcon("images/lady.png").getImage().getScaledInstance(100, 115, java.awt.Image.SCALE_SMOOTH)));
	private JLabel speech = new JLabel(new ImageIcon(new ImageIcon("images/speech.png").getImage().getScaledInstance(1280/5, (int)964/6, java.awt.Image.SCALE_SMOOTH)));
	private JLabel order;
	private JLabel speechText;
	
	//second screen elements
	private JLabel constLabel = new JLabel("here's the constuctor for the cake class");
	private JLabel cakeConstructor = new JLabel(new ImageIcon("images/cake.png"));
	
	
	private String[] number = {"first", "second", "last"};
	
	
	public CustomerOrderClass(int customerNumber) {

		setSize(783, 533);
		setName("All About Objects + Classes");
		
		welcomeLabel = new JLabel("customer "+customerNumber);
		speechText = new JLabel("<html>your "+number[customerNumber-1]+" customer<br> requested the following:</html>");
		order = new JLabel(new ImageIcon(new ImageIcon("images/orders/order"+customerNumber+".png").getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH)));

		// set up main panel
		mainPanel.setBounds(0, 0, 783, 533);
		mainPanel.setBackground(PINK);
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
		welcomeLabel.setFont(MainMenuClass.italiana.deriveFont(60f));
		topPanel.add(welcomeLabel);

		// button
		nextStep.setBounds(683 - 30 - 150, 403 - 30 - 50, 150, 50);
		nextStep.setFont(MainMenuClass.inter.deriveFont(15f));
		nextStep.setBackground(PINK);
		nextStep.addActionListener(this);
		topPanel.add(nextStep);
		
		lady.setBounds(40, 230, 100, 115);
		topPanel.add(lady);
		
		speech.setBounds(110, 120, 1280/5, (int)964/5);
		topPanel.add(speech);
		
		speechText.setBounds(160, 170, 200, 70);
		speechText.setFont(MainMenuClass.inter.deriveFont(15f));
		topPanel.add(speechText);
		
		order.setBounds(390, 50, 250, 250);
		topPanel.add(order);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == nextStep) {
			dispose();
			Board.takenOrder = true;
			//changeScreen();
		}

	}


}
