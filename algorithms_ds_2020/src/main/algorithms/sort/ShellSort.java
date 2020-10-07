package main.algorithms.sort;

import main.utils.ArrayGenerator;
import main.utils.SortUtil;

public class ShellSort {
    private ShellSort() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        int h = data.length / 2;
        while (h >= 1) {
            for (int start = 0; start < h; start ++) {
                for (int i = start + h; i < data.length; i += h) {
                    E temp = data[i];
                    int j;
                    for (j = i; j - h >= 0 && temp.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];
                    }
                    data[j] = temp;
                }
            }
            h = h / 2;
        }
    }

    public static void main(String[] args) {
        int n = 100000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

        SortUtil.sortTest("ShellSort", arr);
    }
}
