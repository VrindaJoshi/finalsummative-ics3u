import javax.swing.JLabel;

public class Mover extends JLabel{
	
	//create rows, columns
	private int row, column;
	
	// delta row, delta column (delta = change) (can only equal -1,0,1)
	private int dRow, dColumn;
	
	// alive/dead variable
	private boolean isDead;

	public Mover(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getdRow() {
		return dRow;
	}

	public void setdRow(int dRow) {
		this.dRow = dRow;
	}

	public int getdColumn() {
		return dColumn;
	}

	public void setdColumn(int dColumn) {
		this.dColumn = dColumn;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	//
	public void move() {
		
		// change the row
		row += dRow;
		column += dColumn;
	}
	
	public void setDirection(int direction) {
		
		//set delta values
		dRow = 0;
		dColumn = 0;
		
		// based on direction, mover mover
		if (direction == 0)
			dColumn  = -1;
		else if (direction == 1)
			dRow  = -1;
		else if (direction == 2)
			dColumn  = 1;
		else if (direction == 3)
			dRow  = 1;
	}
	
	public int getDirection() {
		
		if (dRow == 0 && dColumn == -1)
			return 0;
		else if (dRow == -1 && dColumn == 0)
			return 1;
		else if (dRow == 0 && dColumn == 11)
			return 2;
		else
			return 3;
		
	}
	
	public int getNextRow() {
		
		return row + dRow;
	}
	
	public int getNextColumn() {
		
		return column + dColumn;
		
	}
	
	

}