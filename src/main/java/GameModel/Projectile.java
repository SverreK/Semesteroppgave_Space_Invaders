package GameModel;

import java.awt.image.BufferedImage;

import GameController.Interfaces.CollidableSpaceInvadersModel;
import GameController.Interfaces.MoveableSpaceInvadersModel;
import GameModel.Interfaces.GameStateObserver;

public class Projectile implements MoveableSpaceInvadersModel, CollidableSpaceInvadersModel {
	
	private int x, y;
	private int width, height;
	private int speed = -15;
	private boolean used = false;
	
	public Projectile(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean isUsed() {
		return used;
	}
	
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
