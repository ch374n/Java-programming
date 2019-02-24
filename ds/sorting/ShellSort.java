// complexity between O(N) and O(N^2)
// stable sort
public class ShellSort {
	public static void main(String[] args) {
		int[] array = {10, 4, 9, 7, 11, 1, 3, 15, 6};
		shellSort(array);
	}
	public static void display(int[] array) {
		for(int i : array) {
			System.out.print(i + " ");
		}		
			System.out.println();
	}
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void shellSort(int[] array) {
		int gap = array.length / 2;
		while(gap >= 1) {
			for(int end = gap; end < array.length; end++) {
				for(int k = end; k - gap >= 0; k -= gap) {
					if(array[k] < array[k - gap]) {
						swap(array, k, k - gap);
					} else {
						break;
					}
				}
				display(array);
			}
			gap--;
		}
	}
}