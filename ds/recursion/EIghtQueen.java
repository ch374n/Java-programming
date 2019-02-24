// program to place 8 queens on 8 * 8 matrix such that no two queens cross each other
public class EIghtQueen {
	public static void main(String[] args) {
		int[][] chessBoard = new int[8][8];
		if(placeQueens(chessBoard, 0)) {
			for(int[] ar : chessBoard) {
				for(int el : ar) {
					System.out.print(el + " ");
				}
				System.out.println();
			}
		}
	}
	public static boolean isRowSafe(int[][] chessBoard, int row) {
		int rowSum = 0;
		for(int col = 0; col < 8; col++) {
			rowSum += chessBoard[row][col];
		}
			return rowSum == 1;
	}
	public static boolean isColSafe(int[][] chessBoard,int col) {
		int colSum = 0;
		for(int row = 0; row < 8; row++) {
			colSum += chessBoard[row][col];
		}
			return colSum == 1;
	}
	public static boolean isLeftDiagonalSafe(int[][] chessBoard, int row, int col) {
		int r = 0, c = 0;
		int leftDiagSum = 0;
		if(row > col) {
			r = row - col;
		} else {
			c = col - row;
		}
		while(r < 8 && c < 8) {
			leftDiagSum += chessBoard[r++][c++];
		}
			return leftDiagSum == 1;
	}
	public static boolean isRightDiagonalSafe(int[][] chessBoard, int row, int col) {
		int r = 0, c = 7;
		int rightDiagSum = 0;
		if(row + col < 8) {
			c = Math.min(row + col, 7);
		} else {
			r = (row + col) % 7 - 2;
		}
			System.out.print("row : " + r + " col : " + col + "\n");
		while(r < 8 && c >= 0) {
			rightDiagSum += chessBoard[r++][c--];
		}
			return rightDiagSum == 1;
	}
	public static boolean isSafe(int[][] chessBoard, int row, int col) {
		if(!isRowSafe(chessBoard, row)) {
			return false;
		}
		if(!isColSafe(chessBoard, col)) {
			return false;
		}
		if(!isLeftDiagonalSafe(chessBoard, row, col)) {
			return false;
		}
			return isRightDiagonalSafe(chessBoard, row, col);
	}
	public static boolean placeQueens(int[][] chessBoard, int col) {
		if(col >= 8) {
			return true;
		}
		for(int row = 0; row < 8; row++) {
			chessBoard[row][col] = 1;
			if(isSafe(chessBoard, row, col)) {
				if(placeQueens(chessBoard, col + 1)) { 
					return true;
				}
			}
			chessBoard[row][col] = 0;
		}
			return false;
	}
}