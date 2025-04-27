package SpaceInvadersModelTests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import GameModel.Ship;
import GameModel.SpaceInvadersBoard;
import GameModel.SpaceInvadersModel;

public class ShipTest {
	
	SpaceInvadersModel model = new SpaceInvadersModel();
	SpaceInvadersBoard board = new SpaceInvadersBoard(23,26);
	Ship ship = model.getShip();
	
	@Test
	public void shipPositionTest() {
		int start_x = (board.width()/2) - (ship.getWidth()/2);
		assertTrue(ship.getX() == start_x && ship.getY() >= 0);
	}
	
	 @Test
	 public void shipMovesRightTest() {
	     int start_x = ship.getX();
	     assertTrue(model.moveShipRight());
	     assertTrue(model.getShip().getX() == start_x + ship.getSpeed());
	    }
	 
	 @Test
	 public void shipMovesLeftTest() {
		 model.moveShipRight();
	     int start_x = model.getShip().getX();
	     assertTrue(model.moveShipLeft());
	     assertTrue(model.getShip().getX() == start_x - ship.getSpeed());
	    }
	


}
