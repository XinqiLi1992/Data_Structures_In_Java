package main.algorithms.sort;

import main.utils.ArrayGenerator;
import main.utils.SortUtil;

import java.util.Random;

public class QuickSort {
    private QuickSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        if (l >= r) return;
        int p = partition(arr, l, r, random);
        sort(arr, l, p - 1, random);
        sort(arr, p + 1, r, random);
    }


    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        int j = l;
        //[l + 1, j], [j + 1, i - 1]
        for (int i = l + 1; i <= r; i++) {
           if (arr[i].compareTo(arr[l]) < 0) {
               j++;
               swap(arr, j, i);
           }
        }
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int l,int r) {
        E temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = ArrayGenerator.generateRandomArray(n, n);
        SortUtil.sortTest("MergeSort", arr);
        SortUtil.sortTest("QuickSort", arr2);

        arr = ArrayGenerator.generateSortedArray(n);
        arr2 = ArrayGenerator.generateSortedArray(n);
        SortUtil.sortTest("MergeSort", arr);
        SortUtil.sortTest("QuickSort", arr2);
    }
}
