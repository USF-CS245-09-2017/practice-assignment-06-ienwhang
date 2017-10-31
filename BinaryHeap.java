
public class BinaryHeap {
	
	int[] arr = new int[10];
	int size = 0;

	public void add(int i) {
		if (arr.length == size) {
			growHeap();
		}
 		arr[size++] = i;
		int index = size-1;
		while ((index > 0) && (arr[index] < arr[parent(index)])) {
			swap(index, parent(index));  // Swap indices
			index = parent(index);
		}
	}
	
	public int remove() {
		int temp = arr[0];
		arr[0] = arr[--size];
		if (size != 0) {
			bubbleDown(0);	
		}
		return temp;
	}
	
	private int parent(int index) {
		return (index-1)/2;
	}
	
	private int leftChild(int index) {
		return (index*2)+1;
	}
	
	private int rightChild(int index) {
		return (index*2)+2;
	}
	
	private void growHeap() {
		int[] newArr = new int[arr.length*2];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}
	
	private void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	private void bubbleDown(int index) {
		while (leftChild(index) < size) {
			int child = leftChild(index);
			if ((rightChild(index) < size) && (arr[child]>arr[rightChild(index)])) 
				child = rightChild(index);
			if (arr[index] < arr[child])
				return;
			swap(index, child);
			index = child;
		}
	}
	
}
