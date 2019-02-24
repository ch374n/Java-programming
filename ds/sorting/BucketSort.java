// program to implement bucket sort using java
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
	private static List<List<Double>> list = new ArrayList<>();
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			list.add(new ArrayList<>());
		}
		double[] arr = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};
		System.out.println(bucketSort(arr, 10));		
	}
	public static List<Double> bucketSort(double[] arr, int n) {
		List<Double> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int loc = (int) arr[i] * 10;
			list.get(loc).add(arr[i]);
		}
		for(List<Double> l : list) {
			Collections.sort(l);
		}
		for(List<Double> l : list) {
			result.addAll(l);
		}
			return result;
	}
}