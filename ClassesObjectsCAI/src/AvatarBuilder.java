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

	private JPanel mainPanel = new JPanel();

	private JLabel welcomeLabel = new JLabel("create your avatar");

	private JPanel topPanel = new JPanel();

	private JButton nextStep = new JButton("finish");

	private JLabel fieldsLabels = new JLabel("<html>name:<br><br>age:<br><br>gender:<br><br>hair color:</html>");

	public AvatarBuilder()
	{

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
		nextStep.setBackground(BEIGE);
		nextStep.addActionListener(this);
		topPanel.add(nextStep);

		// set title
		fieldsLabels.setBounds(50, 130, 90, 200);
		fieldsLabels.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		topPanel.add(fieldsLabels);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
