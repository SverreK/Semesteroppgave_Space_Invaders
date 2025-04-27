package GameModel;

import GameModel.Interfaces.GridDimension;

public class SpaceInvadersBoard implements GridDimension {
	
	private static final int TILE_SIZE = 25;
	private final int rows;
	private final int cols;
	private final int WIDTH;
	private final int HEIGHT;
	
	/** 
	 * Constructs a SpaceInvadersBoard object, which is a playing board built as
	 * a grid with a specified amount of rows and cols
	 * 
	 * @param rows the amount of rows the given board should have
	 * @param cols the amount of cols the given board should have
	 **/
	public SpaceInvadersBoard(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.WIDTH = TILE_SIZE * cols; 
		this.HEIGHT = TILE_SIZE * rows;
	}
	
	@Override
	public int width() {
		return WIDTH;
	}
	
	@Override
	public int height() {
		return HEIGHT;
	}
	
	@Override
	public int rows() {
		return rows;
	}

	@Override
	public int cols() {
		return cols;
	}

	@Override
	public int cellSize() {
		return TILE_SIZE;
	}

	
	

}
