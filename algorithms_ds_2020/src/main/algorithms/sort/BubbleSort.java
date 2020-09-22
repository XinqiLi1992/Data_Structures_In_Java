package main.algorithms.sort;

import main.utils.ArrayGenerator;
import main.utils.SortUtil;

import java.util.Arrays;

public class BubbleSort {

    private BubbleSort() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i + 1 < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j ++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {
        for (int i = 0; i + 1 < data.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < data.length - i - 1; j ++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] data) {
        for (int i = 0; i + 1 < data.length; ) {
            int lastSwappedIndex = 0;
            for (int j = 0; j < data.length - i - 1; j ++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    lastSwappedIndex = j + 1;
                }
            }
            i = data.length - lastSwappedIndex;
        }
    }


    public static <E extends Comparable<E>> void sort4(E[] data) {
        // 在 [0, i) 已排好序
        // 对 i 设置值
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = data.length - 1; j > i; j--) {
                if (data[j].compareTo(data[j - 1]) < 0) {
                    swap(data, j, j - 1);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void sort5(E[] data) {
        // 在 [0, i) 已排好序
        // 对 i 设置值
        for (int i = 0; i < data.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = data.length - 1; j > i; j--) {
                if (data[j].compareTo(data[j - 1]) < 0) {
                    swap(data, j, j - 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

    public static <E extends Comparable<E>> void sort6(E[] data) {
        // 在 [0, i) 已排好序
        // 对 i 设置值
        for (int i = 0; i < data.length - 1;) {
            int lastSwappedIndex = data.length -1;
            for (int j = data.length - 1; j > i; j--) {
                if (data[j].compareTo(data[j - 1]) < 0) {
                    swap(data, j, j - 1);
                    lastSwappedIndex = j - 1;
                }
            }
            i = lastSwappedIndex + 1;
        }
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 10000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);

        System.out.println("Random Array");
        SortUtil.sortTest("BubbleSort", arr);
        SortUtil.sortTest("BubbleSort2", arr2);
        SortUtil.sortTest("BubbleSort3", arr3);
        SortUtil.sortTest("BubbleSort4", arr4);
        System.out.println();

        arr = ArrayGenerator.generateSortedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        arr4 = Arrays.copyOf(arr, arr.length);

        System.out.println("Sorted Array");
        SortUtil.sortTest("BubbleSort", arr);
        SortUtil.sortTest("BubbleSort2", arr2);
        SortUtil.sortTest("BubbleSort3", arr3);
        SortUtil.sortTest("BubbleSort4", arr4);

    }
}
