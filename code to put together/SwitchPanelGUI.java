// this class is the skeleton for the education class (slide show like frame)
package tests;

// SEE IF YOU CAN CHANGE THE SLIDE USING THE KEYBOARD

// imports
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// class
public class SwitchPanelGUI extends JFrame implements ActionListener {
	
	// colors
	static final Color BEIGE = new Color(227, 228, 219);
	static final Color GRAY = new Color(205, 205, 205);

	
	// static variables
	static JPanel[] panelArray = new JPanel[30]; // array of jpanels
	static int currentSlide = 0; // changing value of the current slide
	
	private JPanel mainPanel = new JPanel();

	private JPanel topPanel = new JPanel();

	// panel for buttons at the bottom
	private JPanel buttonPanel = new JPanel();
	private JProgressBar progressBar = new JProgressBar(0, panelArray.length);

	// contents of button panel
	private JButton nextButton = new JButton(">"); // next button to go to next slide
	private JButton backButton = new JButton("<"); // back button to go to previous slide
	private JButton finishButton = new JButton("finish"); // finish button to end slideshow
	
	
	// constructor
	public SwitchPanelGUI() {
		
		// set size of frame
		setSize(1366, 766);
		setTitle("Education Class");
		
		//set up main panel
		mainPanel.setBounds(0, 0, 1366, 766);
		mainPanel.setBackground(BEIGE);
		mainPanel.setLayout(null);
		add(mainPanel);
		
		setTopPanel();

		// initials panelArray method
		initializePanels();
		
		// show first panel
		mainPanel.add(panelArray[currentSlide]);
		
		// initialize buttonPanel and contents
		initializeButtons();
		
		// remove layout manager
		setLayout(null);
		
		// set frame to visible
		setVisible(true);
	}

	private void setTopPanel() {
		
		topPanel.setBounds(50, 50, 1166, 70);
		topPanel.setBackground(Color.WHITE);
		topPanel.setLayout(null);
		mainPanel.add(topPanel);
		
		// set up progress bar
        progressBar.setValue(currentSlide);
        progressBar.setForeground(GRAY);
        progressBar.setBounds(50, 120, 1166, 20);
        progressBar.setStringPainted(true); // show percent on progress bar
        mainPanel.add(progressBar);
		
	}

	// initialize buttonPanel and contents
	private void initializeButtons() {
		
		// button to go back (is not added at first as you cannot go back from first panel)
		backButton.setBounds(50, 0, 50, 50);
		backButton.addActionListener(this);
		backButton.setBackground(GRAY);
		backButton.setLayout(null);
		
		// button to go next
		nextButton.setBounds(1066, 0, 50, 50);
		nextButton.addActionListener(this);
		nextButton.setBackground(GRAY);
		nextButton.setLayout(null);
		buttonPanel.add(nextButton);
		
		// button to finish (is not added at first as you cannot go finish until you have gone through all slides)
		finishButton.setBounds(1016, 0, 100, 50);
		finishButton.addActionListener(this);
		finishButton.setBackground(GRAY);
		finishButton.setLayout(null);
		
		// set up button panel
		buttonPanel.setBounds(50, 576, 1166, 90);
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(Color.WHITE);
		mainPanel.add(buttonPanel);
		
	}

	// initials panelArray method 
	private void initializePanels() {
		
		// for loop for all panels, as they all have the same dimensions and locations
		for (int index = 0; index<panelArray.length; index++) {
			panelArray[index] = new JPanel();
			panelArray[index].setBounds(50, 140, 1166, 566-130);
			panelArray[index].setBackground(Color.WHITE);
			panelArray[index].setLayout(null);
		}		
	}

	// action listener for buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// check if button is finish button
		if (e.getSource() == finishButton) {
			dispose(); // close frame
		}
		
		// remove the current panel
		mainPanel.remove(panelArray[currentSlide]);
		
		// decide whether to go back or next
		if (e.getSource() == nextButton)
			currentSlide++;
		else if (e.getSource() == backButton) 
			currentSlide--;
		
		// add/remove back button based on if current slide is the first slide
		if (currentSlide != 0) {
			buttonPanel.add(backButton);
		} else
			buttonPanel.remove(backButton);
		
		// add/remove next button based on if current slide is the last slide
		if (currentSlide == panelArray.length-1) {
			buttonPanel.remove(nextButton);
			buttonPanel.add(finishButton); // add finish button
		} else
			buttonPanel.add(nextButton);
		
		progressBar.setValue(currentSlide);// change progress bar value
		mainPanel.add(panelArray[currentSlide]); // add the next or previous slide
		
		// make changes to frame
		revalidate();
		repaint();
		
	}
	

}
