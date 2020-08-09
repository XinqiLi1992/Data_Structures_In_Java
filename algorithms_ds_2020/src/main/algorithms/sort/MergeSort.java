package main.algorithms.sort;

import java.util.Arrays;

import com.sun.javafx.collections.SortHelper;

import main.utils.ArrayGenerator;
import main.utils.SortUtil;

public class MergeSort {
    public MergeSort() { }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp) {
        if (l >= r) return;

//        可能的优化， 元素少就用插入排序
//        if (r - l <= 15) {
//            InsertionSort.sort(arr, l, r);
//            return;
//        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }
    }

    public static <E extends Comparable<E>> void sortB2U(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sortB2U(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sortB2U(E[] arr, int l, int r, E[] temp) {
        int n = arr.length;
        for (int s = 1; s < n; s+=s) {
            // [i, i + s - 1] [i + s, i + s + s - 1]
            for (int i = 0; i + s < n; i = i + s + s) {
                if (arr[i + s - 1].compareTo(arr[i + s]) > 0) {
                    merge(arr, i, i + s - 1, Math.min(i + s + s - 1, n - 1), temp);
                }
            }
        }
    }

    // merge arrays in range [l, mid] and [mid + 1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortUtil.sortTest("MergeSort", arr);
        Integer[] arr2 = ArrayGenerator.generateRandomArray(n, n);
        SortUtil.sortTest("MergeSortB2U", arr2);
    }
}
