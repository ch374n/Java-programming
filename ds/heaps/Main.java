
// heap sort consists up of 2 phases 
/*
	1) heapify
	2) getHighestPriority()
*/
abstract class Heap  {
	private static int MAX_SIZE = 20;
	private int[] array;
	private int count = 0;
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
	public void setCount(int count) {
		this.count = count;
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
	public void heapify() {
		int index = getParentIndex(8 - 1);
		while(index >= 0) {
			percolateDown(index);
			index--;
		}
	}
	public void show() {
		for(int i : array) {
			System.out.println(i + " ");
		}
	}
	public void percolateDown(int index) {
		int leftIndex = getLeftChildIndex(index);
		int rightIndex = getRightChildIndex(index);
		int tempIndex;
		if(leftIndex != -1 && rightIndex != -1) {
			tempIndex = (array[leftIndex] > array[rightIndex])
					  ? leftIndex : rightIndex;

		 	if(array[tempIndex] > array[index]) {
				swap(tempIndex, index);
			}
			percolateDown(leftIndex);
			percolateDown(rightIndex);
		}
		if(leftIndex != -1) {
			if(array[leftIndex] > array[index])  {
				swap(leftIndex, index);
			}
			percolateDown(leftIndex);
		}
	}
	public void heapSort() {
		count--;
		while(count >= 0) {
			swap(0, count);
			count--;
			percolateDown(0);
		}
		if(array[0] > array[1]) {
			swap(0, 1);
		}
	}	

}

class MinHeap extends Heap {
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
}

public class Main{
	private static MinHeap hs = new MinHeap();
	public static void main(String[] args) {
		int[] array = {11, 30, 10, 4, 15, 32, 9, 21};
		hs.setArray(array);
		hs.setCount(8);
		hs.heapify();	
		hs.heapSort();
		hs.show();
	}
}

