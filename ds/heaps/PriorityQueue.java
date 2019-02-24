// program to implement priority queue using heap 
/* To find largest element in min heap
 * To find k largest element in stream
 * To merge K sorted lists 
 *	procedure : 
 * 	1) add small elements from all lists
 *	2) remove highest priority and 
 * 	3) add element from list of highest priority
*/

abstract class Heap  {
	private static int MAX_SIZE = 20;
	private int[] array;
	private int count = 0;
	public Heap() {
		this(MAX_SIZE);
	}
	public Heap(int size) {
		array = new int[size];
	}
	public void setArray(int[] array) {
		this.array = array;
	}
	public int getLeftChildIndex(int index) {
		int leftChildIndex = 2 * index + 1;
		if(leftChildIndex >= count) {
			return -1;
		}
		return leftChildIndex;
	}
	public int getRightChildIndex(int index) {
		int rightChildIndex = 2 * index + 2;
		if(rightChildIndex >= count) {
			return -1;
		}
		return rightChildIndex;
	}
	public int getParentIndex(int index) {
		index = (index - 1) / 2;
		if(index < 0) {
			return -1;
		}
			return index;
	}
	public void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public int getCount() {
		return count;
	}
	public boolean isEmpty() {
		return count == 0;
	}
	public boolean isFull() {
		return count == array.length;
	}
	public int getElementAtIndex(int index) {
		return array[index];
	}
	protected abstract void siftUp(int index);
	protected abstract void siftDown(int index);
	public void insert(int data) {
		if(count <= array.length) {
			array[count] = data;
			siftUp(count);
			count++;			
		}
	}
	public int getHighestPriority() {
		if(count == 0) {
			 return -1;
		}
		return array[0];
	}
	public int delete() {
		int temp = getHighestPriority();
		array[0] = array[count - 1];
		count--;
		siftDown(0);
		return temp;
	}
	public void show() {
		for(int el : array) {
			System.out.println(el);
		}
	}	
}
class MaxHeap extends Heap{
	public MaxHeap(int size) {
		super(size);
	}
	protected void siftUp(int index) {

	}
	protected void siftDown(int index) {

	}
}
class MinHeap extends Heap {
	public MinHeap(int size) {
		super(size);
	}
	public void siftUp(int index) {
		int parentIndex = getParentIndex(index);
		if(parentIndex != -1 && (getElementAtIndex(index) < getElementAtIndex(parentIndex))) {
			swap(parentIndex, index);
			siftUp(parentIndex);
		}
	}
	public void siftDown(int index) {
		int leftIndex = getLeftChildIndex(index);
		int rightIndex = getRightChildIndex(index);
		int smallerIndex = -1;
		if(leftIndex != -1 && rightIndex != -1) {
			smallerIndex = (getElementAtIndex(leftIndex) < getElementAtIndex(rightIndex))
						 ? leftIndex : rightIndex;
		} else if(rightIndex == -1) {
			smallerIndex = leftIndex;
		} else if(leftIndex == -1) {
			smallerIndex = rightIndex;
		}
		if(smallerIndex == -1) {
			return;
		}
		if(getElementAtIndex(smallerIndex) < getElementAtIndex(index)) {
			swap(smallerIndex, index);
			siftDown(smallerIndex);
		}
	}
	public int findLargest() {
		int k = getParentIndex(getCount() - 1) + 1;
		int max = getElementAtIndex(k);
		while(k < getCount()) {
			if(max < getElementAtIndex(k)) {
				max = getElementAtIndex(k);
			}
			k++;
		}
		return max;
	}
	public void findKlargest(int... stream) {
		for(int el : stream) {
			if(!isFull()) {
				insert(el);
			} else {
				if(getHighestPriority() < el) {
					delete();
				}
				insert(el);
			}
		}
	}
	public void mergeKlists(int numElements, List<Integer>... lists) {

	}
}

public class PriorityQueue {
	private static MinHeap minHeap = new MinHeap(20);
	private static MinHeap anotherHeap = new MinHeap(5);
	public static void main(String[] args) {
		// minHeap.insert(111);
		// minHeap.insert(10);
		// minHeap.insert(9);
		// minHeap.insert(5);
		// minHeap.insert(1);
		// minHeap.insert(8);
		// minHeap.insert(38);
		// System.out.println(minHeap.findLargest());
		anotherHeap.findKlargest(111, 10, 9, 1, 8, 5, 38);
		anotherHeap.show();
	}
}

