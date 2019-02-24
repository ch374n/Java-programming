// program to find whether two trees are similar or not 
// complexity O(N)
class Node {
	int data;
	Node right;
	Node left;
	public Node(int data) {
		this.data = data;
		this.right = null;
		this.left = null;
	}
	public int getValue() {
		return data;
	}
	public void addRight(Node right) {
		this.right = right;
	}
	public void addLeft(Node left) {
		this.left = left;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}
}
public class SimilarTrees {
	private static Node root1 = new Node(10);
	private static Node root2 = new Node(10);
	public static void main(String[] args) {
		root1.addRight(new Node(8));
		root1.addLeft(new Node(15));
		root2.addRight(new Node(8));
		root2.addLeft(new Node(15));
		System.out.print(similarTrees(root1, root2));
	}
	public static boolean similarTrees(Node root1, Node root2) {
		if(root1 == null && root1 == null) {
			return true;
		}
		if(root1 == null) {
			return false;
		} else if(root2 == null) {
			return false;
		}
		if(root1.getValue() != root2.getValue()) {
			return false;
		}
		if(similarTrees(root1.getRight(), root2.getRight()) && similarTrees(root1.getLeft(), root2.getLeft())) {
		 	return root1.getValue() == root2.getValue();
		}
			return false;
	}
}