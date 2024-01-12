import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private Timer timer = new Timer(600000, this);
	
	private JLabel timerLabel = new JLabel(""+timer.getDelay());

	private JPanel[] questionPanelArray = new JPanel[numQuestions];
	
	

	public QuizClass() {
		
		timer.start();

		setSize(1366, 766);

		// set up main panel
		mainPanel.setBounds(0, 0, 1366, 766);
		mainPanel.setBackground(BEIGE);
		mainPanel.setLayout(null);
		add(mainPanel);

		setFirstPanel();

		setSecondPanel();

		setQuestionsPanel();

		setLayout(null);
		setVisible(true);

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
		
		timerLabel.setBounds(800, 30, 500, 100);
		timerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		timerLabel.setLayout(null);
		topPanelTwo.add(timerLabel);

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scroll.setBounds(0, 175, 1166, 442);
		topPanelTwo.add(scroll);

		mainPanel.add(topPanelTwo);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == firstButton) {
			mainPanel.remove(topPanelOne);
			setSecondPanel();

			revalidate();
			repaint();
		}

	}

}
