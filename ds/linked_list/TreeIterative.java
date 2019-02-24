
import java.lang.reflect.Array;

class Stack<T> {
	private T[] data;
	private int top = 0;
	public Stack(Class<T> clazz, int size) {
		data = (T[]) Array.newInstance(clazz, size);
	}
	public void push(T d) {
		data[top] = d;
		top += 1;
	}
	public T pop() {
		top--;
		T temp = data[top];
		return temp;
	}
	public boolean isEmpty() {
		return top == 0;
	}
	public int getTop() {
		return top;
	}
	public void print() {
		for(T t : data) {
			System.out.println(t);		
		}
	}

}
class Node {
	private int data;
	private int state;
	private Node left = null;
	private Node right = null;
	public Node(int data, int state) {
		this.data  = data;
		this.state = state;
	}
	public Node addLeft(Node left) {
		this.left = left;
		return left;
	}
	public Node addRight(Node right) {
		this.right = right;
		return right;
	}
	public void setStatus(int status) {
		this.state = status;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}
	public int getData() {
		return data;
	}
	public int getStatus() {
		return state;
	}
}
public class TreeIterative {
	private static Node root = new Node(20, 0);
	private static Stack<Node> stack = new Stack<>(Node.class, 30);
	public static void main(String[] args) {
		Node left  = root.addLeft(new Node(15, 0)).addLeft(new Node(10, 0));
		Node right = root.addRight(new Node(25, 0)).addLeft(new Node(22, 0));
		left.addRight(new Node(17, 0));
		right.addRight(new Node(27, 0))
;		traverse(root);	
	}
	public static void traverse(Node root) {
		stack.push(root);
		while(!stack.isEmpty()) {
			Node temp = stack.pop();
			if(temp == null) {
				continue;
			}
			int status = temp.getStatus();
			int data = temp.getData();
			if(status == 3) {
				continue;
			} 
			temp.setStatus(status + 1);
			stack.push(temp);
			if(status == 0) {
				if(root.getLeft() != null) {
					stack.push(root.getLeft());
				}
			} else if(status == 1) {
					System.out.println("Data : " + data);
			} else if(status == 2) {
				if(root.getRight() != null) {
					stack.push(root.getRight());
				}
			}
		}
	}
}