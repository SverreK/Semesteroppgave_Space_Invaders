package GameModel.Aliens;

import GameController.Interfaces.CollidableSpaceInvadersModel;
import GameModel.Ship;
import GameModel.SpaceInvadersBoard;
import GameModel.Interfaces.AlienSpaceInvadersModel;

public class redShip implements CollidableSpaceInvadersModel, AlienSpaceInvadersModel {
	
	private int x, y;
	private int width, height;
	private int speed = 2;
	public SpaceInvadersBoard board;
	boolean isAlive = false;
	private boolean movingRight = true;
	
	
	public redShip (int x, int y, int width, int height, int speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	
	public static redShip newShip(SpaceInvadersBoard board) {
		int speed = 20;
		int width = board.size()*2;
		int height = board.size();
		int x = board.size() * board.cols() / 2 - board.size();
		int y = board.size();
		
		return new redShip(x, y, width, height, speed);
	}
	
	

	@Override
	public void moveAlien() {
		if (movingRight) {
            x += speed; // flytt til høyre
        } else {
            x -= speed; // flytt til venstre
        }
		
	}

	@Override
	public void reverseDirection() {
		movingRight = !movingRight;
		
	}

	@Override
	public void dropDown() {
	}
	
	public void revive() {
		isAlive = true;
	}

	@Override
	public void kill() {
		isAlive = false;
		
	}

	@Override
	public boolean isAlive() {
		return isAlive;
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
