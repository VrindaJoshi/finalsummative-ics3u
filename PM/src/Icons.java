// ICONS
// creates the imageicon constants for the elements on out screen

// import statements
import javax.swing.Icon;
import javax.swing.ImageIcon;

// class
public class Icons {
	
	// icons that do not change
	public static final ImageIcon COMPUTER = new ImageIcon("images/comp.png");
	public static final ImageIcon BLANK = new ImageIcon("images/Black.bmp");
	public static final ImageIcon DOOR = new ImageIcon("images/Black.bmp");
	public static final ImageIcon SKULL = new ImageIcon("images/Skull.bmp");
	public static final ImageIcon CHERRY = new ImageIcon("images/Cherry.bmp");
	public static final ImageIcon BLUE = new ImageIcon("images/BlueGhost.bmp");
	public static final ImageIcon GATE = new ImageIcon("images/Black.bmp");
	
	// wall array for different themes
	public static final ImageIcon COUNTER = new ImageIcon("images/counter.png");
	
	// pac man array for the different directions
	public static final ImageIcon[] USER = {
			new ImageIcon("images/user.png"),
			new ImageIcon("images/userInvert.png"),
			new ImageIcon("images/user.png"),
			new ImageIcon("images/userInvert.png"),
	};
	
	public static final ImageIcon[] CUSTOMER = {
			new ImageIcon("images/dog1.png"),
			new ImageIcon("images/dog2.png"),
			new ImageIcon("images/dog3.png"),
			new ImageIcon("images/dogRest.png"),
	};
	


} // end of class