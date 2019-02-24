// program to implement counting sort 
// stable sorting algorithm
public class CountingSort {
	public static void main(String[] args) {
		int[] array = {1, 0, 3, 1, 3, 1};
		countingSort(array, 4);
	}
	public static void countingSort(int[] array, int maxEl) {
		int[] range  = new int[maxEl];
		int[] sorted = new int[array.length];
		for(int el : array) {
			range[el]++;
		}
		int sum = 0;
		for (int i = 0; i < maxEl; i++) {
			sum += range[i];
			range[i] = sum;
		}
		for(int el = maxEl - 1; el > 0; el--) {
			range[el] = range[el - 1];
		}
			range[0] = 0;
		for(int el : array) { 
			sorted[range[el]++] = el;
		}
		for(int el : sorted) {
			System.out.print(el + " ");
		}
	}
}
