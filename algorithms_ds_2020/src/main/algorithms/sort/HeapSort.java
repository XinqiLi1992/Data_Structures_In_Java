package main.algorithms.sort;

import main.ds.heap.MaxHeap;
import main.utils.ArrayGenerator;
import main.utils.SortUtil;

import java.util.Arrays;

public class HeapSort {
    private HeapSort() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e: data) {
            maxHeap.add(e);
        }

        for(int i = data.length - 1; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {
        if (data.length <= 1) return;
        for (int i = (data.length - 2) / 2; i >= 0; i--) {
            siftDown(data, i, data.length);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            swap(data, 0, i);
            siftDown(data, 0, i);
        }
    }

    public static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        Integer[] arr5 = Arrays.copyOf(arr, arr.length);

        SortUtil.sortTest("MergeSort", arr);
        SortUtil.sortTest("QuickSort2Ways", arr2);
        SortUtil.sortTest("QuickSort3Ways", arr3);
        SortUtil.sortTest("HeapSort", arr4);
        SortUtil.sortTest("HeapSort2", arr5);
    }
}
