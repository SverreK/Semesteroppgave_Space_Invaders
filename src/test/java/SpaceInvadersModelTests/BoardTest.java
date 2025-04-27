package SpaceInvadersModelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import GameModel.SpaceInvadersBoard;

public class BoardTest {
	
	SpaceInvadersBoard board = new SpaceInvadersBoard(10,10);
	
	@Test
	public void boardTest() {
		int width = board.cellSize() * board.cols();
		int height = board.cellSize() * board.rows();
		int cellSize = board.width() / board.cols();
		assertEquals(board.width(), width);
		assertEquals(board.height(), height);
		assertEquals(board.cols(), 10);
		assertEquals(board.rows(), 10);
		assertEquals(board.cellSize(), cellSize);
	}

}
