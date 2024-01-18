import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ActivityClass extends JFrame implements ActionListener {

	// colors
	static final Color PINK = Color.decode("#FFE1E1");
	static final Color GRAY = new Color(205, 205, 205);

	static Board board = new Board();

	static JPanel mainPanel = new JPanel();
	static JPanel sidePanel = new JPanel();

	static JPanel topPanel = new JPanel();

	static int currentCake = 1;

	// second screen elements
	private static JLabel constLabel = new JLabel(
			"<html>here's the recipe for a basic cake! modify <br>it to make the perfect cake for your customer!!</html>");
	private static JLabel cakeConstructor = new JLabel(new ImageIcon("images/cake.png"));

	private static JLabel order = new JLabel(new ImageIcon(new ImageIcon("images/orders/order" + currentCake + ".png")
			.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH)));

	private static JLabel welcomeLabel = new JLabel("welcome to the kitchen!");

	private static JLabel cakeInstructions = new JLabel(
			"<html>create the cake in the box below! name the cake <i>cake" + currentCake + "<i>!</html>");
	private static JTextField answerField = new JTextField();

	private static JButton nextStep = new JButton("serve your cake!");

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
		sidePanel.setBounds(810, 45, 300, 40 * 13);
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

	// https://docs.oracle.com/javase/tutorial/uiswing/examples/components/TabbedPaneDemoProject/src/components/TabbedPaneDemo.java
	protected static JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		panel.setLayout(null);
		panel.setBackground(Color.white);

		return panel;
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = ActivityClass.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	// -------------------------------------------------------

	static void setCustomer() {

		// basic for all orders----------

		mainPanel.setBackground(PINK);
		mainPanel.setBounds(0, 0, 1366, 766);

		// set up blank panel
		topPanel.setBounds(50, 50, 1166, 616);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.setBackground(Color.WHITE);
		topPanel.setLayout(null);
		mainPanel.add(topPanel);

		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = createImageIcon("cakeIcon.png");

		JComponent panel1 = makeTextPanel("Panel #1");
		//
		constLabel.setBounds(20, 0, 400, 40);
		constLabel.setFont(MainMenuClass.inter.deriveFont(15f));
		panel1.add(constLabel);

		cakeConstructor.setBounds(20, 40, 445, 235);
		panel1.add(cakeConstructor);

		tabbedPane.addTab("Basic Cake Recipe", icon, panel1, null);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent panel2 = makeTextPanel("Panel #2");

		order.setBounds(0, 0, 500, 300);
		panel2.add(order);

		tabbedPane.addTab("Customer's Order", icon, panel2, null);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		tabbedPane.setBounds(50, 150, 500, 350);
		topPanel.add(tabbedPane);

		// set title
		welcomeLabel.setBounds(40, 40, 683, 70);
		welcomeLabel.setFont(MainMenuClass.italiana.deriveFont(60f));
		topPanel.add(welcomeLabel);

		// ------------

		cakeInstructions.setBounds(600, 250, 400, 30);
		cakeInstructions.setFont(MainMenuClass.inter.deriveFont(15f));
		topPanel.add(cakeInstructions);

		answerField.setBounds(600, 290, 450, 60);
		answerField.setBorder(BorderFactory.createLineBorder(Color.black));
		answerField.setFont(MainMenuClass.inter.deriveFont(15f));
		topPanel.add(answerField);

		// button
		nextStep.setBounds(730, 370, 200, 50);
		nextStep.setFont(MainMenuClass.inter.deriveFont(15f));
		nextStep.setBackground(PINK);
		nextStep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// set up blank panel
				mainPanel.setBounds(50, 50, 1166, 616);
				mainPanel.add(board);

				// key listener for board so pacman can move
				//addKeyListener(board);
				
				mainPanel.remove(topPanel);
				
				mainPanel.revalidate();
				mainPanel.repaint();
				
			}
		});
		topPanel.add(nextStep);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}