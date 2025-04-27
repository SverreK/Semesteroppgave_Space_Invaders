package GameView;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for loading and managing game sprites from a sprite sheet
 * 
 * The class loads and stores sprites from a single image resource
 * It allows easy access to individual sprites throughout the game
 * Each image is given a name and can be called upon statically
 */
public class SpriteLoader {
	
	private static final BufferedImage spriteSheet = Inf101Graphics.loadImageFromResources("sprite.png");
	private static final Map<String, BufferedImage> sprites = new HashMap<>();
	
	static {
        sprites.put("crab", spriteSheet.getSubimage(74,225, 21, 15));
        sprites.put("crab2", spriteSheet.getSubimage(107, 225, 21, 15));
        sprites.put("squid", spriteSheet.getSubimage(7, 225, 15, 15));
        sprites.put("squid2", spriteSheet.getSubimage(40, 225, 15, 15));
        sprites.put("blob", spriteSheet.getSubimage(179, 226, 26, 15));
        sprites.put("blob2", spriteSheet.getSubimage(147, 226, 26, 15));
        sprites.put("red_ship", spriteSheet.getSubimage(214, 224, 48, 20));
        sprites.put("board_frame", spriteSheet.getSubimage(5, 993, 255, 223));
        sprites.put("alien_hit", spriteSheet.getSubimage(437, 276, 26, 15));
        sprites.put("ship", spriteSheet.getSubimage(277, 228, 25, 15));
    }
	
	/**
     * Retrieves a sprite image by its name
     * 
     * @param name the name of the sprite e.g "crab", "ship", "alien_hit"
     * @return the corresponding BufferedImage or null if not found
     */
	public static BufferedImage get(String name) {
        return sprites.get(name);
    }

}
