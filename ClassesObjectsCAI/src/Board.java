// PAC MAN BOARD  - can have different themes

// imports
import java.util.Scanner;
import javax.swing.*;
import java.io.*; // io : input-output
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.sound.sampled.*;

// class
@SuppressWarnings("serial")
public class Board extends JPanel implements KeyListener {

	// panel for board
	private JPanel mazePanel = new JPanel();

	// creates the maze array (25 rows, 27 columns)
	private Cell[][] mazeArray = new Cell[13][17];

	// creates the pacman mover
	static Mover user;

	// array of customers
	private Mover[] customerArray = new Mover[1];

	private boolean currentCakeDone = false;
	
	static int currentStance = 1;

	// constructor method - this method constructs the board
	public Board() {

		// set background color base on theme chose in intro panel
		Color bkgdColour = (Color.WHITE);

		// setBackground(bkgdColour);

		// set up panel
		mazePanel.setLayout(new GridLayout(13, 17));
		mazePanel.setBackground(bkgdColour);
		mazePanel.setBounds(0, 0, 40 * 13, 40 * 17);

		add(mazePanel);

		// load board, contents
		loadBoard();
		
	} // end of constructor

	// load board method
	private void loadBoard() {

		// set row to 0
		int row = 0;

		// initialize new file
		Scanner inputFile;

		// try the file, or catch the errors
		try {

			// set file to import
			inputFile = new Scanner(new File("mazes/store.txt"));

			// reads every row
			while (inputFile.hasNext()) {

				// reads in ONE line, switched to a char array
				char[] lineArray = inputFile.nextLine().toCharArray();

				// reads every column on the line array
				for (int column = 0; column < lineArray.length; column++) {

					// set the contents of the maze array to be the cell at the column index of the
					// line array
					mazeArray[row][column] = new Cell(lineArray[column]);

					// if the column is pacman, put pac man there
					if (lineArray[column] == 'W')
						mazeArray[row][column].setBorder(BorderFactory.createLineBorder(Color.decode("#98343c")));

					else if (lineArray[column] == 'U') {
						user = new Mover(row, column);
						user.setIcon(Icons.USER[0]);
						user.setDirection(2);
					}
					else if (lineArray[column] == 'C') {
						customerArray[0] = new Mover(row, column);
						customerArray[0].setIcon(Icons.CUSTOMER[0]);
						customerArray[0].setDirection(1);
					}

					// if the columns designates a customer, put a customer there
					if (lineArray[column] == '0' || lineArray[column] == '1' || lineArray[column] == '2') {

						// get the customer number
						int gNum = Character.getNumericValue(mazeArray[row][column].getItem());

						// set up that customer number
						customerArray[gNum] = new Mover(row, column);
					}

					mazePanel.add(mazeArray[row][column]);

				}
				row++;
				// add the block to the board

			} // end of for loop

			// go to next row

			// end of while loop

			// close the file
			inputFile.close();

			// catch any errors
		} catch (FileNotFoundException error) {

			// print error
			System.out.println("File Not Found");
		}

	} // end of loadBoard method
	
	

// ______________________________________________________________________________________________

	@Override
	public void keyTyped(KeyEvent key) {

	}

	@Override
	public void keyReleased(KeyEvent key) {
		// not used
	}

// ______________________________________________________________________________________________

	@Override
	public void keyPressed(KeyEvent key) {
		
		moveCustomers();

		// if pacman is not dead and user has not wo

		// change direction based on key
		int direction = key.getKeyCode() - 37;

		// delta row/column
		int dRow = 0;
		int dCol = 0;

		// based on key set direction
		if (direction == 0)
			dCol = -1;
		else if (direction == 1)
			dRow = -1;
		else if (direction == 2)
			dCol = 1;
		else if (direction == 3)
			dRow = 1;

		// if the next row/column is not equal to a wall
		if (mazeArray[user.getRow() + dRow][user.getColumn() + dCol].getIcon() != Icons.COUNTER && noBumping(dRow, dCol)) {
			// set icon to that direction
			if (direction == 0 || direction == 2)
				user.setIcon(Icons.USER[direction]);
			user.setDirection(direction);

			// update the Pac-Man's position
			// user.move();

			// perform the move immediately
			performMove(user);

		}

	}

	// perform move
	private void performMove(Mover mover) {

		// if mover is in bounds
		if (mover.getNextRow() >= 0 && mover.getNextRow() < 13 && mover.getNextColumn() >= 0
				&& mover.getNextColumn() < 17) {

			// set current cell and next cell
			Cell currentCell = mazeArray[mover.getRow()][mover.getColumn()];
			Cell nextCell = mazeArray[mover.getNextRow()][mover.getNextColumn()];

			// passage ways
			if (mover.getColumn() == 13) {
				// prompt question fill in..
			}

			// if next cell is not a wall
			if (nextCell.getIcon() != Icons.COUNTER) {

				currentCell.setIcon(Icons.BLANK);

				// move the mover
				mover.move();
				// set currrent cell
				currentCell = mazeArray[mover.getRow()][mover.getColumn()];

				// is mover and pacman did not collide

				currentCell.setIcon(mover.getIcon());
				if (mover == customerArray[0]) {
					currentCell.setIcon(Icons.CUSTOMER[3]);
				}
				
				System.out.println(currentCell);

				if (mover == user && currentCell.getItem() == 'M') {
					new CustomerOrderClass(1);

				}
				
				if (mover == customerArray[0]) {
					moveCustomers();
				}
			}
		
			// if current cell is a food
			// if the cell is a cherry

		}

	}// end of priv method

	// checks to make sure the customer and user do not bump into each other
	private boolean noBumping(int dRow, int dCol) {

		// check if ghost has collided
		for (int index = 0; index < Icons.CUSTOMER.length; index++) {

			if (mazeArray[user.getRow() + dRow][user.getColumn() + dCol].getIcon() == Icons.CUSTOMER[index]) {
				return false;
			}
		}

		return true;

	}

	// this method moves the customers
	private void moveCustomers() {

		// code to get the customers out

		// for all the customers
		for (Mover customer : customerArray) {

			// set current cell and next cell
			Cell currentCell = mazeArray[customer.getRow()][customer.getColumn()];
			Cell nextCell = mazeArray[customer.getNextRow()][customer.getNextColumn()];

			int dir = 0;
			

			if (nextCell.getItem() != 'C') {
				dir = 2;
				customer.setDirection(dir);
				performMove(customer);
			} 



			// set the customers' direction
						
		}

	}

} // end of class