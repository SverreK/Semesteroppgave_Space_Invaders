package GameModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import GameModel.Aliens.Aliens;
import GameModel.Interfaces.AlienSpaceInvadersModel;
import GameModel.Interfaces.GameStateObserver;
import GameModel.Interfaces.GridDimension;
import GameView.ViewableSpaceInvadersModel;

public class SpaceInvadersModel implements ViewableSpaceInvadersModel, GameStateObserver {
	
	private SpaceInvadersBoard board;
	
	private Ship ship;
	private Projectile projectile;
	private List<Aliens> aliens;
	
	private GameState state = GameState.ACTIVE_GAME;
	
	public SpaceInvadersModel() {
		this(new SpaceInvadersBoard(16, 16));
	}
	
	public SpaceInvadersModel(SpaceInvadersBoard board) {
		this.aliens = new ArrayList<>();
		this.board = board;
		this.ship = Ship.newShip(board);
		
		createAlienGrid(5, 11);
	}
	
	public boolean moveShip(int delta_x, int delta_y) {
		Ship shifted = ship.shiftedBy(delta_x, delta_y);
		if(shifted.getX() >= 0 && shifted.getX() + shifted.getWidth() <= board.size() * board.cols()) {
			this.ship = shifted;
			return true;
		}	
		return false;
	}
	
	public void createAlienGrid(int rows, int cols) {
		int SPACING = 5;
		
	    int totalGridWidth = cols * board.size() + (cols - 1) * SPACING;
	    int boardWidth = board.size() * board.cols();
	    
	    int x_start = (boardWidth - totalGridWidth) / 2;
		int y_start = board.size();
		
		for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
        
                int x = x_start + (col * (board.size() + SPACING));
                int y = y_start + (row *(board.size() + SPACING)); 
                
                Aliens alien = new Aliens(x, y, board.size(), board.size(), 10); // speed=1
                aliens.add(alien);
            }
		}
	}
	
	@Override
	public GridDimension getDimension() {
		return board;
	}
	
	@Override
	public List<Aliens> getAliens() {
		return aliens;
		
	}
	
	@Override
	public Ship getShip() {
		return ship;
	}

	@Override
	public int getTimeInterval() {
		return (int) (1000 * Math.pow(0.9, getLevel()));
	}

	@Override
	public void clockTick() {
		for (Aliens alien : aliens) {
            alien.moveAlien();  // Beveg alienene til høyre eller venstre

            // Hvis alienene har nådd kanten, må de reversere og gå ned
            if (alien.getX() <= 0 || alien.getX() + alien.getWidth() >= board.size() * board.cols()) {
                alien.reverseDirection();
            }
        }
		
	}

	@Override
	public GameState getGameState() {
		return state;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

}
