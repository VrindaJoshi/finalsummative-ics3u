import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ActivityClass extends JFrame implements KeyListener {

	// sets up the game board, a panel
	private Store store = new Store();

	// constructor method to set up frame
	public ActivityClass() {
			
		// construct frame
		setSize(1366,766);
		setTitle("Vrinda Joshi's PacMan Game");
			
		// used to save memory
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		// set up board
		store.setBounds(0, 0, 1366, 766);
		add(store);
			
		// key listener for board so pacman can move
		addKeyListener(store);
		setLayout(null);
		
		// set visible
		setVisible(true);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
