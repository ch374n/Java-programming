// not adaptive 
// not stable 
// worst case O(N)
public class QuickSort {
	public static void main(String[] args) {
		int[] array = {10, 4, 9, 7, 11, 1, 3, 15, 6};
		quickSort(array, 0, array.length - 1);
		for(int el : array) {
			System.out.print(el + " ");
		}		
	}
	public static void swap(int[] array, int start, int end) {
		int temp = array[start];
		array[start] = array[end];
		array[end] = temp;
	}
	public static int partition(int[] array, int low, int high) {
		int position = low - 1;
		int pivot = array[high];
		for(int i = low; i <= high - 1; i++) {
			if(array[i] < pivot) {
				position++;
				swap(array, position, i);
			}
		}
			position++;
			swap(array, position, high);
			return position;
	}
	public static void quickSort(int[] array, int low, int high) {
		if(low < high) {
			int pivot = partition(array, low, high);	
			quickSort(array, low, pivot - 1);
			quickSort(array, pivot + 1, high);
		}
	}
}