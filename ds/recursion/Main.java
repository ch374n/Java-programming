// program to implement stack
class Element<T> {
	private T data;
	private Element next;
	public Element(T data, Element top) {
		this.data = data;
		this.next = top;
	}
	public void setNext(Element next) {
		this.next = next;
	}
	public Element getNext() {
		return next;
	}
	public T getData() {
		return data;
	}
}
class Stack<T> {
	private int MAX_SIZE = 10;
	private Element<T> top;
	private int size = -1; 
	public void push(T data) {
		if(size == MAX_SIZE) {
			
		}
			Element el = new Element(data, top);
			top = el;
			size++;
	}
	public T pop() {
		if(size == -1) {
			
		}	
		T data = top.getData();					
		top = top.getNext();
		size--;
		return data;
	}
	public T peek() {
		if(size == -1) {
			
		}
		return top.getData();
	}
	public boolean isEmpty() {
		return size == -1;
	}
}

public class Main {
	private static Stack<Integer> stack = new Stack<>(); 
	public static void main(String[] args) {
		stack.push(10);
		stack.push(20);
		stack.push(30);
	}
}