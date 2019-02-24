
public class Diagonals {
	public static void main(String[] args) {
		int[][] array = {
			{0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 1, 0},
			{0, 1, 0, 1, 0, 0},
			{0, 0, 1, 0, 0, 0},
			{0, 1, 0, 1, 0, 0},
			{1, 0, 0, 0, 1, 0}
		};
		findSum(array, 4, 3);
	}
	public static void findSum(int[][] array, int row, int col) {
		int leftDiag = 0;
		int rightDiag = 0;
		int r = 0, c = 0;
		if(row > col) {
			r = row - col;
		} else {
			c = col - row;
		}
		while(r < 6 && c < 6) {
			leftDiag += array[r++][c++];
		}
		System.out.println("left : " + leftDiag);
		r = 0;
		c = 5;
		if(row + col < 6) {
			c = Math.min(row + col, 5);
		} else {
			r = (row + col) % 5 - 2;
		}
		while(r < 6 && c >= 0) {
			rightDiag += array[r++][c--];
		}
		System.out.println("right : " + rightDiag);
	}
}