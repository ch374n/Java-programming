// stable sort 
public class InsertionSort {
	public static void main(String[] args) {
		int[] array = {10, 4, 9, 7, 11, 1, 3, 5, 6};
		insertionSort(array);
		for(int el : array) {
			System.out.print(el + " ");
		}
	}	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void insertionSort(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = i + 1; j > 0; j--) {
				if(array[j] < array[j- 1]) {
					swap(array, j, j-1);
				} else {
					break;
				}
			}
		}
	}
}