package GameController.Interfaces;

/**
 * Represents a general game object in the game
 * All objects that appear on the game board and can be updated each frame
 * should implement this interface
 */
public interface GameObject {
	
	/**
     * Updates the state or position of the game object
     * Typically called once per game tick or frame
     */
	void update();
	
	/**
     * Gets the x-coordinate of the game object
     *
     * @return the x-position in pixels
     */
	int getX();
	
	/**
     * Gets the y-coordinate of the game object
     *
     * @return the y-position in pixels
     */
	int getY();
	
	/**
     * Gets the width of the game object
     *
     * @return the width in pixels as an integer
     */
	int getWidth();
	
	/**
     * Gets the height of the game object
     *
     * @return the height in pixels as an integer
     */
	int getHeight();
}
