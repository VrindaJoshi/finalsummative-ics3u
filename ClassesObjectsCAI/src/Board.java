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
public class Board extends JPanel implements KeyListener, ActionListener {

	// game timer - timer belongs to swing package
	private Timer gameTimer = new Timer(250, this); // 250ms

	// panel for board
	private JPanel mazePanel = new JPanel();

	// creates the maze array (25 rows, 27 columns)
	private Cell[][] mazeArray = new Cell[13][17];

	// creates the pacman mover
	static Mover user;

	// array of customers
	private Mover[] customerArray = new Mover[3];

	private boolean currentCakeDone = false;

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

					mazeArray[row][column].setBorder(BorderFactory.createLineBorder(Color.black));

					// if the column is pacman, put pac man there
					if (lineArray[column] == 'W')
						mazeArray[row][column].setBorder(BorderFactory.createLineBorder(Color.decode("#98343c")));

					else if (lineArray[column] == 'U') {
						user = new Mover(row, column);
						user.setIcon(Icons.USER[0]);
						user.setDirection(0);
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

		// starts game when key gets pressed
		gameTimer.addActionListener(null);

		if (gameTimer.isRunning() == false)
			gameTimer.start();

		// if pacman is not dead and user has not won
		else {

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
			if (mazeArray[user.getRow() + dRow][user.getColumn() + dCol].getIcon() != Icons.COUNTER) {
				// set icon to that direction
				user.setIcon(Icons.USER[direction]);
				user.setDirection(direction);

				// update the Pac-Man's position
				user.move();

				// perform the move immediately
				performMove(user);
			}

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

				// move the mover
				mover.move();

				// set currrent cell
				currentCell = mazeArray[mover.getRow()][mover.getColumn()];
			}

			// is mover and pacman did not collide
			else
				currentCell.setIcon(mover.getIcon());

			// if current cell is a food
			if (mover == user && currentCell.getItem() == 'M') {
				// prompt question pop up, add to menu bar or button

			}

			// if the cell is a cherry

		}

	}// end of priv method

	// this method moves the customers
	private void moveCustomers() {

		// code to get the customers out

		// for all the customers
		for (Mover customer : customerArray) {

			// set current cell and next cell
			Cell currentCell = mazeArray[customer.getRow()][customer.getColumn()];
			Cell nextCell = mazeArray[customer.getNextRow()][customer.getNextColumn()];

			int dir = 0;

			do {
				dir = 0;
			} while (currentCell.getItem() != 'E' && currentCakeDone == false);

			do {
				dir = 2;
			} while (customer.getColumn() != -1 && currentCakeDone == true);

			// set the customers' direction
			customer.setDirection(dir);

		}

	}

	// action listener
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(1);
		performMove(user);
		// moveCustomers();
	}

} // end of class