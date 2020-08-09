package main.algorithms.sort;

import main.utils.ArrayGenerator;
import main.utils.SortUtil;

public class SelectionSort {
    private SelectionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // Select index of minimum from [i...n)
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

//    public static <E extends Comparable<E>> void sort(E[] arr) {
//        for (int i = arr.length - 1; i >= 0; i--) {
//            int maxIndex = i;
//            for (int j = i; j >= 0; j--) {
//                if (arr[j].compareTo(arr[maxIndex]) > 0) {
//                    maxIndex = j;
//                }
//            }
//            swap(arr, i, maxIndex);
//        }
//    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for(int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortUtil.sortTest("SelectionSort", arr);
        }
    }
}
