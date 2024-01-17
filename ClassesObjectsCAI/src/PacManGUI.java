import java.awt.Color;

import javax.swing.*;

// this class sets up the gui
@SuppressWarnings("serial")
public class PacManGUI extends JFrame {
	
	// sets up the game board, a panel
	private Board board = new Board();
			
	// constructor method to set up frame
	public PacManGUI() {
		
		// construct frame
		setSize(800, 600);
		setTitle("Vrinda Joshi's PacMan Game");
		
		// used to save memory
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		// set up board
		board.setBounds(0, 0, 40*13, 40*17);
		add(board);
		
		// key listener for board so pacman can move
		addKeyListener(board);
		
		// set visible
		setVisible(true);
		
	} // main method end
	
} // class end