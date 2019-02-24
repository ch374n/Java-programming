 
 public class SelectionSort {
 	public static void main(String[] args) {
 		int[] array = {10, 4, 9, 7, 11, 1, 3, 5, 6};
 		selectionSort(array);
 		for(int i : array) {
 			System.out.println(i + " ");
 		}
 	}
 	public static void swap(int[] array, int i, int j) {
 		int temp = array[i];
 		array[i] = array[j];
 		array[j] = temp;
 	}
 	public static void selectionSort(int[] array) {
 		for(int i = 0; i < array.length; i++) {
 			for(int j = i + 1; j < array.length; j++) {
 					if(array[i] > array[j]) {
 						swap(array, i, j);
 					}				
 			}
 		}
 	}
 }