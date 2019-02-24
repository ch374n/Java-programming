
public class Palindrome {
	public static void main(String[] args) {
		System.out.print(isPalindrome("Madam"));
	}
	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int start = 0;
		int end = s.length() - 1;
		while(start <= end) {
			while(s.charAt(start) == ' ') {
				start++;
			}
			while(s.charAt(end) == ' ') {
				end--;
			}
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
		}
		return true;
	}
}