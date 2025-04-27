package GameView;

import java.util.List;

import GameModel.GameState;
import GameModel.Bullet;
import GameModel.Ship;
import GameModel.Aliens.Aliens;
import GameModel.Aliens.redShip;
import GameModel.Interfaces.GridDimension;

/**
 * Interface for the view to access necessary game data from the model
 * Defines all the methods the view needs in order to draw and represent the current game state
 */
public interface ViewableSpaceInvadersModel {
	
	/**
     * The dimensions of the board, i.e. number of rows and columns
     *
     * @return an object of type GridDimension
     */
	GridDimension getDimension();

	/**
     * The state of the game i.e GAME_OVER/ACTIVE
     *
     * @return current game state
     */
	GameState getGameState();
	
	/**
     * Returns the player's ship object
     * Is used to draw and track the ships position
     *
     * @return the player's ship
     */
	Ship getShip();
	
	/**
     * Returns the red alien ship if it is currently active and alive
     *
     * @return the redShip instance
     */
	redShip getRedShip();
	
	/**
     * Returns the list of alien enemies currently in the game
     *
     * @return the list of aliens from game model
     */
	List<Aliens> getAliens();
	
	/**
     * Returns the list of bullets currently active on the screen
     *
     * @return a list of bullet objects from game model
     */
	List<Bullet> getBullets();
	
	/**
     * Returns the current alien toggle state, used for animating alien sprites
     *
     * @return true if aliens are in a toggled state, otherwise false
     */
	boolean getAlienToggle();
	
	/**
     * Returns the interval, in game ticks, between each alien movement
     *
     * @return number of ticks between alien moves
     */
	int getAlienInterval();
	
	/**
     * Returns the player's current score
     *
     * @return current score
     */
	int getScore();
	
	/**
     * Returns the highest score achieved during gameplay
     *
     * @return highest score recorded
     */
	int getHighScore();
	
	/**
     * Returns the current level the player has reached
     *
     * @return current level
     */
	int getLevel();
	
	/**
     * Returns the number of game ticks since the game started
     * Is used to time events and animation
     *
     * @return total number of ticks passed
     */
	int getTickCounter();
}
