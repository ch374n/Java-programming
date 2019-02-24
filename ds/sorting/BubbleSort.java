// stable sorting algorithm 
public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {10, 4, 9, 7, 11, 1, 3, 5, 6};
		bubbleSort(array);
		for(int el : array) {
			System.out.print(el + " ");
		}
	}
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void bubbleSort(int[] array) {
		boolean swapped = false;
		for(int i = 0; i < array.length; i++) {
			for(int j = array.length - 1; j > 0; j--) {
				if(array[j] < array[j-1]) {
					swap(array, j, j-1);
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
}