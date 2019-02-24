// O(LogN)

public class BinarySearch {
	public static void main(String[] args) {
		String s = "chetan is awesome programmer!";
		reverseIt(s, s.charAt(0), 0);
	}
	public static void reverseIt(String s, char c, int index) {
		if(index == s.length() - 1) {
			System.out.print(s.charAt(index));
			return;
		}
		reverseIt(s, s.charAt(index + 1), index + 1);
		System.out.print(s.charAt(index));
	}
}