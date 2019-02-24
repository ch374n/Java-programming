// program to find out all possible subsets of a given set 
public class Subsets {
	public static void main(String[] args) {
		int[] array = {1, 2, 3};
		int[] temp = {-1, -1, -1};
		findSubsets(array, temp, 0);
	}
	public static void printIt(int[] temp) {
		System.out.print("{ ");
		for(int i = 0; i < 3; i++) {
			if(temp[i] != -1) {
				System.out.print(temp[i] + ", ");
			}
		}
		System.out.println("}");
	}
	public static void findSubsets(int[] array, int[] temp, int pointer) {
		if(pointer == array.length) {
			printIt(temp);
		} else {
			temp[pointer] = -1;
			findSubsets(array, temp, pointer + 1);
			temp[pointer] = array[pointer];
			findSubsets(array, temp, pointer + 1);			
		}
	}
}