package main.algorithms.sort;

import main.utils.ArrayGenerator;
import main.utils.SortUtil;

import java.util.Arrays;

public class MergeSort2 {
    private MergeSort2() {};

    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length, temp);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp) {
        if (r - l <= 1) return;
        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid, r, temp);

        if (arr[mid - 1].compareTo(arr[mid]) > 0) {
            merge(arr, l, mid, r, temp);
        }
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] aux) {
        System.arraycopy(arr, l, aux, l, r - l);
        int i = 0;
        int j = mid;

        for(int k = l; k < r; k++) {
            if (i >= mid) {
                arr[k] = aux[j];
                j++;
            } else if (j >= r) {
                arr[k] = aux[i];
                i++;
            } else if (arr[i].compareTo(arr[j]) < 0) {
                arr[k] = arr[i];
                i++;
            } else {
                arr[k] = arr[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortUtil.sortTest("MergeSort2", arr);
    }
}
