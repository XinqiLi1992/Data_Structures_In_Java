package main.algorithms.sort;

import java.util.Arrays;

import main.utils.ArrayGenerator;
import main.utils.SortUtil;

public class InsertionSort {
    private InsertionSort() {}

//    public static <E extends Comparable<E>> void sort(E[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
//                swap(arr, j, j - 1);
//            }
//        }
//    }

//    private static <E> void swap(E[] arr, int i, int j) {
//        E temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            E t = arr[i];
            int j;
            for (j = i; j < arr.length - 1 && t.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
    }

//    public static <E extends Comparable<E>> void sort(E[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            E t = arr[i];
//            int j;
//            for (j = i; j > 0 && t.compareTo(arr[j - 1]) < 0; j--) {
//                arr[j] = arr[j - 1];
//            }
//            arr[j] = t;
//        }
//    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        for(int i = l; i <= r; i++) {
            E t = arr[i];
            int j;
            for (j = i; j > l && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for(int n : dataSize) {
            System.out.println("Random array: ");
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortUtil.sortTest("InsertionSort", arr);
            SortUtil.sortTest("SelectionSort", arr2);
            System.out.println();

            System.out.println("Sorted array: ");
            arr = ArrayGenerator.generateSortedArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);
            SortUtil.sortTest("InsertionSort", arr);
            SortUtil.sortTest("SelectionSort", arr2);
            System.out.println();
        }
    }
}
