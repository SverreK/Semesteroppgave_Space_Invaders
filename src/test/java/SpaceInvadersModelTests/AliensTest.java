package SpaceInvadersModelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import GameModel.SpaceInvadersBoard;
import GameModel.SpaceInvadersModel;
import GameModel.Aliens.AlienType;
import GameModel.Aliens.Aliens;
import GameModel.Aliens.redShip;

public class AliensTest {
	
	SpaceInvadersModel model = new SpaceInvadersModel();
	SpaceInvadersBoard board = new SpaceInvadersBoard(23, 26);
	
	@Test
	public void alienGridTest() {
		List<Aliens> aliens = model.getAliens();
		model.createAlienGrid(5, 11);
		
		//Grid = 5x11 = 55
		assertEquals(aliens.size(), 55);
		
		for (int i = 0 ; i < 11 ; i++) {
			Aliens alien = aliens.get(i);
			int row = i / 11;
			
			if (row == 0) {
				assertEquals(alien.getAlienType(), AlienType.SQUID);
			} else if (row <= 2) {
				assertEquals(alien.getAlienType(), AlienType.CRAB);
			} else if (row <= 5) {
				assertEquals(alien.getAlienType(), AlienType.BLOB);
			}
		}
		
		for (Aliens alien : aliens) {
			   switch (alien.getAlienType()) {
			       case SQUID -> assertEquals(alien.getScoreValue(), 30);
			       case CRAB -> assertEquals(alien.getScoreValue(), 20);
			       case BLOB -> assertEquals(alien.getScoreValue(), 10);
			   }
			alien.kill();
		}
		
		for (Aliens alien : aliens) {
			assertFalse(alien.isAlive());
		}
		
		
	}
	
	@Test
	public void alienRedShipTest() {
		redShip redAlienShip = redShip.newRedShip(board);
		assertFalse(redAlienShip.isAlive());
		redAlienShip.revive();
		assertTrue(redAlienShip.isAlive());
		
		int start_x = (board.width()/2) - (redAlienShip.getWidth()/2);
		assertEquals( redAlienShip.getX(), start_x);
		redAlienShip.moveAlien();
		assertEquals(redAlienShip.getX(), start_x + 20);
	}

}
