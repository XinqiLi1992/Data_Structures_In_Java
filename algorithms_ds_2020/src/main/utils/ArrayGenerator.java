package main.utils;

import java.util.Random;

public class ArrayGenerator {
    public static Integer[] generateSortedArray(int n) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }

        return data;
    }

    //random array [0, bound)
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] data = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = rnd.nextInt(bound);
        }
        return data;
    }
}
