// ICONS
// creates the imageicon constants for the elements on out screen

// import statements
import javax.swing.Icon;
import javax.swing.ImageIcon;

// class
public class Icons {
	
	// icons that do not change
	public static final ImageIcon COMPUTER = new ImageIcon("images/images/comp.png");
	public static final ImageIcon BLANK = new ImageIcon("images/images/Black.bmp");
	public static final ImageIcon DOOR = new ImageIcon("images/images/Black.bmp");
	public static final ImageIcon SKULL = new ImageIcon("images/images/Skull.bmp");
	public static final ImageIcon CHERRY = new ImageIcon("images/images/Cherry.bmp");
	public static final ImageIcon BLUE = new ImageIcon("images/images/BlueGhost.bmp");
	public static final ImageIcon GATE = new ImageIcon("images/images/Black.bmp");
	public static final ImageIcon COUNTER = new ImageIcon("images/images/counter.png");
	
	// pac man array for the different directions
	public static final ImageIcon[] USER = {
			new ImageIcon("images/images/userInvert.png"),
			new ImageIcon("images/images/userInvert.png"),
			new ImageIcon("images/images/user.png"),
			new ImageIcon("images/images/user.png"),
	};
	
	public static final ImageIcon[] CUSTOMER = {
			new ImageIcon("images/images/dog1.png"),
			new ImageIcon("images/images/dog2.png"),
			new ImageIcon("images/images/dog3.png"),
			new ImageIcon("images/images/dogRest.png"),
	};
	


} // end of class