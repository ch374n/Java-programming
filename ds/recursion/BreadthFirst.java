
import java.util.List;
import java.util.ArrayList;
class Node {
	private int data;
	private Node right;
	private Node left;
	public Node(int data) {
		this.data = data;
		right = null;
		left  = null;
	}
	public Node getRight() {
		return right;
	}
	public Node getLeft() {
		return left;
	}
	public int getData() {
		return data;
	}
	public void addLeft(Node node) {
		left = node;
	}
	public void addRight(Node node) {
		right = node;
	}
}
class Tree {
	private Node root;
	public Tree(Node root) {
		this.root = root;
	}
	public void insert(Node root, int data) {
		if(root == null) {
			root = new Node(data);
			return;
		}
		if(data < root.getData()) {
			if(root.getLeft() == null) {
				root.addLeft(new Node(data));
				return;
			} 
			insert(root.getLeft(), data);
		} else {
			if(root.getRight() == null) {
				root.addRight(new Node(data));
				return;
			}
			insert(root.getRight(), data);
		}
	}
	public Node getRoot() {
		return root;
	}
}
public class BreadthFirst {
	private static Tree tree = new Tree(new Node(10));
	private static Queue<Node> queue = new Queue<>(Node.class);
	public static void main(String[] args) {
		tree.insert(tree.getRoot(), 8);
		tree.insert(tree.getRoot(), 11);
		tree.insert(tree.getRoot(), 13);
		tree.insert(tree.getRoot(), 15);
		// breadthFirst(tree.getRoot());
		// System.out.println("minimum : " + findMinimum(tree.getRoot()));
		// System.out.println("Maximum depth : " + maximumDepth(tree.getRoot()));
		// System.out.print("after\n");
		// mirror(tree.getRoot());
		// breadthFirst(tree.getRoot());
		// printInRange(tree.getRoot(), 7, 12);
		// System.out.println(isThisBin(tree.getRoot(),Integer.MIN_VALUE, Integer.MAX_VALUE));
		// System.out.println(hasPathSum(tree.getRoot(), 34));
		// printPaths(tree.getRoot(), new ArrayList<>());
		Node n = leastCommon(tree.getRoot(), tree.getRoot().getLeft(), tree.getRoot().getRight());
		System.out.println("lca = " + n.getData());
	}
	public static void breadthFirst(Node root) {
		queue.enqueue(root);
		int i = 4;
		while(!queue.isEmpty()) {
			Node temp = queue.dequeue();
			System.out.println(temp.getData());
			if(temp.getLeft() != null) {
				queue.enqueue(temp.getLeft());
			}
			if(temp.getRight() != null) {
				queue.enqueue(temp.getRight());
			}
			i--;
		}
	}
	public static int findMinimum(Node root) {
		if(root == null) {
			return -1;
		} 
		while(root.getLeft() != null) {
			root = root.getLeft();
		}
			return root.getData();
	}
	public static int maximumDepth(Node root) {
		if(root == null) {
			return 0;
		}
		if(root.getLeft() == null && root.getRight() == null) {
			return 0;
		}
		int leftDepth = maximumDepth(root.getLeft()) + 1;
		int rightDepth = maximumDepth(root.getRight()) + 1;
		return Math.max(leftDepth, rightDepth);
	}
	public static void mirror(Node root) {
		if(root == null) {
			return;
		}
		mirror(root.getLeft());
		mirror(root.getRight());
		Node temp = root.getLeft();
		root.addLeft(root.getRight());
		root.addRight(temp);
	}
	public static int countTrees(int numNodes) {
		if(numNodes <= 1) {
			return 1;
		}
		int sum = 0;
		for(int i = 1; i <= numNodes; i++) {
			int countLeftTrees = countTrees(i - 1);
			int countRightTrees = countTrees(numNodes - i);
			sum += countLeftTrees * countRightTrees;
		}
		return sum;
	}
	public static void printInRange(Node root, int low, int high) {
		if(root == null) {
			return;
		}
		if(low < root.getData()) {
			printInRange(root.getLeft(), low, high);
		}
		if(low <= root.getData() && high >= root.getData()) {
			System.out.println(root.getData());
		}
		if(high > root.getData()) {
			printInRange(root.getRight(), low, high);
		}
	}
	public static boolean isThisBin(Node root, int low, int high) {
		if(root == null) {
			return true;
		}
		if(root.getData() < low || root.getData() > high) {
			return false;
		}
			return isThisBin(root.getLeft(), low, root.getData()) 
			&& isThisBin(root.getRight(), root.getData(), high);
	}
	public static boolean hasPathSum(Node root, int sum) {
		if(root == null) {
			return false;
		} 
		if(root.getLeft() == null && root.getRight() == null) {
			return root.getData() == sum;
		}		
		if(root.getData() == sum) {
			return true;
		}
			sum -= root.getData();
		if(root.getLeft() != null) {
			boolean left = hasPathSum(root.getLeft(), sum);
			if(left) {
				return true;
			}
		}
		if(root.getRight() != null) {
			boolean right = hasPathSum(root.getRight(), sum);
			if(right) {
				return true;
			}
		}
		return false;
	}
	public static void print(List<Node> pathList) {
		for(Node n : pathList) {
			System.out.print(n.getData() + " ");
		}
		System.out.println();
	}
	public static void printPaths(Node root, List<Node> pathList) {
		if(root == null) {
			return;
		}
		pathList.add(root);
		printPaths(root.getLeft(), pathList);
		printPaths(root.getRight(), pathList);
		if(root.getLeft() == null &&  root.getRight() == null) {
			print(pathList);
		}
		pathList.remove(root);
	}
	public static Node leastCommon(Node root, Node a, Node b) {
		if(root == null || root == a || root == b) {
			return root;
		}
		Node left  = leastCommon(root.getLeft(), a, b);
		Node right = leastCommon(root.getRight(), a, b);
		if(left != null && right != null) {
			return root;
		}
		if(right == null) {
			return left;
		}
			return right;
	}
}

/* 
	10 
  8    11 
  		  13 
  		  	 15 

  		  	  7 to 12
*/