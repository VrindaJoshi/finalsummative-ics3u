import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;

public class Store extends JPanel implements KeyListener {

	// panel for board
	private JPanel storePanel = new JPanel();

	// creates the maze array (25 rows, 27 columns)
	private Cell[][] storeArray = new Cell[8][13];
	
	public Store() {
		
		setSize(1366, 766);
		setLayout(null);
				
		//storePanel.setBackground(Color.decode("#D9CAB3"));
		storePanel.setLayout(null);
		storePanel.setBounds(0, 0, 1235, 95*8);
		add(storePanel);
		storePanel.setBackground(Color.WHITE);

		
		loadBoard();
	
	}
	
private void loadBoard() {
		
		// set row to 0
		int row = 0;
		
		// initialize new file
		Scanner inputFile;
		
		// try the file, or catch the errors
		try {
			
			// set file to import
			inputFile = new Scanner(new File("store.txt"));
			
			// reads every row
			while (inputFile.hasNext()) {
				
				// reads in ONE line, switched to a char array
				char[] lineArray = inputFile.nextLine().toCharArray();
								
				// reads every column on the line array
				for (int column = 0; column < lineArray.length; column++) {
					
					//set the contents of the maze array to be the cell at the column index of the line array
					storeArray[row][column] = new Cell(lineArray[column]);
					 
					storeArray[row][column].setBorder(BorderFactory.createLineBorder(Color.black));
					
					System.out.println(storeArray[row][column].getIcon());
					// add the block to the board
					storePanel.add(storeArray[row][column]);
					
					
					
				} // end of for loop
				
				// go to next row
				row++;
				
			} // end of while loop
		
			// close the file
			inputFile.close();
			
		// catch any errors
		} catch (FileNotFoundException error) {
			
			// print error
			System.out.println("File Not Found");
		}
		
	} // end of loadBoard method

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
