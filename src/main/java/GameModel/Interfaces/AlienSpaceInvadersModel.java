package GameModel.Interfaces;

import GameModel.Aliens.AlienType;

/**
 * Represents the behavior and properties of an alien in the Space Invaders game
 * Provides functionality for movement, alien state changes (dead or alive), and type-specific information
 */
public interface AlienSpaceInvadersModel {
	
	/**
     * Moves the alien horizontally based on its current direction and speed.
     */
	void moveAlien();
	
	/**
     * Reverses the alien's horizontal movement direction
     * Is called when the alien hits the left or right edge of the screen
     */
	void reverseDirection();
	
	/** Kills the alien, marking it as no longer alive */
	void kill();
	
	/**
     * Checks if the alien is alive or not
     *
     * @return true if aliens is alive, false if not
     */
	boolean isAlive();
	
	/**
     * Returns the score value when this alien is destroyed
     * The value depends on the alien's type
     *
     * @return the number of points awarded for killing this alien
     */
	int getScoreValue();
	
	/**
     * Gets the number of ticks since the alien was killed
     * Is used to time the duration of the aliens death animation
     *
     * @return the number of ticks passed since the alien was killed
     */
	int getDeathTicks();
	
	/**
	 * Gets the type of this alien (e.g. BLOB, CRAB, or SQUID)
	 *
	 * @return the alien type enum representing the alien's type
	 */
	AlienType getAlienType();

}
