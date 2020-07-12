package Queue;

import Heap.MaxHeap;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<E>();
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    public int getSize() {
        return maxHeap.size();
    }

    public void enqueue(E e) {
        maxHeap.add(e);
    }

    public E dequeue() {
        return maxHeap.extractMax();
    }

    public E getFront() {
        return maxHeap.findMax();
    }
}
