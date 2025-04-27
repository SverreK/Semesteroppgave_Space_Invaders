package GameModel.Aliens;

import GameController.Interfaces.GameObject;
import GameModel.Ship;
import GameModel.Interfaces.AlienSpaceInvadersModel;

/**
 * Represents a single alien in the Space Invaders game.
 * Handles movement, state of the alien (dead or alive), scoring, and rendering positions
 */
public class Aliens implements GameObject, AlienSpaceInvadersModel {
	
	private AlienType type;
	private int x, y, width, height, speed, deathTicks, scoreValue;
	private boolean isAlive = true;
	private boolean movingRight = true;
	
	/**
	 * Constructs an Alien with specified position, size, type, and score value
	 *
	 * @param x          The x-position of the alien
	 * @param y          The y-position of the alien
	 * @param width      The width of the alien
	 * @param height     The height of the alien
	 * @param type       The type of the alien e.g CRAB, SQUID, etc
	 * @param scoreValue The score the player earns by killing this alien
	 */
	public Aliens(int x, int y, int width, int height, AlienType type, int scoreValue) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = 12;
		this.type = type;
		this.scoreValue = scoreValue;
	}
	
	/**
	 * Moves the alien downward vertically.
	 */
	public void dropDown() {
		y += 10;
	}
	
	@Override
	public void update() {
		if (!isAlive) {
			deathTicks++;
		}
	}

	@Override
	public void moveAlien() {
		if (movingRight) {
            x += speed;
        } else {
            x -= speed;
        }
	}

	@Override
	public void reverseDirection() {
		movingRight = !movingRight;	
	}
	
	@Override
	public boolean isAlive() {
		return isAlive;
	}

	@Override
	public void kill() {
		isAlive = false;
		deathTicks = 0;
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
	
	@Override
	public int getScoreValue() {
		return scoreValue;
	}
	
	@Override
	public int getDeathTicks() {
		return deathTicks;
	}
	
	@Override
	public AlienType getAlienType() {
		return type;
	}
}
