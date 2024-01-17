import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

// this clase creates the score panel at the top of the board
public class ScorePanel extends JPanel	{
	
	// font used
	private Font headerFont = new Font("Times New Roman", Font.PLAIN, 20);
	
	// score
	static JLabel scoreLabel = new JLabel();
	private JLabel scoreHeaderLabel = new JLabel("SCORE:");
	
	// high score
	static JLabel highScoreLabel = new JLabel();
	private JLabel highScoreHeaderLabel = new JLabel("HIGH SCORE:");
	
	// lives
	static JLabel livesLabel = new JLabel();
	private JLabel livesHeaderLabel = new JLabel("LIVES:");
	
	// player
	static JLabel userNameLabel = new JLabel();
	static JLabel userNameHeaderLabel = new JLabel("PLAYER:");

	
	// constructor method
	public ScorePanel() {
		
		setBounds(0, 0, 600, 35);
		setBackground(Color.BLACK);
		
		userNameLabel.setText("");
		userNameLabel.setForeground(Color.WHITE);
		userNameLabel.setFont(headerFont);
		
		userNameHeaderLabel.setBounds(305, 5, 100, 20);
		userNameHeaderLabel.setForeground(Color.WHITE);
		userNameHeaderLabel.setFont(headerFont);
		
		add(userNameHeaderLabel);
		add(userNameLabel);
		
		scoreLabel.setText(""+Board.score);
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setFont(headerFont);
		
		scoreHeaderLabel.setBounds(5, 5, 100, 20);
		scoreHeaderLabel.setForeground(Color.WHITE);
		scoreHeaderLabel.setFont(headerFont);
		add(scoreHeaderLabel);
		add(scoreLabel);
		
		highScoreLabel.setText(""+Board.highscore);
		highScoreLabel.setForeground(Color.WHITE);
		highScoreLabel.setFont(headerFont);
		
		highScoreHeaderLabel.setBounds(305, 5, 100, 20);
		highScoreHeaderLabel.setForeground(Color.WHITE);
		highScoreHeaderLabel.setFont(headerFont);
		add(highScoreHeaderLabel);
		add(highScoreLabel);
		
		livesLabel.setText(""+3);
		livesLabel.setForeground(Color.WHITE);
		livesLabel.setFont(headerFont);
		
		livesHeaderLabel.setBounds(605, 5, 100, 20);
		livesHeaderLabel.setForeground(Color.WHITE);
		livesHeaderLabel.setFont(headerFont);
		
		add(livesHeaderLabel);
		add(livesLabel);
				
	}

}