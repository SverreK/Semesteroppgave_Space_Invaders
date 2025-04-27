package GameController.Interfaces;

import GameModel.GameState;

/**
 * Represents a controllable model for the Space Invaders game
 * Provides methods to control the player's ship and access game status
 */
public interface ControllableSpaceInvadersModel {
	
	/**
     * Moves the ship left
     *
     * @return true if the ship can move left, false if move is illegal
     */
	boolean moveShipLeft();
	
	/**
     * Moves the ship right
     *
     * @return true if the ship can move right, false if move is illegal
     */
	boolean moveShipRight();
	
	/**
     * The state of the game i.e GAME_OVER/ACTIVE
     *
     * @return current game state
     */
	GameState getGameState();
	
	/**
     * Defines number of milliseconds between each time interval
     *
     * @return number of milliseconds between each tick
     */
	int getTimeInterval();
	
	/**
	 * Called every game tick (frame update) to progress the game logic.
	 */
	void clockTick();
}
