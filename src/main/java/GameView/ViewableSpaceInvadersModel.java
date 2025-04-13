package GameView;

import java.util.List;

import GameModel.GameState;
import GameModel.Projectile;
import GameModel.Ship;
import GameModel.Aliens.Aliens;
import GameModel.Aliens.redShip;
import GameModel.Interfaces.GridDimension;

public interface ViewableSpaceInvadersModel {
	
	GridDimension getDimension();
	
	Ship getShip();
	
	redShip getRedShip();
	
	List<Aliens> getAliens();
	
	List<Projectile> getBullets();
	
	GameState getGameState();
	
	int getScore();
	
	int getLevel();

}
