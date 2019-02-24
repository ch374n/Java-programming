
class MinimumStack {
	private static Stack<Integer> mainStack = new Stack<>();
	private static Stack<Integer> minimumStack = new Stack<>();

	public void push(int data) {
		int min = data;
		if(!minimumStack.isEmpty()) {
			if(min > minimumStack.peek()) {
				min = minimumStack.peek();
			}
		}
		mainStack.push(data);
		minimumStack.push(min);
	}
	public int pop() {
		minimumStack.pop();
		return mainStack.pop();
	}
	public int getMinimum() {
		return minimumStack.peek();
	}
}
public class FindMinimum {
	private static MinimumStack stack = new MinimumStack();
	public static void main(String[] args) {
		stack.push(10);
		stack.push(9);
		stack.push(7);
		System.out.print(stack.getMinimum());
	}
}