package GameModel;

import GameController.Interfaces.GameObject;

/**
 * Represents the player's ship in the game
 * Implements the GameObject interface to provide its basic properties
 */
public class Ship implements GameObject {
	
	private int x, y, width, height, speed;

	/**
     * Constructs a new Ship instance with specified position and size
     *
     * @param x the x-coordinate of the ship
     * @param y the y-coordinate of the ship
     * @param width the width of the ship
     * @param height the height of the ship
     */
	public Ship(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = 12;
	}
	
	/**
     * Creates a new Ship instance positioned in the bottom center of the board
     *
     * @param board the SpaceInvadersBoard used to determine position and dimensions
     * @return a new Ship object with the given dimensions and coordinates on the board
     */
	public static Ship newShip(SpaceInvadersBoard board) {
		int width = board.cellSize()*2;
		int height = board.cellSize();
		int x = board.cellSize() * board.cols() / 2 - board.cellSize();
		int y = board.cellSize() * (board.rows() - 6);
		
		return new Ship(x, y, width, height);
	}
	
	/**
     * Returns a new Ship object shifted by the specified x and y offsets
     *
     * @param delta_x the amount to shift the ship horizontally
     * @param delta_y the amount to shift the ship vertically
     * @return a new Ship object at the new position
     */
	public Ship shiftedBy(int delta_x, int delta_y) {
		return new Ship(x + delta_x, y + delta_y, width, height);
	}
	
	/**
     * Gets the movement speed of the ship
     *
     * @return the speed of the ship
     */
	public int getSpeed() {
		return speed;
	}

	@Override
	public void update() {
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
}
