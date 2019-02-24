// program to check whether the point is within certain distance of central point 
import java.util.ArrayList;
import java.util.List;

class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public double getDistance(Point cp) {
		return Math.sqrt(Math.pow((cp.x - x), 2) + Math.pow((cp.y - y), 2));
	}
	public boolean isWithinDistance(Point cp, double distance) {
		if((cp.x - x > distance) || (cp.y - y > distance)) {
			return false;
		}
		return getDistance(cp) <= distance;
	}
	public String toString() {
		return "x : " + this.x + " y : " + this.y;
	}
}
public class WithinDistance {
	private static List<Point> list = new ArrayList<>();
	public static void main(String[] args) {
		list.add(new Point(1, 2));			
		list.add(new Point(3, 2));			
		list.add(new Point(4, 3));			
		list.add(new Point(5, 3));			
		list.add(new Point(2, 2));					
		getPointsWithinDistance(new Point(3, 2), 1);
	}
	public static void getPointsWithinDistance(Point cp, double distance) {
		for(Point p : list) {
			if(p.isWithinDistance(cp, distance)) {
				System.out.println(p);
			}
		}
	}
}


/*
	| 
	| 	*
	|			  *
	|	 	(*)
	|
	|	  *		*	
	|
	|		 *	   *   * 
	|
	|
	|
	|_______________________________
*/