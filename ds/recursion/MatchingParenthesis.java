
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class MatchingParenthesis {
	private static Map<Character, Character> matchingParenMap = new HashMap<>();
	private static Set<Character> openingParenSet = new HashSet<>();
	public static void main(String[] args) {
		matchingParenMap.put('}', '{');
		matchingParenMap.put(')', '(');
		matchingParenMap.put(']', '[');
		openingParenSet.add('{');
		openingParenSet.add('(');
		openingParenSet.add('[');
		String expr = "{}(())[]";
		System.out.println(matchExp(expr));				
	}

	public static boolean matchExp(String expr) {
		Stack<Character> openingStack = new Stack<>();
		for(char ch : expr.toCharArray()) {
			if(openingParenSet.contains(ch)) {
				openingStack.push(ch);
			}
			if(matchingParenMap.keySet().contains(ch)) {
				char lastChar = openingStack.pop();
				if(lastChar != matchingParenMap.get(ch)) {
					return false;
				}
			}
		}
			return openingStack.isEmpty();
	}
}