package main.ds.heap;

import main.ds.array.Array;

import java.util.Random;

public class MinHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MinHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MinHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("Index 0 does not have parent");
        }

        return (index - 1) / 2;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) > 0) {
            data.swap(parent(k), k);
            k = parent(k);
        }
    }

    public E findMin() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Cannot findMax when heap is empty.");
        }

        return data.get(0);
    }

    public E extractMin() {
        E ret = findMin();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) < 0) {
                j++;
            }
            if (data.get(k).compareTo(data.get(j)) <= 0) {
                break;
            }

            data.swap(j, k);
            k =  j;
        }
    }

    public E replace(E e) {
        E ret = findMin();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
