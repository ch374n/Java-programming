
public class GCD {
	public static void main(String[] args) {
		System.out.println(findGCD(105, 91));
	}
	public static int findGCD(int a, int b) {
		if(a == b || (a % b == 0)) {
			return b;
		}
		if(b % a == 0) {
			return a;
		}
		if(a > b) {
			return findGCD(a % b, b);
		} 
			return findGCD(a, b % a);
	}
}