/*
	given a 2D matrix with state of cell (0 for dead 1 for live) 
	find out the next generation matrix 
	conditions : 
		1) a cell will die due to lack of resources if it's surrounded by less than 2 live cell
		2) a cell will die due to overcrowding if it's surrounded by more than 2 live cell
		3) a cell will live if its surrounded by 2 live cells
*/
public class GameOfLife {
	public static void main(String[] args) {
		int[][] mat = {
			{0, 1, 0, 0, 0},
			{1, 1, 1, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0},
			{0, 0, 0, 1, 0}
		};
		for(int[] row : mat) {
			for(int el : row) {
				System.out.print(el + " ");
			}
				System.out.println();
		}
		System.out.println("\n\n");
		mat = getNewGeneration(mat, 5, 5);
		for(int[] row : mat) {
			for(int el : row) {
				System.out.print(el + " ");
			}
				System.out.println();
		}
	}
	public static int getState(int[][] mat, int row, int col, int numRows, int numCols) {
		int count = 0;
		for(int i = row - 1; i <= row + 1; i++) {
			for(int j = col - 1; j <= col + 1; j++) {
					if((i >= 0  && i < numRows)&& (j < numCols && j >= 0) && (i != row || j != col)) {
						if(mat[i][j] == 1) {
							++count;
						}
					}
			}
		}		
		return count == 2 ? 1 : 0;
	}
	public static int[][] getNewGeneration(int[][] mat, int numRows, int numCols) {
		int[][] newGeneration = new int[numRows][numCols];
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				newGeneration[i][j] = getState(mat, i, j, numRows, numCols);
			}
		}
			return newGeneration;
	}
}