
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


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

class AdjMatGraph implements Graph {
	private GraphType graphType;
	private int[][] adjacencyMat;
	private int numVertices;
	public AdjMatGraph(int numVertices, GraphType type) {
		this.numVertices = numVertices;
		this.graphType = graphType;
		adjacencyMat = new int[numVertices][numVertices];
	}
	public void addEdge(int v1, int v2) {
			adjacencyMat[v1][v2] = 1;
		if(graphType == GraphType.UNDIRECTED) {
			adjacencyMat[v1][v2] = 1;
		}
	}
	public void depthFirst(int vertex, boolean[] visited) {
		// if it's traversed, return
		if(visited[vertex]) {
			return;
		}
		// if not then traverse childrens
		visited[vertex] = true;
		// traverse node
		List<Integer> list = getAdjVertices(vertex);
		for(int v : list) {
			depthFirst(v, visited);
		}
		System.out.print(vertex + " --> ");
	}
	public void breadthFirst(int vertex, boolean[] visited) {
		Queue<Integer> queue = new Queue<>(Integer.class);
		// insert first in queue
		queue.enqueue(vertex);
		// continue till queue empty
		while(!queue.isEmpty()) {
		// dequeue
			int v = queue.dequeue();
			if(visited[v]) {
				continue;
			}
			System.out.print(v + " --> ");
			visited[v] = true;
			List<Integer> list = getAdjVertices(v);
			for(int el : list) {
				// add not visited neighbours to queue
				if(!visited[el]) {
					queue.enqueue(el);
				}
			}
		}
		// visit

	}
	public void traverse() {
		boolean[] visited = new boolean[numVertices];
		for (int i = 0; i < numVertices; i++) {
			// depthFirst(i, visited);
			breadthFirst(i, visited);
		}
	}
	public List<Integer> getAdjVertices(int v) {
		List<Integer> neighbours = new ArrayList<>();
		for(int i = 0; i < numVertices; i++) {
			if(adjacencyMat[v][i] == 1) {
				neighbours.add(i);
			}
		}
		return neighbours;
	}
	public int getIndegree(int v) {
		int indegree = 0;
		for(int i = 0; i < numVertices; i++) {
			if(getAdjVertices(i).contains(v)) {
				indegree++;
			}
		}	
		return indegree;
	}
	public List<Integer> topologicalSort() {
		Queue<Integer> queue = new Queue<>(Integer.class);
		Map<Integer, Integer> indegreeMap = new HashMap<>();
		List<Integer> sortedList = new ArrayList<>();
		// find vertex with indegree 0 
		for (int vertex = 0; vertex < numVertices; vertex++) {
			int indegree = getIndegree(vertex);
			System.out.println("vertex : " + vertex + " indegree : " + indegree);
			indegreeMap.put(vertex, indegree);
			if(indegree == 0) {
				queue.enqueue(vertex);
			}
		}
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			sortedList.add(v);
			List<Integer> neighbours = getAdjVertices(v);
			for(int i : neighbours) {
				int deg = indegreeMap.get(i) - 1;
				indegreeMap.put(i, deg);
				if(deg == 0) {
					queue.enqueue(i);
				}
			}
		}
		if(sortedList.size() != numVertices) {
			System.out.println("ERROR");
		}
		return sortedList;
		// find all neighbours
		// reduce indegree of neighbours by 1
		// repeat
	}
}
public class Main {
	private static AdjMatGraph graph = new AdjMatGraph(5, Graph.GraphType.DIRECTED);

	public static void main(String[] args) {
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(3, 4);
		graph.addEdge(1, 4);
		List<Integer> list = graph.topologicalSort();
		for(int el : list) {
			System.out.print(el + " ---> ");
		}
		System.out.println();
		// graph.traverse();
	}
}