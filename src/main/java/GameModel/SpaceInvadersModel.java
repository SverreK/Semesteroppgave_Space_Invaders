package GameModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import GameModel.Aliens.Aliens;
import GameModel.Aliens.redShip;
import GameModel.Interfaces.AlienSpaceInvadersModel;
import GameModel.Interfaces.GameStateObserver;
import GameModel.Interfaces.GridDimension;
import GameView.ViewableSpaceInvadersModel;

public class SpaceInvadersModel implements ViewableSpaceInvadersModel, GameStateObserver {
	
	//Game objects
	private Ship ship;
	private redShip redShip;
	private SpaceInvadersBoard board;
	
	//Game object functionalities
	private boolean shouldDrop = false;
	private int alienCount = 0;
	private GameState state = GameState.ACTIVE_GAME;

	//Game object lists
	private List<Aliens> aliens;
	private List<Projectile> bullets;

	//ClockTick tasks
	private int tickCounter = 0;
	private int shootCoolDown = 40;
	private int timeSinceLastShot = shootCoolDown;
	private int ALIEN_MOVE_INTERVAL = 60;
	private int REDSHIP_SPAWN_INTERVAL = 500;
	private int REDSHIP_MOVE_INTERVAL = 4;
	private int REDSHIP_KILL_INTERVAL = 1000;
	
	//Level and score
	private int score = 0;
	private int level = 1;
	
	public SpaceInvadersModel() {
		this(new SpaceInvadersBoard(16, 13));
	}
	
	public SpaceInvadersModel(SpaceInvadersBoard board) {
		this.board = board;
		this.ship = Ship.newShip(board);
		
		this.redShip = redShip.newShip(board);
		this.aliens = new ArrayList<>();
		this.bullets = new ArrayList<>();
		
		
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
	
	public void moveRedShip() {
		
		if (redShip.isAlive()) {
			redShip.moveAlien();
			if (hitEdge(redShip.getX(), redShip.getWidth())) {
				redShip.reverseDirection();
			}
		}
	}
	
	public void createRedShip() {
		if (!redShip.isAlive()) {
			redShip = redShip.newShip(board);
			redShip.revive();
		}
	}
	
	public void createAlienGrid(int rows, int cols) {
		int padding = 5;
		double scaleFactor = 0.8;
		
	    int totalGridWidth = cols * board.size();
	    int boardWidth = board.width();
	    
	    int x_start = (boardWidth - totalGridWidth) / 2;
	    int y_start = board.size() * 5;
	    
	    // Beregn den nye størrelsen på alien basert på skaleringsfaktoren
	    int alienWidth = (int) (board.size() * scaleFactor);
	    int alienHeight = (int) (board.size() * scaleFactor);

	    for (int row = 0; row < rows; row++) {
	        for (int col = 0; col < cols; col++) {
	            // Beregn posisjon for alien
	            int x = x_start + (col * board.size());
	            int y = y_start + (row * board.size());

	            // Lag en alien med den nye størrelsen
	            Aliens alien = new Aliens(x, y, alienWidth, alienHeight, 12); // speed=12
	            
	            aliens.add(alien);
	        }
	    }
		
		alienCount = aliens.size();
	}
	
	public boolean hitEdge(int x, int width) {
		    int padding = 5;
		    if (x <= 14 || x + width >= board.width() - 10) {
		        return true;
		    }
		    return false;
	}
	
	public boolean hitBottom() {
		for (Aliens alien : aliens) {
			if (alien.getY() + alien.getHeight() >= ship.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public void moveAliens() {
		
		if (shouldDrop) {
			for (Aliens alien: aliens) {
				alien.dropDown();
				alien.reverseDirection();
			}
			shouldDrop = false;
			return;
		}
		
		boolean edgeHit = false;
		
		for (Aliens alien : aliens) {
			if (alien.isAlive()) {
				alien.moveAlien();
				
				if (hitEdge(alien.getX(), alien.getWidth())) {
					edgeHit = true;
					}
				}	
			}
		if (edgeHit) {
			shouldDrop = true;
			
		}
	}
	
	public Projectile createBullet() {
		int bulletWidth = board.size() / 8;
		int bulletHeight = board.size() / 2;
		
		if (canShoot()) {
			Projectile bullet = new Projectile(ship.getX() + ship.getWidth()*15/32, ship.getY(), bulletWidth, bulletHeight);
			bullets.add(bullet);
			timeSinceLastShot = 0;
			
			return bullet;
		}
		return null;
	}
	
	public void moveBullets() {
		for(Projectile bullet : bullets) {
			bullet.update();
			
			for (Aliens alien : aliens) {
			if(!bullet.isUsed() && alien.isAlive() && detectCollision(alien.getX(), alien.getY(), alien.getWidth(), alien.getHeight(),
																	  bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight())) {
				bullet.remove();
				alien.kill();
				score += 100;
				alienCount--;
				}
			
			if (!bullet.isUsed() && redShip.isAlive() && detectCollision(redShip.getX(), redShip.getY(), redShip.getWidth(), redShip.getHeight(),
																		 bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight())) {
				bullet.remove();
				score += 250;
				redShip.kill();
			}
				
			}
		}
		
		while (bullets.size() > 0 && (bullets.get(0).isUsed() || bullets.get(0).getY() <0 )) {
			bullets.remove(0);
		}
	}
	
	public boolean detectCollision(int x1, int y1, int w1, int h1,
            					   int x2, int y2, int w2, int h2) {
			return x1 < x2 + w2 &&
				   x1 + w1 > x2 &&
				   y1 < y2 + h2 &&
				   y1 + h1 > y2;
	}

	
	public boolean canShoot() {
		return timeSinceLastShot >= shootCoolDown;
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
	public List<Projectile> getBullets() {
		return bullets;
	}
	
	@Override
	public Ship getShip() {
		return ship;
	}

	@Override
	public int getTimeInterval() {
		return (int) (10 * Math.pow(0.9, getLevel()));
	}

	@Override
	public void clockTick() {
		
		if (hitBottom()) {
			state = GameState.GAME_OVER;
			return;
		}
		
		if (alienCount == 0) {
			aliens.clear();
			bullets.clear();
			level += 1;
			createAlienGrid(5,11);
		}
		
		if (tickCounter % (ALIEN_MOVE_INTERVAL - 5*level) == 0) {
			moveAliens();
		}
		
		if (tickCounter % REDSHIP_SPAWN_INTERVAL == 0) {
			createRedShip();
		}
		
		if (redShip.isAlive() && tickCounter % REDSHIP_KILL_INTERVAL == 0) {
			redShip.kill();
		}
		
		if(tickCounter % REDSHIP_MOVE_INTERVAL == 0) {
			moveRedShip();
			}

		moveBullets();
		
		tickCounter++;
		timeSinceLastShot++;

	}

	@Override
	public GameState getGameState() {
		return state;
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public redShip getRedShip() {
		return redShip;
	}

}
