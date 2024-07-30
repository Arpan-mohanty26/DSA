
package priorityQueueAndHeaps;

class MyHeap {
    final int capacity = 10; // Size of the array
    int[] arr = new int[capacity];
    int size = 0; // Number of elements at any particular time

    // Functions to get indexes
    int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    int getLeftChildIndex(int i) {
        return 2 * i + 1;
    }

    int getRightChildIndex(int i) {
        return 2 * i + 2;
    }

    // Functions to check if the parent/children exist
    boolean hasParent(int i) {
        return getParentIndex(i) >= 0;
    }

    boolean hasLeftChild(int i) {
        return getLeftChildIndex(i) < size;
    }

    boolean hasRightChild(int i) {
        return getRightChildIndex(i) < size;
    }

    // Functions to get the value of parent/children
    int parent(int i) {
        return arr[getParentIndex(i)];
    }

    int leftChild(int i) {
        return arr[getLeftChildIndex(i)];
    }

    int rightChild(int i) {
        return arr[getRightChildIndex(i)];
    }

    boolean isEmpty() {
        return size == 0;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("The Heap is Empty. Nothing to peek!!!");
            return -1;
        }
        return arr[0];
    }

    void add(int data) {
        arr[size++] = data; // Place the element at index size and increase the size by one.
        heapifyUp(); // Create the heap from the array in a bottom-up manner
    }

    void heapifyUp() {
        int currIndex = size - 1;
        // Implement heapifyUp logic here
        // This method is incomplete in the provided snippet
    }
}

public class HeapImpl {
    public static void main(String[] args) {
        MyHeap heap = new MyHeap();
        System.out.println(heap.isEmpty());
        System.out.println(heap.peek());
        heap.add(7);
        System.out.println(heap.isEmpty());
        System.out.println(heap.peek());
        heap.add(8);
        System.out.println(heap.peek());
        heap.add(5);
        System.out.println(heap.peek());
    }
}
