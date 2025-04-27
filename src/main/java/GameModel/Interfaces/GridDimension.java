package GameModel.Interfaces;

public interface GridDimension {
	
	/** 
	 * The total width of the board
	 * 
	 * @return the total width of the board as an integer
	 */
	int width();
	
	/** 
	 * The total height of the board
	 * 
	 * @return the total height of the board as an integer
	 */
	int height();

	/** 
	 * Number of rows in the grid
	 * 
	 * @return amount of rows in the grid as an integer
	 */
	int rows();

	/** 
	 * Number of columns in the grid
	 * 
	 * @return amount of columns in the grid as an integer
	 */
	int cols();
  
	/** 
	 * size of each cell in the grid 
	 * 
	 * @return size of each cell as an integer
	 */
	int cellSize();
}
