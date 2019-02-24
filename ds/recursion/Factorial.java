// program to find factorial of given number 
// program to find n th fibonacci number

public class Factorial {
	public static void main(String[] args) {
		// System.out.println(findFact(5));
		System.out.println(findNthFib(7));
	}
	public static int findFact(int num) {
		if(num > 0) {
			return num * findFact(num - 1);
		}
			return 1;
	}
	public static int findNthFib(int num) {
		if(num == 1 || num == 2) {
			return 1;
		}
		return findNthFib(num - 1) + findNthFib(num - 2);
	}	
}