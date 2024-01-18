import java.awt.Color;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class BoardClass extends JFrame implements KeyListener{
	
	static Board board = new Board();
	
	public BoardClass() {
	
	// construct frame
		
			setSize(40*18, 40*14);
			setName("All About Objects+ + Classes");

			// used to save memory
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// intro screen
			setMainPanel();

			// key listener for board so pacman can move
			setLayout(null);
			
			setLocationRelativeTo(null); // sets pop-up in center of screen

			// set visible
			setVisible(true);
	}
	
	
	private void setMainPanel() {

		// set up board
		board.setBounds(0, 20, 40 * 18, 40 * 14);
		add(board);
		
		// key listener for board so pacman can move
		addKeyListener(board);

	}


	public static void close() {
		
		setVisible(false);
		
	}

}
