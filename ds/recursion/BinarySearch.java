// Recursive solution for binary search
// O(logN)
public class BinarySearch {
	public static void main(String[] args) {
		int[] array = {1, 3, 4, 6, 7, 9, 10, 11};
 		System.out.print("element found at : " + binarySearch(array, 0, array.length - 1, 7));
	}
	public static int binarySearch(int[] array, int low, int high, int el) {
		int mid = (low + high) / 2;
		if(array[mid] == el) {
			return mid;
		}
		if(low + 1 >= high) {
			return -1;
		}
		if(el < array[mid]) {
			return binarySearch(array, low, mid - 1, el);
		} else { 
			return binarySearch(array, mid + 1, high, el);
		}
	}
}
