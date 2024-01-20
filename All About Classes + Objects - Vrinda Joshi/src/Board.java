// ACTIVITY BOARD, pops up new JFrame

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
public class Board extends JFrame implements KeyListener {

	// color
	static final Color PINK = Color.decode("#FFE1E1");

	// panel for board
	private JPanel mazePanel = new JPanel();

	// creates the maze array (25 rows, 27 columns)
	private Cell[][] mazeArray = new Cell[13][17];

	// creates the user mover
	static Mover user;

	// checks whether customer has been served => open up door to kitchen
	private boolean servedCustomer = false;

	// array of customers; ended up only being 1 element
	private Mover[] customerArray = new Mover[1];

	// constructor method - this method constructs the board
	public Board() {

		// set up
		setSize(40 * 19, 40 * 17);
		setName("All About Objects + Classes");
		getContentPane().setBackground(PINK);

		// used to save memory
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(null);

		// key listener for board so pacman can move
		addKeyListener(this);

		setLocationRelativeTo(null); // sets pop-up in center of screen //
										// https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution

		// set visible
		setVisible(true);

		// set up panel
		mazePanel.setLayout(new GridLayout(13, 17));
		mazePanel.setBackground(Color.WHITE);
		mazePanel.setBounds(80, 60, 40 * 15 - 10, 40 * 13 - 15);
		mazePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(mazePanel);

		// load board, contents
		loadBoard();

	} // end of constructor

	// load board method
	private void loadBoard() {

		// set row to 0
		int row = 0;

		// initialize
		Scanner inputFile;

		// try the file, or catch the errors
		try {
			// set file to import
			if (ActivityClass.takenOrder == true) {
				inputFile = new Scanner(new File("mazes/kitchenStore.txt")); // has trigger up results after serving
			} else {
				inputFile = new Scanner(new File("mazes/store.txt")); // triggers user's order pop up
			}

			// reads every row
			while (inputFile.hasNext()) {

				// reads in ONE line, switched to a char array
				char[] lineArray = inputFile.nextLine().toCharArray();

				// reads every column on the line array
				for (int column = 0; column < lineArray.length; column++) {

					// set the contents of the maze array to be the cell at the column index of the
					// line array
					mazeArray[row][column] = new Cell(lineArray[column]);

					// if the column is counter, put counter there
					if (lineArray[column] == 'W') {
						mazeArray[row][column].setBorder(BorderFactory.createLineBorder(PINK));
					}
					// if user
					else if (lineArray[column] == 'U') {
						user = new Mover(row, column);
						user.setIcon(Icons.USER[0]);
						user.setDirection(2);
					}
					// if customer
					else if (lineArray[column] == 'C') {
						customerArray[0] = new Mover(row, column);
						customerArray[0].setIcon(Icons.CUSTOMER[0]);
						customerArray[0].setDirection(1);
					}

					// add cell
					mazePanel.add(mazeArray[row][column]);
				}

				row++;

			} // end of for loop

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
		// not used
	}

	@Override
	public void keyReleased(KeyEvent key) {
		// not used
	}

// ______________________________________________________________________________________________

	@Override
	public void keyPressed(KeyEvent key) {

		// move the customer to counter
		moveCustomers();

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

		// if the next row/column is not equal to a counter
		if (mazeArray[user.getRow() + dRow][user.getColumn() + dCol].getIcon() != Icons.COUNTER
				&& noBumping(dRow, dCol)) {
			// set icon to that direction
			if (direction == 0 || direction == 2)
				user.setIcon(Icons.USER[direction]);
			user.setDirection(direction);

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

			// if next cell is not a counter
			if (nextCell.getIcon() != Icons.COUNTER) {

				currentCell.setIcon(Icons.BLANK);

				// move the mover
				mover.move();

				// set current cell
				currentCell = mazeArray[mover.getRow()][mover.getColumn()];

				currentCell.setIcon(mover.getIcon());

				// set customer to rest
				if (mover == customerArray[0]) {
					currentCell.setIcon(Icons.CUSTOMER[3]);
				}

				// order pop up
				if (mover == user && currentCell.getItem() == 'M') {
					new CustomerOrderClass(ActivityClass.currentCake);
				}

				// allows customer to move w/o duplicating
				if (nextCell.getItem() == 'E' && mover != user) {
					currentCell.setIcon(Icons.BLANK);
				}

				// if serving customer..
				if (mover == user && currentCell.getItem() == 'S') {
					if (ActivityClass.gradeCake)
						JOptionPane.showMessageDialog(mazePanel, "They loved your cake! ", "!!!",
								JOptionPane.INFORMATION_MESSAGE);
					else {
						JOptionPane.showMessageDialog(mazePanel, "Your cake was a little disapointing... ", "!!!",
								JOptionPane.INFORMATION_MESSAGE);
					}

					// kick out customer
					mazeArray[2][7].setIcon(Icons.BLANK);

					JOptionPane.showMessageDialog(mazePanel, "Let's go back to the kitchen! ", "!!!",
							JOptionPane.INFORMATION_MESSAGE);
				}

				// dispose frame
				if (mover == user && currentCell.getItem() == 'K' && ActivityClass.takenOrder == true) {
					// if 3 rounds are over
					if (ActivityClass.currentCake == 4) {
						ActivityClass.finishedGame = true;
					}
					dispose();

				}

				// mover customers
				if (mover == customerArray[0]) {
					moveCustomers();
				}
			}
		}
	}

	// checks to make sure the customer and user do not bump into each other
	private boolean noBumping(int dRow, int dCol) {

		// check if cell is not any of the customers
		for (int index = 0; index < Icons.CUSTOMER.length; index++) {

			if (mazeArray[user.getRow() + dRow][user.getColumn() + dCol].getIcon() == Icons.CUSTOMER[index]) {
				return false; // do not allow move
			}
		}
		return true; // allow move
	}

	// this method moves the customers
	private void moveCustomers() {

		// code to get the customers out

		// for all the customers
		for (Mover customer : customerArray) {

			// set current cell and next cell
			Cell currentCell = mazeArray[customer.getRow()][customer.getColumn()];
			Cell nextCell = mazeArray[customer.getNextRow()][customer.getNextColumn()];

			// default
			int dir = 0;

			// if next cell is not a counter
			if (nextCell.getItem() != 'C') {
				dir = 2;
				customer.setDirection(dir);
				performMove(customer);
			}

			// set the customers' direction

		}

	}

} // end of class