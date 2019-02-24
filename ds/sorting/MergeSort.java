// O(NLOGN)
// Not adaptive : doesn't break out early 
// stable sort 
public class MergeSort {
	public static void main(String[] args) {
		int[] array = {10, 4, 9, 7, 11, 1, 3, 15, 6};
		mergeSort(array);
		for(int el : array) {
			System.out.print(el + " ");
		}
	}
	public static void split(int[] array, int[] left, int[] right) {
		int index = 0;
		int firstHalf = left.length;
		for(int el : array) {
			if(index < firstHalf) {
				left[index] = el;
			} else {
				right[index - firstHalf] = el;				
			}
			index++;
		}
	}
	public static void merge(int[] array, int[] left, int[] right) {
		int first = 0;
		int second = 0;
		int index = 0;
		while(first < left.length && second < right.length) {
			if(left[first] < right[second]) {
				array[index] = left[first];
				first++;
			} else {
				array[index] = right[second];
				second++;
			}
				index++;
		}
		while(first < left.length) {
			array[index] = left[first];
			index++;
			first++;
		}
		while(second < right.length) {
			array[index] = right[second];
			second++;
			index++;
		}
	}
	public static void mergeSort(int[] array) {
		if(array.length == 1) {
			return;
		}
		int mid = array.length / 2 + array.length % 2;
		int[] left = new int[mid];
		int[] right = new int[array.length - mid];
		split(array, left, right);

		mergeSort(left);
		mergeSort(right);

		merge(array, left, right);
	}
}
