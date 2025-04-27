package GameModel;

import GameController.Interfaces.GameObject;

/**
 * Represents a bullet fired by the player's ship
 * Implements the GameObject interface to provide its basic properties
 */
public class Bullet implements GameObject {
	
	private int x, y, width, height;
	private int speed = -15;
	private boolean used = false;
	
	/**
     * Constructs a new Bullet with the specified position and dimensions
     *
     * @param x the x-coordinate of the bullet
     * @param y the y-coordinate of the bullet
     * @param width the width of the bullet
     * @param height the height of the bullet
     */
	public Bullet(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
     * Checks if the bullet has already been used e.g hit an enemy or gone off screen
     *
     * @return true if the bullet is used, otherwise false
     */
	public boolean isUsed() {
		return used;
	}
	
	/**
     * Marks the bullet as used
     */
	public void remove() {
		used = true;
	}

	@Override
	public void update() {
		y += speed;	
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
