// program to validate sudoku 
/*
	step 1 : make sure number is unique in row and column 
	step 2 : make sure number is unique in block
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class SudokuValidator {
	public static void main(String[] args) {
		int[][] sudokuBoard = {
			{ 8, -1,  -1,  4, -1,  6, -1, -1,  7},
			{-1, -1,  -1, -1, -1, -1,  4, -1, -1},
			{-1,  1,  -1, -1, -1, -1,  6,  5, -1},
			{ 5, -1,   9, -1,  3, -1,  7,  8, -1},
			{-1, -1,  -1, -1,  7, -1, -1, -1, -1},
			{-1,  4,   8, -1,  2, -1,  1, -1,  3},
			{-1,  5,   2, -1, -1, -1, -1,  9, -1},
			{-1, -1,   1, -1, -1, -1, -1, -1, -1},
			{ 3, -1,  -1,  9, -1,  2, -1, -1,  5}

		};
		System.out.println(isValid(sudokuBoard));
	}
	public static boolean isValidRowsAndCols(int[][] sudokuBoard) {
		List<Set<Integer>> rowSet = new ArrayList<>();
		List<Set<Integer>> colSet = new ArrayList<>();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				rowSet.add(new HashSet<>());
				colSet.add(new HashSet<>());
			}
		}
		for(int i = 0; i < 9; i++) { 
			for(int j = 0; j < 9; j++) {
				if(sudokuBoard[i][j] == -1) {
					continue;
				}
				if(sudokuBoard[i][j] < 0 || sudokuBoard[i][j] > 9) {
					return false;
				}
				if(rowSet.get(i).contains(sudokuBoard[i][j])) {
					return false;
				}
				if(colSet.get(j).contains(sudokuBoard[i][j])) {
					return false;
				}
				rowSet.get(i).add(sudokuBoard[i][j]);
				colSet.get(j).add(sudokuBoard[i][j]);
			}
		}
				return true;
	}
	public static boolean isValidBlock(int[][] sudokuBoard) {
			List<Set<Integer>> blockList = new ArrayList<>();
			for(int i = 0; i < 9; i++) {
				blockList.add(new HashSet<>());
			}
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					for(int miniRow = 0; miniRow < 3; miniRow++) {
						for(int minCol = 0; minCol < 3; minCol++) {
							int curRow = i * 3 + miniRow;
							int curCol = j * 3 + minCol;
							int cellValue = sudokuBoard[curRow][curCol];
							if(cellValue == -1) {
								continue;
							}
							if(cellValue < 0 || cellValue > 9) {
								return false;
							}
							int blockNum = i * 3 + j;
							if((blockList.get(blockNum)).contains(cellValue)) {
								return false;
							} 
								blockList.get(blockNum).add(cellValue);
						}
					}
				}
			}
				return true;
	}
	private static boolean isValid(int[][] sudokuBoard) {
		if(!isValidRowsAndCols(sudokuBoard)) {
			return false;
		}
		if(!isValidBlock(sudokuBoard)) {
			return false;

		}
			return true;
	}
}