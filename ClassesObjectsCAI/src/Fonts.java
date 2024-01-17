// this class imports and initialized fonts that do not exist in Java library
// fonts are downloaded from https://fonts.google.com/

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import java.io.File;

public class Fonts {

	public static Font interRegularEDU;
	public static Font italianaTitle;

	public static void main(String[] args) {

		italianaTitle = loadFont("fonts/Italiana/Italiana-Regular.ttf");

	}

	// this method creates a new font from a true type font file
	private static void createFont(Font fontName, String address, float size) {

		// code is from https://docs.oracle.com/javase/tutorial/2d/text/fonts.html
		try {
			fontName = Font.createFont(Font.TRUETYPE_FONT, new File(address)).deriveFont(size);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(address)));
		} catch (IOException | FontFormatException e) {
			// handle exception
		}

	}

	private static Font loadFont(String address) {
		Font bodyFont = null;
		try {
			bodyFont = Font.createFont(Font.TRUETYPE_FONT, new java.io.File(address));
			GraphicsEnvironment font = GraphicsEnvironment.getLocalGraphicsEnvironment();
			font.registerFont(bodyFont);
			return bodyFont;
		} catch (FontFormatException | IOException error) {
			System.out.println("File not found!");
		}
		return bodyFont;
	}

}
