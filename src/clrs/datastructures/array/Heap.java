package clrs.datastructures.array;

public class Heap {

	// --------------------
	// HeapSort Functions
	// --------------------

	/**
	 * Initializes a[] to a max heap by calling maxHeapify on all internal tree
	 * elements.
	 * 
	 * @param a
	 *            the array being sorted
	 */
	public static void buildMaxHeap(int[] a) {
		int internal = (a.length - 1) / 2;

		for (int i = internal; i >= 0; i--) {
			maxHeapify(a, i, a.length - 1);
		}
	}

	/**
	 * Performs recursive 'bubble-down' of a[i] in order to maintain the max
	 * heap property of a[i].
	 * 
	 * @param a
	 *            the array being sorted
	 * @param i
	 * @param heapEnd
	 */
	public static void maxHeapify(int[] a, int i, int heapEnd) {
		int left = leftChild(i);
		int right = rightChild(i);
		int largest;

		if (left <= heapEnd && a[left] > a[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right <= heapEnd && a[right] > a[largest]) {
			largest = right;
		}

		if (largest != i) {
			int temp = a[largest];
			a[largest] = a[i];
			a[i] = temp;
			maxHeapify(a, largest, heapEnd);
		}
	}

	// ------------------------
	// Priority Queue Functions
	// ------------------------

	// ---------------
	// Heap Properties
	// ---------------

	public static int parent(int currIndex) {
		// Will this cause infinite loop?
		// if (currIndex == 0) {
		// return 0;
		// }
		return (currIndex - 1) / 2;
	}

	public static int leftChild(int currIndex) {
		return (2 * currIndex) + 1;
	}

	public static int rightChild(int currIndex) {
		return (2 * currIndex) + 2;
	}
}