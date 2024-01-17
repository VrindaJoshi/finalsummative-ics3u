import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ActivityClass extends JFrame {

	// colors
	static final Color BEIGE = new Color(200, 235, 198);
	static final Color GRAY = new Color(205, 205, 205);

	static Board board = new Board();

	static JPanel mainPanel = new JPanel();
	static JPanel sidePanel = new JPanel();


	// constructor method to set up frame
	public ActivityClass() {

		// construct frame
		setSize(1366, 766);
		setName("All About Objects+ + Classes");

		// used to save memory
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setMainPanel();
		setSidePanel();

		// key listener for board so pacman can move
		setLayout(null);

		// set visible
		setVisible(true);
	}


	private void setSidePanel() {

		// set up blank panel
		sidePanel.setBounds(810, 45, 300, 40*13);
		sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		sidePanel.setBackground(Color.decode("#ffe5ec"));
		sidePanel.setLayout(null);
		mainPanel.add(sidePanel);
		
	}


	private void setMainPanel() {

		// set up blank panel
		mainPanel.setBounds(50, 50, 1166, 616);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel.setLayout(null);
		add(mainPanel);

		// set up board
		board.setBounds(30, 25, 40 * 18, 40 * 14);
		mainPanel.add(board);

		// key listener for board so pacman can move
		addKeyListener(board);

	}
	
	
}