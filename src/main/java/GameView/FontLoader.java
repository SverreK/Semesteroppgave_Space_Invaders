package GameView;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

/**
 * Utility class for loading and applying custom fonts to a graphics context.
 * 
 * This class attempts to load a TrueType font from a given file path and applies it
 * with the desired size. If the font cannot be loaded a fallback monospaced font is used instead
 */
public class FontLoader {
	
	/**
     * Sets a custom TrueType font on the provided graphics
     * 
     * @param g2 the graphics context where the font will be set
     * @param file_path the file path to the TrueType font file
     * @param size the desired font size given as a float value
     */
	public static void setFont(Graphics g2, String file_path, float size) {
		try {
		    Font arcadeFont = Font.createFont(Font.TRUETYPE_FONT, new File(file_path))
		                          .deriveFont(size);
		    g2.setFont(arcadeFont);
		} catch (FontFormatException | IOException e) {
		    e.printStackTrace();
		    g2.setFont(new Font("Monospaced", Font.BOLD, (int) size));
		}

	}

}
