// program to implement circular queue
import java.lang.reflect.Array;
class Queue<T> {
	private final T[] elements;
	private int head = -1;
	private int tail = -1; 
	private int MAX_SIZE = 10;
	public Queue(Class<T> clazz) {
		elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
	}
	public void enqueue(T data) {
		if(!isFull()) {
			if(head == -1) {
				head = 0;
			}
				tail = (tail + 1) % MAX_SIZE;
				elements[tail] = data;
		}
	} 
	public T dequeue() {
		if(!isEmpty()) {
			T value = elements[head];
			if(head == tail) {
				head = -1;
				tail = -1;
			} else {
				head = (head + 1) % MAX_SIZE;
			}
				return value;
		} else {
				return null;
		}
	}
	public boolean isFull() {
		return ((tail + 1) % MAX_SIZE == head);
	}	
	public boolean isEmpty() {
		return head == -1;
	}
	public T peek() {
		return elements[head];
	}
}
public class Main1 {
	private static Queue<Integer> queue = new Queue<>(Integer.class);
	public static void main(String[] args) {
	}
}