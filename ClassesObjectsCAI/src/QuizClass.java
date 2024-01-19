import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.*;

public class QuizClass extends JFrame implements ActionListener {
	
	// colors
	static final Color BEIGE = new Color(227, 228, 219);
	static final Color GRAY = new Color(205, 205, 205);

	private JPanel mainPanel = new JPanel();

	private JPanel topPanelOne = new JPanel();
	private JLabel firstHeader = new JLabel("the final quiz");
	private JLabel firstText = new JLabel(
			"<html><div style='text-align: center;'>The lesson will conclude with a short quiz, that tests everything you can learned so far! You will get 10 minutes to complete the test, and feel free to review any content before you start!</div></html>");
	private JButton firstButton = new JButton("start");

	private JPanel topPanelTwo = new JPanel();
	private JLabel titleLabel = new JLabel("final quiz");

	private JPanel questionsPanel = new JPanel();
	private JScrollPane scroll = new JScrollPane(questionsPanel);

	int numQuestions = 10;
	private String[] questionsArray = new String[numQuestions];
	private JPanel[] questionPanelArray = new JPanel[numQuestions];
	private JTextField[] textFieldArray = new JTextField[4];
	
	// timer related variables
	private int[] timeArray = {10, 0, 10*1000*60 }; // minutes, seconds, time left
	private JLabel timerLabel = new JLabel(timeArray[0]+":0"+timeArray[1]);
	static Timer timer;
	
	private JButton finishQuiz = new JButton("submit");
	
	private String[] questionArray = new String[10];
	private JLabel[] questionLabelArray = new JLabel[10];
	@SuppressWarnings("rawtypes")
	private JComboBox[] trueFalseArray = new JComboBox[4];

	 // Initialization of object of "JRadioButton" class. 
    private JRadioButton  = new JRadioButton(); 

    // Initialization of object of "JRadioButton" class. 
    jRadioButton2 = new JRadioButton(); 
	
	private String[] tfArray = {"select","true","false"};

	public QuizClass() {		

		setSize(1366, 766);
		setName("All About Objects+ + Classes");
		
		// set up main panel
		mainPanel.setBounds(0, 0, 1366, 766);
		mainPanel.setBackground(BEIGE);
		mainPanel.setLayout(null);
		add(mainPanel);

		setFirstPanel();

		setSecondPanel();

		setQuestionsPanel();
		initializeArrays();


		setLayout(null);
		setVisible(true);
		
		// modified the code from https://www.youtube.com/watch?v=0cATENiMsBE to create a countdown
		timer = new Timer (1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				timeArray[2]-=1000;
				
				timeArray[0] = (timeArray[2]/60000)%60;
				timeArray[1] = (timeArray[2]/1000)%60;
				
				if (timeArray[1] < 10)
					timerLabel.setText(timeArray[0]+":0"+timeArray[1]);
				else
					timerLabel.setText(timeArray[0]+":"+timeArray[1]);
			}
		});

	}

	private void initializeArrays() {
		
		// question array
		questionArray[0] = "<html><br><br>What is an instance?</html>";
		questionArray[1] = "<html><br><br>What is the difference between fields and instance variables?</html>";
		questionArray[2] = "<html><br><br>TRUE OR FALSE: The data types of all objects is String<br><br><br><br><br><br></html>";
		questionArray[3] = "<html><br><br>TRUE OR FALSE: Get methods are called accessor methods<br><br><br><br><br><br></html>";
		questionArray[4] = "<html><br><br>TRUE OR FALSE: Every instance if familliar with it\'s own instance variables.<br><br><br><br><br><br></html>";
		questionArray[5] = "<html><br><br>TRUE OR FALSE: To create a new instance, you use the toString method<br><br><br><br><br><br></html>";
		questionArray[6] = "<html><br><br>FILL IN THE BLANK: <br><br>"
				+ "a(n)&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; "
				+ "is used to modify the contents of an instance variable.</html>";
		questionArray[7] = "<html><br><br>FILL IN THE BLANK: <br><br>"
				+ "a(n)&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;is a template for creating objects.</html>";
		questionArray[8] = "<html><br><br>FILL IN THE MISSING CODE: <br><br>"
				+ "atlanta.&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(100);</html>";
		questionArray[9] = "<html><br><br>FILL IN THE MISSING CODE: <br><br>"
				+ "City newYork = &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(\"Earth\", \"North America\", \"USA\", \"New York\", 8468000);</html>";		

		
		for (int index = 0; index < questionArray.length; index++ ) {
			questionLabelArray[index] = new JLabel(questionArray[index]);
			questionLabelArray[index].setBounds(40, 100, 766, 250);
			questionLabelArray[index].setFont(MainMenuClass.inter.deriveFont(20f));

			questionLabelArray[index].setLayout(null);
			questionPanelArray[index].add(questionLabelArray[index]);
			
			//`if true/false (combo box)
			
			if (index > 1 && index < 6 ) {
				trueFalseArray[index-2] = new JComboBox<Object>(tfArray);
				trueFalseArray[index-2].setLayout(null);
				trueFalseArray[index-2].setBorder(BorderFactory.createLineBorder(Color.black));
				trueFalseArray[index-2].setFont(MainMenuClass.inter.deriveFont(20f));
				trueFalseArray[index-2].setBounds(50, 100, 100, 40);

				questionLabelArray[index].add(trueFalseArray[index-2]);


			}
			
			// if needs text field
			else if (index >= 6) {
				textFieldArray[index-6] = new JTextField();
				textFieldArray[index-6].setLayout(null);
				textFieldArray[index-6].setBorder(BorderFactory.createLineBorder(Color.black));
				textFieldArray[index-6].setFont(MainMenuClass.inter.deriveFont(20f));
				textFieldArray[index-6].setBounds(50, 95, 130, 40);
				
				if (index == 8)
					textFieldArray[index-6].setBounds(85, 95, 140, 40);
				else if (index == 9)
					textFieldArray[index-6].setBounds(150, 95, 150, 40);
					
				questionLabelArray[index].add(textFieldArray[index-6]);
			}
		}
	}

	// ONE PANEL
	private void setQuestionsPanel() {

		questionsPanel.setBounds(0, 150, 1166, 442);
		questionsPanel.setBackground(Color.WHITE);
		questionsPanel.setLayout(null);
		questionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		questionsPanel.setPreferredSize(new Dimension(1166, 200*numQuestions));

		for (int index = 0; index < numQuestions; index++) {
			setQuestionPanels(index);
			questionLabelArray[index] = new JLabel();
		}

	}

	// TEN SIMILAR PANELS
	private void setQuestionPanels(int index) {
		questionPanelArray[index] = new JPanel();

		questionPanelArray[index].setBounds(0, 0 + (200 * index), 1166, 200);
		questionPanelArray[index].setBorder(BorderFactory.createLineBorder(Color.black));


		if (index % 2 == 0)
			questionPanelArray[index].setBackground(GRAY);
		else
			questionPanelArray[index].setBackground(Color.WHITE);
		
		questionsPanel.add(questionPanelArray[index]);
	
		

	}

	private void setFirstPanel() {

		// set up blank panel
		topPanelOne.setBounds(50, 50, 1166, 616);
		topPanelOne.setBackground(Color.WHITE);
		topPanelOne.setLayout(null);
		topPanelOne.setBorder(BorderFactory.createLineBorder(Color.black));

		firstHeader.setBounds(350, 100, 500, 70);
		firstHeader.setBackground(GRAY);
		firstHeader.setFont(new Font("Times New Roman", Font.BOLD, 70));
		firstHeader.setLayout(null);
		topPanelOne.add(firstHeader);

		firstText.setBounds(300, 200, 500, 150);
		firstText.setBackground(GRAY);
		firstText.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		firstText.setLayout(null);
		topPanelOne.add(firstText);

		firstButton.setBounds(450, 400, 200, 70);
		firstButton.addActionListener(this);
		firstButton.setBackground(GRAY);
		firstButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		firstButton.setLayout(null);
		topPanelOne.add(firstButton);

		mainPanel.add(topPanelOne);
	}

	private void setSecondPanel() {

		// set up blank panel
		topPanelTwo.setBounds(50, 50, 1166, 616);
		topPanelTwo.setBackground(Color.WHITE);
		topPanelTwo.setLayout(null);
		topPanelTwo.setBorder(BorderFactory.createLineBorder(Color.black));

		titleLabel.setBounds(50, 30, 500, 100);
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 80));
		titleLabel.setLayout(null);
		topPanelTwo.add(titleLabel);
		
		timerLabel.setBounds(800, 70, 100, 40);
		timerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		timerLabel.setLayout(null);
		topPanelTwo.add(timerLabel);

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scroll.setBounds(0, 175, 1166, 442);
		topPanelTwo.add(scroll);
		
		finishQuiz.setBounds(950, 50, 160, 75);
		finishQuiz.setFont(new Font("Times New Roman", Font.BOLD, 30));
		finishQuiz.setBackground(GRAY);
		finishQuiz.addActionListener(this);
		topPanelTwo.add(finishQuiz);

		mainPanel.add(topPanelTwo);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == firstButton) {
			mainPanel.remove(topPanelOne);
			setSecondPanel();
			
			timer.start();

			revalidate();
			repaint();
		}
		else if (e.getSource() == finishQuiz) {
			//grade quiz
			//if passed
			new CertificateClass();
			dispose();
			
		}

	}

}
