// CELL
// template class for the cell object

// import classes
import javax.swing.*;

// class
public class Cell extends JLabel{
	
	// field
	private char item;

	// constructor
	public Cell(char item) {
		super();
		this.item = item;
		
		setCodeIcon();
	}

	// getters and setters
	public char getItem() {
		return item;
	}
	public void setItem(char item) {
		this.item = item;
	}
	
	// to string
	@Override
	public String toString() {
		return "Cell [item=" + item + "]";
	}
	
	// code icon method
	private void setCodeIcon() {
		
		// DEFAULT
		if (item == 'W') 
			 setIcon(Icons.COUNTER);
		else if (item == 'B') 
			 setIcon(Icons.COMPUTER);
		else if (item == 'U') 
			 setIcon(Icons.USER[1]);
		else if (item == 'C') 
			 setIcon(Icons.CUSTOMER[1]);	
	}

}