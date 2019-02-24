// program to print binary strings of length n
public class BinaryStrings { 
	public static void main(String[] args) {
		int[] arr = new int[10];
		binaryStrings(9, arr);
	}
	public static void binaryStrings(int ptr, int[] arr) {
		if(ptr < 0) {
			for(int i = 9; i >= 0; i--) {
				System.out.print(arr[i] + " ");
			}
				System.out.println();
		} else {
			arr[ptr] = 0;
			binaryStrings(ptr - 1, arr);
			arr[ptr] = 1;
			binaryStrings(ptr - 1, arr);
		}
	}
}