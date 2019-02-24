
public class Hanoi {
	public static void main(String[] args) {
		towerOfHanoi(3, 'A', 'B', 'C');
	}
	public static void towerOfHanoi(int numDisks, char start, char aux, char end) {
		if(numDisks >= 1) {
			towerOfHanoi(numDisks - 1, start, end, aux);
			System.out.format("disk : %d is moved from %c to %c\n", numDisks, start, end);
			towerOfHanoi(numDisks - 1, aux, start, end);
		}
	}
}
 