// program to implement queue using two stacks
class QueueUsingStacks<T> {
	private final Stack<T> forwardStack = new Stack<>();
	private final Stack<T> reverseStack = new Stack<>();
	public void enque(T data) {
		if(!isFull()) {
			while(!reverseStack.isEmpty()) {
				forwardStack.push(reverseStack.pop());
			}
				forwardStack.push(data);			
		}
	}
	public T deque() {
		if(!isEmpty()) {
			while(!forwardStack.isEmpty()) {
				reverseStack.push(forwardStack.pop());
			}
				return reverseStack.pop();			
		} 
	}
}
public class Main3 {
	private static QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
	public static void main(String[] args) {
		queue.enque(10);		
		queue.enque(20);		
		queue.enque(30);		
		queue.deque();
		queue.deque();
		queue.deque();
	}
}