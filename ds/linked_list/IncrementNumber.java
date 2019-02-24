// program to increment number in any number system 
/*
	consider a number system A, B, C, D 
	DD --> AAA

*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class IncrementNumber {
	private static List<Character> digitList = Arrays.asList('A', 'B', 'C', 'D');
	public static void main(String[] args) {
		List<Character> increment = getIncrement(Arrays.asList('A', 'D'));						
		for(Character c : increment) {
			System.out.print(c);
		}
	}
	public static List<Character> getIncrement(List<Character> oldNum) {
		List<Character> newNum = new ArrayList<>();
		boolean incrementComplete = false;
		int currentIndex = oldNum.size() - 1; 
		newNum.addAll(oldNum);
		while(!incrementComplete && currentIndex >= 0) { 
			char currentDigit = oldNum.get(currentIndex);
			int indexOfCurrentDigit = digitList.indexOf(currentDigit);
			int nextIndex = (indexOfCurrentDigit + 1) % digitList.size();
			newNum.remove(currentIndex);
			newNum.add(currentIndex, digitList.get(nextIndex));
			if(nextIndex != 0) {
				incrementComplete = true;
			}
			if(currentIndex == 0 && nextIndex == 0) {
				newNum.add(0, digitList.get(0));
			}
			currentIndex--;
		}
		return newNum;
	}
}
