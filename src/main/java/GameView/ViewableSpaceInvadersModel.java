package GameView;

import java.util.List;

import GameModel.GameState;
import GameModel.Ship;
import GameModel.Aliens.Aliens;
import GameModel.Interfaces.GridDimension;

public interface ViewableSpaceInvadersModel {
	
	GridDimension getDimension();
	
	Ship getShip();
	
	List<Aliens> getAliens();
	
	GameState getGameState();
	
	int getScore();
	
	int getLevel();

}
