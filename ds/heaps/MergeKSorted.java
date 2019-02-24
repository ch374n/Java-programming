 // * To merge K sorted lists 
 // *	procedure : 
 // * 	1) add small elements from all lists
 // *	2) remove highest priority and 
 // * 	3) add element from list of highest priority

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

abstract class Heap<T>  {
	private T[] array;
	private int count = 0;

	public Heap(Class<T> clazz, int size) {
		array = (T[])Array.newInstance(clazz, size);
	}
	public void setArray(T[] array) {
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
		T temp = array[i];
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
	public T getElementAtIndex(int index) {
		return array[index];
	}
	protected abstract void siftUp(int index);
	protected abstract void siftDown(int index);
	public void insert(T data) {
		if(count <= array.length) {
			array[count] = data;
			siftUp(count);
			count++;			
		}
	}
	public T getHighestPriority() {
		if(count == 0) {
			try {
			 throw new Exception();
			} catch(Exception e) {

			}
		}
		return array[0];
	}
	public T delete() {
		T temp = getHighestPriority();
		array[0] = array[count - 1];
		count--;
		siftDown(0);
		return temp;
	}
	public void show() {
		for(T el : array) {
			System.out.println(el);
		}
	}	
}
class MinHeap<T> extends Heap {
	public MinHeap(Class<T> clazz, int size) {
		super(clazz, size);
	}
	public void siftUp(int index) {
		int parentIndex = getParentIndex(index);
		if(parentIndex != -1 && (((Element)getElementAtIndex(index))
			.compareTo((Element)getElementAtIndex(parentIndex)) < 0)) {
			swap(parentIndex, index);
			siftUp(parentIndex);
		}
	}
	public void siftDown(int index) {
		int leftIndex = getLeftChildIndex(index);
		int rightIndex = getRightChildIndex(index);
		int smallerIndex = -1;
		if(leftIndex != -1 && rightIndex != -1) {
			smallerIndex = (((Element)getElementAtIndex(leftIndex))
						   .compareTo((Element)getElementAtIndex(rightIndex)) < 0)
						 ? leftIndex : rightIndex;
		} else if(rightIndex == -1) {
			smallerIndex = leftIndex;
		} else if(leftIndex == -1) {
			smallerIndex = rightIndex;
		}
		if(smallerIndex == -1) {
			return;
		}
		if(((Element)getElementAtIndex(smallerIndex))
			.compareTo((Element)getElementAtIndex(index)) < 0) {
			swap(smallerIndex, index);
			siftDown(smallerIndex);
		}
	}
	public void mergeKlists(int numElements, List<Integer>... lists) {
		for (int i = 0; i < lists.length; i++) {

				List<Integer> list = lists[i];
			if(!list.isEmpty()) {
				insert(new Element(list.remove(0), i));				
			}
		}
		List<Integer> sortedList = new ArrayList<>();
		while(sortedList.size() < numElements) {
			Element el = (Element)getHighestPriority();
			sortedList.add(el.getData());
			List<Integer> list1 = lists[el.getIndex()];
			if(!list1.isEmpty()) {
				insert(new Element(list1.remove(0), el.getIndex()));
			}
		}
		// printList(sortedList);
	}
	public void printList(List<Integer> list) {
		for(int el : list) {
			System.out.println(el);
		}
	}
}

class Element implements Comparable<Element> {
	private int data;
	private int index;
	public Element(int data, int index) {
		this.data = data;
		this.index = index;
	}
	public int getData() {
		return data;
	}
	public int getIndex() {
		return index;
	}
	public int compareTo(Element el) {
		return data - el.getData();
	}
	public String toString() {
		return "" + data;
	}
}
public class MergeKSorted {
	private static MinHeap<Element> minHeap = new MinHeap(Element.class, 20);
	public static void main(String[] args) {
		minHeap.mergeKlists(20, 
                new ArrayList<>(Arrays.asList(4, 6, 9, 11, 19, 21, 23)),
                new ArrayList<>(Arrays.asList(2, 5, 12, 18, 19, 31, 33)),
                new ArrayList<>(Arrays.asList(5, 15, 25, 35, 45, 55)));
	}
}

	//    2 
	// 4   5 
