// program to find path to reach from current cell to destination cell

class Cell {
	private String id;
	private List<Cell> neighbors;
	public Cell(String id, Cell... neighbors) {
		this.id = id;
		for(Cell c : neighbors) {
			neighbors.add(c);
		}
	}
	public static boolean findPath()
}
public class Maze {
	public static void main(String[] args) {
	}

}