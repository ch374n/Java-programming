// O(NLOGN)
// Not adaptive : doesn't break out early 
// stable sort 
public class MergeSort {
	public static void main(String[] args) {
		int[] array = {10, 4, 9, 7, 11, 1, 3, 15, 6};
		mergeSort(array);
	}
	public static void split(int[] array, int[] left, int[] right) {
		int index = 0;
		int firstHalf = left.length;
		for(int el : array) {
			
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
