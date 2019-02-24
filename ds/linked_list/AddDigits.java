
import java.util.ArrayList;
import java.util.List;
public class AddDigits {
	public static void main(String[] args) {
		int[] num1 = {1, 2, 7};
		int[] num2 = {4, 4};
		List<Integer> sum = addDigits(num1, num2);
		for(Integer i : sum) {
			System.out.print(i);
		}
	}
	public static List<Integer> addDigits(int[] num1, int[] num2) {
		List<Integer> sum = new ArrayList<>();
		int index1 =  num1.length - 1;
		int index2 = num2.length - 1;
		int carry = 0, rem, total;
		while(index1 >= 0 && index2 >= 0) {
			total = num1[index1] + num2[index2] + carry;
			carry = total/10;
			rem = total%10;
			sum.add(0, rem);
			index1--;
			index2--;
		}
		while(index1 >= 0) {
			total = num1[index1] + carry;
			carry = total/10;
			rem = total%10;
			sum.add(0, rem);
			index1--;
		}
		while(index2 >= 0) {
			total = num2[index2] + carry;
			carry = total/10;
			rem = total%10;
			sum.add(0, rem);
			index2--;
		}
		if(carry != 0) {
			sum.add(0, carry);
		}
		return sum;
	}
}