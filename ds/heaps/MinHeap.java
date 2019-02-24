
public class MinHeap extends Heap {
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
}
