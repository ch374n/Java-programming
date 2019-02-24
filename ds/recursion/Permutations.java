
public class Permutations {
	public static void main(String[] args) {
		char[] s = {'C', 'E', 'H', 'A', 'T', 'N'};
		printPermutations(s, 0, 5);
	}
	public static char[] swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
		return s;
	}
	public static void printPermutations(char[] s, int start, int end) {
		if(start == end) {
			if(new String(s).equals("CHETAN")) {
				System.out.println("I guessed it!, your password is : " + new String(s));
			}
		} else {
			for(int j = start; j <= end; j++) {
				s = swap(s, start, j);
				printPermutations(s, start + 1, end);
				s = swap(s, start, j);
			}
		}
	}
}