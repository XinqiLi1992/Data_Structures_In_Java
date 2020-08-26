package main.algorithms.sort;

import main.utils.ArrayGenerator;
import main.utils.SortUtil;

import java.util.Arrays;
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

    public static <E extends Comparable<E>> void sort2ways(E[] arr) {
        Random random = new Random();
        sort2ways(arr, 0, arr.length - 1, random);
    }

    public static <E extends Comparable<E>> void sort2ways(E[] arr, int l, int r, Random random) {
        if (l >= r) return;
        int p = partition2(arr, l, r, random);
        sort2ways(arr, l, p - 1, random);
        sort2ways(arr, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        int i = l + 1;
        int j = r;
        while (true) {
            while(i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            while(j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort3ways(E[] arr) {
        Random random = new Random();
        sort3ways(arr, 0, arr.length - 1, random);
    }

    public static <E extends Comparable<E>> void sort3ways(E[] arr, int l, int r, Random random) {
        if (l >= r) return;
        int p = l + random.nextInt(1 + r - l);
        swap(arr, l, p);

        // arr[l + 1, lt] < v, arr[lt + 1, i - 1] == v, arr[gt, r] > v
        int lt = l;
        int i = l + 1;
        int gt = r + 1;

        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
            } else {
                i++;
            }
        }

        swap(arr, l, lt);

        // arr[l, lt - 1] < v, arr[lt, gt - 1] == v, arr[gt, r] > v
        sort3ways(arr, l, lt - 1, random);
        sort3ways(arr, gt, r, random);
    }

    private static <E> void swap(E[] arr, int l,int r) {
        E temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int n = 100000;

        System.out.println("Random array: ");
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        SortUtil.sortTest("QuickSort", arr);
        SortUtil.sortTest("QuickSort2Ways", arr2);
        SortUtil.sortTest("QuickSort3Ways", arr3);

        System.out.println("Sorted array: ");
        arr = ArrayGenerator.generateSortedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        SortUtil.sortTest("QuickSort", arr);
        SortUtil.sortTest("QuickSort2Ways", arr2);
        SortUtil.sortTest("QuickSort3Ways", arr3);

        System.out.println("Same value array: ");
        arr = ArrayGenerator.generateRandomArray(n, 1);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        SortUtil.sortTest("QuickSort", arr);
        SortUtil.sortTest("QuickSort2Ways", arr2);
        SortUtil.sortTest("QuickSort3Ways", arr3);
    }
}
